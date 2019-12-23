package bookstoremanagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void createUser() {
        user = new User("charBrown", "Charlotte", "Brown", "Manager");
    }

    @Test
    void testToString() {
        assertEquals("User[id=charBrown, firstName='Charlotte', lastName='Brown']", user.toString());
    }

    @Test
    void getUsername() {
        assertEquals("charBrown", user.getUsername());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("oliMiller");
        assertEquals("oliMiller", user.getUsername());
    }

    @Test
    void getFirstName() {
        assertEquals("Charlotte", user.getFirstName());
    }

    @Test
    void setFirstName() {
        User user = new User();
        user.setFirstName("Olivia");
        assertEquals("Olivia", user.getFirstName());
    }


    @Test
    void getLastName() {
        assertEquals("Brown", user.getLastName());
    }

    @Test
    void setLastName() {
        User user = new User();
        user.setLastName("Miller");
        assertEquals("Miller", user.getLastName());
    }

    @Test
    void getUserType() {
        assertEquals("Manager", user.getUserType());
    }

    @Test
    void setUserType() {
        User user = new User();
        user.setUserType("Staff");
        assertEquals("Staff", user.getUserType());

    }


}