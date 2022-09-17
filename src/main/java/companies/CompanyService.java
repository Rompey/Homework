package companies;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDTO> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> new CompanyDTO(
                        company.getId(),
                        company.getCompanyName(),
                        company.getTaxiDriver(),
                        company.getCar(),
                        company.getCompanyIncome(),
                        company.getTaxiDriverIncome()))
                .collect(Collectors.toList());
    }
}
