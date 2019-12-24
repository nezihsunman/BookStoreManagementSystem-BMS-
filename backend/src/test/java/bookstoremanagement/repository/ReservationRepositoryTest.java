package bookstoremanagement.repository;

import bookstoremanagement.domain.BookReservation;
import bookstoremanagement.domain.Books;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.print.Book;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReservationRepository reservations;

    private BookReservation bookReservation1 = new BookReservation("john", "1000", 10);

    @Before
    public void fillSomeDataIntoOurDb() {
        entityManager.persist(bookReservation1);
    }

    @Test
    public void findByISBN() {
        List<BookReservation> bookReservations = reservations.findByISBN("1000");
        assertThat(bookReservations, contains(bookReservation1));
    }

    @Test
    public void findByPersonName() {
        List<BookReservation> bookReservations = reservations.findByPersonName("john");
        assertThat(bookReservations, contains(bookReservation1));
    }

    @Test
    public void findBooksByISBN() {
        BookReservation bookReservation = reservations.findBooksByISBN("1000");
        assertTrue(bookReservation1.getISBN().equals(bookReservation.getISBN()));
    }
}
