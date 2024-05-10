package login;
import java.util.HashMap;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Authentication {
    HashMap<String, User> users = new HashMap<>();

    Authentication() {
        users.put("test", new User("test", "test"));
    }

    boolean register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }
        users.put(username, new User(username, password));
        System.out.println("Registration successful.");
        return true;
    }

    boolean authenticate(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.password.equals(password)) {
            System.out.println("Invalid username or password.");
            return false;
        }
        System.out.println("Login successful.");
        return true;
    }
}

class SecuredPage {
    void accessSecuredPage(Authentication auth) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (auth.authenticate(username, password)) {
            System.out.println("Access granted to secured page.");
        }
    }
}

public class in {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        SecuredPage securedPage = new SecuredPage();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Access secured page\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                auth.register(username, password);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                auth.authenticate(username, password);
            } else if (choice == 3) {
                securedPage.accessSecuredPage(auth);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}