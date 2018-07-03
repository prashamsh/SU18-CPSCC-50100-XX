package GCDOne;

import java.util.Scanner;

public class GCDClass{
	
	   private int calGCD(int num1, int num2)
	   {
	   
		   while (num1 != num2)
		   {  if (num1 > num2)
	         {
	            num1 = num1 - num2;
	         }
	            else
	            {
	            	num2 = num2 - num1;
	            }

	  	  	   }
		    return num1;
	   }

	   public static void main(String[] args) throws Exception {
		   	Scanner scanFirst = new Scanner(System.in);
			System.out.println("Please enter the first positive integer to calculate gcd");
			int firstPositiveInteger = scanFirst.nextInt();
		 	Scanner scanSecond = new Scanner(System.in);
			System.out.println("Please enter the second positive integer to calculate gcd");
			int secondPositiveInteger = scanSecond.nextInt();
			GCDClass gcd = new GCDClass();
			int a = gcd.calGCD(firstPositiveInteger, secondPositiveInteger);
			
			if (a==1)
			{
				throw new Exception("GCD is 1");
			}
			else
			{
				System.out.println("The GCD of " +firstPositiveInteger+" and "+secondPositiveInteger+" is: "+a);
			}
			
	   }
	}

