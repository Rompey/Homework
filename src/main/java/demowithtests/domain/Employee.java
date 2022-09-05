package demowithtests.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "email")
    private String email;
    @Column(name = "salary")
    private int salary;
    @Column(name = "work_experience")
    private String workExperience;
    @Column(name = "birthday")
    private Timestamp birthday;
}
