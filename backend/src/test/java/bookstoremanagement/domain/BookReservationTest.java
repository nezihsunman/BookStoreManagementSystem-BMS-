package bookstoremanagement.domain;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookReservationTest {

    BookReservation bookReservation;

    @BeforeEach
    public void createBookReservation() {
        bookReservation = new BookReservation("David", "1001001001001", 222);
    }


    @Test
    public void testToString() {
        BookReservation bookReservation;
        bookReservation = new BookReservation("David", "1001001001001", 222);
        assertEquals("Book[personName='David', ISBN='1001001001001', bookNumber='222']", bookReservation.toString());
    }

    @Test
    public void getPersonName() {

        BookReservation bookReservation;
        bookReservation = new BookReservation("David", "1001001001001", 222);
        assertEquals("David", bookReservation.getPersonName());
    }

    @Test
    public void setPersonName() {
        BookReservation bookReservation = new BookReservation();
        bookReservation.setPersonName("Richard");
        assertEquals("Richard", bookReservation.getPersonName());
    }

    @Test
    public void getISBN() {

        BookReservation bookReservation;
        bookReservation = new BookReservation("David", "1001001001001", 222);
        assertEquals("1001001001001", bookReservation.getISBN());
    }

    @Test
    public void setISBN() {
        BookReservation bookReservation;
        bookReservation = new BookReservation("David", "1001001001001", 222);
        bookReservation.setISBN("1001001001002");
        assertEquals("1001001001002", bookReservation.getISBN());
    }
}