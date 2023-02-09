package project_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project_1.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
