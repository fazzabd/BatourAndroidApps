package app.satu.com.batourproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class deskripsi_wisata extends AppCompatActivity {
    ViewPager viewPager1;
    CustomSwipeAdapter adapter1;
    TextView descTxt;
    DatabaseHelper db = home.db;
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
            Toast.makeText(deskripsi_wisata.this, "Tempat Wisata Tidak Kosong", Toast.LENGTH_LONG).show();
            descTxt.setText(t.getDeskripsi());
        }

        viewPager1.setAdapter(adapter1);
    }
}
