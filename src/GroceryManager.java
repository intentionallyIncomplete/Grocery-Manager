import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018
 * 
 * This class is instantiated from the Driver class and is used to populate the inventory
 * of Dairy, Produce, and Meat objects in the virtual store.
 */
public class GroceryManager {
    /*	Data items for the class.	*/
    /**
     * A List of Objects of type GroceryItem to maintain
     * the virtual store's current stock count.
     */
    ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();
    /**
     * A list of items by their String values sorted using HashSet
     * built in library tools.
     */
    HashSet<String> reorderList = new HashSet<String>();

    /**
     * @throws FileNotFoundException - throws an exception on the condition the file is not
     * able to be located.
     * 
     * readInventory() populates the virtual store with items from the
     * groceryInventory.txt file.
     */
    public void readInventory() throws FileNotFoundException {
	Scanner input = null;
	try {
	    input = new Scanner(new FileInputStream("groceryInventory.txt"));
	    String qline = input.nextLine();
	    String[] qparts = qline.split(" ");
	    int nDairy = Integer.parseInt(qparts[0]);
	    int nProduce = Integer.parseInt(qparts[1]);

	    int i = 0;

	    while (input.hasNext()) {
		String line = input.nextLine();
		i++;
		if (i <= nDairy) {
		    assert(line!=null);
		    inventory.add(new Dairy(line));
		    //System.out.println("Added Dairy Items");
		} else if (i<= (nProduce + nDairy)) {
		    assert(line!=null);
		    inventory.add(new Produce(line));
		    //System.out.println("Added Produce Items");
		} else {
		    assert(line!=null);
		    inventory.add(new Meat(line));
		    //System.out.println("Added Meat Items");
		}
	    }
	} catch (Exception e) {
	    System.out.println(e);
	} finally {
	    input.close();
	}
    }

    /**
     * @param order - Represents the data from a few lines read in from the groceryOrders.txt
     * file in Driver.java. 
     * 
     * Subtracts the items and quantities in the order from the inventory
     * If 0 inventory hit, add to reorder list.
     * If the quantity ordered is greater than the quantity in inventory, 
     * error thrown with message “out of item_name” (continues).
     */
    public void processOrder(GroceryOrder order){
	// Find the item in the list

    }

    /**
     * @param name
     * @return
     */
    public GroceryItem findItemByName(String name){


	return null;
    }

    /**
     * Uses selection sort method to organize the List of items by their String values
     * (lexicographically evaluated) by compareTo() method.
     */
    public void sortByName(){

    }

    /**
     * @see http://bit.ly/2G3pDhG
     * @see http://bit.ly/2G4Oulh
     * @see http://bit.ly/2G3PyGc
     * @see Lab_9 assignment.
     * 
     * This method utilizes the properties of BubbleSort (O(n^2)) to
     * check one price against its next immediate neighbor in the List.
     * 
     * Under the condition that Max > Max +1, then swap the values until
     * the condition is no longer satisfied.
     */
    public void sortByPrice(){
	// The outer loop moves over 1 item every List size number of iterations
	for(int i=0;i<inventory.size()-1;i++){
	    // The inner loop checks value at some index 'j' against
	    // its neighbor 'j+1'.
	    for(int j=0;j<inventory.size()-i-1;j++){
		// If the value at 'j' is > (greater than) its neighbor then initiate the swapping.
		if(inventory.get(j).getPrice() > inventory.get(j+1).getPrice()){
		    // Retain value of Object at position 'j' because it will be replaced when using set(e)
		    GroceryItem item = inventory.get(j);
		    // Replace Object at 'j', at position 'j', with the value of Object at position of 'j+1'
		    inventory.set(j, inventory.get(j+1));
		    // Finally, set - at position of the neighbor's last position, the value of the retained Object.
		    inventory.set(j+1,item); // Item should always be greater than Object at position 'j'.
		}
	    }
	}
    }

    /**
     * @return - Returns a compiled String of items that make-up the List 
     * of items who's inventory is 0 or the item requested was GT the amount available
     * and the quantity was set to 0, and the item added to the 
     */
    public String getReorderList(){
	String retVal = " ";
	for(String item : reorderList){
	    retVal = "Item ran out of stock: " + item;
	}
	return retVal;
    }

    /**
     * Uses a simple for-each loop and calls the super class toString method
     * (stored in GroceryItem) that will print the contents of each List item
     * to the console.
     */
    public void displayInventory(){
	for(GroceryItem gi : inventory){
	    System.out.println(gi.toString());
	}
    }
}
