package tryandcatch;

import java.util.Scanner;

public class DivisionDemo {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a number:");
	        int a = sc.nextInt();
	        try {
	            int result = 100 / a;
	            System.out.println("Result: " + result);
	        } catch (ArithmeticException e) {
	            System.out.println("Cannot divide by zero");
	        } finally {
	            System.out.println("Division operation complete");
	        }
	    }

}
