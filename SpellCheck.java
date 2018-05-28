// CEN 3024
// Phillip Modesto P1559694

// Spell check assignment with the following conditions
// Write a program that does spell checking. The program should 
// do spell checking as follows,

// -The program should accept two text file names on the command line

// -The program should read both files into string variables. The first is 
// the file to check, and the second is the dictionary

// -Both strings should be split into lists of words (two ArrayList collections)

// -Implement your main loop. For each word in the document file, if that word doesn't 
// exist in the dictionary, print it out, saying that it is an unknown word

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class SpellCheck 
{
	
	public static void main(String[] args)
	{
		//input
		Scanner stdin = new Scanner(System.in);
		//Variable arrays
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> dict = new ArrayList<String>();
		
		try
		{
			
			// Get the word file from the user.
			// Add words to list array
			System.out.println("Enter your word file path.");
			String wordfile = stdin.next();
			Scanner fin = new Scanner(new File(wordfile));
		
				while (fin.hasNext()) 
				{
				
					list.add(fin.next());
			
				}
				fin.close();
			
		}
		catch(IOException e)
		{
			System.out.println("File not found try again" );
			System.exit(0);
		}
		
		
		try
		{
			// Get the dictionary file from the user.
			// Add words to dict array
			System.out.println("Enter your dictionary file path.");
			String dictfile = stdin.next();
			Scanner din = new Scanner(new File(dictfile));
			
			
				while (din.hasNext()) 
				{
					
				dict.add(din.next());
				
				}
				din.close();
				
		}
		catch(IOException e)
			{
				System.out.println("File not found try again" );
				System.exit(0); 
			}
				
				// Close input
				stdin.close();
				
				//Convert both dictionary and word list to lower case, and remove punctuation
				UnaryOperator<String> newlist = (y) -> y.replaceAll("[^a-zA-Z \n]", "").toLowerCase();
				list.replaceAll(newlist);
				
				UnaryOperator<String> newdict = (x) -> x.replaceAll("[^a-zA-Z \n]", "").toLowerCase();
				dict.replaceAll(newdict);
				
				
				// Main loop comparing the two arrays from files 
				for(int i = 0; i <list.size(); i++)
				{
					String check = list.get(i);
					
					if(dict.contains(check))
					{
					}
					else
					{
						System.out.println(check + " is an unknown word");
					}
				}
			// Test print for list
			//System.out.println("testlist " + list);
			//System.out.println("dictionary " + dict);
	}
}