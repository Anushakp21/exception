package tryandcatch;

import java.util.Scanner;

public class InvalidAgeException extends Exception{
	private String message;
	InvalidAgeException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return message;
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the Age : ");
	int age=sc.nextInt();
	if(age>18)
	{
		System.out.println("Valid Age "+age);
	}
	else
	{
		try
		{
			throw new InvalidAgeException("Invalid age ");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
}

