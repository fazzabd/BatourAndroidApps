package me.everything.providers.sample.fragments;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.TextView;

import me.everything.providers.android.calendar.CalendarProvider;
import me.everything.providers.android.calendar.Event;
import me.everything.providers.core.Data;
import me.everything.providers.sample.base.GetCursorTask;
import me.everything.providers.sample.base.RecycleViewCursorFragment;

/**
 * Created by sromku
 */
public class EventsFragment extends RecycleViewCursorFragment<Event> {

    private static final String ARG_CALENDAR_ID = "arg_calendar_id";

    private long mCalendarId;
    private String[] mColumns = new String[] {
            CalendarContract.Events._ID,
            CalendarContract.Events.TITLE,
            CalendarContract.Events.DESCRIPTION
    };

    public static EventsFragment newInstance(long calendarId) {
        EventsFragment eventsFragment = new EventsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(ARG_CALENDAR_ID, calendarId);
        eventsFragment.setArguments(bundle);
        return eventsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCalendarId = getArguments().getLong(ARG_CALENDAR_ID);
    }

    @Override
    protected String getTitle() {
        return "Events";
    }

    @Override
    protected void bindEntity(Event event, TextView title, TextView details) {
        title.setText(event.title);
        details.setText(event.description);
    }

    @Override
    protected String[] getProjectionColumns() {
        return mColumns;
    }


    @Override
    protected CharSequence[] getDialogItems() {
        CharSequence[] items = new CharSequence[] {
                "Show Event Reminders",
                "Show Event Attendees",
                "Show Event Instances"
        };
        return items;
    }

    @Override
    protected void onDialogItemSelected(Event entity, int which) {
        switch (which) {
            case 0: // "Show Event Reminders"
                setFragment(RemindersFragment.newInstance(entity.id));
                break;
            case 1: // "Show Event Attendees"
                setFragment(AttendeesFragment.newInstance(entity.id));
                break;
            case 2: // "Show Event Instances"
                setFragment(InstancesFragment.newInstance(entity.id));
                break;
        }
    }

    @Override
    protected GetCursorTask.DataFetcher<Event> getFetcher() {
        return new GetCursorTask.DataFetcher<Event>() {
            @Override
            public Data<Event> getData() {
                CalendarProvider calendarProvider = new CalendarProvider(getApplicationContext());
                return calendarProvider.getEvents(mCalendarId);
            }
        };
    }


}
