package bookstoremanagement.repository;

import bookstoremanagement.domain.Company;
import bookstoremanagement.domain.Books;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyReporsitoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompanyReporsitory companies;

    private Company company1 = new Company("storeBook", 5000);

    @Before
    public void fillSomeDataIntoOurDb() {
        entityManager.persist(company1);
    }

    @Test
    public void findByCompanyName() {
        List<Company> companyList = companies.findByCompanyName("storeBook");
        assertThat(companyList, contains(company1));
    }
}