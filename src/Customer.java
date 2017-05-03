
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newName) {
        name = newName;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        StringBuilder resultBuilder = new StringBuilder(result);
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            resultBuilder.append(each.getString());
        }
        result = resultBuilder.toString();
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getAllFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints(Rental rental) {
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            return 2;
        return 1;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;

    }

    private int getAllFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += getFrequentRenterPoints(each);
        }
        return result;

    }

}
    