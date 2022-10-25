package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project1.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
