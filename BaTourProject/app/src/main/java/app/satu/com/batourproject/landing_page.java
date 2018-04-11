package app.satu.com.batourproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 4/4/2018.
 */

public class landing_page extends AppCompatActivity {
    public Button buttonGetStarted;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        Alamat a = new Alamat(6, 6);

        long inserted = db.createAlamat(a);

        buttonGetStarted = findViewById(R.id.button_get_started);

        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(landing_page.this, home.class);
                startActivity(toHome);
            }
        });
    }
}
