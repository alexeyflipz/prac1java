package com.example.app;

import com.example.model.Person;
import com.example.service.PersonService;

import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonService personService = new PersonService();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nОберіть опцію:");
            System.out.println("1. Додати особу");
            System.out.println("2. Видалити особу");
            System.out.println("3. Знайти особу за ID");
            System.out.println("4. Переглянути всіх осіб");
            System.out.println("5. Вийти");
            System.out.print("Опція: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> addPerson();
                case 2 -> deletePerson();
                case 3 -> findPerson();
                case 4 -> viewAllPeople();
                case 5 -> running = false;
                default -> System.out.println("Невірна опція, спробуйте ще раз.");
            }
        }
    }

    private static void addPerson() {
        System.out.print("Введіть ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();

        Person person = new Person(id, name, age);
        personService.addPerson(person);
    }

    private static void deletePerson() {
        System.out.print("Введіть ID особи, яку потрібно видалити: ");
        int id = scanner.nextInt();

        if (personService.deletePerson(id)) {
            System.out.println("Особу видалено.");
        } else {
            System.out.println("Особу не знайдено.");
        }
    }

    private static void findPerson() {
        System.out.print("Введіть ID особи, яку потрібно знайти: ");
        int id = scanner.nextInt();

        personService.findPersonById(id).ifPresentOrElse(
                person -> System.out.println("Знайдено: " + person),
                () -> System.out.println("Особу не знайдено.")
        );
    }

    private static void viewAllPeople() {
        System.out.println("Особи в системі:");
        for (Person person : personService.getAllPeople()) {
            System.out.println(person);
        }
    }
}