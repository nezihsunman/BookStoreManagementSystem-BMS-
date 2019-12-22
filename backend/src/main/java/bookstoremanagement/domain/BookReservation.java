package bookstoremanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookreservations")
public class BookReservation {
        @Id
    private String ISBN;

    private String personName;

    private int bookNumber;

    protected BookReservation() {
    }

    public BookReservation(String personName, String ISBN,int bookNumber) {

        this.ISBN = ISBN;
        this.personName = personName;
        this.bookNumber=bookNumber;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String bookType) {
        this.personName = bookType;
    }


}
