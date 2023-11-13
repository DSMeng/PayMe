import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class createUserAccount{

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

        // the 3rd party paying app is represented by an API key
        System.out.println("Enter your 3rd party paying app API key:");
        String thirdPartyAppApiKey = scanner.nextLine();

        // Create a user object with the provided information
        User newUser = new User(username, password, name, birthday, thirdPartyAppApiKey);

        // Display the created user's information
        System.out.println("User account created successfully. Details:");
        System.out.println(newUser);

        System.out.println("Valid Username: " + newUser.isValidUsername(username));
        System.out.println("Valid Birthday: " + newUser.isValidBirthday(birthday));
        System.out.println("Valid Name: " + newUser.isValidName(name));
        System.out.println("Valid Password: " + newUser.isValidPassword(password));
        System.out.println("Valid API Key: " + newUser.isValidThirdPartyKey(thirdPartyAppApiKey));

        scanner.close();
    }
}

class User {
    private String username;
    private String password;
    private String name;
    private String birthday;
    private String thirdPartyAppApiKey;
    private ArrayList<String> groupList = new ArrayList<>();

    public User(String username, String password, String name, String birthday, String thirdPartyAppApiKey) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.thirdPartyAppApiKey = thirdPartyAppApiKey;
    }

    public void addGroup(String groupname){
        groupList.add(groupname);
    }

    public void removeGroup(int index){
        groupList.remove(index);
    }

    public String getGroup(int index){
        return groupList.get(index);
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

    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && (password.contains("!") || password.contains("@") || password.contains("#") || password.contains("$") || password.contains("%"));
    }

    public static boolean isValidUsername(String username) {
        return username.length() >= 8;
    }

    public static boolean isValidName(String name) {
        return name.length() >= 2 && name.matches("[a-zA-Z ]+");
    }

    public static boolean isValidThirdPartyKey(String thirdPartyKey) {
        return !thirdPartyKey.isEmpty();
    }

    public static boolean isValidBirthday(String birthday){
        Locale locale = Locale.ENGLISH;
        String format = "yyyy-MM-dd";
        LocalDateTime ldt = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, locale);
        String[] date = birthday.split("-");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[2]), Integer.parseInt(date[1]));
        LocalDate now = LocalDate.now();
        long years = ChronoUnit.YEARS.between(birthDate, now);
        boolean formatting = false;

        //Check Formatting of Date
        try {
            ldt = LocalDateTime.parse(birthday, formatter);
            String result = ldt.format(formatter);
            formatting = result.equals(birthday);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(birthday, formatter);
                String result = ld.format(formatter);
                formatting = result.equals(birthday);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(birthday, formatter);
                    String result = lt.format(formatter);
                    formatting = result.equals(birthday);
                }catch(DateTimeParseException e2){
                    //place holder
                }
            }
        }

        //Check Age
        if(years >= 18 && formatting){
            return true;
        }

        return false;

    }
}