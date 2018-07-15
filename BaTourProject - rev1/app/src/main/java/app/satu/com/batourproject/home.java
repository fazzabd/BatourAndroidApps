package app.satu.com.batourproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
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
    int [] listGambar={R.drawable.w_alam,R.drawable.w_bermain,R.drawable.w_sejarah,R.drawable.w_belanja,
            R.drawable.w_seni,R.drawable.w_kuliner,R.drawable.w_position};
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

        TempatWisata kp = new TempatWisata("Kawah Putih", "alam", "Jl. Raya Soreang Ciwidey, Ciwidey, Bandung, Jawa Barat 40973",
                "Kawah Putih adalah sebuah tempat wisata di Jawa Barat yang terletak di kawasan Ciwidey. Kawah putih merupakan sebuah danau yang terbentuk dari letusan Gunung Patuha. Tanah yang bercampur belerang di sekitar kawah ini berwarna putih, lalu warna air yang berada di kawah ini berwarna putih kehijauan, yang unik dari kawah ini adalah airnya kadang berubah warna. Kawah ini berada pada ketinggian +2090 m dpl dibawah puncak/titik tertinggi Gunung Patuha.", 15000,
                "Jam Buka: 07.00 - 17.00 WIB", "-", 8);

        TempatWisata sp = new TempatWisata("Situ Patenggang", "alam", "Jl. Situ Patenggang, Ciwidey, Bandung, ",
                "Situ Patenggang atau Situ Patengan adalah suatu danau yang terletak di kawasan objek wisata alam Bandung Selatan, Jawa Barat, Indonesia, tepatnya di Ciwidey. Terletak di ketinggian 1600 meter di atas permukaan laut, danau ini memiliki pemandangan yang sangat eksotik. Situ patenggang juga memiliki pemandangan alam yang asri, karena disekitarnya terdapat hamparan kebun teh.", 18000,
                "Jam Buka: 09.00-17.00 WIB", "-", 8);

        TempatWisata tp = new TempatWisata("Tangkuban Perahu", "alam", "Jl. Raya Tangkuban Perahu, Lembang Bandung ",
                "Tangkuban Parahu atau Gunung Tangkuban Perahu adalah salah satu gunung yang terletak di Provinsi Jawa Barat, Indonesia. Sekitar 20 km ke arah utara Kota Bandung, dengan rimbun pohon pinus dan hamparan kebun teh di sekitarnya, Gunung Tangkuban Perahu mempunyai ketinggian setinggi 2.084 meter. Bentuk gunung ini adalah Stratovulcano dengan pusat erupsi yang berpindah dari timur ke barat. Jenis batuan yang dikeluarkan melalui letusan kebanyakan adalah lava dan sulfur, mineral yang dikeluarkan adalah sulfur belerang, mineral yang dikeluarkan saat gunung tidak aktif adalah uap belerang. Daerah Gunung Tangkuban Perahu dikelola oleh Perum Perhutanan. Suhu rata-rata hariannya adalah 17 oC pada siang hari dan 2 °C pada malam hari.", 16000,
                "Jam Buka: 07.00-16.00 WIB", "-", 8);

        TempatWisata bc = new TempatWisata("Batu Cinta", "alam", "Jl. Situ Patenggang, Rancabali, Bandung ",
                "Di seberang danau di Situ Patenggang terdapat lokasi yang cukup menarik yang diberi nama Batu Cinta yang konon dipercaya akan memberi kelanggengan cinta bagi pasangan yang datang berkunjung ke lokasi tersebut.", 15000,
                "Jam Buka: 08.00-18.00 WIB", "-", 8);
        TempatWisata ptr = new TempatWisata("Perkebunan Teh Rancabali", "alam", "Jl. Rancabali, Ciwidey, Bandung",
                "Rancabali adalah sebuah kecamatan di Kabupaten Bandung, Provinsi Jawa Barat, Indonesia. Sebuah kecamatan hasil pemekaran dari Kec. Ciwidey, yang berbatasan langsung dengan Kab Cianjur. Rancabali berjarak 60 KM dari kota Bandung, terletak di dataran tinggi yang memiliki Iklim sejuk karena di kelilingi oleh pegunungan, hamparan perkebunan teh dan lahan pertanian masyarakat. pertumbuhan ekonomi masyarakat Rancabali dari tahun ke tahun mengalami kemajuan di karenakan Rancabali mejadi pusat tujuan wisata, baik wisata alam, wisata edukasi, agrowisata, wisata religi. walaupun belum ditunjang oleh sarana prasaana dan infrastuktur yang memadai dari pihak pemda.", 0,
                "Jam Buka: 07.00-17.00 WIB", "-", 8);
        TempatWisata bip = new TempatWisata("Bandung Indah Plaza", "belanja", " Jalan Merdeka No. 56, Citarum, Bandung, Jawa Barat 40115, Indonesia",
                "Bandung Indah Plaza adalah salah satu pusat perbelanjaan besar di kota Bandung. Mall ini merupakan pusat perbelanjaan tertua di Bandung. Didirikan pada akhir tahun 80-an, mulai buka tahun 1989 dan secara resminya dibuka pada 19 Agustus 1990. Dikenal dengan nama BIP, menjadi sebuah ikon belanja di Bandung masa itu. Sebelumnya, masyarakat Bandung hanya mengenal konsep department store dan pasar swalayan. Terletak di pusat kota , Jalan Merdeka Bandung. Dengan ada BIP maka kawasan ini menjadi tempat nongkrong/hang out baru beralih dari kawasan Alun-Alun kota dan juga menjadi awal pembangunan mall dan pusat perbelanjaan di Bandung Utara (sebelumnya hampir semuanya ada di Bandung selatan, batas rel kereta api). BIP yang sekarang sudah mengalami perluasan dan renovasi bangunannya, serta berpindah management/pemilik lama ke yang pemilik baru disertai dengan perubahan konsep baru pula. Di mall ini terdapat beberapa tenant seperti Toserba Yogya (ditutup pada 2009), Hypermart, Matahari Department Store, BIP, Pizza Hut, Timezone, dan lain-lain. Mall ini terintergrasi dengan hotel Hyatt Regency Bandung.", 0,
                "Jam Buka: 08:00–22:00 WIB", "-", 8);
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

        TempatWisata br = new TempatWisata("Batagor Riri", "kuliner", "Jl. Burangrang No.41, Malabar, Lengkong, Kota Bandung, Jawa Barat 40262",
                "Memang jika bicara batagor yang enak di kota bandung ini, tidak salah salain informasi dari mulut ke mulut dan juga informasi lewat internet terutama media sosial, banyak sekali orang-orang yang pernah berkunjung ke sini sangat merekomendasikan Batagor ini sebagai salah satu kuliner yang wajib untuk dikunjungi yang lokasinya berada di jalan Burangrang No 41, Lengkong kota Bandung. Batagor Riri memang sudah tidak hanya menjadi favorit kuliner warga bandung atau wisatawan pada umumnya, namun sensasi cita rasanya telah banyak menarik minat banyak kalangan artis ibukota untuk datang ke tempat makan batagor enak di kota bandung ini. Jika anda mau mebuktikan kebenaran informasi saya berikut, silahkan jika anda datang pertama kali ke sana, coba deh, lihat-lihat dulu sebelum memesan batagornya ( Paling ditanya sama pelayannya, mas mau beli apa mau lihat-lihat ?,,heheh), di sana anda kan menjumpai foto-foto artis yang pernah mampir ke tempat jualan batagor yang sangat enak di Bandung ini.", 10000,
                "Jam Buka: 08:00–20:00 WIB", "-", 8);

        TempatWisata dmh = new TempatWisata("D'Moners Home ", "kuliner", "Jl. PH.H. Mustofa No.73, Sukapada, Cibeunying Kidul, Kota Bandung, Jawa Barat 40125.",
                "Doraemon adalah sebuah tokoh fiktif binatang kucing yang datang dari masa dari abad 222 yang di dalam ceritanya dikirim ke abad 20 untuk menolong tokoh kartin sosok manusia bernama Nobita.Dalam ceritanya kita ketahui bagaimana “kesaktian” doraemon dan bagaimana pula setianya menemani dan membantu nobita dan doraemon terkenal juga dengan makanan favoritnya dorayaki. Nah lalu apa hubungannya Doremon dengan D’Moners Home Kota Bandung ini ?. Yang pasti menurut pendapat kang dian sendiri, dari asal usul namanya saja sudah keliatan bahwa nama tempat disediakan khusus bagi anda para pecinta tokoh doraemon. sehingga jangan kaget jika anda datang ke cafe di jalan PHH Mustopa ini banyak dikunjungi oleh doraemon lover, baik yang datang sendiri maupun yang tergabung dalam komunitas. amun demikian, tidak sedikit juga pengunjung yang datang ke D’Moner Home Bandung ini adalah wisatawan yang tertarik dan penasaran setelah mengetahuinya di dunia maya. Pemilik atau pengelola cafe ini memberinya nama D’Moners, sama uniknya dengan nama cafe unik di bandung lainnya seperti D’Dieuland ( Disneyland ) dan Rabbit Town yang namanya sempat kontroversial ini.", 18000,
                "Jam Buka: 11:00–21:30 WIB", "-", 8);

        TempatWisata pb = new TempatWisata("Pelangi Balonggede ", "kuliner", "Jalan Dalem Kaum, Balonggede, Regol, Kota Bandung, Jawa Barat 40251.",
                "Sahabat traveler’s, mungkin ada dari asahabat yang bertanya, kenapa tem,pat wisata kuliner terbaru di kota bandung ini diberikan nama “pelangi” ?. nah ternyata alasannya adalah di kawasan ini nanti akan terdapat banyak pusat kuliner, mulai dari rumah makan tradisional, hingga tempat yang menjual aneka jajanan khas bandung seperti Siomay serta kue- kue enak yang tak kalah lezat dengan Bandung Makuta Cake, Bandung Kunafe dan Bandung Princes Cake. tidak hanya itu saja, di kawasan tempat wisata kuliner pelangi balonggede bandung ini juga disediakan banyak stand yang menjual beragam Oleh – oleh Bandung.", 0,
                "Jam Buka: 07.00 – 22.00  WIB", "-", 8);

        TempatWisata oc = new TempatWisata("Orofi Cafe Bandung ", "kuliner", "Jl. Lembah Pakar Tim. No.99, Ciburial, Cimenyan, Bandung, Jawa Barat 40198.",
                "Sahabat traveler’s, ada banyak tempat makan dan nongkrong di kota bandung seperti cafe dan resto yang menawarkan sisi eksotisme kota bandung di lihat dari ketinggian. Dan salah satunya adalah Cafe Orofi di Lembah Pakar Dago ini, yang mana cafe ini menempati area Rooftop di sebuah bangunan yang dulunya pernah digunakan The Valley Cafe. Dari cafe di dago sahabat traveler’s, kita bisa dengan mudah menyaksikan indahnya pemandangan kota bandung dengan kerlap – kerlip lampunya di malam hari atau Bandung City Light, sementara jika anda datang di waktu sore hari sekitar jam 4 sore, maka anda di berada di sini seakan mendapati sebuah cafe di bandung yang romantis dengan suasana sunsetnya, terlebih jika saat mulai menjelang malam, dengan mulai dinyalakannya lampu – lampu cafe yang berwarna temaram, membuat suasana semakin nyaman dan penuh kehangatan. Ya benar, pemandagan sore hari dimana anda bisa dengan jelas menikmati keindahan hamparan kota bandung dan saat matahari terbenam secara bersamaan sangat bagus sekali dari cafe ini.", 0,
                "Jam Buka: 16.00 – 23.00 WIB", "-", 8);

        TempatWisata gs = new TempatWisata("Goldstar 360 Cafe Bandung", "kuliner", "Jalan Dangdeur Indah No. 2B, Sukagalih, Sukajadi, Kota Bandung, Jawa Barat 40163.",
                "cafe Goldstar 360 ini menyediakan beragam menu hidangan mulai dari makanan ringan, makanan berat serta tentunya makanan penutup serta sejumlah minuman. Untuk jenis menu kulinernya, cafe goldstar 360 menyajikan aneka hidangan mulai dari indonesia food, oriental atau asian food serta tentunyya Western Food. Nah berikut adalah menu yang menjadi hidangan terfavorit cafe goldstar 360 yang menjadi buruan kuliner pengunjung yang datang dan makan di sini : yaitu Western Food seperti Chicken Steak, Slash Fried Stick serta Hungry Bear. rentang harga yang ditawarkan oleh cafe goldstar 360 bandung ini adalah menu makanan mulai Rp.20.000 – Rp.60.000/porsi, sementara minuman mulai Rp.12.000 – Rp.35.000/porsi. untuk memberikan kenyamanan kepada seluruh pengunjungnya, tempat ini juga menawarkan banyak fasilitas – fasilitas yang sangat memanjakan pengunjungnya seperti ; Lapangan Basket, Futsal dan Bilyard",0," Jam Buka :11.00 – 00.00 WIB.","-", 8);

        TempatWisata ks = new TempatWisata("Kolam Renang Karang Setra", "taman bermain", "Jalan Dangdeur Indah No. 2B, Sukagalih, Sukajadi, Kota Bandung, Jawa Barat 40163.",
                "Kolam Renang Karang Setra Bandung pertama kali diresmikan oleh Presiden pertama Indoensia Soekarno pada tahun 1954. Kolam Renang Karang Setra Bandung yang pertama kali digagas dalam pembuatannya dengan konsep kolam renang outdoor di tengah kawasan hutan kota Bandung yang luas, dengan salah satu fungsinya kolam renang karang setra di bandung ini digunakan sebagai kolam renang pembinaan atlit renang pada saat itu, namun kini karang setra bandung telah merubah diri dengan konsep wisata air yang lebih up todate, modern dan lengkap sebagai pusat hiburan keluarga, dengan fasilitas wisata airnya yang lengkap seperti waterPark modern lainnya. Berwisata di Kolam Renang Karang Setra Bandung, pengunjung tidak hanya bisa menikmati aneka wahana permainan air yang tersedia, akan tetapi nilai lebih dari tempat ini adalah karena berada di kawasan hutan kota Bandung, maka anda juga bisa menikmati sekaligus merasakan pemandangan indah berhawa sejuk yang akan membuat nyaman selama beraktifitas di sini.",45000,"Jam Buka : 08.00 – 16.00 WIB.","-", 8);

        TempatWisata tsb = new TempatWisata("Trans Studio Bandung", "taman bermain", "Jl. Gatot Subroto No.289, Cibangkong, Batununggal, Kota Bandung, Jawa Barat 40273, Indonesia",
                "Lokasi ini merupakan salah satu tempat wisata yang menjadi andalan di Kota Bandung. Trans Studio termasuk indoor theme park terbesar di dunia yang menyediakan setidaknya 20 wahana permainan dan berbagai sarana hiburan yang semuanya dibagi menjadi tiga area. Yang pertama adalah Studio Central .Di area ini kita bisa menaiki beberapa wahana yang memacu adrenalin, seperti roller coaster, kincir vertigo, atau ayunan giant swing. Selain wahana yang mendebarkan, ada pula Trans City Theater, simulator Marvel Superheroes 4D, Science Center, Kiddy’s Land, dan masih banyak lagi. Yang Kedua adalah The Lost City, Area ini penuh dengan petualangan. Kita bisa melakukan panjat tebing, menaiki kapal perompak, atau menonton pertunjukan seru di Amphitheater. Dan yang terakhir adalah Magical Corner. Di sini kita akan menemukan banyak hal yang menegangkan. Ada wahana Dragon Rides, mengunjungi Dunia Lain, atau melihat pertunjukan Special Effect Action yang seru. ",170000,"Jam Buka : 09.00 – 22.00 WIB.","-", 8);

        TempatWisata tm = new TempatWisata("Taman Miniatur Kereta Api Lembang", "taman bermain", "Floating Market Lembang, jalan Grand Hotel No 33E Lembang, Bandung Jawa Barat ( Belakang lokasi Grand Hotel Lembang )",
                "Sahabat traveler’s, taman miniatur kereta api adalah tempat wisata baru di lembang bandung yang berlokasi atau berada di dalam kawasan wisata kuliner terpopuler di lembang yaitu pasar terapung lembang ( Floating Market ) adalah ternyata merupakan taman miniatur kereta api terbesar yang ada di indonesia, karena berdiri di atas lahan seluas hampir 2 hektar.Di dalam taman miniatur kereta api lembang ini, anda akan bisa melihat miniatur kereta api lengkap dengan pemandangan alamnya, serta ornamen pelengkap lainnya seperti rel kereta, stasiun, pom bensin, menara pengawas, jembatan, terowongan hingga rumah penduduk.Pastinya taman miniatur kereta api indonesia ini akan tampak sangat nyata dan persis sama dengan aslinya karena skala miniatur kereta apinya juga dibuat dengan perbandingan 1-24, sangat detil sekali. Jika anda berkunjung ke taman miniatur kereta api lembang ini, maka karena lokasinya memang berada di dalam floating market, maka wahana miniatur kereta api ini pun sangat dekat dengan wahana permainan seru lainnya yang telah ada terlebih dahulu di Folating market lembang seperti Taman Kelinci, Flying Fox, Sepeda Air, Paddle Boat, Kereta Api dan masih banyak yang lainnya, sehingga dijamin anak-anak anda kan betah berlama-lama bermain di sana.  ",20000,"Jam Buka : 09.00 – 20.00 WIB.","-", 8);

        TempatWisata hf = new TempatWisata("Happy Farm Lembang", "taman bermain", "Jalan Raya Lembang No 125 D, Kabupaten Bandung Barat",
                "Happy Farm selama ini memang dikenal cukup baik oleh wisatawan sebagai salah satu lokasi kebun petik buah strawberry sendiri yang sangat mengasyikan, tak kalah dengan yang ada di Natural Strawberry Land maupun di Kebun Strawberry Ciwidey. Tempat ini selalau ramai diwaktu libur akhir pekan, apalagi di musim liburan anak sekolah maupun libur nasional lainnya, terutama oleh wisatawan yang datang dari ibukota jakarta dan sekitarnya. Sahabat tarveler’s pecinta Wisata Bandung, hal pertama yang menarik dan pastinya seru yang bisa anda lakukan di sini adalah kita bisa memetik sendiri secara langsung buah strawberry dari tanamannya. Anda akan nyaman melakukannya karena tanaman buah strawberry tersebut diletakan berjajar secara rapi di areal kebun yang cukup luas, dan diletakan di dalam plastik-plastik yang sudah diisi tanah. Dengan dibekali gunting kecil dan keranjang, anda bisa memilih dan memilah sendiri buah mana yang anda ambil dari tanaman strawberrynya dengan cara mengunting batangnya dan menaruhnya ke dalam keranjang yang sudah disiapkan. Nah setelah anda berhasil mengumpulkan buah strawberry yang anda inginkan yang terkumpul di keranjang, selanjutnya anda pun langsung membawanya ke kasir dan membayarnya dengan jumlah berat yang telah ditimbang. Sampai di sini, buah strawberry yang sudah anda bayar di kasir, bisa anda kemas langsung untuk dibawa pulang, atau diolah langsung di tempat sesuai dengan keinginan anda sendiri.",10000,"Jam Buka : 08.00 – 18.00 WIB.","-", 8);

        TempatWisata tfb = new TempatWisata("Taman Film Bandung", "taman bermain", "Jalan Layang Pasupati, Bandung Wetan, Kota Bandung Jawa Barat Indonesia.",
                "Sahabat traveler’s, berbicara tentang Taman Film Bandung, maka seperti arti namanya lokasi salah satu tempat hiburan di kota Bandung ini diperuntukan sebagai tempat atau sarana menonton film bagi warga bandung. Namun pada perkembangannya taman film yang pertama kali ada di indonesia ini tidak hanya diperuntukan untuk menyaksikan berbagai acara nonton film ,akan tetapi sudah dijadikan tempat nobar ( nonton bareng ) warga bandung dan sekitarnya untuk menonton pertandingan sepakbola klub kebanggan kota Bandung Persib. Taman Film Bandung berdiri di atas areal lahan seluas 1.300 M2, dengan kapasitas penonton yang bisa masuk di dalamnya hampir 500 orang penonton. Tidak tanggung-tanggung untuk memanjakan kenyamanan taman yang cukup unik di bandung ini, taman film di bandung ini pun dilengkapi dengan teknologi canggih seperti videotron raksasa berukuran 4 x 8 Meter, dengan dukungan sound system berdaya setara 33.000 watt. Kenyamanan kawasan taman film yang diperuntukan sebagai tempat “ngadaweung” wargi urang bandung ini pun dilengkapi dengan tempat duduk beton yang bergaya terasering bak galengan di pesawahan yang berundak-undak, hingga bagi pengunjung yang mau lesehan atau duduk bersila di bawah pun akan sangat nyaman, karena di bawahnya sudah ditanami rumput sintesis yng sangat bagus sekali dan empuk untuk diduduki.",0,"Jam Buka : 17.00 – 22.00  WIB.","-", 8);

        TempatWisata aab = new TempatWisata("Alun-Alun Bandung", "sejarah", "Jl. Asia Afrika, Balonggede, Regol, Kota Bandung, Jawa Barat 40251, Indonesia",
                "Ada banyak hal yang menarik dari obyek wisata Bandung  ini, terutama dari sisi sejarahnya di masa silam. Dahulu, ketika kota Bandung baru berdiri, kuda menjadi transportadi andalan yang digunakan untuk mengantarkan surat. Ada sebuah jalan yang bernama Jalan banceuy yang dahulu bernama Oude Kerkhoffweg karena disna merupakan bekas kuburan China. Lambat laun, lokasi tersebut kini semkain ramai digunakan sebagai pusat penjualan suku cadang mobil dan peralatan listrik. Alun – alun bandung yang menempati sisi di bagian selatan salah satu jalan raya pos (Grote Postweg) yang lokasinya berdekatan dengan Kantor Pos Besar Bandung, terkadang disebut masyarakat sekitar masih ada, tapi juga tidak ada. Aneh memang. Masyarakat yang menyebut tidak ada, beranggapan bahwa lokasi yang dimaksud telah tiada dan secara fisik telah digantikan dengan bangunan plaza modern yang menjadi bagian dari Masjid Raya bandung. Sebaliknya, saah satu obyek wisata bandung yang bersejarah ini disebut oleh sebagian masyarakat masih ada, lantaran mereka jugha menyebutkan tempat ini sebagai Alun – alun Bandung. Sempat direnovasi beberapa kali oleh pemerintah hingga terakhir dilakukan pada tahun 2014. Hingga pada tanggal 31 Desember pada tahun yang sama, Walikota Bandung yang saat itu dijabat oleh Ridwan Kamil, meresmikan pengunaan Alun – alun Bandung secara resmi. Dengan luas area taman yang mencapai 1,2000 meter persegi, kawasan obyek wisata bandung ini dilengkapi dengan aneka fasilitas yang memanjakan pengunjungnya.  Dilengkapi dengan rumput sintetis, fasilitas pendukung seperti arena bermain anak, perpustakaan hingga jaringan internet melalui WiFi, bisa ditemukan disini. Disebelah utara alun -alun, terdapat halte bis yang memanjang guna melengkapi fasilitas bangunan yang ada pada Alun – laun tersebut. Selain itu, di kawasan ini pula, banyak terdapat penjaja kuliner dan pedagang aksesoris. Selain berfungsi sebagai taman hiburan dan sarana berkumpul, disekitar Alun – alun ini juga terdapat berbagai lokasi untuk berbelanja seperti di Jalan Dalem Kaum, Jalan Dewi Sartika, Jalan Otto Iskandardinata, atau Jalan Sudirman.",0,"Jam Buka : 24 jam.","-", 8);

        TempatWisata gb = new TempatWisata("Gubernuran Bandung (Gedung Pakuan)", "sejarah", "Jl. Cicendo No 1 Pasir Kaliki Bandung, Babakan Ciamis, Sumur Bandung, Bandung City, West Java 40171, Indonesia",
                "Salah satu bangunan yang sarat dengan nilai sejarah adalah Gedung Pakuan atau biasa disebut juga sebagai Gubernuran. Proses dibangunnya gedung ini pada tahun 1864 hingga selesai pada tahun 1867, merupakan perintah dari Gubernur Jenderal Ch.F. Pahud. Kronologi sejarah awal mula dibangunnya gedung ini disebabkan oleh pemindahan Ibukota Karesidenan Priangan dari Cianjur ke Bandung. Namun, pemindahan tersebut baru benar – benar terlaksana oleh residen Van der Moore. Pemindahan ini juga disebabkan oleh bencana alam meletusnya Gunung Gede yang memporak – porandakan Kota Cianjur. Gedung Pakuan berhasil dibangun dengan mengerahkan pasukan Genie Militair, Belanda, yang juga disokong oleh Bupati Bandung ke-8, R.A Wiranatakusumah. Bupati yang juga dikenal sebagai Dalem Bintang R.A. Wiranatakusumah merupakan Bupati yang menjabat pada periode 1846 hingga 1847. Dalam prosesnya, R.A. Wiranatakusumah banyak mengerahkan tenaga penduduk lokal yang diambil dari kampung Babakan Bogor dan Balubur Hilir untuk menyelesaikan pembangunan gedung tersebut. Sebagai imbalan atas jasa mereka, penduduk yang terlibat pengerjaan gedung tersebut dibebaskan dari biaya pajak. Salah satu bentuk yang eksotis dari Gedung Pakuan ini adalah arsitektur yang digunakan menggunakan gaya Indische Empire Stijl yang sangat berkelas. Gaya arsitektur bangunan gedung ini juga sangat diminati oleh Jenderal Herman Willem Daendels. Perancang Gedung Priangan yang monumental ini adalah seorang Insinyur yang merupakan kepala dari Departement van Burgerlijke Openbare Werken (B.O.W), yang juga seorang staff dari Residen Van Der Moore. Gedung Pakuan yang digunakan sebagai tempat berdinas dari Residen pertama yang memerintah Kota bandung, merupakan sebuah bangunan bersejarah dan menjadi warisan cagar budaya yang harus dilestarikan keberadaanya. Saat ini, bangunan tersebut difungsikan sebagai rumah dinas dari Gubernur Jawa Barat.",0,"Jam Buka : 08.00-19.00.","-", 8);

        TempatWisata gm = new TempatWisata("Gedung Merdeka Bandung", "sejarah", "Jl. Asia Afrika No. 65 Bandung",
                "Pada tahun 1926, Van Galen Lasr dan C.P Wolff Schoemaker yang merupakan Guru Besar Technische Hoogeschool te Bandoeng ( kini Institut Teknologi Bandung) yang juga merupakan seorang arsitek, merancang sebuah bangunan serbaguna yang sangat megah. Kemegahan gedung ini terlihat dari struktur rancangannya yang sangat luas, penggunaan marmer yang berkilau buatan italia sebagai lantainya, ruangan yang difungsikan sebagai ruang untuk bersantai sembari minum – minum yang terbuat dari kayu cikenhout, ditambah dengan lampu kristal hias sebagai pemanis ruangan yang tergantung dan terlihat gemerlap. Dengan luas areal mencapai 7.500 m2, pertama kali dibangun pada tahun 1895, bangunan ini dinamakan  Sociëteit Concordi, yang digunakan sebagai sarana berkumpul para pembesar, perwira, pegawai perkebunan belanda dan pengusaha Belanda yang ada di Kota Bandung. Di tahun 1926, bangunan megah ini direnovasi ulang secara keseluruhan oleh Wolff Schoemacher, Aalbers dan Van Gallen dan rekan – rekannya. Karena gedung ini digunakan untuk berkumpul para elite Belanda pada masa itu. Pada malam harinya, gedung ini penuh dengan keriuhan oleh mereka yang sedang berpesta, berdansa, menonton pertunjukan kesenian hingga makan malam. Hingga beralih masa pada pendudukan penjajah Jepang, bangunan gedung ini dinamakan Dai Toa Kaman yang berfungsi sebagai pusat kebudayaan. Pada saat peristiwa proklamasi kemerdekaan Indoenesia tanggal 17 Agustus 1945, di gedung ini pula, oleh para pemuda Indonesia kemudian menjadikannya sebagai markas komando yang bertujuan merebut kekuasaan dari penjajah Jepang yang masih tersisa. Setelah pulih dari penjajahan dan kondisi pemerintahan Indonesia telah terbentuk pada periode 1946 hingga 1950, gedung concordia ini difungsikan kembali sebagai tempat untuk menggelar pertemuan umum oleh pemerintahan Haminte Bandung, Negara Pasundan, dan Recomba Jawa Barat.",0,"Jam Buka : 08.00-15.00.","-", 8);
        TempatWisata gsb = new TempatWisata("Gedung Sate Bandung", "sejarah", "Jl. Diponegoro No.22, Citarum, Bandung Wetan, Kota Bandung, Jawa Barat 40115, Indonesia",
                "Kota  Wisata Bandung yang berhawa sejuk, mempunyai sebuah bangunan yang disebut dengan Gedung sate. Gedung eksotis yang kental dengan nilai sejarah dan seni tersebut, menjadi ciri khas  yang ikonik dari Kota yang mempunyai sebutan Priangan tersebut. Gedung Sate yang mulai didirikan pada tahun 1920 tersebut, mempunyai ciri khas berupa ornamennya yang mempunyai arsitektur tusuk sate pada menara utama yang terletak di tengah gedung. Bangunan berwarna putih ini juga disebut sebagai Gouvernements Bedrijven (GB), pada masa penjajahan kolonial Belanda. Prosesi peletakan batu pertama dalam pembangunannya dilakukan oleh Johanna Catherina Coops yang merupakan puteri sulung dari Walikota Bandung, B. Coops. dan Petronella Roelofsen sekaligus mewakili Gubernur Jenderal Hindia Belanda di Batavia, J.P. Graaf van Limburg Stirum. Selain dihadiri oleh tokoh dan pejabat elite pada masa itu, pembangunan Gedung Sate ini merupakan hasil kolaborasi yang telah direncanakan dengan matang oleh tim arsitek Hindia Belanda. Tim arsitek tersenut beranggotakan Ir. J.Gerber yang merupakan seorang arsitek muda lulusan Fakultas Teknik Delf Nederland, Ir.Eh.De Roo dan Ir.G. Hendriks dan didukung oleh pihak dari Gemeente van Bandoeng, diketuai Kol. Pur. VL. Slors. Selain para arsitek Belanda tersebut, pengerjaan bangunan gedung ini juga banyak melibatkan pekerja pribumi dan China, dengan jumlah total hingga 2000 pekerja. Pekerja dari China yang dipekerjakan mencapai 150 orang dengan keahlian sebagai pengukir kayu dan batu nisan. Sementara itu, dari pihak pribumi, banyak yang didatangkan dari Kampung Sekeloa, Kampung Coblong Dago, Kampung Gandok dan Kampung Cibarengkok. Mereka bertugas sebagai tukang batu dan kuli aduk bahan bangunan. Arsitektur Gedung Sate yang mempunyai nuansa tradisional khas Indonesia ini, tidak lepas dari tangan dingin arsitek Ir. J.Gerber dan timnya, serta masukan dan arahan dari maestro arsitek Belanda yaitu Dr.Hendrik Petrus Berlage. Pada medio 1980-an, Gedung sate lebih dikenal sebagai Kantor Gubernur dan digunakan sebagai pusat pemerintahan Provinsi Jawa Barat.  Gedung Sate di masa kini telah menjadi salah satu bangunan cagar budaya yang mempunyai nilai seni dan historis yang tinggi. Tidak salah jika bangunan ini menjadi ikon dari Kota Bandung yang banyak menyita perhatian masyarakat.",0,"Jam Buka : 08.00-16.00.","-", 8);

        TempatWisata gkl = new TempatWisata("Gedung Konvensi Landmark Bandung", "sejarah", "Jalan Braga No 129, Braga Bandung, Jawa Barat.",
                "Kota wisata Bandung yang penuh dengan bangunan bersejarah pada masa penjajahan kolonial Belanda, menyisakan berbagai peninggalan penting yang keberadaannya bisa disaksikan hingga di zaman modern. Salah satu dari gedung bersejarah tersebut adalah Gedung Konvensional Landmark yang terletak di kawasan Braga, Kota Bandung. Gedung yang kini termasuk cagar budaya sejarah yang dilestraikan keberadaanya, mempunyai cerita sejarah yang unik untuk diungkap. Ketika Indonesia menjadi jajahan pemerintah kolonial Belanda, bangunan yang kini dikenal sebagai Gedung Landmark itu, dulunya merupakan bangunan toko buku yang bernama Van Dorp yang didirikan sejak tahun 1922 hingga medio tahun 1960-an. Memasuki tahun 1970, toko buku Van Dorp ditutup dan beralih fungsi menjadi gedung bioskop. Sejak dari saat itu, Gedung Landmark tersebut berubah – ubah fungsinya penggunaannya, meski dari segi bangunan tidak ada perubahan yang mencolok. Di era modern saat ini, Gedung Landmark berubah menjadi gedung serbaguna yang memiliki banyak fungsi dan kegunaan. Salah satu kegiatan yang sering diselenggarakan adalah pesta pernikahan maupun kegiatan resmi lainnya seperti pameran dan bazaar.",0,"Jam Buka : 08.00-18.00.","-", 8);

        TempatWisata sau = new TempatWisata("Saung Angklung Udjo", "Seni dan Budaya", "Jl. Padasuka No.118, Pasirlayung, Cibeunying Kidul, Kota Bandung, Jawa Barat 40192, Indonesia",
                "Saung Angklung Udjo ini merupakan salah satu Paguyuban Kesenian Sunda yang berada di kota Bandung bagian timur. Paguyugan Seni ini di dirikan oleh sepasang suami istri yang bernama Udjo Ngalagena dan Uum Sumiati yang mana pendiriannya di mulai sejak tahun 50-an. Saung ini di dirikan oleh sepasang suami ini dengan tujuan untuk melestarikan kesenian Sunda yang memang semakin waktu semakin di lupakan. Karena adanya respon yang sangat baik, maka Saung ini resmi berdiri sejak tahun 1966. Nah, bagi Anda yang ingin berkunjung ke kawasan ini, maka Anda akan memperoleh beberapa fasilitas yang memadai, yang memang akan mendukung musim liburan Anda. Bukan hanya bersenang-senang, namun ketika Anda datang ke lokasi ini, Anda juga akan mendapatkan pelajaran yang lebih banyak.",60000,"Jam Buka : 08.00-22 .00.","-", 8);

        TempatWisata tb = new TempatWisata("Taman Budaya Jawa barat", "Seni dan Budaya", "Jl. Bukit Dago Utara No.53, Dago, Coblong, Kota Bandung, Jawa Barat 40135, Indonesia",
                "Taman wisata ini mungkin sudah lama terkenal, bahkan bisa di katakan sejak zaman penjajahan belanda. Namun dulu tempat ini lebih di kenal sebagai tempat minum teh juga kuliner orang-orang bangsawan, dan lebih di kenal sebagai Dago The Huis atau Rumah Teh Dago. Namun seiring berjalannya waktu, kini tempat tersebut sudah berganti fungsi menjadi Taman Budaya Jawa Barat. Dan untuk saat ini, Taman Budaya Jawa Barat ini memiliki nama Balai Pengelolaan Taman Budaya Jawa Barat. Nah adanya pergantian fungsi ini sebenarnya bukan tidak memiliki tujuan, karena jelas mereka memiliki tujuan yang baik di balik adanya kawasan tersebut, yaitu untuk melestarikan kebudayaan Sunda. Di kawasan ini, para wisatawan bisa melihat pertunjukan juga teater terbuka yang masih memiliki kaitan dengan budaya Sunda.",15000,"Jam Buka : 09.00-22.00.","-", 8);

        TempatWisata kam = new TempatWisata("kampung Adat Mahmud", "Seni dan Budaya", "RW 04 Desa Mekarrahayu Kecamatan Margaasih Kabupaten Bandung Selatan",
                "Kampong Mahmud atau Makom Karomah Mahmud adalah salah satu wilayah atau kampung yang masih memiliki nilai adat yang kental ini berlokasikan di Bandung bagian selatan. Tepatnya berlokasikan di RW 04 Desa Mekarrahayu Kecamatan Margaasih Kabupaten Bandung Selatan. Berdasarkan hasil survey dari masyarakat yang berada di sekitaran Kampung Mahmud, kampung ini dulunya di bangun oleh leluhur mereka yaitu Sembah Eyang Abdul Manaf yang mana beliau merupakan salah stau keturunan dari seorang wali yang berasal dari Cirebon. Kampung ini sendiri di bandung pada abad ke-15 Masehi. Sebelum beliau membangun kampung ini, Eyang Abdul manaf memutuskan untuk pergi ke Mekah untuk meninggalkan kampung halamannya, beliau menetap di Mekah dalam waktu yang cukup lama.",0,"Jam Buka : 07.00-22.00","-", 8);

        TempatWisata grs = new TempatWisata("Gedung Kesenian Rumantang Siang", "Seni dan Budaya", "Jl. Baranang Siang No. 1, Kebon Pisang, Sumurbandung, Kb. Pisang, Sumur Bandung, Kota Bandung, Jawa Barat 40112.",
                "Sebenarnya Rumentang Siang ini dulunya bekas gedung bioskop Rivoli, yang mana bioskop ini merupakan bioskop peninggalan pada tahun 1930-an. Nah, pada tahun 1975, gedung Rumentang ini di alih pungsikan oleh Gubernur Jabar, yaitu Solihin GP yang saat itu tengah bertugas. Dikarenakan pada waktu itu fasilitas untuk gedung kesenian masih sangat jarang, dan itu hanya ada satu yaitu Gedung Yayasan Pusat kebudayaan (YPK), maka Gubernur memutuskan untuk menjadikan Gedung Rumentang Siang ini sebagai gedung untuk mementaskan kesenian. Nama Rumentang sendiri di ambil atau di berkan langsung oleh seorang penyair, yang bernama Wahyu Wibisana. Jika kita mengartikannya dalam bahasa Suna, Rumentang Siang ini berarti “Bahwa dari berbagai macam jenis kesenian dan banyaknya seniman di kota Bandung yang terlihat samar samar, akan terlihat jelas dan nyata setelah adanya gedung Kesenian Rumentang siang.”",0,"Jam Buka : 08.00–22.00","-", 8);

        TempatWisata mb = new TempatWisata("Museum Barli", "Seni dan Budaya", "Jl. Prof. Ir. Sutami.",
                "Musium Barli merupakan salah satu Musium yang berada di Bandung, yang mana Musium ini tidaklah begitu ramai oleh pengunjung. Padahal Museum ini berlokasikan di Jl. Prof. Ir. Sutami. Di dalam Museum ini terkumpul sejumlah karya seni dari sejumlah pelukis yang sangat terkenal yang berasal dari kota Bandung, yang mana pelukis ini bernama Barli Sasminawinata. Dan di Meseum ini pastinya terdapat sejumlah lukisan karya Barli yang mana memiliki nilai yang sangat inggi.",0,"Jam Buka : 08.00–22.00","-", 8);

        //insert data hardcode
        db.insertTempatWisata(grs);
        db.insertTempatWisata(kam);
        db.insertTempatWisata(tb);
        db.insertTempatWisata(sau);
        db.insertTempatWisata(gkl);
        db.insertTempatWisata(gs);
        db.insertTempatWisata(gm);
        db.insertTempatWisata(gb);
        db.insertTempatWisata(aab);
        db.insertTempatWisata(tfb);
        db.insertTempatWisata(hf);
        db.insertTempatWisata(dmh);
        db.insertTempatWisata(oc);
        db.insertTempatWisata(kp);
        db.insertTempatWisata(br);
        db.insertTempatWisata(sp);
        db.insertTempatWisata(tp);
        db.insertTempatWisata(bc);
        db.insertTempatWisata(ptr);
        db.insertTempatWisata(bip);
        db.insertTempatWisata(pjp);
        db.insertTempatWisata(pbtc);
        db.insertTempatWisata(pc);
        db.insertTempatWisata(mp);
        db.insertTempatWisata(gsb);
        db.insertTempatWisata(ks);
        db.insertTempatWisata(tsb);
        db.insertTempatWisata(tm);
        db.insertTempatWisata(mb);

        context = this;
        viewPager = findViewById(R.id.view_pager);

        adapter = new CustomSwipeAdapter(this);
        lv1.setAdapter(new CustomAdapterHome(this,listGambar,listJudul));
        viewPager.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        Intent i = getIntent();
        int id = i.getIntExtra("id",-1);
        switch (id){
            case 0:
                final ArrayList<TempatWisata> tw = db.getTempatWisataKategori("alam");
                Intent toNatureList = new Intent(home.this, list_page.class);
                toNatureList.putExtra("LIST", (Serializable) tw);
                startActivity(toNatureList);
                break;
            case 1:
                final ArrayList<TempatWisata> twtb = db.getTempatWisataKategori("taman bermain");
                Intent toThemePark = new Intent(home.this, list_page.class);
                toThemePark.putExtra("LIST", (Serializable) twtb);
                startActivity(toThemePark);
                break;
            case 2:
                final ArrayList<TempatWisata> tws= db.getTempatWisataKategori("sejarah");
                Intent toHistory = new Intent(home.this, list_page.class);
                toHistory.putExtra("LIST", (Serializable) tws);
                startActivity(toHistory);
                break;
            case 3:
                final ArrayList<TempatWisata> twb = db.getTempatWisataKategori("belanja");
                Intent toShopping = new Intent(home.this, list_page.class);
                toShopping.putExtra("LIST", (Serializable) twb);
                startActivity(toShopping);
                break;
            case 4:
                final ArrayList<TempatWisata> twsdb = db.getTempatWisataKategori("Seni dan Budaya");
                Intent toArt = new Intent(home.this, list_page.class);
                toArt.putExtra("LIST", (Serializable) twsdb);
                startActivity(toArt);
                break;
            case 5:
                final ArrayList<TempatWisata> twk = db.getTempatWisataKategori("kuliner");
                Intent toCulinary = new Intent(home.this, list_page.class);
                toCulinary.putExtra("LIST", (Serializable) twk);
                startActivity(toCulinary);
                break;
            case 6:
                Intent toAroundMap = new Intent(home.this, maps.class);
                startActivity(toAroundMap);
        }
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
