package edu.coursework.admissions.data;

/*
    @author:    Anton
    @project:    Trade
    @class:    FakeData
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.admissions.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeData {

    private List<Person> person = new ArrayList<>(
            Arrays.asList(
                    new Person("1", "Boris", "Dut", 37, "Male"),
                    new Person("2", "Nikit", "Bon", 27, "Male"),
                    new Person("3", "Sasha", "Sel", 36, "Male"),
                    new Person("4", "Jhon", "Smith", 29, "Male"),
                    new Person("5", "Nina", "Hin", 39, "Female"),
                    new Person("6", "Lina", "Bort", 30, "Female"),
                    new Person("7", "Lora", "Metu", 28, "Female"),
                    new Person("8", "Giner", "Kiyo", 26, "Female"),
                    new Person("9", "Famon", "Vouer", 27, "Male"),
                    new Person("10", "Grish", "Funch", 36, "Male")));

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}
