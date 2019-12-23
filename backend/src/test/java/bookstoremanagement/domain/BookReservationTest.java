package bookstoremanagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookReservationTest {

    BookReservation bookReservation;

    @BeforeEach
    void createBookReservation() {
        bookReservation = new BookReservation("David", "1001001001001", 222);
    }


    @Test
    void testToString() {
        assertEquals("Book[personName='David', ISBN='1001001001001', bookNumber='222']", bookReservation.toString());
    }

    @Test
    void getPersonName() {
        assertEquals("David", bookReservation.getPersonName());
    }

    @Test
    void setPersonName() {
        BookReservation bookReservation = new BookReservation();
        bookReservation.setPersonName("Richard");
        assertEquals("Richard", bookReservation.getPersonName());
    }

    @Test
    void getISBN() {
        assertEquals("1001001001001", bookReservation.getISBN());
    }

    @Test
    void setISBN() {
        bookReservation.setISBN("1001001001002");
        assertEquals("1001001001002", bookReservation.getISBN());
    }
}