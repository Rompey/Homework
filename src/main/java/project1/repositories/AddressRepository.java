package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project1.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
