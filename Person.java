package CalculatePay;

public class Person {

	private String firstName;// store the first name
	private String lastName; // store the last name

	public Person() // Default constructor
	{
		firstName = "";
		lastName = "";
	} // Constructor with parameters

	public void Person(String first, String last) {
		setName(first, last);
	} // Method to output the first name and last name

	public String toString() {
		return (firstName + " " + lastName);
	} // Method to set the first name and last name

	public void setName(String first, String last) {
		firstName = first;
		lastName = last;
	} // Method returns first name

	String getFirstName() {
		return (firstName);
	} // Method returns last name

	public String getLastName() {
		return lastName;
	}

}
