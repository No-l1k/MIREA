package Lab19;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static boolean check_password(String password){
        String bigLetter="\\w*[A-Z]+\\w*";
        String lowLetter="\\w*[a-z]+\\w*";
        String number="\\w*\\d+\\w*";
        String count="\\w{8,}";
        if(Pattern.matches(bigLetter,password)&&Pattern.matches(lowLetter,password)&&Pattern.matches(number,password)&&Pattern.matches(count,password))return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println("Введите пароль");
        Scanner scanner=new Scanner(System.in);
        System.out.println(check_password(scanner.nextLine()));
    }
}