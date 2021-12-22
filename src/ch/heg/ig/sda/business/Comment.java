package ch.heg.ig.sda.business;

public class Comment {

    private String review;
    private int rating;

    public Comment() {
    }

    public Comment(String review, int rating) {
        this.review = review;
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }

}
