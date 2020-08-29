/*Comment start
 
 *This class receives warehouse details and its Inventory items availability form the Inventory Allocator class, pre-process the data and creates Hash Map for these details
 
 		*Tasks performed in this class include the following:
 
 			* Calculates the total number of warehouses in the input string.
 			* Separates warehouse and inventory details and passes the details to "WarehouseAndInventorySelectionForDelivery" class to select the user requirements.
 			*  Handles exceptions if there is no inventory data in the input string
 			*  Checks if all the User Requirements for items are available across the warehouses
comment ends*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.*;  

public class WarehouseAndInventoryDetails extends MainClass
{
	
	static String listOfWarehouseNameAndInventoryAmounts;	
	static int lengthOfList = 0;
//	String warehouses_and_inventories = null;
	static int numberOfWarehouses =0;
	static String outputString=  null;
	
	// variable to store the value of input 2 based on warehouses
	static String[] eachWarehouseAsAString;	
	static int numberOfItemsInEachInventory;
	static String[] itemInTheInventory;
	 
	// this variable is used to split the item and the count
	static  String[] additionalVariavleForTheItemInInventory; 
	static  String[] itemAndCountInInventory;
	 	
	static WarehouseAndInventorySelectionForDelivery warehouseSelection;
		 
	//constructor.
	public WarehouseAndInventoryDetails(String listOfWarehouseNameAndInventoryAmounts) 
	{
		this.listOfWarehouseNameAndInventoryAmounts = listOfWarehouseNameAndInventoryAmounts;
		lengthOfList = this.listOfWarehouseNameAndInventoryAmounts.length();
	}

	// This function calculates the total number of warehouses in the input string.
	public static void calculateTotalNumberOfWarehouses() 
	{
	     for (int i = 1; i < lengthOfList; i++)
		 {
			 if(listOfWarehouseNameAndInventoryAmounts.charAt(i-1) == listOfWarehouseNameAndInventoryAmounts.charAt(i) && listOfWarehouseNameAndInventoryAmounts.charAt(i) == '}')
			 {
				 numberOfWarehouses++;
			 }
		 } 	
	}
	
	// This function separates warehouse and inventory details and passes the details to "WarehouseAndInventorySelectionForDelivery" class to select the user requirements.
	public static String separateEachWarehousesDetails() 
	{	
		for(int i=0;i<numberOfWarehouses;i++)
	     {
			
				// Creating a hash map to store the Inventory items and its count for a particular warehouse
					HashMap<String,Integer> inventoryItemsAndCountHashMap=new HashMap<String,Integer>();
				
				// separating the list based on Warehouses
		    	 eachWarehouseAsAString = listOfWarehouseNameAndInventoryAmounts.split("}}");  
		    	 eachWarehouseAsAString[i] = eachWarehouseAsAString[i].replaceAll("[\\[{}\\]]", "") ; 
		    	 eachWarehouseAsAString[i] = eachWarehouseAsAString[i].substring(1, eachWarehouseAsAString[i].length());
	
		    	 String temporaryStringForManipulation = eachWarehouseAsAString[i];
		    	 
		    	//array which contains separated warehouse name and inventory details.
		    	String warehouseNameAndInventorySeparated [];
		    		    	
		    	//string to store warehouse name
		    	String warehouseName;
		    	
		    	//string to store the inventory items for a particular warehouse
		    	String itemsInInventory ;
		    	
		    	 warehouseNameAndInventorySeparated = temporaryStringForManipulation.split(",",2);    	 
		    	 warehouseName = warehouseNameAndInventorySeparated[0];    	 
   		    	 warehouseName =  warehouseName.substring(warehouseName.indexOf(":")+1, warehouseName.length()) ;	 
		    	 itemsInInventory = warehouseNameAndInventorySeparated[1];
		    	 
		    	 // remove the inventory tag from the string
		    	 itemsInInventory = itemsInInventory.substring(itemsInInventory.indexOf(":",1)+1);
		    	
		    	 //	This if loop is used to create Hash map for Inventory items in a warehouse
		    	 if(!itemsInInventory.isEmpty())// if loop for exception handling
		    	 {	    	  
				    	//splitting input 1 values (to individual key pair value) 
					     itemInTheInventory = itemsInInventory.split(",");
		
					     numberOfItemsInEachInventory = itemInTheInventory.length;
					     
					     additionalVariavleForTheItemInInventory = itemInTheInventory;
					     
					     for(int j=0;j<numberOfItemsInEachInventory;j++)
					     {
					    	 itemAndCountInInventory = additionalVariavleForTheItemInInventory[j].split(":");
					    	 
					    	 // if else to check if same item is entered twice in the input string for a particular inventory
					    	 if(!inventoryItemsAndCountHashMap.containsKey(itemAndCountInInventory[0]))
					    	 {
					    		 inventoryItemsAndCountHashMap.put(itemAndCountInInventory[0], Integer.parseInt(itemAndCountInInventory[1]));
					    	 }
					    	 else if(inventoryItemsAndCountHashMap.containsKey(itemAndCountInInventory[0]))
					    	 {
					    		 inventoryItemsAndCountHashMap.replace(itemAndCountInInventory[0], inventoryItemsAndCountHashMap.get(itemAndCountInInventory[0])+Integer.parseInt(itemAndCountInInventory[1]));
					    	 }
					    
					      }
						warehouseSelection = new WarehouseAndInventorySelectionForDelivery(inventoryItemsAndCountHashMap, ItemsOrderedByUser.userRequirementHashmap, warehouseName);
		    	
		    	 } 
		
	     }  // end of for loop - seperate_each_warehouses
				
		// This condition handles exceptions if there is no inventory data in the input string
		if(WarehouseAndInventorySelectionForDelivery.outputStringBuilder.length() > 0)  
		{
			WarehouseAndInventorySelectionForDelivery.outputStringBuilder.setLength(WarehouseAndInventorySelectionForDelivery.outputStringBuilder.length()-1);
		}
		if(WarehouseAndInventorySelectionForDelivery.outputStringBuilder.length() == 0)
		{
			WarehouseAndInventorySelectionForDelivery.outputStringBuilder.append("[");
		}			 
		WarehouseAndInventorySelectionForDelivery.outputStringBuilder.append("]");
		outputString = WarehouseAndInventorySelectionForDelivery.outputStringBuilder.toString();	
		outputString = checkIfAllUserRequirementsAreShipped(ItemsOrderedByUser.userRequirementHashmap);	
		return outputString;
	} 
	
	// This function checks if all the User Requirements for items are available across the warehouses
	public static String  checkIfAllUserRequirementsAreShipped(HashMap<String, Integer> userRequirementMap)
	{
		ArrayList<String> array = new ArrayList<String>(); 
		
		for (String name : userRequirementMap.keySet())  
		{
			 if(userRequirementMap.get(name) > 0)
			 {
				 array.add(name);
			 }
		}
		
		// loop to remove allocated items form the output string due to insufficient allocations
		for (String name : array)  
		{	
			// scenarios where we should remove the data if Not enough inventories are available
			if(outputString.contains(name))
			{
				outputString = outputString.replaceAll(name+":"+" \\d"+",", ""); 
				outputString = outputString.replaceAll(name+":"+" \\d", "");		
			}		
		}
		
		// loop to remove empty warehouse names form the output string due to insufficient allocations
		for (String warehouses : WarehouseAndInventorySelectionForDelivery.availableWarehouses)
		{
			if(outputString.contains(warehouses))
			{
				outputString = outputString.replaceAll(warehouses+":"+" "+"\\{"+"\\s*"+"\\}", "");
				outputString = outputString.replaceAll("\\{"+" "+"\\}"+",", "");
				outputString = outputString.replaceAll(","+"\\{"+" "+"\\}", "");			
				outputString = outputString.replaceAll(","+"\\s*"+"}", "}");		
			}
		}
	
		if(outputString.contains("{ }"))
		{
			outputString = "[ ]";
		}
		return outputString;		
	}
} // end class


