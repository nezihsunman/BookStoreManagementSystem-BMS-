package bookstoremanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companys")
public class Company {

    @Id
    private String companyName;

    private float income;

    protected Company() {
    }

    public Company(String companyName, float income) {

        this.companyName = companyName;
        this.income = income;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
