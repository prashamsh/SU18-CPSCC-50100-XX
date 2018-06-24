package CalculatePay;

import java.util.Scanner;

public class PaidAdvisor extends Person {
	double regularPayRate;
	double specialPayRate;
	double overtimePayRate;
	double hoursWorked;
	double hoursSpecial;
	double totalWage;
	String first;
	String last;

	public PaidAdvisor(String first, String last, double regularPayRate, double specialPayRate, double overtimePayRate,
			double hoursWorked, double hoursSpecial) {
		setNameRateHours(first, last, regularPayRate, specialPayRate, overtimePayRate, hoursWorked, hoursSpecial);
	}

	public double calculatePay() {
		if (getPayRate(hoursWorked, hoursSpecial) == 25) {
			totalWage = hoursSpecial * specialPayRate + (hoursWorked - hoursSpecial) * regularPayRate;
		} else {
			totalWage = hoursSpecial * specialPayRate + (hoursWorked - hoursSpecial - 30) * overtimePayRate
					+ 30 * regularPayRate;
		}
		return totalWage;

	}

	public String toString() {
		return ("The wage of " + first + " " + last + " is " + totalWage);

	}

	public double getPayRate(double workedHours, double specialHours) {
		if ((workedHours - specialHours) > 30) {
			return 37.5;
		} else {
			return 25;
		}

	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setNameRateHours(String first, String last, double regularPayRate, double specialPayRate,
			double overtimePayRate, double hoursWorked, double hoursSpecial)

	{
		this.first = first;
		this.last = last;
		this.regularPayRate = regularPayRate;
		this.specialPayRate = specialPayRate;
		this.overtimePayRate = overtimePayRate;
		this.hoursWorked = hoursWorked;
		this.hoursSpecial = hoursSpecial;
	}

}

class CalculatePay extends Person {
	public static void main(String[] args) {

		double payRateRegular = 25;
		double payRateSpecial = 50;
		double payRateOvertime = payRateRegular * 1.5;
		Scanner scanFirst = new Scanner(System.in);
		System.out.print("Enter Customer First Name");
		String fName = scanFirst.next();
		Scanner scanLast = new Scanner(System.in);
		System.out.print("Enter Customer Last Name");
		String lName = scanLast.next();
		Person personName = new Person();
		personName.Person(fName, lName);
		Scanner scanTotalHours = new Scanner(System.in);
		System.out.println("Please enter Total Hours worked");
		double workedHours = scanTotalHours.nextDouble();
		Scanner scanSpecialHours = new Scanner(System.in);
		System.out.println("Please enter Special Hours worked. Enter 0 if no special hours were worked");
		double specialHours = scanSpecialHours.nextDouble();
		PaidAdvisor paidAdvisor = new PaidAdvisor(personName.getFirstName(), personName.getLastName(), payRateRegular,
				payRateSpecial, payRateOvertime, workedHours, specialHours);
		paidAdvisor.calculatePay();
		System.out.println(paidAdvisor.toString());
	}
}
