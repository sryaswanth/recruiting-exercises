/* This class contains Unit Test cases for this Inventory Allocator Program

*/

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.ComparisonFailure;

public class InventoryAllocatorTest 
{
	
	void printInputandOutputDetails(String input, String expectedOutput, String actualOutput) 
	{
		System.out.println("-----------------------------------------------------------------------------------------------------------------"+"\n");
		System.out.println("Unit test details: "+"\n");
		System.out.println("Input: "+input+"\n");
		System.out.println("Expected (written result) Output: "+expectedOutput+"\n");
		System.out.println("Actual (execution result) Output: "+actualOutput+"\n");
		

			if(expectedOutput.replaceAll(" ", "").contentEquals(actualOutput.replaceAll(" ", "")) )
			{
				System.out.println("Result: Expected Output and Acutal Output Matches");
			}
			else
			{
				System.out.println("Expected and Actual Output does not match. This unitTest case is performed to show that Actual output has the correct logic and the expected user output cannot be obtained.");
				fail();
			}
	//	assertEquals("Expected and Actual Output does not match. This unitTest case is performed to show that Actual output has the correct logic.", expectedOutput.replaceAll(" ", ""), actualOutput.replaceAll(" ", ""));
	
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	
		
	@Test
	public void unitTest01() 
	{
		
		String input = "{ apple: 1 }, [{ name: owd, inventory: { apple: 1 } }]";
		String expectedOutput = "[{ owd: { apple: 1 } }]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);	
		InventoryAllocator.cleanAllStaticVariables();	
		printInputandOutputDetails(input,expectedOutput,actualOutput);
		
	}
	
	@Test
	public void unitTest02() 
	{
		
		String input = "{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]";
		String expectedOutput = "[{ owd: { apple: 5 }}, { dm: { apple: 5 } }]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();	
		actualOutput  = InventoryAllocator.checkInputFormat(input);
		InventoryAllocator.cleanAllStaticVariables();	
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest03() 
	{
		
		String input = "{ apple: 1 }, [{ name: owd, inventory: { apple: 0 } }]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	
	@Test
	public void unitTest04() 
	{
		
		String input = "{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest05() 
	{
		
		String input = "{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 6 }}]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest06() 
	{
		
		String input = "{ apple: 9 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {apple: 4}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest07() 
	{
		
		String input = "{ apple: 11 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]";
		String expectedOutput = "[ ]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest08() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 5, orange:5 } }]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest09() 
	{
		
		String input = "{ apple: 5, orange:6 }, [{ name: owd, inventory: { apple: 5, orange:5 } }]";
		String expectedOutput = "[ { owd: { apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest10() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 4, orange:4 } }]";
		String expectedOutput = "[ ]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest11() 
	{
		
		String input = "{ apple: 6, orange:5 }, [{ name: owd, inventory: { apple: 5, orange:5 } }]";
		String expectedOutput = "[ { owd: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	
	@Test
	public void unitTest12() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 0, orange:0 } }]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest13() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 5 } }]";
		String expectedOutput = "[ { owd: {apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest14() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { orange: 5 } }]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest15() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { orange: 6 } }]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest16() 
	{
		
		String input = "{ apple: 5, orange:5 }, [{ name: owd, inventory: { apple: 6 } }, { name: dm, inventory: { orange: 5 } }]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest17() 
	{
		
		String input = "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest18() 
	{
		
		String input = "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest19() 
	{
		
		String input = "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {apple: 5}},{ dm: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest20() 
	{
		
		String input = "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 5, orange:4 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 4, apple: 5}},{ dm: {orange: 1, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest21() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest22() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 10, orange:5 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 10}},{ dm: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest23() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 10, orange:10 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 10, apple: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest24() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 10, orange:5 } }, { name: dm, inventory: { apple: 5, orange:10 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 10}},{ dm: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest25() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 5, orange:10 } }, { name: dm, inventory: { apple: 10, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 10, apple: 5}},{ dm: {apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}

	@Test
	public void unitTest26() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 10, orange:10 }}]";
		String expectedOutput = "[ { dm: {orange: 10, apple: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest27() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:10 } }, { name: dm, inventory: { apple: 10, orange:0 }}]";
		String expectedOutput = "[ { owd: {orange: 10}},{ dm: {apple: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest28() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 10, orange:0 } }, { name: dm, inventory: { apple: 0, orange:10 }}]";
		String expectedOutput = "[ { owd: {apple: 10}},{ dm: {orange: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest29() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 0, orange:10 }}]";
		String expectedOutput = "[ { dm: {orange: 10}}]";
		String actualOutput = "";

		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest30() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 9, orange:0 } }, { name: dm, inventory: { apple: 0, orange:10 }}]";
		String expectedOutput = "[ { dm: {orange: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest31() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 9, orange:10 }}]";
		String expectedOutput = "[ { dm: {orange: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest32() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 0, orange:0 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest33() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 9, orange:9 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest34() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 5, orange:5 }}, { name: env, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest35() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 5, orange:5 }}, { name: env, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest36() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 10, orange:10 }}, { name: env, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest37() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 10, orange:10 }}, { name: env, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { dm: {orange: 10, apple: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest38() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 5, orange:5 }}, { name: env, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { dm: {orange: 5, apple: 5}},{ env: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest39() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 0, orange:0 }}, { name: env, inventory: { apple: 10, orange:10 }}]";
		String expectedOutput = "[{env: {orange: 10, apple: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest40() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 3, orange:3 } }, { name: dm, inventory: { apple: 3, orange:3 }}, { name: env, inventory: { apple: 3, orange:3 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest41() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 9, orange:9 } }, { name: dm, inventory: { apple: 0, orange:0 }}, { name: env, inventory: { apple: 0, orange:0 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest42() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 9, orange:9 }}, { name: env, inventory: { apple: 0, orange:0 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest43() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 0, orange:0 }}, { name: env, inventory: { apple: 9, orange:9 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest44() 
	{
		
		String input = "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 0, orange:0 } }, { name: dm, inventory: { apple: 0, orange:0 }}, { name: env, inventory: { apple: 0, orange:0 }}]";
		String expectedOutput = "[ ]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest45() 
	{
		
		String input =  "{ apple: 10, orange:10, banana:10 }, [{ name: owd, inventory: { apple: 5, orange:5, banana:0 } }, { name: dm, inventory: { apple: 5, orange:5,banana:0 }}, { name: env, inventory: { apple: 5, orange:5, banana:0 }}]";
		String expectedOutput = "[ { owd: {orange: 5, apple: 5}},{ dm: {orange: 5, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest46() 
	{
		
		String input =  "{ apple: 10, orange:10, banana:10 }, [{ name: owd, inventory: { apple: 5, orange:5, banana:3 } }, { name: dm, inventory: { apple: 5, orange:5,banana:3 }}, { name: env, inventory: { apple: 5, orange:5, banana:3 }}]";
		String expectedOutput = "[ { owd: {orange: 5,  apple: 5}},{ dm: {orange: 5,  apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest47() 
	{
		
		String input =  "{ apple: 9, orange:10, banana:10 }, [{ name: owd, inventory: { apple: 3, orange:5, banana:3 } }, { name: dm, inventory: { apple: 3, orange:5,banana:3 }}, { name: env, inventory: { apple: 2, orange:5, banana:3 }}]";
		String expectedOutput = "[ { owd: {orange: 5}},{ dm: {orange: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest48() 
	{
		
		String input =  "{ apple: 10, orange:10, banana:10 }, [{ name: owd, inventory: { apple: 0, orange:0, banana:0 } }, { name: dm, inventory: { apple: 0, orange:0,banana:0 }}, { name: env, inventory: { apple: 0, orange:0, banana:0 }}]";
		String expectedOutput = "[]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest49() 
	{
		
		String input =  "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 5,apple:5,orange:4 } }, { name: dm, inventory: { apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 4, apple: 10}},{ dm: {orange: 1}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest50() 
	{
		
		String input =  "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 5,orange:4 } }, { name: dm, inventory: { apple: 5,apple: 5, orange:5 }}]";
		String expectedOutput = "[{owd: {orange: 4, apple: 5}},{ dm: {orange: 1, apple: 5}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest51() 
	{
		
		String input =  "{ apple: 10, orange:5 }, [{ name: owd, inventory: { apple: 4,orange:4 } }, { name: dm, inventory: { apple: 5,apple: 5, orange:5 }}]";
		String expectedOutput = "[ { owd: {orange: 4, apple: 4}},{ dm: {orange: 1, apple: 6}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	
	@Test
	public void unitTest52() 
	{
		
		String input =  "{  }, [{ name: owd, inventory: { apple: 1 } }]";
		String expectedOutput = "[  ]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest53() 
	{
		
		String input =  "{ apple:1 }, [{ name: owd, inventory: { } }]";
		String expectedOutput = "[  ]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest54() 
	{
		
		String input =  "{ apple:1 }, [{ name: owd, inventory:  }]";
		String expectedOutput = "[  ]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------
	// The following are the unitTest cases which should not pass (may contain some syntax errors bacuase of missing/extra brackets'[,],{,}')
	
	@Test
	public void unitTest55() 
	{
		
		String input =  "{ apple: 1 }, [{ name: owd, inventory: { apple: 2 } }]";
		String expectedOutput = "[ { owd: {apple: 2}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest56() 
	{
		
		String input =  "{ Orange: 1 }, [{ name: owd, inventory: { apple: 2 } }]";
		String expectedOutput = "[ { owd: {apple: 1}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}
	
	@Test
	public void unitTest57() 
	{
		
		String input =  "{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 10 }}]";
		String expectedOutput = "[ { dm: {apple: 10}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}

	
	@Test
	public void unitTest58() 
	{
		
		String input =  "{ apple: 1 }, [{ name: owd, inventory: { apple: 0 } }]";
		String expectedOutput = "[ { owd: {apple: 1}}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}	
	
	@Test
	public void unitTest59() 
	{
		
		String input =  "{ apple: 5 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 10 }}]";
		String expectedOutput = "[{ owd: {apple: 3}}, {dm: {apple:2 }}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}	
	
	@Test
	public void unitTest60() 
	{
		
		String input =  "{ apple: 10, orange:10 }, [{ name: owd, inventory: { apple: 5, orange:5 } }, { name: dm, inventory: { apple: 10, orange:10 }}]";
		String expectedOutput = "[{ dm: {apple: 10}}, {dm: {apple: 10 }}]";
		String actualOutput = "";
		
		//call the development function
		InventoryAllocator inventoryallocator  = new InventoryAllocator();
		actualOutput  = InventoryAllocator.checkInputFormat(input);		
		InventoryAllocator.cleanAllStaticVariables();		
		printInputandOutputDetails(input,expectedOutput,actualOutput);
	}		
}
