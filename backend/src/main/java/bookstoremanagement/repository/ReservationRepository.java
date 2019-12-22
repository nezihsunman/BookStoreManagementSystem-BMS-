package bookstoremanagement.repository;


import bookstoremanagement.domain.BookReservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends CrudRepository<BookReservation, Long> {


    List<BookReservation> findByISBN(@Param("ISBN") String ISBN);

    List<BookReservation> findByPersonName(@Param("personalName") String personalName);

    BookReservation findBooksByISBN(@Param("ISBN") String ISBN);



}
