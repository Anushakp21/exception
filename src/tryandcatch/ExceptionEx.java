package tryandcatch;

import java.util.Scanner;

public class ExceptionEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter 1 to trigger ArithmeticException : \n2.for NullPointerException : \n3.any other number for no exception:");
            int ch = sc.nextInt();

            if (ch == 1) {
                int result = 10 / 0;
            } else if (ch == 2) {
                String str = null;
                str.length();
            } else {
                System.out.println("No exception triggered.");
            }

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (NullPointerException e) {
            System.out.println("Error: Null reference encountered.");
        } catch( Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } 
    }
}
