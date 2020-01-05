import java.util.Scanner;

class ReverseNumber
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		System.out.println("You entered " + number);

		int reversed = 0;

		while(number > 0) 
		{
			int digit = number % 10;
			reversed = reversed * 10 + digit;
			number /= 10;
		}

		System.out.println("After reversal " + reversed);
	}
}