package companies;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class Controller {

    private final CompanyService companyService;

    @GetMapping
    public Collection<CompanyDTO> getCompanies() {
        return companyService.getCompanies();
    }
    @GetMapping("/top_company")
    public CompanyDTO findCompanyByCompanyIncome(){
        return companyService.getTopCompany();
    }
}
