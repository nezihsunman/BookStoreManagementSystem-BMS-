package bookstoremanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "books")
public class Books {


    private String firstName;

    @Id
    private String ISBN;

    private String bookType;
    private String publishDate;
    private float price;
    private String versionDate;
    private int booknumber;

    protected Books() {
    }

    public Books(String firstName , String ISBN, String bookType, String versionDate, String publishDate, Float price, int booknumber) {
        this.firstName = firstName;
        this.ISBN = ISBN;
        this.bookType = bookType;
        this.publishDate = publishDate;
        this.versionDate = versionDate;
        this.price = price;
        this.booknumber = booknumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
