/*Comment start
 
 *This class receives user and warehouse requirements form the WarehouseAndInventoryDetails class.
 
 		*Tasks performed in this class include the following:
 		*	check if a warehouse has the user requirements and picks the items
 		* keeps a  track of key's in the HashMap whose values become zero
comment ends*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class WarehouseAndInventorySelectionForDelivery extends MainClass
{
		 static StringBuilder outputStringBuilder = new  StringBuilder();
		 // to track a condition if we do not pick any items from an inventory because of insufficient inventory allocations
		static ArrayList<String> availableWarehouses = new ArrayList<String>();  
	
		// This function checks if a warehouse has the user requirements and picks the items
		public WarehouseAndInventorySelectionForDelivery(HashMap<String, Integer> warehouseDetailsMap,
		HashMap<String, Integer> inputRequirementMap, String warehouseNameToPickOrder) 
		{
			// This hash map is used to store the values that will be appended to the output string
				HashMap<String,Integer> availableItemsHashMap=new HashMap<String,Integer>(); 
				
				availableWarehouses.add(warehouseNameToPickOrder); 
				
				 // to keep track of key's in HashMap whose values become zero
				ArrayList<String> array = new ArrayList<String>();
			
				StringBuilder temporaryOutputString = new  StringBuilder();
					
				if(outputStringBuilder.length() == 0)
				{
					 outputStringBuilder.append("[ ");
				 }
				if( outputStringBuilder.length() != 0)
				{
					temporaryOutputString.append("{ "+warehouseNameToPickOrder+": ");
				}

				// This "for" loop checks if the user Requirements is available in the warehouse. If available, it appends the data to the output String
				for (String name : inputRequirementMap.keySet())  
				{
					 boolean isKeyPresent = warehouseDetailsMap.containsKey(name); 		 
					 if(isKeyPresent)
					 { 
						 if(warehouseDetailsMap.get(name) == 0)
						 {
							 //perform No Actions
						 }
						 
						 else if(warehouseDetailsMap.get(name) >= inputRequirementMap.get(name))
						 {				 
							 if(inputRequirementMap.get(name) - inputRequirementMap.get(name) == 0)
							 {
								 array.add(name);
							 }	 
							 availableItemsHashMap.put(name, inputRequirementMap.get(name));
							 inputRequirementMap.replace(name, inputRequirementMap.get(name) - inputRequirementMap.get(name));			
						 }
						 
						 else if(warehouseDetailsMap.get(name) < inputRequirementMap.get(name))
						 {
								 if(inputRequirementMap.get(name) - warehouseDetailsMap.get(name) == 0)
								 {
									 array.add(name);
								 }
							     availableItemsHashMap.put(name, warehouseDetailsMap.get(name));
							     inputRequirementMap.replace(name, inputRequirementMap.get(name) - warehouseDetailsMap.get(name));					 
						 }								 	 
					 }				 
				}

				if(availableItemsHashMap.size()>0)
				{
					outputStringBuilder.append(temporaryOutputString);
					outputStringBuilder.append(availableItemsHashMap.toString().replace("=", ": "));
					outputStringBuilder.append("},");
				}
							
				for (String name : array)  
				{
					inputRequirementMap.remove(name);
				}			
		} // end of function "WarehouseAndInventorySelectionForDelivery"
		
}// end class
