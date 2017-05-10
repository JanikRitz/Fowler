public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;

    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        setPriceCode(newPriceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) throws IllegalArgumentException {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasesPrice();
                break;
            default:
                throw new IllegalArgumentException("Icorrect Price Code");
        }
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {

        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        return price.getFrequentRenterPoints(daysRented);
    }

}

