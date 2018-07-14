package app.satu.com.batourproject;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class home extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    Toolbar toolbar;
    ImageButton buttonNature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        /*
        //memeriksa database
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        TempatWisata t = new TempatWisata("gunung", "alam", "jalan", "bagus", 10,
                "10-13", "08080", 8);

        //insert data hardcode
        boolean inserted = db.insertTempatWisata(t);

        //untuk memeriksa apakah data berhasil dimasukkan
        if(inserted == true)
            Toast.makeText(home.this, "Data Tempat Wisata inserted!", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(home.this, "Data Tempat Wisata not inserted!", Toast.LENGTH_LONG).show();
        */
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        TempatWisata t = new TempatWisata("Kawah Putih", "alam", "Jalan Raya Soreang Ciwidey Kilo Meter 25, Desa Ciwidey, Kecamatan Ciwidey, Kabupaten Bandung",
                "bagus", 18000,
                "Jam Buka: 7.00 - 17.00 WIB", "08080", 8);

        //insert data hardcode
        db.insertTempatWisata(t);

        TempatWisata a = new TempatWisata("Perkebunan Teh Rancabali", "alam", "Jl. Rancabali, Ciwidey, Bandung", "bagus", 0,
                "Jam Buka: 7.00-17.00 WIB", "09080", 8);

        //insert data hardcode
        db.insertTempatWisata(a);


        final ArrayList<TempatWisata> tw = db.getTempatWisata();

        if(tw.isEmpty())
            Toast.makeText(home.this, "Data Tempat Wisata tidak terambil", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(home.this, "Data Tempat Wisata terambil", Toast.LENGTH_LONG).show();

        viewPager = findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        buttonNature = findViewById(R.id.natureButton);

        buttonNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toNatureList = new Intent(home.this, list_page.class);
                toNatureList.putExtra("LIST", (Serializable) tw);
                startActivity(toNatureList);
            }
        });
    }
}
