class Rental {
    Movie movie;
    private int daysRented;

    public Rental(Movie newMovie, int newDaysRented) {
        movie = newMovie;
        daysRented = newDaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge(){
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(){
        return movie.getFrequentRenterPoints(daysRented);
    }

    String getString() {
        return "\t" + getMovie().getTitle() + "\t" + "\t" + getDaysRented() + "\t" + String.valueOf(getCharge()) + "\n";
    }

}