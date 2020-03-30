package pojos;


import org.eclnt.ccee.db.dofw.annotations.doentity;
import org.eclnt.ccee.db.dofw.annotations.doproperty;

import java.math.BigDecimal;
import java.util.Date;

@doentity(table="employee")
public class DOEmployee {

    Integer id;
    String first_name;
    String second_name;
    String third_name;
    int age;
    int company_id;
//    String company_name;
    Date date_start;
    BigDecimal salary;
    String iban;


    @doproperty(key=true, autoIncrement=true)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }

    @doproperty
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @doproperty
    public String getSecond_name() {
        return second_name;
    }
    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @doproperty
    public String getThird_name() {
        return third_name;
    }
    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    @doproperty
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @doproperty
    public int getCompany_id() {
        return company_id;
    }
    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

//    @doproperty
//    public String getCompanyName() {
//        return companyName;
//    }

//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }

    @doproperty
    public Date getDate_start() {
        return date_start;
    }
    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    @doproperty
    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @doproperty
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
}
