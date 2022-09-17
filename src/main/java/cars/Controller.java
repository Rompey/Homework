package cars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/cars")
@RestController
public class Controller {
    private final Main main;

    public Controller(Main main) {
        this.main = main;
    }

    @GetMapping
    public Iterable<Person> getPeople(){
        return main.getPeople();
    }
}
