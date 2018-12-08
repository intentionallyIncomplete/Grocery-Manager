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
     * @param order - 
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
