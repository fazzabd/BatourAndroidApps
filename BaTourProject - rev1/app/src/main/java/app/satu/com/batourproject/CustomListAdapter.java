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

public class CustomListAdapter extends BaseAdapter{
    String [] result;
    String [] result1;
    String [] result2;
    String [] result3;
    Context context;
    int [] imageId;
    ArrayList<TempatWisata> tw = null;
    private static LayoutInflater inflater=null;
    public CustomListAdapter(list_page listPage, String[] prgmNameList, String[] Alamat, String[] opengate,String[] htm, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        result1=Alamat;
        result2=opengate;
        result3=htm;
        context=listPage;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public CustomListAdapter(list_page listPage, ArrayList<TempatWisata> tw) {
        this.context=listPage;
        this.tw=tw;
    }

    public CustomListAdapter(Activity activity, int[] prgmImages) {
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=activity;

        imageId=prgmImages;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return this.tw.size();
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return this.tw.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public void updateListBook(ArrayList<TempatWisata> tw) {
        this.tw = tw;
    }

    public class Holder
    {
        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        Button buttonDeskripsi;
        rowView = inflater.inflate(R.layout.list_item_layout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.tv1=(TextView) rowView.findViewById(R.id.textView2);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView3);
        holder.tv3=(TextView) rowView.findViewById(R.id.textView4);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);/*
        holder.tv.setText(result[position]);
        holder.tv1.setText(result1[position]);
        holder.tv2.setText(result2[position]);
        holder.tv3.setText(result3[position]);*/
        holder.img.setImageResource(imageId[position]);
        final TempatWisata tempatWisata = this.tw.get(position);
        final String nama = tempatWisata.getNama();

        holder.tv.setText(tempatWisata.getNama());
        holder.tv1.setText(tempatWisata.getAlamat());
        holder.tv2.setText(tempatWisata.getJamOperasional());
        holder.tv3.setText("HTM: Rp. " + Float.toString(tempatWisata.getHargaTiketMasuk()) + "/org");

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                Intent toDesc = new Intent(context, deskripsi_wisata.class);
                toDesc.putExtra("nama", nama);
                context.startActivity(toDesc);
            }
        });
        return rowView;
    }
}
