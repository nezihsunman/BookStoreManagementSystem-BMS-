package bookstoremanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Books {




    @Id
    private String ISBN;

    private String bookName;
    private String bookType;
    private String publishDate;
    private float price;
    private String versionDate;
    private float booknumber;

    protected Books() {
    }

    public Books(String bookName, String ISBN, String bookType, String versionDate, String publishDate, Float price, float booknumber) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.bookType = bookType;
        this.publishDate = publishDate;
        this.versionDate = versionDate;
        this.price = price;
        this.booknumber = booknumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[bookName='%s', ISBN='%s', bookType='%s', versionDate='%s', publishDate='%s', price='%f', booknumber='%f']",
                bookName, ISBN, bookType, versionDate, publishDate, price, booknumber);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String firstName) {
        this.bookName = firstName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(String versionDate) {
        this.versionDate = versionDate;
    }

    public float getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(float booknumber) {
        this.booknumber = booknumber;
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
