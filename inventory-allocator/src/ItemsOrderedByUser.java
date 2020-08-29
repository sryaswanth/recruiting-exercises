/*Comment start
 
 *This class receives user requirements form the Inventory Allocator class, pre-process the data and creates Hash Map for these details
 
 		*Tasks performed in this class include the following:
 
 			*	Split the total user requirement string into separate items 
 			* Create a Hash map to store the user requirement data
comment ends*/

import java.util.HashMap;
import java.util.Iterator;

public class ItemsOrderedByUser extends MainClass
{
	
		String userRequirement;
		
		static int lengthOfUserRequirementString;
		
		static String[] itemsInUserRequirement;
		 
		static  String[] eachItemInRequirement;
		 
		static  String[] itemNameAndCount;
		 
		// Creating a Hash map to store the user requirement data
		static HashMap<String,Integer> userRequirementHashmap=new HashMap<String,Integer>();
	 
		//This function separates each items in User Requirement
		public ItemsOrderedByUser(String userRequirement) 
		{
				this.userRequirement = userRequirement;
				this.userRequirement = this.userRequirement.replaceAll("[\\[{}\\]]", "");   
				
				//split the total user requirement string into separate items 
			     itemsInUserRequirement = this.userRequirement.split(",");
			     lengthOfUserRequirementString = itemsInUserRequirement.length; 
			     eachItemInRequirement = itemsInUserRequirement;	
		}
		
		// This function creates aHah map for each user requirement 
		public static void createHashMapForUserRequirement() 
		{
				// to handle exception if the input values are empty
				if(itemsInUserRequirement[0] != null && itemsInUserRequirement[0].length() > 0) 
				{
					 for(int i =0;i<lengthOfUserRequirementString;i++)
				     {
					    	 itemNameAndCount = eachItemInRequirement[i].split(":");
					    	 userRequirementHashmap.put(itemNameAndCount[0], Integer.parseInt(itemNameAndCount[1]));
				      }
				}
		}
	
}
