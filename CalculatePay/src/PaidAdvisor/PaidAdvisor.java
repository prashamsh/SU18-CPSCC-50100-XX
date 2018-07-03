package PaidAdvisor;

import java.util.Scanner;
import Person.Person;

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