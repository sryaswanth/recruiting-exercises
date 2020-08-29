/*Comment start
 
 *This class receives the input string from Main method method and splits the
 
 		*Tasks performed in this class include the following:
 
 			*	Check the input String format for missing brackets, details.
 			* Split the input into 2 (Map of items that were ordered by the user , Warehouse and Inventory details).
 			* Pass the "Map of items that were ordered by the user" input to the "ItemsOrderedByUser" class and creates Hash map for User Requirements.
 			* Pass the 'Warehouse and Inventory requirements' to "WarehouseAndInventoryDetails" class,  creates Hash map for WarehouseAndInventoryDetails.
 			* Clean some of the static variables used in this program (assign back its default values).
comment ends*/


import java.util.*;  
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InventoryAllocator extends MainClass
{
	
			// variable to store the value of entered userInput 
			static String[] userInput;
			
			// variable to store the value of UserRequirment 
			static String userRequirement;
			
			// variable to store the value of Warehouse and inventory details
			static String inventoryDetails;
			
			// creating an object for 'ItemsOrderedByUser' class
			static ItemsOrderedByUser itemsOrdered = null;
			
			// creating an object for 'WarehouseAndInventoryDetails' class
			static WarehouseAndInventoryDetails warehouseAndInventoryDetails = null;
	
	
	static String checkInputFormat(String inputString)
	{
	
				String OutputString = null;
				boolean inputPattern = Pattern.matches("(^\\s*[{]{1}?\\s*([a-zA-Z]+\\s*[:]{1}\\s*[0-9]+\\s*[,]?\\s*){0,}[}]{1}){1}\\s*[,]+"
																					+ "\\s*[\\[]\\s*([{]{1}?\\s*[a-zA-Z]+\\s*[:]{1}\\s*[a-zA-Z]+\\s*[,]?\\s*[a-zA-Z]+\\s*[:]{1}\\s*([{]{1}?\\s*([a-zA-Z]+\\s*[:]{1}\\s*[0-9]+\\s*[,]?\\s*){0,}[}]{1}){0,}\\s*[}]{1}?\\s*[,]?\\s*)+[\\]]{1}\\s*", inputString);
				
				if(inputPattern == false)
				{
					System.out.println("Please check the input format.");
					System.out.println();
					System.out.println("It needs to be in the format : { Item1: count, Item2: count,... }, [{ name: name_of_the_warehouse, inventory: { Item1: Available_count, Item2: Available_count,... } }, { name: name_of_the_warehouse, inventory: { Item1: Available_count, Item2: Available_count,... } }]");
					System.out.println("Please check for extra/missing brackets '[ { } }' / missing inventory values/ warehousenames ");
					System.out.println();
					OutputString = "Input String Format error. Please check Input.";
				}
				else
				{	
					OutputString = performInputProcessingAndWarehouseSelection(inputString);
				}    
				return OutputString;
	}

	/* This function separates Input 1 and Input 2 from the Input String. Pass theses string values to appropriate classes for
		processing the strings.
	*/
	private static String performInputProcessingAndWarehouseSelection(String inputString) 
	{
			
		
				String outputString = null;
				
				// remove all unwanted spaces in the string
				inputString = inputString.replaceAll("\\s*", "");
				
				 // separate input 1 and input 2
				userInput = inputString.split("}",2); 		
				
				// input 1 - User Requirement
				userRequirement = userInput[0];   	
				itemsOrdered = new ItemsOrderedByUser(userRequirement);  
				ItemsOrderedByUser.createHashMapForUserRequirement();   
				
				//input 2 - Warehouse and Inventory details
				inventoryDetails = userInput[1]; 		
				warehouseAndInventoryDetails = new WarehouseAndInventoryDetails(inventoryDetails);
				WarehouseAndInventoryDetails.calculateTotalNumberOfWarehouses();
				outputString = WarehouseAndInventoryDetails.separateEachWarehousesDetails();
				
				return outputString;
		
	}

	// This function cleans and resets all static variables after getting the output
	public static void cleanAllStaticVariables() 
	{
				WarehouseAndInventoryDetails.numberOfWarehouses = 0;
				WarehouseAndInventoryDetails.outputString = null;
				WarehouseAndInventorySelectionForDelivery.outputStringBuilder.setLength(0);
	}
	
}
