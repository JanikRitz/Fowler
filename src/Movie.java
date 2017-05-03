public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    private Price price;

    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        setPriceCode(newPriceCode);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
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
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {

        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        if ((getPriceCode() == NEW_RELEASE) && daysRented > 1)
            return 2;
        return 1;
    }

    abstract class Price {
        abstract int getPriceCode();

        abstract double getCharge(int daysRented);
    }

    class ChildrensPrice extends Price {

        @Override
        int getPriceCode() {
            return Movie.CHILDRENS;
        }

        @Override
        double getCharge(int daysRented) {
            double result = 1.5;
            if (daysRented > 3)
                result += (daysRented - 3) * 1.5;
            return result;
        }
    }

    class NewReleasesPrice extends Price {

        @Override
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }

        @Override
        double getCharge(int daysRented) {
            return daysRented * 3;
        }
    }

    class RegularPrice extends Price {

        @Override
        int getPriceCode() {
            return Movie.REGULAR;
        }

        @Override
        double getCharge(int daysRented) {
            double result = 2;
            if (daysRented > 2)
                result += (daysRented - 2) * 1.5;
            return result;
        }
    }
}