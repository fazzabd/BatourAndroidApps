package id.web.twoh.placesapitutorial;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bandung.explore.location.PlaceCursorAdapter;
import com.bandung.explore.location.PlaceDatabaseHelper;

public class TempatActivity extends AppCompatActivity {

    private ListView listTempat;
    private double lat;
    private double lng;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat);

        listTempat = findViewById(R.id.list);

        try {
            this.lat = Double.parseDouble(getIntent().getExtras().getString("Lat"));
            this.lng = Double.parseDouble(getIntent().getExtras().getString("Long"));
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            this.lat = -6.872250;
            this.lng = 107.572989;
        }

        final Location location = new Location("Current Loc");
        location.setLatitude(lat);
        location.setLongitude(lng);

        SQLiteOpenHelper sqLiteOpenHelper = new PlaceDatabaseHelper(this);

        SQLiteDatabase db = null;

        Cursor dbcursor = null;

        try
        {
            db = sqLiteOpenHelper.getReadableDatabase();

            dbcursor = db.query("Location",
                    new String[]{"_id","NAME","DESCRIPTION","LAT","LONG"},
                    null,null,null,null,null);

            listTempat.setAdapter(new PlaceCursorAdapter(this, dbcursor){
                @Override
                public void bindView(View view, Context context, Cursor cursor)
                {
                    TextView namatempat = view.findViewById(R.id.nama_tempat);
                    TextView alamat = view.findViewById(R.id.alamat_tempat);
                    TextView latitude = view.findViewById(R.id.latitude);
                    TextView longitude = view.findViewById(R.id.longitude);
                    TextView jarak = view.findViewById(R.id.jarak);

                    String objnama = cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
                    String objdesc = cursor.getString(cursor.getColumnIndexOrThrow("DESCRIPTION"));
                    Double objlat = cursor.getDouble(cursor.getColumnIndexOrThrow("LAT"));
                    Double objlong = cursor.getDouble(cursor.getColumnIndexOrThrow("LONG"));

                    namatempat.setText(objnama);
                    alamat.setText(objdesc);
                    latitude.setText(String.valueOf(objlat));
                    longitude.setText(String.valueOf(objlong));

                    Location locItem = new Location("Item");
                    locItem.setLatitude(objlat);
                    locItem.setLongitude(objlong);

                    jarak.setText(String.valueOf(location.distanceTo(locItem)).concat(" meter"));
                }
                }
            );


        }
        catch (Exception e)
        {
            Toast.makeText(TempatActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        finally
        {
            if(db != null && db.isOpen())
            {
                db.close();
            }
        }

    }

}
