package GradCalculator;
import java.io.*;
import java.util.*;
import java.util.Scanner;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

interface grade
{
	void printGrade(String[] grade);
}

	class Student implements grade
	{

		String studentGrade[];
	
			public void printGrade(String[] calculatedGrade)
			{
				for(int i=1;i<11;i++)
				{
					System.out.println("The Student grade of student"+i+" is "+calculatedGrade[i]);
				}
			}
	
				public double [] gatherStudentScore() throws IOException{
					FileInputStream fis = new FileInputStream(new File("StudentScores.xls"));
				//create workbook instance that refers to .xls file
					HSSFWorkbook wb = new HSSFWorkbook(fis);
				//create a sheet object to retrieve the sheet
				HSSFSheet sheet = wb.getSheetAt(0);
				//that is for evaluating the cell type
				FormulaEvaluator forlulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
				double[] studentScore = new double[200];
				int k=1;
				int l=8; 
				for(Row row : sheet) {
					for(Cell cell : row) {
						switch(forlulaEvaluator.evaluateInCell(cell).getCellType())
						{
						//if cell is in numeric format
						case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						studentScore[k]=cell.getNumericCellValue();
						k++;
						break;
						//if cell is in string format
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t\t");
							break;
						}
					}
				System.out.println();
				}
			double studentTempTotal=0;
			double[] studentTotal=new double[20];
			int p=1;
			int r=1;
			for(int q=2;q<sheet.getPhysicalNumberOfRows()+2;q++)
			{
				for(int m=r; m<l+1;m++)
				{
					studentTempTotal=studentTempTotal+studentScore[m];
				}
			studentTotal[p]=studentTempTotal;
			p++;
			r=r+8;
			l=l+8;
			studentTempTotal=0;
						
				}
			return studentTotal;	
		}
			
			public String[] calculateStudentGrade() throws IOException
			
			{
				Student studentScore = new Student();
				double[] storeStudentTotal = new double[20];
				storeStudentTotal=studentScore.gatherStudentScore();
				String[] calStdGrd = new String[20];
				
			    double sum = 0;
			    double newSum = 0; 

			    for (int i = 1; i<11; i++){
			        sum = sum + storeStudentTotal[i];
			    }
			    double mean = (sum) /10; 

			    for (int j = 1; j<11; j++){
			        // put the calculation right in there
			        newSum = newSum + ((storeStudentTotal[j] - mean) * (storeStudentTotal[j] - mean)); 
			    }
			    double squaredDiffMean = (newSum) /10; 
			    double standardDev = (Math.sqrt(squaredDiffMean)); 

			     
				
				for(int i=1;i<11;i++)
				{
						if(storeStudentTotal[i]>=(mean+2*(standardDev)))
						calStdGrd[i]="A";
						else if(storeStudentTotal[i]>=(mean+standardDev))
						calStdGrd[i]="B";
						else if(storeStudentTotal[i]>=(mean))
						calStdGrd[i]="C";
						else if(storeStudentTotal[i]>=(mean-2*(standardDev)))
						calStdGrd[i]="D";
						else if(storeStudentTotal[i]<(mean-2*(standardDev)))
						calStdGrd[i]="F";
	
				
				}
						return calStdGrd;
				}
			
	}
		
		class Instructor implements grade
		{
			
				public String[] calculateInstructorGrade() throws IOException
				{
					Student studentScore = new Student();
					double[] storeStudentTotal = new double[20];
					storeStudentTotal=studentScore.gatherStudentScore();
					String[] calInsGrd = new String[20];
					for(int i=1;i<11;i++)
					{
							if(storeStudentTotal[i]>450)
							calInsGrd[i]="A";
							else if(storeStudentTotal[i]>400)
							calInsGrd[i]="B";
							else if(storeStudentTotal[i]>350)
							calInsGrd[i]="C";
							else if(storeStudentTotal[i]>300)
							calInsGrd[i]="D";
							else if(storeStudentTotal[i]>=0)
							calInsGrd[i]="F";
		
					System.out.println("The total score of Student"+i+" is: "+storeStudentTotal[i]);
					}
							return calInsGrd;
					}

				public void printGrade(String[] calculatedGrade) {

					for(int i=1;i<11;i++)
					{
						System.out.println("The Instructor grade of student"+i+" is "+calculatedGrade[i]);
					}
					
				}

			}

	
	class GradeCalculator
	{
	public static void main (String[] args)throws IOException
	{
		Student student = new Student();
		Instructor instructor = new Instructor();
		instructor.printGrade(instructor.calculateInstructorGrade());
		student.printGrade(student.calculateStudentGrade());
		
	}
}