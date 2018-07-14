package app.satu.com.batourproject;

/**
 * Created by USER on 4/11/2018.
 */

public class Ulasan {
    private String pengulas;
    private String email;
    private String detailUlasan;
    private float rating;

    public Ulasan(String pengulas, String email, String detailUlasan, float rating) {
        this.setPengulas(pengulas);
        this.setEmail(email);
        this.setDetailUlasan(detailUlasan);
        this.setRating(rating);
    }
    public String getPengulas() {
        return pengulas;
    }

    public void setPengulas(String pengulas) {
        this.pengulas = pengulas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetailUlasan() {
        return detailUlasan;
    }

    public void setDetailUlasan(String detailUlasan) {
        this.detailUlasan = detailUlasan;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
