import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

public class Main {

    public static Optional<User> findUserById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Vanya"));
        users.add(new User(2, "Sasha"));
        users.add(new User(3, "Oksana"));
        users.add(new User(4, "Yarik"));
        users.add(new User(5, "Vova"));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ID користувача для пошуку: ");
        int searchId = scanner.nextInt();

        Optional<User> user = findUserById(users, searchId);

        user.ifPresentOrElse(
                u -> System.out.println("Знайдено користувача: " + u),
                () -> System.out.println("Користувача з ID " + searchId + " не знайдено")
        );

        scanner.close();
    }
}