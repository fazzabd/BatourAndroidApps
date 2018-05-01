package app.satu.com.batourproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by USER on 4/4/2018.
 */

public class landing_page extends AppCompatActivity {
    public Button buttonGetStarted;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        /*
        //memeriksa database
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        Alamat a = new Alamat(69, 69);

        //insert data hardcode
        boolean inserted = db.insertAlamat(a);

        //untuk memeriksa apakah data berhasil dimasukkan
        if(inserted == true)
            Toast.makeText(landing_page.this, "Data inserted!", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(landing_page.this, "Data not inserted!", Toast.LENGTH_LONG).show();
        */

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
