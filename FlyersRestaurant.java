package javapackage;

import java.util.Scanner;

public class FlyersRestaurant 
{
	

	public String gatherOrderType()
	{
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter P for Pick-up and D for Delivery: ");
	String order = scan.next();
	return order;
	}
	
	public int gatherZipcode()
	{			
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter the zip code: ");
	int zipCode = scan.nextInt();
	return zipCode;
	}	

	public int[] gatherOrderList()
	{			

	System.out.print("List of items include:");
	System.out.println("(1) Flyers' Burger: $ 4.50 per an order");
	System.out.println("(2) Flyers' Drink: $ 1.50 per an order");
	System.out.println("(3) Flyers' Fries: $ 2.50 per an order");
	System.out.println("(4) Flyers' Dessert: $ 3.00 per an order");
	System.out.println("(5) Flyers' Hashbrowns: $ 3.50 per an order");
	System.out.println("(6) Flyers' Chips: $ 1.00 per an order");

	int i=0;
	int[] orderList= new int[20];
	do  {
		System.out.println("Enter next order. Example - '1' for Flyers' Burger '2' for Flyers' Drink. Enter '0' if you are done ordering");
		Scanner scan = new Scanner(System.in);
		orderList[i] = scan.nextInt();
		i++;
		}while(orderList[i-1]!=0);
	return orderList;
	
	}
	
	public double calculateFinalPrice ()
	{
		int[] selectedOrderList= new int[20];
		String selectedOrderType;
		int selectedZipCode;
		double orderSum=0;
		double zipSum=0;
		double finalOrderPrice=0;
		double [] selectedOrderListPrice = new double[20];
		FlyersRestaurant flyers = new FlyersRestaurant();
		selectedOrderType = flyers.gatherOrderType();
		selectedZipCode = flyers.gatherZipcode();
		selectedOrderList = flyers.gatherOrderList();
		
			for(int i=0;i<selectedOrderList.length;i++)
			{
				switch(selectedOrderList[i])
				{
				case 1: selectedOrderListPrice[i] = 4.5*1.05;
						break;
				case 2: selectedOrderListPrice[i] = 1.5*1.05;
						break;
				case 3: selectedOrderListPrice[i] = 2.5*1.05;
						break;
				case 4: selectedOrderListPrice[i] = 3*1.05;
						break;
				case 5: selectedOrderListPrice[i] = 3.5*1.05;
						break;
				case 6: selectedOrderListPrice[i] = 1*1.05;
						break;
				default: selectedOrderListPrice[i] = 0;
						break;
						
				}
			
			}
			
				for(int j=0;j<selectedOrderListPrice.length;j++)
				{
					orderSum=orderSum+selectedOrderListPrice[j];
				}
		
				if (selectedZipCode==60451||selectedZipCode==60441)
				{
					zipSum=7.00;
				}
				if (selectedZipCode>60446-5&&selectedZipCode<60446+5)
				{
					zipSum=5.00;
				}
				if (selectedZipCode<=60446-6&&selectedZipCode>=60446+6) 
				{
					zipSum=0;
				}	
				if (selectedOrderType.equals("D")&&(selectedZipCode>60446-6&&selectedZipCode<60446+6))
				
					finalOrderPrice=orderSum+zipSum;
				else if (selectedOrderType.equals("D")&&(selectedZipCode<=60446-6&&selectedZipCode>=60446+6))
					
					finalOrderPrice=0;
					
				else if (selectedOrderType.equals("P"))
				
				finalOrderPrice=orderSum;
				
				return finalOrderPrice;

	}
	
	public static void main(String[] args)
	
	{
	double finalOrderPrice;
		FlyersRestaurant flyers = new FlyersRestaurant();
		finalOrderPrice=flyers.calculateFinalPrice();
		if (finalOrderPrice==0)
		System.out.println("Sorry, either delivery is not available to your location or you may have entered a incorrect delivery type");
		else
		System.out.println("Your total order price is: " + finalOrderPrice);
			
	}
	}
	
		

	
