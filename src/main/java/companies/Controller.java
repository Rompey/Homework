package companies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/companies")
public class Controller {

    private final CompanyService companyService;

    public Controller(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public Collection<CompanyDTO> getCompanies() {
        return companyService.getCompanies();
    }
}
