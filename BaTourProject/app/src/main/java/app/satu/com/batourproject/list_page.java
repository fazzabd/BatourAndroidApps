package app.satu.com.batourproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class list_page extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.kawahputih,R.drawable.perkebunantehrancabali,R.drawable.situpatenggang,R.drawable.tangkubanperahu,R.drawable.batucinta};
    public static String [] prgmNameList={"Kawah Putih","Perkebunan Teh Rancabali","Situ Patenggang","Tangkuban Perahu ","Batu Cinta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomListAdapter(this, prgmNameList,prgmImages));
    }
}
