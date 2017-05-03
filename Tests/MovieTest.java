import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Janik on 03.05.2017.
 */
public class MovieTest {
    static final int priceCodeTest = 3;
    static final int priceCodeTestPre = -1;
    static final String testTitle = "Title";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPriceCode() throws Exception {
        Movie m = new Movie(testTitle, priceCodeTest);
        assertEquals(priceCodeTest, m.getPriceCode());
    }

    @Test
    public void setPriceCode() throws Exception {
        Movie m = new Movie(testTitle, priceCodeTestPre);
        assertEquals(priceCodeTestPre, m.getPriceCode());
        m.setPriceCode(priceCodeTest);
        assertEquals(priceCodeTest, m.getPriceCode());
    }

    @Test
    public void getTitle() throws Exception {
        Movie m = new Movie(testTitle, priceCodeTest);
        assertEquals(testTitle, m.getTitle());
    }

}