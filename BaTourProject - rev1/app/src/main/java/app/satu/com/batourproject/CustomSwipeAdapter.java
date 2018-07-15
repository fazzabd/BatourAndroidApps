package app.satu.com.batourproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by USER on 3/31/2018.
 */

public class CustomSwipeAdapter extends PagerAdapter{
    private int[] image_resources = {R.drawable.r_alam, R.drawable.r_belanja, R.drawable.r_sejarah};
    private int[] image_resources1 = {R.drawable.tangkubanperahu, R.drawable.batucinta, R.drawable.hills};
    private int[] image_resources2 = {R.drawable.castle, R.drawable.hills, R.drawable.bank};
    private Context ctx;
    private LayoutInflater layoutInflater;
    private Intent intent;

    public CustomSwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public CustomSwipeAdapter(Context ctx, Intent intent) {
        this.ctx = ctx;
        this.intent = intent;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageVew = (ImageView) item_view.findViewById(R.id.image_view);
        //TextView textView = (TextView) item_view.findViewById(R.id.image_count);
        //imageVew.setImageResource(image_resources[position]);
        try{
            String nama = intent.getStringExtra("nama");
            //Memeriksa apakah data diterima dari intent
            switch (nama) {
                case "Kawah Putih":
                    imageVew.setImageResource(image_resources[position]);
                    break;
                case "Perkebunan Teh Rancabali":
                    imageVew.setImageResource(image_resources1[position]);
                    break;
                case "Situ Patenggang":
                    imageVew.setImageResource(image_resources2[position]);
                    break;
                case "Tangkuban Perahu ":
                    imageVew.setImageResource(image_resources[position]);
                    break;
                case "Batu Cinta":
                    imageVew.setImageResource(image_resources1[position]);
                    break;
                default:
                    imageVew.setImageResource(image_resources[position]);
                    break;
            }
        }
        catch(NullPointerException ex) {
            String nama = "";
            switch (nama) {
                case "Kawah Putih":
                    imageVew.setImageResource(image_resources[position]);
                    break;
                case "Perkebunan Teh Rancabali":
                    imageVew.setImageResource(image_resources1[position]);
                    break;
                case "Situ Patenggang":
                    imageVew.setImageResource(image_resources2[position]);
                    break;
                case "Tangkuban Perahu ":
                    imageVew.setImageResource(image_resources[position]);
                    break;
                case "Batu Cinta":
                    imageVew.setImageResource(image_resources1[position]);
                    break;
                default:
                    imageVew.setImageResource(image_resources[position]);
                    break;
            }
        }


        //textView.setText("Image : " + position);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
