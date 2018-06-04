package javapackage;

public class CalculateWeightedAverage
{
	public static void main(String[] args) 
	
	{
	// Declaring variables for test scores
		float [][] testScoreAndWeight = 
		{
				{75f,95f,85f,55f,65f,70f},
				{0.10f,0.20f,0.25f,0.25f,0.10f,0.10f}
		};
	
	// Declaring variables for assignment scores
		float [][] assignScoreAndWeight = 
		{
				{55,65,65,60,55,50},
				{0.05f,0.10f,0.15f,0.25f,0.25f,0.20f}
		};
			
	//Calculating weighted average for test scores
		float testWeightedAverage = 0.0f;
		for (int i=0; i<testScoreAndWeight[0].length;i++)
		{
			testWeightedAverage = testWeightedAverage+testScoreAndWeight[0][i]*testScoreAndWeight[1][i];
		}
		
		System.out.println("Weighted Average of the test scores is " + testWeightedAverage);	


	//Calculating weighted average for assignment scores
		float assignWeightedAverage = 0.0f;
			for (int j=0; j<testScoreAndWeight[0].length;j++)
		{
			assignWeightedAverage = assignWeightedAverage+assignScoreAndWeight[0][j]*assignScoreAndWeight[1][j]; 
		}
		
		System.out.println("Weighted Average of the test scores is " + assignWeightedAverage);
		
	//Calculating master average of test and assignment scores:
		float masterAverage = (testWeightedAverage+assignWeightedAverage)/2;
		System.out.println("Master Average of the test and assignment scores is " + masterAverage);	
		
		
		
	}
}