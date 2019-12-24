package bookstoremanagement.repository;

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

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    private Books book1 = new Books("D book", "700", "x type", "1997-06-26", "1997-06-26", 10f, 10);
    private Books book2 = new Books("E book", "701", "x type", "1997-06-26", "1997-06-26", 30f, 40);

    @Before
    public void fillSomeDataIntoOurDb() {
        entityManager.persist(book1);
        entityManager.persist(book2);
    }


    @Test
    public void findByISBN() {
        List<Books> bookList = bookRepository.findByISBN("700");
        assertThat(bookList, contains(book1));
    }

    @Test
    public void findByBookName() {
        List<Books> bookList = bookRepository.findByBookName("D book");
        assertThat(bookList, contains(book1));
    }

    @Test
    public void findAllByBooknumberGreaterThan() {
        List<Books> bookList = bookRepository.findAllByBooknumberGreaterThan(15);
        assertThat(bookList, contains(book2));
        //Todo fix
        //assertThat(bookList, not(contains(book1)));
    }

    @Test
    public void deleteBooksByISBN() {
        Books book3 = new Books("E book", "703", "x type", "1997-06-26", "1997-06-26", 30f, 1);
        entityManager.persist(book3);
        bookRepository.deleteBooksByISBN("703");
        Exception exception = assertThrows(Exception.class, () -> {
            bookRepository.findBooksByISBN("703").getISBN();
        });
    }

    @Test
    public void countBooksByISBN() {
        int count = bookRepository.countBooksByISBN("701");
        assertEquals(count, 1);

    }

    @Test
    public void findBooksByISBN() {
        Books book = bookRepository.findBooksByISBN("700");
        assertTrue(book.getISBN().equals(book1.getISBN()));
    }
}