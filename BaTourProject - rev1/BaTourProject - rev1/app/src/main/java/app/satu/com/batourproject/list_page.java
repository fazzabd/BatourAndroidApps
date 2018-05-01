package app.satu.com.batourproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class list_page extends AppCompatActivity {
    ListView lv;
    Context context;
    public Button buttonDeskripsi;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.kawahputih,R.drawable.perkebunantehrancabali,R.drawable.situpatenggang,R.drawable.tangkubanperahu,R.drawable.batucinta};
    public static String [] prgmNameList={"Kawah Putih","Perkebunan Teh Rancabali","Situ Patenggang","Tangkuban Perahu ","Batu Cinta"};
    public static String [] Alamat={"Jalan Raya Soreang Ciwidey Kilo Meter 25, Desa Ciwidey, Kecamatan Ciwidey, Kabupaten Bandung,","Jl. Rancabali, Ciwidey, Bandung, ","Jl. Situ Patengan Ciwidey Bandung","Jalan Raya Tangkuban Perahu, Lembang","Jl. Situ Patengan, Patengan, Rancabali, Bandung,"};
    public static String [] opengate={"Jam Buka: 7.00 - 17.00 WIB","Jam Buka: 7.00-17.00 WIB ","Jam Buka: 09.00–17.00 WIB","Jam Buka: 07.00 – 17.00 WIB","Jam Buka: 06.00-18.00 WIB"};
    public static String [] htm={"HTM: Rp.18.000/org","HTM: Rp. 0/org","HTM: Rp.18.000/org","HTM: 20.000/org","HTM: Rp.18.000/org"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomListAdapter(this, prgmNameList,Alamat,opengate,htm,prgmImages));


        buttonDeskripsi = findViewById(R.id.button_get_started);

        /*buttonDeskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDeskripsi = new Intent(list_page.this, deskripsi_wisata.class);
                startActivity(toDeskripsi);
            }
        });*/
    }
}
