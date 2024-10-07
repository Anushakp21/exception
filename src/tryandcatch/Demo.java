package tryandcatch;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Number :");
		int a=sc.nextInt();
		try
		{
			int rs=100/a;
			System.out.println(rs);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Divide By zero error");
		}	
	}
}
