package lab_9;

import java.util.Scanner;

public class Exception {

    Exception() {}

    public void exceptionDemo() {
        System.out.println( 2 / 0 );
    }

    public void exceptionDemo1() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public void exceptionDemo2() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println( 2 / i );
        }
        catch (NumberFormatException e) {
            System.out.println("This is not an integer: " + intString);
        }
        catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public void exceptionDemo3() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println( 2 / i );
        }
        catch (NumberFormatException e) {
            System.out.println("This is not an integer: " + intString);
        }
        catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
        finally {
            System.out.println("That all");
        }
    }

    public void getDetails(String key) {
        if (key == null)
            throw new NullPointerException( "null key in getDetails" );
    }
}
