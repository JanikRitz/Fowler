/**
 * Created by Janik on 10.05.2017.
 */
class NewReleasesPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented){
        return (daysRented > 1) ? 2: 1;
    }
}
