package companies;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyDTO getTopCompany(){
        Company company = companyRepository.getTopCompanyByCompanyIncome();
        return getCompanyDTO(company);
    }

    public List<CompanyDTO> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(this::getCompanyDTO)
                .collect(Collectors.toList());
    }

    @NotNull
    private CompanyDTO getCompanyDTO(Company company) {
        return new CompanyDTO(
                company.getId(),
                company.getCompanyName(),
                company.getTaxiDriver(),
                company.getCar(),
                company.getTaxiDriverIncome(),
                company.getCompanyIncome());
    }
}
