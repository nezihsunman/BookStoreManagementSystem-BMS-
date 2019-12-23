package bookstoremanagement.contoller;

import bookstoremanagement.SpringBootVuejsApplication;
import bookstoremanagement.controller.BackendController;
import bookstoremanagement.domain.BookReservation;
import bookstoremanagement.domain.Books;
import bookstoremanagement.domain.User;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = SpringBootVuejsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class BackendControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void sayHello() {
        when()
                .get("/api/hello")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(is(equalTo(BackendController.HELLO_TEXT)));
    }


    @Test
    public void addNewUser_and_getUser() {

        //Created new user.
        User user1 =
                given()
                        .pathParam("userName", "UveysAkbas")
                        .pathParam("firstName", "Uveys")
                        .pathParam("lastName", "Akbas")
                        .pathParam("userType", "Staff")
                        .when()
                        .post("/api/addNewUser/{userName}/{firstName}/{lastName}/{userType}")
                        .then()
                        .statusCode(is(HttpStatus.SC_CREATED))
                        .assertThat()
                        .extract().as(User.class);

        //Get a user by using user1 id.
        User user2 =
                given()
                        .pathParam("userName", user1.getUsername())
                        .when()
                        .post("/api/getUser/{userName}")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .assertThat()
                        .extract().as(User.class);

        //Check if user1 is equal to user2.
        assertThat(user1.getUsername(), is(user2.getUsername()));
        assertThat(user1.getFirstName(), is(user2.getFirstName()));
        assertThat(user1.getLastName(), is(user2.getLastName()));
        assertThat(user1.getUserType(), is(user2.getUserType()));
    }

    @Test
    public void getSecured() {
        when()
                .get("/api/secured")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(is(equalTo(bookstoremanagement.controller.BackendController.SECURED_TEXT)));
    }

    @Test
    public void redirectApi() {

    }

    @Test
    public void saveBook_and_takeBookByISBN() {

        //This book must not be in DB.
        Books subjectBook = new Books("Harry Potter", "1001001002000", "Fantasy", "2019-12-12", "1997-06-26", 25f, 100);

        Books addedBook =
                given()
                        .pathParam("bookName", subjectBook.getBookName())
                        .pathParam("ISBN", subjectBook.getISBN())
                        .pathParam("bookType", subjectBook.getBookType())
                        .pathParam("date", subjectBook.getVersionDate())
                        .pathParam("publishDate", subjectBook.getPublishDate())
                        .pathParam("price", subjectBook.getPrice())
                        .pathParam("booknumber", subjectBook.getBooknumber())
                        .when()
                        .post("/api/savebook/{bookName}/{ISBN}/{bookType}/{date}/{publishDate}/{price}/{booknumber}")
                        .then()
                        .statusCode(is(HttpStatus.SC_CREATED))
                        .assertThat()
                        .extract().as(Books.class);

        assertThat(subjectBook.getBookName(), is(addedBook.getBookName()));
        assertThat(subjectBook.getBookType(), is(addedBook.getBookType()));
        assertThat(subjectBook.getISBN(), is(addedBook.getISBN()));

        ArrayList<Books> bookList =
                given()
                        .pathParam("ISBN", subjectBook.getISBN())
                        .when()
                        .post("/api/takeBookByISBN/{ISBN}")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .assertThat()
                        .extract().as(ArrayList.class);

        assertThat(subjectBook.getBookName(), is(bookList.get(0).getBookName()));
        assertThat(subjectBook.getBookType(), is(bookList.get(0).getBookType()));
        assertThat(subjectBook.getISBN(), is(bookList.get(0).getISBN()));
    }

    @Test
    public void changeBookNumber() {

        //Book is added with bookNumber > 1.
        Books addedBook =
                given()
                        .pathParam("bookName", "X Book")
                        .pathParam("ISBN", "1001001002001")
                        .pathParam("bookType", "Mystery")
                        .pathParam("date", "2019-12-11")
                        .pathParam("publishDate", "1997-06-25")
                        .pathParam("price", 25f)
                        .pathParam("booknumber", 10)
                        .when()
                        .post("/api/savebook/{bookName}/{ISBN}/{bookType}/{date}/{publishDate}/{price}/{booknumber}")
                        .then()
                        .statusCode(is(HttpStatus.SC_CREATED))
                        .assertThat()
                        .extract().as(Books.class);

        Books changedBook =
                given()
                        .pathParam("ISBN", addedBook.getISBN())
                        .when()
                        .post("/api/changeBookNumber/{ISBN}")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .assertThat()
                        .extract().as(Books.class);

        assertEquals(addedBook.getBooknumber() - 1, changedBook.getBooknumber());
    }

    @Test
    public void changeBookNumber_with_zero_book_number() {

        //Added book with bookNumber = 0.
        Books addedBook =
                given()
                        .pathParam("bookName", "Y Book")
                        .pathParam("ISBN", "1001001002002")
                        .pathParam("bookType", "Fantasy")
                        .pathParam("date", "2019-12-12")
                        .pathParam("publishDate", "1997-06-26")
                        .pathParam("price", 25f)
                        .pathParam("booknumber", 0)
                        .when()
                        .post("/api/savebook/{bookName}/{ISBN}/{bookType}/{date}/{publishDate}/{price}/{booknumber}")
                        .then()
                        .statusCode(is(HttpStatus.SC_CREATED))
                        .assertThat()
                        .extract().as(Books.class);

        Assertions.assertThrows(Exception.class, () -> {

            Books changedBook =
                    given()
                            .pathParam("ISBN", addedBook.getISBN())
                            .when()
                            .post("/api/changeBookNumber/{ISBN}")
                            .then()
                            .statusCode(HttpStatus.SC_OK)
                            .assertThat()
                            .extract().as(Books.class);

        });

    }

    @Test
    public void takeBookData() {

        ArrayList<Books> addedList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Books book =
                    given()
                            .pathParam("bookName", "A Book")
                            .pathParam("ISBN", String.valueOf(1000 + i))
                            .pathParam("bookType", "Fantasy")
                            .pathParam("date", "2019-12-12")
                            .pathParam("publishDate", "1997-06-26")
                            .pathParam("price", 25f)
                            .pathParam("booknumber", 10)
                            .when()
                            .post("/api/savebook/{bookName}/{ISBN}/{bookType}/{date}/{publishDate}/{price}/{booknumber}")
                            .then()
                            .statusCode(is(HttpStatus.SC_CREATED))
                            .assertThat()
                            .extract().as(Books.class);

            addedList.add(book);
        }

        ArrayList<Books> allBookList =
                when()
                        .get("/api/takeBookData")
                        .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .assertThat()
                        .extract().as(ArrayList.class);


        for (int i = 0; i < addedList.size(); i++) {
            boolean isBookExist = false;
            for (int j = 0; j < allBookList.size(); j++) {
                if (addedList.get(i).getISBN().equals(allBookList.get(j).getISBN())) {
                    isBookExist = true;
                }
            }

            assertTrue(isBookExist);
        }
    }

    @Test
    public void saveReservation() {

        BookReservation bookReservation =
                given()
                        .pathParam("isbn", "1001001003000")
                        .pathParam("personalname", "X personal")
                        .pathParam("booknumber", 500)
                        .when()
                        .post("/api/orderBook/{isbn}/{personalname}/{booknumber}")
                        .then()
                        .statusCode(is(HttpStatus.SC_CREATED))
                        .assertThat()
                        .extract().as(BookReservation.class);

        assertEquals("1001001003000", bookReservation.getISBN());

    }

}