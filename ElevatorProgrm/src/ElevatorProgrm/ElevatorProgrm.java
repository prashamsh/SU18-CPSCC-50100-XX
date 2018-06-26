package ElevatorProgrm;
import java.util.Scanner;
public class ElevatorProgrm {

	private int gatherFloorNumber()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your current floor Number, 1 for first and 2 for Second");
		int floorNumber = scan.nextInt();
		return floorNumber;
	}
	
	private int gatherDestinationFloor()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your destination floor, 1 for first 2 for second and 0 for basement");
		int destinationFloor = scan.nextInt();
		return destinationFloor;
	}
	public static void main(String[] args)
	{
		int presentFloorNumber;
		int finalFloorNumber;
		System.out.println("Elevator is currrently in Basement");
		ElevatorProgrm elevator = new ElevatorProgrm();
		presentFloorNumber=elevator.gatherFloorNumber();
		finalFloorNumber=elevator.gatherDestinationFloor();
		String elevatorInitialDirection = null;
		if (presentFloorNumber==1){elevatorInitialDirection="U";}else {elevatorInitialDirection="2U";}
		String elevatorFinalDirection = null;
		int a=finalFloorNumber-presentFloorNumber;
		if (a==1) {elevatorFinalDirection="U";}
		if (a==2) {elevatorFinalDirection="2U";}
		if (a==-1) {elevatorFinalDirection="D";}
		if (a==-2) {elevatorFinalDirection="2D";}
		if (a!=1&&a!=2&&a!=-1&&a!=-2) {System.out.println("You entered incorrect destination floor");}
		if (presentFloorNumber==finalFloorNumber) {System.out.println("You are already in "+presentFloorNumber+ " floor");}
		else {
	
				System.out.println("The elevator is now moving "+elevatorInitialDirection+" to: " + presentFloorNumber + " floor");
				try {Thread.sleep(5000);}
				catch (InterruptedException e) {e.printStackTrace();}
				System.out.println("The elevator is now on the "+ presentFloorNumber +" floor and open O please board the elevator");
				try {Thread.sleep(7000);}
				catch (InterruptedException e) {e.printStackTrace();}
				System.out.println("The elevator is now closed C, elevator is moving "+elevatorFinalDirection+" to "+finalFloorNumber);
				try {Thread.sleep(7000);}
				catch (InterruptedException e) {e.printStackTrace();}				
				System.out.println("The elevator is now on "+finalFloorNumber +" and open O, please move out");
				try {Thread.sleep(5000);}
				catch (InterruptedException e) {e.printStackTrace();}
				System.out.println("The elevator is now on "+finalFloorNumber +" and closed C");}
		
		
			
		
	}
}
