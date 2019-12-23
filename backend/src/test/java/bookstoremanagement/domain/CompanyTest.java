package bookstoremanagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company;

    @BeforeEach
    void createBook() {
        company = new Company("BookStore", 111222);
    }


    @Test
    void testToString() {
        assertEquals("Book[companyName='BookStore', income='111222,000000']", company.toString());
    }

    @Test
    void getCompanyName() {
        assertEquals("BookStore", company.getCompanyName());
    }

    @Test
    void setCompanyName() {
        Company company = new Company();
        company.setCompanyName("Apple");
        assertEquals("Apple", company.getCompanyName());
    }

    @Test
    void getIncome() {
        assertEquals(111222, company.getIncome());
    }

    @Test
    void setIncome() {
        Company company = new Company();
        company.setIncome(111);
        assertEquals(111, company.getIncome());
    }
}