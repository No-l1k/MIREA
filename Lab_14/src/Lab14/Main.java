package Lab14;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        Pattern p1 = Pattern.compile("abcdefghijklmnopqrstuv18340");
        Matcher m1 = p1.matcher(in.nextLine());
        if(m1.matches())
            System.out.println(" Строка соответствует шаблону");
        else
            System.out.println(" Строка не соответствует шаблону");
    }
}