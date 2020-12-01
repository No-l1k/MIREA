package lab_13;
import java.util.Scanner;
import java.util.regex.Pattern;
public class PasswordChecker {
    public static void main(String[] args) {
        String pswd;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите пароль: ");
            pswd = scanner.next();
            if (pswd.equals("?")) {
                System.out.println("Пароль должен состоять из 8 и более букв латиницы (обоих регистров!) и\n" +
                        "цифр, он может содержать '_'");
                continue;
            } else if (pswd.length() < 8) {
                System.out.println("Пароль должен содержать минимум 8 символов");
                continue;
            } else if (!Pattern.matches("\\w+", pswd)) {
                System.out.println("Пароль может состоять только из букв латиницы," +
                        " цифр и знака '_'");
                continue;
            } else if (!Pattern.matches(".*[A-Z].*", pswd)) {
                System.out.println("Пароль должен содержать минимум одну" +
                        " заглавную букву");
                continue;
            } else if (!Pattern.matches(".*[a-z].*", pswd)) {
                System.out.println("Пароль должен содержать минимум одну" +
                        " строчную букву");
                continue;
            } else if (!Pattern.matches(".*\\d.*", pswd)) {
                System.out.println("Пароль должен содержать минимум одну" +
                        " цыфру");
                continue;
            }
            System.out.println("Пароль ±прокатит");
        }
    }
}
