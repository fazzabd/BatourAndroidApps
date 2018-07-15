package app.satu.com.batourproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 4/8/2018.
 */

public class CustomAdapterHome extends BaseAdapter{
    String [] judul;
    int [] gambar;
    Context context;
    //ArrayList<TempatWisata> tw = null;
    private static LayoutInflater inflater=null;
    public CustomAdapterHome(home home, int[] Gambar, String[] Judul) {
        // TODO Auto-generated constructor stub
        judul=Judul;
        gambar=Gambar;
        context=home;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return judul.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_home_layout, null);
        //holder.tv=(TextView) rowView.findViewById(R.id.textViewHome);
        holder.img=(ImageView) rowView.findViewById(R.id.imageViewHome);

        holder.img.setImageResource(gambar[position]);
        //holder.tv.setText(judul[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent toList = new Intent(context, home.class);
                    toList.putExtra("id", position);
                    context.startActivity(toList);
                }
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
               // Intent toList = new Intent(context, list_page.class);
                //toList.putExtra("nama", nama);
                //context.startActivity(toDesc);
        });

        return rowView;
    }
}
