package bookstoremanagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    Books books;

    @BeforeEach
    void createBook() {
        books = new Books("Harry Potter", "1001001001001", "Fantasy", "2019-12-12", "1997-06-26", 25f, 100);
    }

    @Test
    void testToString() {
        assertEquals("Book[bookName='Harry Potter', ISBN='1001001001001', bookType='Fantasy', versionDate='2019-12-12', publishDate='1997-06-26', price='25.000000', booknumber='100.000000']", books.toString());
    }

    @Test
    void getBookName() {
        assertEquals("Harry Potter", books.getBookName());
    }

    @Test
    void setBookName() {
        Books books = new Books();
        books.setBookName("Game of Thrones");
        assertEquals("Game of Thrones", books.getBookName());
    }

    @Test
    void getPublishDate() {
        assertEquals("1997-06-26", books.getPublishDate());
    }

    @Test
    void setPublishDate() {
        books.setPublishDate("1998-06-06");
        assertEquals("1998-06-06", books.getPublishDate());
    }

    @Test
    void getVersionDate() {
        assertEquals("2019-12-12", books.getVersionDate());
    }

    @Test
    void setVersionDate() {
        books.setVersionDate("2018-12-12");
        assertEquals("2018-12-12", books.getVersionDate());
    }

    @Test
    void getBooknumber() {
        assertEquals(100, books.getBooknumber());
    }

    @Test
    void setBooknumber() {
        books.setBooknumber(200);
        assertEquals(200, books.getBooknumber());
    }

    @Test
    void getISBN() {
        assertEquals("1001001001001", books.getISBN());
    }

    @Test
    void setISBN() {
        books.setISBN("1001001001002");
        assertEquals("1001001001002", books.getISBN());
    }

    @Test
    void getBookType() {
        assertEquals("Fantasy", books.getBookType());
    }

    @Test
    void setBookType() {
        books.setBookType("Mystery");
        assertEquals("Mystery", books.getBookType());
    }

    @Test
    void getPrice() {
        assertEquals(25, books.getPrice());
    }

    @Test
    void setPrice() {
        books.setPrice(125);
        assertEquals(125, books.getPrice());
    }
}
