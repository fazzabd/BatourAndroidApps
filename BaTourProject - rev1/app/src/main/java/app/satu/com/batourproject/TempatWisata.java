package app.satu.com.batourproject;

import android.widget.TextView;

/**
 * Created by USER on 4/11/2018.
 */

public class TempatWisata {
    private String nama;
    private String jenis;
    private String alamat;
    private String deskripsi;
    private float hargaTiketMasuk;
    private String jamOperasional;
    private String noTelepon;
    private float averageRating;

    public TempatWisata(String nama, String jenis, String alamat, String deskripsi, float hargaTiketMasuk,
                        String jamOperasional, String noTelepon, float averageRating) {
        this.setNama(nama);
        this.setJenis(jenis);
        this.setAlamat(alamat);
        this.setDeskripsi(deskripsi);
        this.setHargaTiketMasuk(hargaTiketMasuk);
        this.setJamOperasional(jamOperasional);
        this.setNoTelepon(noTelepon);
        this.setAverageRating(averageRating);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public float getHargaTiketMasuk() {
        return hargaTiketMasuk;
    }

    public void setHargaTiketMasuk(float hargaTiketMasuk) {
        this.hargaTiketMasuk = hargaTiketMasuk;
    }

    public String getJamOperasional() {
        return jamOperasional;
    }

    public void setJamOperasional(String jamOperasional) {
        this.jamOperasional = jamOperasional;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }
}
