package bookstoremanagement.repository;

import bookstoremanagement.domain.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyReporsitory extends CrudRepository<Company, Long> {


    List<Company> findByCompanyName(@Param("companyName") String companyName);

    

}
