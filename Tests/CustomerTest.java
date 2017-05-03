import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Janik on 03.05.2017.
 */
public class CustomerTest {
    private static final String MOVIE1 = "movie1";
    private static final String MOVIE2 = "movie2";
    private static final String statementTest = "Rental Record for joe\n"
            + "\tTitle\t\tDays\tAmount\n"
            + "\t" + MOVIE1 + "\t\t10\t30.0\n"
            + "\t" + MOVIE2 + "\t\t5\t4.5\n"
            + "Amount owed is 34.5\n"
            + "You earned 3 frequent renter points";
    private static final String htmlStatementTest = "<H1>Rentals for <EM>joe</EM></H1><P>\n" +
            MOVIE1 + ": 30.0<BR>\n" +
            MOVIE2 + ": 4.5<BR>\n" +
            "<P>You owe <EM>34.5</EM><P>\n" +
            "On this rental you earned <EM>3</EM> frequent renter points<P>";
    private static final String NAME = "joe";

    @Test
    public void getName() throws Exception {
        Customer c1 = new Customer(NAME);
        assertEquals(NAME, c1.getName());
    }

    @Test
    public void statement() throws Exception {
        Movie m1 = new Movie(MOVIE1, 1);
        Movie m2 = new Movie(MOVIE2, 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer(NAME);
        c1.addRental(r1);
        c1.addRental(r2);
        String result = c1.statement();
        assertEquals(statementTest, result);
    }

    @Test
    public void htmlStatement() throws Exception {
        Movie m1 = new Movie(MOVIE1, 1);
        Movie m2 = new Movie(MOVIE2, 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer(NAME);
        c1.addRental(r1);
        c1.addRental(r2);
        String result = c1.htmlStatement();
        assertEquals(htmlStatementTest, result);
    }

}