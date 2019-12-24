package bookstoremanagement.repository;

import bookstoremanagement.domain.Company;

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