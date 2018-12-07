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
 * 
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
	/*Variable naming reference*/
	/*
	 * input = Scanner object
	 * qline = next "queried" line of data from Scanner object
	 * qparts = an array of Strings with the first item always the Item Type, then
	 * */
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
		    inventory.add(new Dairy(line));
		    System.out.println("Added Dairy Items");
		} else if (i<= (nProduce + nDairy)) {
		    inventory.add(new Produce(line));
		    System.out.println("Added Produce Items");
		} else {
		    inventory.add(new Meat(line));
		    System.out.println("Added Meat Items");
		}
	    }
	} catch (Exception e) {
	    System.out.println(e);
	} finally {
	    input.close();
	}
    }


}
