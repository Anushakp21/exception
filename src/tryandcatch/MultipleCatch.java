package tryandcatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter number1 :");
			int a=sc.nextInt();
			System.out.println("Enter number2 :");
			int b=sc.nextInt();
			int rs=a/b;
			System.out.println(rs);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
