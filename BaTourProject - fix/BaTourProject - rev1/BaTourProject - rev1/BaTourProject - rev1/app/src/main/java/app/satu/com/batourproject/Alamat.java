package app.satu.com.batourproject;

/**
 * Created by USER on 4/11/2018.
 */

public class Alamat {
    private float longitude;
    private float latitude;

    public Alamat() {

    }

    public Alamat(float latitude, float longitude) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
