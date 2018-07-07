package StringTree;

import java.util.Scanner;

public class StringTree {
	
	public static void main(String[] args)
	{
		
		Tree t = new Tree();
		String nextWord = "Y";
		while (!"N".equals(nextWord))
		{
			Scanner scanNext = new Scanner(System.in);
			System.out.println("Enter next Word. Enter 'N' if you are done entering the words: ");
			String newWord = scanNext.next();
			nextWord=newWord;
			t.insertWord(newWord);
			System.out.println("Here is the sorted order or the words: ");
			t.inOrder(t.root);
			nextWord=nextWord.toUpperCase();
		}
		System.out.println("Thank you, Your final list of alphabetically sorted words is printed above");
	}

}


