package app.satu.com.batourproject;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    Toolbar toolbar;
    ImageButton buttonNature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

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
                startActivity(toNatureList);
            }
        });
        //getSupportActionBar().setTitle("BaTour");
        //toolbar.setSubtitle("Bandung Tourism");
        //toolbar.setLogo(R.drawable.logo);
        //toolbar.setNavigationIcon(R.drawable.food); untuk navigasi di kiri toolbar
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }*/
}