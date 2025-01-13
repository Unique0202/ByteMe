package ByteMe;

public class Review {
    private String customerId;
    private String reviewText;
    private int rating;

    public Review(String customerId, String reviewText, int rating) {
        this.customerId = customerId;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getCustomerId() { return customerId; }
    public String getReviewText() { return reviewText; }
    public int getRating() { return rating; }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Rating: " + rating + ", Review: " + reviewText;
    }
}