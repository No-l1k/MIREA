package lab_12;
import java.util.Scanner;
import java.util.regex.*;

public class DateChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите дату: ");
            String s = sc.nextLine();
            if (!Pattern.matches("(\\d\\d/){2}\\d{4}", s))
                System.out.println("Неверный формат");
            else if (logicalCheck(s))
                System.out.println("Дата корректна!");
        }
    }

    public static boolean logicalCheck(String date) {
        String[] dtmp = date.split("/");
        int day = Integer.parseInt(dtmp[0]);
        int month = Integer.parseInt(dtmp[1]);
        int year = Integer.parseInt(dtmp[2]);
        if (year < 1900 || year > 9999) {
            System.out.println("Неверно указан год");
            return false;
        }
        if (month < 1 || month > 12) {
            System.out.println("Неверно указан месяц");
            return false;
        }
        int max_day = 30;
        if (month%2 == 1 || month == 8)
            max_day = 31;
        else if (month == 2) {
            max_day = 28;
            if (year%400 == 0 || (year%4 == 0 && year%100 != 0))
                max_day = 29;
        }
        if (day < 1 || day > max_day) {
            System.out.println("Неверно указан день");
            return false;
        }
        return true;
    }
}