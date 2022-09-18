package companies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {

        @Query("SELECT c FROM Company c WHERE c.companyIncome=(" +
                "SELECT MAX(companyIncome) FROM Company )")
        Company getTopCompanyByCompanyIncome();
}
