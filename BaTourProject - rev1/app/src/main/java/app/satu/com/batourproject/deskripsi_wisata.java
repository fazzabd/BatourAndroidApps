package app.satu.com.batourproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class deskripsi_wisata extends AppCompatActivity {
    ViewPager viewPager1;
    CustomSwipeAdapter adapter1;
    TextView descTxt;
    DatabaseHelper db = home.db;
    Button buttonMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_wisata);

        viewPager1 = findViewById(R.id.view_pager1);
        Intent intent = getIntent();
        adapter1 = new CustomSwipeAdapter(this, intent);
        String nama = intent.getStringExtra("nama");
        descTxt = findViewById(R.id.txtDesc);
        TempatWisata t = null;
        t = db.getOneTempatWisata(nama);
        if (t == null) {
            Toast.makeText(deskripsi_wisata.this, "Tempat Wisata Kosong", Toast.LENGTH_LONG).show();
        }
        else {
            descTxt.setText(t.getDeskripsi());
        }

        LatLng latlng = null;
        switch(nama){
            case "Kawah Putih":
                latlng = new LatLng(-7.1661, 107.4022);
                break;
            case "Situ Patenggang":
                latlng = new LatLng(-7.174425, 107.347508);
                break;
            case "Tangkuban Perahu":
                latlng = new LatLng(-6.767213, 107.622624);
                break;
            case "Batu Cinta":
                latlng = new LatLng(-7.166902, 107.358045);
                break;
            case "Perkebunan Teh Rancabali":
                latlng = new LatLng(-7.149796, 107.381336);
                break;
        }

        viewPager1.setAdapter(adapter1);
        buttonMap = findViewById(R.id.buttonOpenMap);
        final LatLng finalLatlng = latlng;
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toMap = new Intent(deskripsi_wisata.this, maps.class);
                toMap.putExtra("Latlng", finalLatlng);
                startActivity(toMap);
            }
        });
    }
}
