package com.example.service;

import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
        System.out.println("Особа додана: " + person);
    }

    public boolean deletePerson(int id) {
        return people.removeIf(person -> person.getId() == id);
    }

    public Optional<Person> findPersonById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    public List<Person> getAllPeople() {
        return new ArrayList<>(people);
    }
}