package bookstoremanagement.repository;

import bookstoremanagement.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    private User norbertSiegmund = new User("norSie", "Norbert", "Siegmund", "staff");
    private User jonasHecht = new User("jonHec", "Jonas", "Hecht", "Manager");

    @Before
    public void fillSomeDataIntoOurDb() {
        // Add new Users to Database
        entityManager.persist(norbertSiegmund);
        entityManager.persist(jonasHecht);
    }


    @Test
    public void findByLastName() {
        List<User> userList = users.findByLastName("Siegmund");
        asserThat(userList, contains(norbertSiegmund));
    }

    @Test
    public void findByFirstName() {
        List<User> userList = users.findByFirstName("Jonas");
        assertThat(userList, contains(jonasHecht));
    }

    @Test
    public void findByUsername() {
        User userJonas = users.findByUsername("jonHec");
        assertTrue(userJonas.getUsername().equals(jonasHecht.getUsername()));
    }
}

