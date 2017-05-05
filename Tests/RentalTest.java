import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Janik on 03.05.2017.
 */
public class RentalTest {
    private static final int priceCodeTest = 0;
    private static final int daysTest = 3;
    private static final String testTitle = "Title";
    private static final Movie m = new Movie(testTitle, priceCodeTest);

    @Test
    public void getDaysRented() throws Exception {
        Rental rental = new Rental(m, daysTest);
        assertEquals(daysTest, rental.getDaysRented());
    }

    @Test
    public void getMovie() throws Exception {
        Rental rental = new Rental(m, daysTest);
        assertEquals(m, rental.getMovie());
    }
}