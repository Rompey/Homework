package demowithtests.repository;


import demowithtests.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);

}
