package app.satu.com.batourproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class list_page extends AppCompatActivity {
    ListView lv;
    Context context;
    ArrayList<TempatWisata> tw = null;
    CustomListAdapter adapter = null;

    ArrayList prgmName;
    public static int [] alam={R.drawable.kp1,R.drawable.tr1,R.drawable.sp,R.drawable.tb1,R.drawable.bc1};
    public static int [] sejarah={R.drawable.gkl1,R.drawable.gm1,R.drawable.gb1,R.drawable.aab1,R.drawable.gs1};
    public static int [] bermain={R.drawable.tfb1,R.drawable.hf1,R.drawable.ks1,R.drawable.tsb1,R.drawable.tm1};
    public static int [] seni={R.drawable.grs,R.drawable.kam1,R.drawable.tb1,R.drawable.sau1,R.drawable.mb};
    public static int [] belanja={R.drawable.kawahputih,R.drawable.pjp1,R.drawable.pbtc1,R.drawable.pc,R.drawable.md};
    public static int [] kuliner={R.drawable.gsb1,R.drawable.dmh1,R.drawable.ob,R.drawable.br1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page);

        context=this;

        lv=(ListView) findViewById(R.id.listView);

        Intent i = getIntent();
        tw = (ArrayList<TempatWisata>) i.getSerializableExtra("LIST");
        String jenis = tw.get(0).getJenis();
        switch(jenis){
            case "alam":
                adapter = new CustomListAdapter(this,alam);
                break;
            case "sejarah":
                adapter = new CustomListAdapter(this,sejarah);
                break;
            case "taman bermain":
                adapter = new CustomListAdapter(this,bermain);
                break;
            case "belanja":
                adapter = new CustomListAdapter(this,belanja);
                break;
            case "Seni dan Budaya":
                adapter = new CustomListAdapter(this,seni);
                break;
            case "kuliner":
                adapter = new CustomListAdapter(this,kuliner);
                break;
        }

        refreshListAdapter();
        /*if(tw.isEmpty())
            Toast.makeText(list_page.this, "Data Tempat Wisata tidak terambil", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(list_page.this, "Data Tempat Wisata terambil", Toast.LENGTH_LONG).show();*/
        //lv.setAdapter(new CustomListAdapter(this));
    }

    protected void refreshListAdapter() {
        adapter.updateListBook(tw);
        lv.setAdapter(adapter);
    }
}
