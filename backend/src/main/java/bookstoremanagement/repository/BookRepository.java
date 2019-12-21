package bookstoremanagement.repository;


import bookstoremanagement.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Books, Long> {


    List<Books> findByISBN(@Param("ISBN") String ISBN);

    List<Books> findByFirstName(@Param("firstname") String firstname);

    List<Books> findAllBy();

}
