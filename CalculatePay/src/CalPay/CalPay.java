package CalPay;

import java.util.Scanner;

import PaidAdvisor.PaidAdvisor;
import Person.Person;

class CalPay extends Person {

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
