package app.satu.com.batourproject;

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
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
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
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(result[position]);
        holder.tv1.setText(result1[position]);
        holder.tv2.setText(result2[position]);
        holder.tv3.setText(result3[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
        buttonDeskripsi = rowView.findViewById(R.id.button_deskripsi);
        buttonDeskripsi.setTag(position);
        buttonDeskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent toDeskripsi = new Intent(CustomListAdapter.this, deskripsi_wisata.class);
                int position = (Integer) view.getTag();
                switch (position) {
                    case 0:
                        context.startActivity(new Intent(context, deskripsi_wisata.class));
                        break;
                    case 1: //contoh untuk mengecek apakah pagenya beda
                        context.startActivity(new Intent(context, comment_page.class));
                }

            }
        });
        return rowView;
    }
}
