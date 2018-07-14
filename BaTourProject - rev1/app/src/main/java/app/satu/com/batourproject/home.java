package app.satu.com.batourproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class home extends AppCompatActivity {
    ListView lv1;
    ViewPager viewPager;
    CustomAdapterHome adapterlist;
    CustomSwipeAdapter adapter;
    Toolbar toolbar;
    Context context;
    ImageButton buttonNature , buttonAround;
    public static DatabaseHelper db;
    int [] listGambar={R.drawable.kawahputih,R.drawable.perkebunantehrancabali,R.drawable.situpatenggang,R.drawable.tangkubanperahu,
            R.drawable.batucinta,R.drawable.kawahputih,R.drawable.perkebunantehrancabali};
    String [] listJudul={"Wisata Alam","Taman Bermain","Wisata Sejarah","Pusat Perbelanjaan ","Wisata Seni dan Budaya","Wisata Kuliner",
                        "Wisata Sekitar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        lv1=(ListView) findViewById(R.id.listViewHome);

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
        db = new DatabaseHelper(getApplicationContext());

        TempatWisata kp = new TempatWisata("Kawah Putih", "alam", "Jalan Raya Soreang Ciwidey Kilo Meter 25, Desa Ciwidey, Kecamatan Ciwidey, Kabupaten Bandung",
                "Kawah Putih adalah sebuah tempat wisata di Jawa Barat yang terletak di kawasan Ciwidey. Kawah putih merupakan sebuah danau yang terbentuk dari letusan Gunung Patuha. Tanah yang bercampur belerang di sekitar kawah ini berwarna putih, lalu warna air yang berada di kawah ini berwarna putih kehijauan, yang unik dari kawah ini adalah airnya kadang berubah warna. Kawah ini berada pada ketinggian +2090 m dpl dibawah puncak/titik tertinggi Gunung Patuha.", 18000,
                "Jam Buka: 07.00 - 17.00 WIB", "-", 8);

        TempatWisata sp = new TempatWisata("Situ Patenggang", "alam", "Jl. Situ Patenggang, Ciwidey, Bandung, ",
                "Situ Patenggang atau Situ Patengan adalah suatu danau yang terletak di kawasan objek wisata alam Bandung Selatan, Jawa Barat, Indonesia, tepatnya di Ciwidey. Terletak di ketinggian 1600 meter di atas permukaan laut, danau ini memiliki pemandangan yang sangat eksotik. Situ patenggang juga memiliki pemandangan alam yang asri, karena disekitarnya terdapat hamparan kebun teh.", 18000,
                "Jam Buka: 09.00-17.00 WIB", "-", 8);

        TempatWisata tp = new TempatWisata("Tangkuban Perahu", "alam", "Jl. Raya Tangkuban Perahu, Lembang Bandung ",
                "Tangkuban Parahu atau Gunung Tangkuban Perahu adalah salah satu gunung yang terletak di Provinsi Jawa Barat, Indonesia. Sekitar 20 km ke arah utara Kota Bandung, dengan rimbun pohon pinus dan hamparan kebun teh di sekitarnya, Gunung Tangkuban Perahu mempunyai ketinggian setinggi 2.084 meter. Bentuk gunung ini adalah Stratovulcano dengan pusat erupsi yang berpindah dari timur ke barat. Jenis batuan yang dikeluarkan melalui letusan kebanyakan adalah lava dan sulfur, mineral yang dikeluarkan adalah sulfur belerang, mineral yang dikeluarkan saat gunung tidak aktif adalah uap belerang. Daerah Gunung Tangkuban Perahu dikelola oleh Perum Perhutanan. Suhu rata-rata hariannya adalah 17 oC pada siang hari dan 2 °C pada malam hari.", 20000,
                "Jam Buka: 07.00-17.00 WIB", "-", 8);

        TempatWisata bc = new TempatWisata("Batu Cinta", "alam", "Jl. Situ Patenggang, Rancabali, Bandung ",
                "Di seberang danau di Situ Patenggang terdapat lokasi yang cukup menarik ynag diberi nama Batu Cinta yang konon dipercaya akan memberi kelanggengan cinta bagi pasangan yang datang berkunjung ke lokasi tersebut.", 20000,
                "Jam Buka: 06.00-18.00 WIB", "-", 8);
        TempatWisata ptr = new TempatWisata("Perkebunan Teh Rancabali", "alam", "Jl. Rancabali, Ciwidey, Bandung",
                "Rancabali adalah sebuah kecamatan di Kabupaten Bandung, Provinsi Jawa Barat, Indonesia. Sebuah kecamatan hasil pemekaran dari Kec. Ciwidey, yang berbatasan langsung dengan Kab Cianjur. Rancabali berjarak 60 KM dari kota Bandung, terletak di dataran tinggi yang memiliki Iklim sejuk karena di kelilingi oleh pegunungan, hamparan perkebunan teh dan lahan pertanian masyarakat. pertumbuhan ekonomi masyarakat Rancabali dari tahun ke tahun mengalami kemajuan di karenakan Rancabali mejadi pusat tujuan wisata, baik wisata alam, wisata edukasi, agrowisata, wisata religi. walaupun belum ditunjang oleh sarana prasaana dan infrastuktur yang memadai dari pihak pemda.", 0,
                "Jam Buka: 07.00-17.00 WIB", "-", 8);
        TempatWisata gt = new TempatWisata("Gang Tamim", "belanja", "Gg. Abah Tamim, Dago, Coblong, Kota Bandung, Jawa Barat",
                "Suka mengkoleksi jeans? Atau ingin cari jeans berkualitas dengan harga murah? Anda bisa datang ke Gang Tamim yang bisa diakses dengan mudah melalui Jalan Sudirman. Dengan biaya mulai dari Rp100.000 hingga Rp200.000, Anda sudah bisa membeli dan memilih jeans dari bahan yang Anda pilih sendiri. Tidak perlu kuatir dengan pilihan bahan yang ada, di tempat wisata belanja di Bandung ini pilihan bahannya sangat lengkap dan tentunya murah.", 0,
                "Jam Buka: 09:30–23:30 WIB", "-", 8);
        TempatWisata pjp = new TempatWisata("Pasar Jumat Pusdai", "belanja", "Jalan Diponegoro No.63, Cihaur Geulis, Cibeunying Kaler, Cihaur Geulis, Cibeunying Kaler, Kota Bandung, Jawa Barat",
                "Sesuai dengan namanya, tempat wisata belanja murah di Bandung ini hadir setiap hari Jumat. Berbagai macam barang murah meriah dijual di tempat wisata belanja yang terletak di Jalan Diponegoro ini, mulai dari baju sisa ekspor hingga baju bekas. Jika Anda pandai memilih barang bagus dan juga menawar harga, Anda pasti bisa mendapatkan barang dengan harga miring dan kualitas lumayan bagus.", 0,
                "Jam Buka: 07:00–17:00 WIB", "-", 8);
        TempatWisata pbtc = new TempatWisata("Pasar Baru Trade Center", "belanja", "Jalan Otto Iskandar Dinata No.70, Bandung, Jawa Barat",
                "Tak jauh berbeda dengan Pasar Baru yang ada di Jakarta, Pasar Baru Bandung juga merupakan salah satu pusat belanja terbesar di daerahnya. Tempat wisata belanja di Bandung ini juga sering disebut sebagai Mangga Dua-nya Bandung karena Pasar Baru Bandung juga merupakan salah satu tempat belanja stok dagangan bagi para pedagang dari berbagai tempat, sama dengan Mangga Dua di Jakarta.", 0,
                "Jam Buka: 07:00–17:00 WIB", "( 022 ) 4245555", 8);
        TempatWisata pc = new TempatWisata("Pasar Cibaduyut", "belanja", "Jalan Cibaduyut Raya No. 7, Kb. Lega, Bojongloa Kidul, Kota Bandung",
                "Pasar Cibaduyut adalah pusatnya tas dan sepatu dengan bahan kulit. Walaupun termasuk produk lokal, sepatu yang diproduksi di pasar ini terkenal awet dan juga tahan lama sehingga tidak kalah bersaing dengan merek-merek sepatu terkenal yang ada di mall Bandung. Jika Anda ingin memesan sepatu dengan desain sendiri, Anda berada di tempat wisata belanja yang tepat. Anda hanya perlu memesan dan kemudian menunggu selama 1 atau 2 minggu tergantung kerumitan model sepatu yang Anda pesan.", 0,
                "Jam Buka: 08:00–22:00 WIB", "-", 8);
        TempatWisata mp = new TempatWisata("MD Plaza", "belanja", "Jalan Dalem Kaum, Balong Gede, Balonggede, Bandung, Kota Bandung, Jawa Barat",
                "Pusat belanja di Bandung ini memang masih terbilang baru. Dulunya para pedagang yang berdagang di MD ini berlokasi di King’s Shopping Center. Namun karena kejadian kebakaran beberapa waktu lalu, mereka pindah ke MD Plaza. Walaupun bernama Plaza, tapi barang yang dijual tergolong murah lho. Anda bisa mencoba berkunjung ke MD Plaza ini di Jalan Dalem Kaum sebagai alternatif tempat wisata belanja murah di Bandung.", 0,
                "Jam Buka: 10:00–22:00 WIB", "0810-0000-0000", 8);



        //insert data hardcode
        db.insertTempatWisata(kp);
        db.insertTempatWisata(sp);
        db.insertTempatWisata(tp);
        db.insertTempatWisata(bc);
        db.insertTempatWisata(ptr);
        db.insertTempatWisata(gt);
        db.insertTempatWisata(pjp);
        db.insertTempatWisata(pbtc);
        db.insertTempatWisata(pc);
        db.insertTempatWisata(mp);


        final ArrayList<TempatWisata> tw = db.getTempatWisata();

        if(tw.isEmpty())
            Toast.makeText(home.this, "Data Tempat Wisata tidak terambil", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(home.this, "Data Tempat Wisata terambil", Toast.LENGTH_LONG).show();
        context = this;
        viewPager = findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        lv1.setAdapter(new CustomAdapterHome(this,listGambar,listJudul));
        viewPager.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        /*buttonNature = findViewById(R.id.natureButton);

        buttonNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toNatureList = new Intent(home.this, list_page.class);
                toNatureList.putExtra("LIST", (Serializable) tw);
                startActivity(toNatureList);
            }
        });

        buttonAround = findViewById(R.id.aroundButton);
        buttonAround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAroundMap = new Intent(home.this, maps.class);
                startActivity(toAroundMap);
            }
        });*/

    }
}
