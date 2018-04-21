package app.satu.com.batourproject;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class deskripsi_wisata extends AppCompatActivity {
    ViewPager viewPager1;
    CustomSwipeAdapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_wisata);

        viewPager1 = findViewById(R.id.view_pager1);
        adapter1 = new CustomSwipeAdapter(this);
        viewPager1.setAdapter(adapter1);
    }
}
