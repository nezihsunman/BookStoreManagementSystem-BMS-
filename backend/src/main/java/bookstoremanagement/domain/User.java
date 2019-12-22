package bookstoremanagement.domain;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    // PrimaryKey
    @Id
    private String username;

    private String firstName;
    private String lastName;
    private String userType;

    protected User() {}

    public User(String userName, String firstName, String lastName, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.userType=userType;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                username, firstName, lastName);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

}
