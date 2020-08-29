
/*Comment start
 
 *This class contains the main method for this program
 
 *Tasks performed in this class include the following:
 
 		*	Get the input (String) from the user
 		*	Pass the obtained input to "Inventory Allocator class" - to pre process the string data and calculate the best probability
 		*	Finally print the obtained output String that contains the orders which can be shipped.
 
comment ends*/

import java.util.Scanner;

import junit.framework.ComparisonFailure;

public class MainClass 
{
		/* This function gets the input string from the user, passes the input to InventoryAllocator Class and gets the processed Output String to be displayed.
		and finally it calls the function that cleans all the static variables and set its default value*/
		public static void main(String[] args) 
		{
				Scanner input = new Scanner(System.in);
				
				// string variable that is used to get input from the user.
				String inputString; 
				
				// string variable that obtains the output string to be displayed.
				String outputString;
				
				// string variable to choose between manual testing or to run Unit test cases
				String choice = null;
				
				// string variable to decide if the program needs to continue
				String runAnotherTestCase = null;
				
				System.out.println("Welcome to the Inventory Allocator Program"+"\n");
				System.out.println("Please enter your choice to run this program"+"\n"+"Enter 'M' to manually enter the input string and check the output (or) 'U' to run the unit test cases (or) 'Q' to exit program"+"\n");
				
				/* This do while loop is used to obtain the input from the user to decide onbe of the following:
				 * If manual test case should be executed
				 * If unit test cases should be executed
				 * Or Exit program
				 */
				do
				{
					choice = input.nextLine();
					if(choice.equalsIgnoreCase("m"))
					{
						System.out.println("Please enter the input in the format below:");
						System.out.println("{ Item1: count, Item2: count,... }, [{ name: name_of_the_warehouse, inventory: { Item1: Available_count, Item2: Available_count,... } }, { name: name_of_the_warehouse, inventory: { Item1: Available_count, Item2: Available_count,... } }]");
						System.out.println(" Input: ");
						inputString  = input.nextLine();
						
						InventoryAllocator inventoryAllocator  = new InventoryAllocator();		
						outputString  = InventoryAllocator.checkInputFormat(inputString);		
						printOutputString(outputString);	
						InventoryAllocator.cleanAllStaticVariables();
						
						System.out.println();
					}
					else if(choice.equalsIgnoreCase("u"))
					{
						InventoryAllocatorTest unitTestCases = new InventoryAllocatorTest();
						unitTestCases.unitTest01();
						unitTestCases.unitTest02();
						unitTestCases.unitTest03();
						unitTestCases.unitTest04();
						unitTestCases.unitTest05();
						unitTestCases.unitTest06();
						unitTestCases.unitTest07();
						unitTestCases.unitTest08();
						unitTestCases.unitTest09();
						unitTestCases.unitTest10();
						unitTestCases.unitTest11();
						unitTestCases.unitTest12();
						unitTestCases.unitTest13();
						unitTestCases.unitTest14();
						unitTestCases.unitTest15();
						unitTestCases.unitTest16();
						unitTestCases.unitTest17();
						unitTestCases.unitTest18();
						unitTestCases.unitTest19();
						unitTestCases.unitTest20();
						unitTestCases.unitTest21();
						unitTestCases.unitTest22();
						unitTestCases.unitTest23();
						unitTestCases.unitTest24();
						unitTestCases.unitTest25();
						unitTestCases.unitTest26();
						unitTestCases.unitTest27();
						unitTestCases.unitTest28();
						unitTestCases.unitTest29();
						unitTestCases.unitTest30();
						unitTestCases.unitTest31();
						unitTestCases.unitTest32();
						unitTestCases.unitTest33();
						unitTestCases.unitTest34();
						unitTestCases.unitTest35();
						unitTestCases.unitTest36();
						unitTestCases.unitTest37();
						unitTestCases.unitTest38();
						unitTestCases.unitTest39();
						unitTestCases.unitTest40();
						unitTestCases.unitTest41();
						unitTestCases.unitTest42();
						unitTestCases.unitTest43();
						unitTestCases.unitTest44();
						unitTestCases.unitTest45();
						unitTestCases.unitTest46();
						unitTestCases.unitTest47();
						unitTestCases.unitTest48();
						unitTestCases.unitTest49();
						unitTestCases.unitTest50();
						unitTestCases.unitTest51();
						unitTestCases.unitTest52();
						unitTestCases.unitTest53();
						unitTestCases.unitTest53();
						unitTestCases.unitTest54();
						try {
							unitTestCases.unitTest55();
						}
						catch(AssertionError e)
						{		
						}
						try {
							unitTestCases.unitTest56();
						}
						catch(AssertionError e)
						{
						}
						try {
							unitTestCases.unitTest57();
						}
						catch(AssertionError e)
						{	
						}
						try {
							unitTestCases.unitTest58();
						}
						catch(AssertionError e)
						{		
						}
						try {
							unitTestCases.unitTest59();
						}
						catch(AssertionError e)
						{		
						}
						try {
							unitTestCases.unitTest60();
						}
						catch(AssertionError e)
						{		
						}	
						System.out.println();
						System.out.println("End of Unit Test cases.");
						System.out.println();		
					}
					else if(choice.equalsIgnoreCase("q"))
					{
						System.out.println("Thank you!");
						break;
					}
					else if((!choice.equalsIgnoreCase("u")) || (!choice.equalsIgnoreCase("m")) || (!choice.equalsIgnoreCase("q")))
					{
							System.out.println("It looks like an option is entered that is not 'M', 'U' or 'Q'.");
							System.out.println("Please select 'M' to manually enter the input string and check the output (or) 'U' to run the unit test cases (or) 'Q' to exit program:");
					}
				
					if(choice.equalsIgnoreCase("m") || choice.equalsIgnoreCase("u"))
					{
						System.out.println("Would you like to run another test case? ");
						System.out.println("Please choose 'Y' for Yes or 'N' for No and Exit");
						
						do 
						{
							runAnotherTestCase =  input.nextLine();
							if(runAnotherTestCase.equalsIgnoreCase("y"))
							{
								System.out.println("Please enter your choice to run this program"+"\n"+"Enter 'M' to manually enter the input string and check the output (or) 'U' to run the unit test cases (or) 'Q' to exit program"+"\n");
								break;
							}
							else if(runAnotherTestCase.equalsIgnoreCase("n"))
							{
								System.out.println("Thank you!");
								break;	
							}
							else if(!runAnotherTestCase.equalsIgnoreCase("y") || !runAnotherTestCase.equalsIgnoreCase("n"))
							{
								System.out.println("It looks like an option is entered that is not 'Y' or 'N'");
								System.out.println("Please choose 'Y' for 'Yes' or 'N' for 'No and Exit'");
							}
						}while(!(runAnotherTestCase.equalsIgnoreCase("y")) || !(runAnotherTestCase.equalsIgnoreCase("n")));		
					}
					
					if((choice.equalsIgnoreCase("m") || choice.equalsIgnoreCase("u")) && runAnotherTestCase.equalsIgnoreCase("n"))
					{
						break;
					}
				
			}while((!choice.equalsIgnoreCase("u")) || (!choice.equalsIgnoreCase("m")) || (!choice.equalsIgnoreCase("q")));
				
		}

		//This function prints the output String to the user.
		private static void printOutputString(String outputString) 
		{
				System.out.println("Output:");
				System.out.println(outputString);
		}

}


