import java.util.Scanner;

public class UserAccountCreation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for account creation
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your birthday (YYYY-MM-DD):");
        String birthday = scanner.nextLine();

        // For simplicity, let's assume the 3rd party paying app is represented by an
        // API key
        System.out.println("Enter your 3rd party paying app API key:");
        String thirdPartyAppApiKey = scanner.nextLine();

        // Create a user object with the provided information
        User newUser = new User(username, password, name, birthday, thirdPartyAppApiKey);

        // Display the created user's information
        System.out.println("User account created successfully. Details:");
        System.out.println(newUser);
    }
}

class User {
    private String username;
    private String password;
    private String name;
    private String birthday;
    private String thirdPartyAppApiKey;

    public User(String username, String password, String name, String birthday, String thirdPartyAppApiKey) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.thirdPartyAppApiKey = thirdPartyAppApiKey;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", thirdPartyAppApiKey='" + thirdPartyAppApiKey + '\'' +
                '}';
    }
}
