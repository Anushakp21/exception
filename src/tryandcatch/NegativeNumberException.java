package tryandcatch;

import java.util.Scanner;

public class NegativeNumberException extends RuntimeException {
	private String message;
	public NegativeNumberException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return message;
	}
	
	
	public static void checkNumber(int number) {
        if (number < 0) {
             throw new NegativeNumberException("Negative numbers are not allowed.");
        } else {
            System.out.println("You entered: " + number);
        }
    }
 public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);

      try {
          System.out.print("Enter an integer: ");
          int input = scanner.nextInt();
          checkNumber(input);

      } catch (NegativeNumberException e) {
          System.out.println("Error: " + e.getMessage());

      }
	
}
}

