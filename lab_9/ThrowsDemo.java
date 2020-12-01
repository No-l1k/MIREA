package lab_9;

import java.util.Scanner;
import java.lang.Exception;

public class ThrowsDemo {
    ThrowsDemo() {}

    public void getDetails(String key) {
        try {
            if(key == null) {
                throw new NullPointerException( "null key in getDetails" );
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // do something with the key
    }

    public void printMessage(String key) {
        String message = getDetails1(key);
        System.out.println( message );
    }

    public String getDetails1(String key) {
        if(key == null) {
            throw new NullPointerException( "null key in getDetails" );
        }
        return "data for" + key;
    }

    public void getKey() {
        Scanner myScanner = new Scanner( System.in );
        String key = myScanner.next();
        printDetails( key );
    }

    public void printDetails(String key) {
        try {
            String message = getDetails2(key);
            System.out.println(message);
        } catch (Exception e) {
            // throw e;
        }
    }

    private String getDetails2(String key) throws Exception {
        if (key == "") {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public void getKey4() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter Key ");
        for (int i = 0; i < 2; i++) {
            try {
                String key = myScanner.nextLine();
                printDetails4(key);
                break;
            } catch (Exception e) {
                System.out.println("Неккоректо введен ключ: " + e);
            }
        }
    }

    public void printDetails4(String key) throws Exception {
        String message = getDetails4(key);
        System.out.println(message);
    }


    private String getDetails4(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }
}
