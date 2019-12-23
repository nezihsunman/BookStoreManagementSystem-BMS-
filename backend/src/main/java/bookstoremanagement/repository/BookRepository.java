package bookstoremanagement.repository;


import bookstoremanagement.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Books, Long> {


    List<Books> findByISBN(@Param("ISBN") String ISBN);

    List<Books> findByBookName(@Param("bookName") String bookName);

    List<Books> findAllByBooknumberGreaterThan(float i);

    void deleteBooksByISBN(@Param("ISBN") String ISBN);

    int countBooksByISBN(@Param("ISBN") String ISBN);

    Books findBooksByISBN(@Param("ISBN") String ISBN);



}
