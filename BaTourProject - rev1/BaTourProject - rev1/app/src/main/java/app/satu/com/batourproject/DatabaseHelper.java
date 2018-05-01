package app.satu.com.batourproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 4/11/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //Nama Database
    private static final String DATABASE_NAME = "DB_BaTour";

    // Nama table
    private static final String TABLE_ULASAN = "ulasan";
    private static final String TABLE_ALAMAT = "alamat";
    private static final String TABLE_TEMPAT_WISATA = "tempat_wisata";

    //Kolom tabel Ulasan
    private static final String PENGULAS = "pengulas";
    private static final String EMAIL = "email";
    private static final String DETAIL_ULASAN = "detail_ulasan";
    private static final String RATING = "rating";

    //Kolom Tabel Alamat
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";

    //Kolom Tabel Tempat_wisata
    private static final String NAMA = "nama";
    private static final String JENIS = "jenis";
    private static final String LIST_FOTO = "list_foto"; //Belum tau tipe datanya
    private static final String ALAMAT = "alamat";
    private static final String DESKRIPSI = "deskripsi";
    private static final String HARGA_TIKET_MASUK = "harga_tiket_masuk";
    private static final String JAM_OPERASIONAL = "jam_operasional";
    private static final String NO_TELEPON = "no_telepon";
    private static final String LIST_ULASAN = "list_ulasan"; //Belum tau tipe datanya
    private static final String AVERAGE_RATING = "average_rating";

    //Query
    private static final String CREATE_TABLE_ULASAN = "create table "
            + TABLE_ULASAN + " (" + PENGULAS + " TEXT PRIMARY KEY, " + EMAIL + " TEXT, " +
            DETAIL_ULASAN + " TEXT, " + RATING
            + " FLOAT)";

    private static final String CREATE_TABLE_ALAMAT = "create table "
            + TABLE_ALAMAT + " (" + LATITUDE + " FLOAT, " + LONGITUDE + " FLOAT, PRIMARY KEY (" + LATITUDE +
            ", " + LONGITUDE + "))";

    private static final String CREATE_TABLE_TEMPAT_WISATA = "create table "
            + TABLE_TEMPAT_WISATA + " (" + NAMA + " TEXT, " + JENIS + " TEXT, " +
            ALAMAT + " TEXT, " + DESKRIPSI + " TEXT, " + HARGA_TIKET_MASUK + " FLOAT, " + JAM_OPERASIONAL + " TEXT, "
            + NO_TELEPON + " TEXT, " + AVERAGE_RATING + " FLOAT, PRIMARY KEY (" + NAMA +
            ", " + JENIS + "))";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ULASAN);
        sqLiteDatabase.execSQL(CREATE_TABLE_ALAMAT);
        sqLiteDatabase.execSQL(CREATE_TABLE_TEMPAT_WISATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ULASAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ALAMAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMPAT_WISATA);

        onCreate(sqLiteDatabase);
    }

    public boolean insertAlamat(Alamat alamat) {
        SQLiteDatabase db = this.getWritableDatabase();

        //penampung data model
        ContentValues values = new ContentValues();
        values.put(LATITUDE, alamat.getLatitude());
        values.put(LONGITUDE, alamat.getLongitude());

        long result = db.insert(TABLE_ALAMAT, null, values);

        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertUlasan(Ulasan ulasan) {
        SQLiteDatabase db = this.getWritableDatabase();

        //penampung data model
        ContentValues values = new ContentValues();
        values.put(PENGULAS, ulasan.getPengulas());
        values.put(EMAIL, ulasan.getEmail());
        values.put(DETAIL_ULASAN, ulasan.getDetailUlasan());
        values.put(RATING, ulasan.getRating());

        long result = db.insert(TABLE_ULASAN, null, values);

        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertTempatWisata(TempatWisata tempatWisata) {
        SQLiteDatabase db = this.getWritableDatabase();

        //penampung data model
        ContentValues values = new ContentValues();
        values.put(NAMA, tempatWisata.getNama());
        values.put(JENIS, tempatWisata.getJenis());
        values.put(ALAMAT, tempatWisata.getAlamat());
        values.put(DESKRIPSI, tempatWisata.getDeskripsi());
        values.put(HARGA_TIKET_MASUK, tempatWisata.getHargaTiketMasuk());
        values.put(JAM_OPERASIONAL, tempatWisata.getJamOperasional());
        values.put(NO_TELEPON, tempatWisata.getNoTelepon());
        values.put(AVERAGE_RATING, tempatWisata.getAverageRating());

        long result = db.insert(TABLE_TEMPAT_WISATA, null, values);

        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }
}
