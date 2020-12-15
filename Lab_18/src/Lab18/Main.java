package Lab18;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static boolean check_email(String password){
        String patemail="^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        if(Pattern.matches(patemail,password)) return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println("Введите email");
        Scanner scanner=new Scanner(System.in);
        System.out.println(check_email(scanner.nextLine()));
    }
}