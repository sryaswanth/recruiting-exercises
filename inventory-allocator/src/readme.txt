This src folder contains Source Code for the Inventory Allocator Program.

This inventory allocator program can be verified by executing the jar file in the Demo folder.

This program determines the most cost effective shipment for an inventory distribution.

Unit Testing:
  This program has been tested with pre made unit test cases and assertions. (JUnit)

Edge Case Handling:

1) If an inventory is left empty in the string, then it is ocnsidered an empty inventory.
    Example: { apple:1 }, [{ name: owd, inventory:  }]
             { apple:1 }, [{ name: owd, inventory: { } }]
             
2) If user input is empty, then output returns an empty list.
    Example: {  }, [{ name: owd, inventory: { apple: 1 } }]
    output : []
    
 
For more information about the source code, please refer the Source code information documentation file.
  
 

