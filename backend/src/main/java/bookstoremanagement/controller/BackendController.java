package bookstoremanagement.controller;

import bookstoremanagement.domain.BookReservation;
import bookstoremanagement.domain.Books;
import bookstoremanagement.domain.User;
import bookstoremanagement.repository.BookRepository;
import bookstoremanagement.repository.CompanyReporsitory;
import bookstoremanagement.repository.ReservationRepository;
import bookstoremanagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@RestController()
@RequestMapping("/api")
public class BackendController {
  private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
  public static final String ALREADY = "Book is already in DB";
  public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
  public static final String SECURED_TEXT = "Hello from the secured resource!";

  protected EntityManager manager;

  @Autowired private UserRepository userRepository;
  @Autowired private BookRepository bookRepository;
  @Autowired private CompanyReporsitory companyReporsitory;
  @Autowired private ReservationRepository reservationRepository;

  @GetMapping(path = "/hello")
  public String sayHello() {
    LOG.info("GET called on /hello resource");
    return HELLO_TEXT;
  }

  @GetMapping(path = "/secured")
  public @ResponseBody String getSecured() {
    LOG.info("GET successfully called on /secured resource");
    return SECURED_TEXT;
  }

  // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
  // Required because of 'mode: history' usage in frontend routing, see README for further details

  @GetMapping(value = "{_:^(?!index\\.html|api).$}")
  public String redirectApi() {
    LOG.info("URL entered directly into the Browser, so we need to redirect...");
    return "forward:/";
  }

  // save book
  @PostMapping(
      path = "/savebook/{bookName}/{ISBN}/{bookType}/{date}/{publishDate}/{price}/{booknumber}")
  @ResponseStatus(HttpStatus.CREATED)
  public Books saveBook(
      @PathVariable("bookName") String bookName,
      @PathVariable("ISBN") String ISBN,
      @PathVariable("bookType") String booktype,
      @PathVariable("date") String date,
      @PathVariable("publishDate") String publishDate,
      @PathVariable("price") Float price,
      @PathVariable("booknumber") int booknumber)
      throws Exception {
    int count = bookRepository.countBooksByISBN(ISBN);
    if (count == 0) {
      Books books =
          bookRepository.save(
              new Books(bookName, ISBN, booktype, date, publishDate, price, booknumber));
      LOG.info(books.toString() + " successfully saved into DB");
      return books;
    } else {
      LOG.info(ALREADY);
      throw new Exception(ALREADY);
    }
  }
  // changeBookNumber
  @PostMapping(path = "/changeBookNumber/{ISBN}")
  @ResponseStatus(HttpStatus.CREATED)
  public Books changeBookNumber(@PathVariable("ISBN") String ISBN) throws Exception {
    if (bookRepository.findBooksByISBN(ISBN) != null) {
      Books books = bookRepository.findBooksByISBN(ISBN);
      if (books.getBooknumber() == 0) {
        throw new NullPointerException("Null");
      } else if (books.getBooknumber() == 1) {
        bookRepository.delete(bookRepository.findBooksByISBN(ISBN));
        LOG.info("Book number successfully saved into DB");
        return bookRepository.findBooksByISBN(ISBN);
      } else {
        books.setBooknumber(books.getBooknumber() - 1);
        bookRepository.save(books);
        LOG.info("Book number successfully saved into DB");
        return bookRepository.findBooksByISBN(ISBN);
      }
    }
    throw new Exception("ISBN bot in db");
  }
  // takeBookData
  @GetMapping(path = "/takeBookData")
  @ResponseStatus(HttpStatus.CREATED)
  public ArrayList<Books> takeBookData() throws Exception {
    if (bookRepository != null) {
      return (ArrayList<Books>) bookRepository.findAllByBooknumberGreaterThan(0);
    }

    throw new Exception("no book repository");
  }
  // takeBookByISBN
  @PostMapping(path = "/takeBookByISBN/{ISBN}")
  @ResponseStatus(HttpStatus.CREATED)
  public ArrayList<Books> takeBookByISBN(@PathVariable("ISBN") String ISBN) throws Exception {
    if (bookRepository != null) {
      ArrayList<Books> arrayList = new ArrayList<Books>();
      arrayList.add(bookRepository.findBooksByISBN(ISBN));
      return arrayList;
    }
    throw new Exception("no book repository");
  }
  // addNewUser
  @PostMapping(path = "/addNewUser/{userName}/{firstName}/{lastName}/{userType}")
  @ResponseStatus(HttpStatus.CREATED)
  public User addNewUser(
      @PathVariable("userName") String userName,
      @PathVariable("firstName") String firstName,
      @PathVariable("lastName") String lastName,
      @PathVariable("userType") String userType)
      throws Exception {
    User tempUser = userRepository.findByUsername(userName);
    if (tempUser == null) {
      User user = userRepository.save(new User(userName, firstName, lastName, userType));
      LOG.info(user.toString() + " successfully saved into DB");
      return user;
    } else {
      throw new Exception(ALREADY);
    }
  }

  @PostMapping(path = "/getUser/{userName}")
  @ResponseStatus(HttpStatus.CREATED)
  public User getUser(@PathVariable("userName") String userName) {
    User user = userRepository.findByUsername(userName);
    LOG.info("log is " + user.getFirstName() + user.getUsername());
    return user;
  }

  @PostMapping(path = "/orderBook/{isbn}/{personalname}/{booknumber}")
  @ResponseStatus(HttpStatus.CREATED)
  public BookReservation saveReservation(
      @PathVariable("isbn") String isbn,
      @PathVariable("personalname") String personalname,
      @PathVariable("booknumber") String booknumber) {
    return reservationRepository.save(
        new BookReservation(personalname, isbn, Integer.parseInt(booknumber)));
  }
}
