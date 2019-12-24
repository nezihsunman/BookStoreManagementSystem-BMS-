package bookstoremanagement.repository;

import bookstoremanagement.domain.BookReservation;

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
        asserEquals(bookReservation1.getISBN().equals(bookReservation.getISBN()));
    }
}
