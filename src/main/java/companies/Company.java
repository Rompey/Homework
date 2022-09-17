package companies;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "companies")
@Entity
@Getter
@Setter
public class Company{
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "taxi_driver")
    private String taxiDriver;
    @Column(name = "car")
    private String car;
    @Column(name = "taxi_driver_income")
    private String taxiDriverIncome;
    @Column(name = "company_income")
    private Integer companyIncome;
}
