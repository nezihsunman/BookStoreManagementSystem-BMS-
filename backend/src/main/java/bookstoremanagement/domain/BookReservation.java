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

    public BookReservation(String personName, String ISBN, int bookNumber) {

        this.personName = personName;
        this.ISBN = ISBN;
        this.bookNumber = bookNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[personName='%s', ISBN='%s', bookNumber='%d']",
                personName, ISBN, bookNumber);
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String bookType) {
        this.personName = bookType;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


}
