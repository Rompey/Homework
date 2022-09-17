package cars;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class Main {
    public Set<Person> getPeople() {
        final Set<Person> personSet = set();
        for (Person p : personSet) {
            if (p.getAge() > 16 && p.getPenaltyPeriod() > 365 && p.isDriverLicence()) {
                System.out.println(p.getName());
            }
        }
        return personSet;
    }

    static Set<Person> set() {
        Set<Person> people = new HashSet<>();
        Random random = new Random();

        people.add(new Person("Anton",true, 18, random.nextInt(1000)));
        people.add(new Person("Ivan",false, 21, random.nextInt(1000)));
        people.add(new Person("Dmitry",false, 22, random.nextInt(1000)));
        people.add(new Person("Andrey",false, 25, random.nextInt(1000)));
        people.add(new Person("Alex",true, 19, random.nextInt(1000)));
        return people;
    }
}
