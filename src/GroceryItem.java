/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018
 * 
 * An abstract class that contains methods which only allow for
 * abstract data insertion. All methods are inherited by the subclasses
 * that extend GroceryItem.
 * 
 * Note: All data types declared begin with "g" followed by an underscore ("g_") to
 * mark these are all generic in their use here.
 */
public abstract class GroceryItem implements Comparable<GroceryItem>{
    
    /*Data members for the class.*/
    private String g_Name;
    private int g_Quantity;
    private double g_Price;

    /*	Public methods	*/
    
    /**
     * @param name - First data item in the inventory text file. Represents Object's name.
     * @param quantity - Total stock availability of the item.
     * @param price - The price of the individual item to resell.
     * 
     * Constructor that takes in 3 parameters to instantiate an Object
     * of type Dairy that "has a" name, quantity, and price.
     * 
     * All handed data is evaluated through the set___() methods for error checking.
     */
    public GroceryItem(String name, int quantity, double price){
	this.g_Name = this.setName(name);
	this.g_Quantity = setQuantity(quantity);
	this.g_Price = setPrice(price);
    }
    
    /**
     * Constructor takes no arguments and overrides the use of the default, no argument constructor.
     */
    public GroceryItem(){} // Not sure what to do here just yet.
    
    /*Setters for private data*/
    /** 
     * @param c_Name - A name handed to this method by the constructor.
     * @return - Returns the name of the item from the handed data as long as it's valid.
     * 
     * Attempts to set this classes name value to the one handed in through constructor.
     * */
    public String setName(String c_Name){
	try{
	    this.g_Name = c_Name;
	}catch(GroceryException ge){
	    throw new GroceryException("Could not set name of item",ge);
	}
	return g_Name;
    }
    
    /**
     * @param c_Quantity - A quantity that is the stock availability of an item.
     * @return - Returns the integer value that was assigned to the value "g_Quantity"
     * 
     * Takes in quantity, represented by an integer, from the constructor and attempts to
     * assign it to the local class variable.
     */
    public int setQuantity(int c_Quantity){
	try{
	    this.g_Quantity = c_Quantity;
	}catch(GroceryException ge){
	    throw new GroceryException("Could not set quantity of item",ge);
	}
	return g_Quantity;
    }
    
    /**
     * @param c_Price - A price represented as a double.
     * @return - Returns the value of the local variable g_Price.
     * 
     * Attempts to assign the local value of g_Price to the handed value,
     * from the constructor, of c_Price.
     */
    public double setPrice(double c_Price){
	try{
	    this.g_Price = c_Price;
	}catch(GroceryException ge){
	    throw new GroceryException("Could not set price of item",ge);
	}
	return g_Price;
    }
    
    /*Methods that require overriding.*/
    /**
     * @return - Returns a formatted String value of the GroceryItem in immediate memory.
     * */
    @Override
    public String toString(){
	// https://dzone.com/articles/java-string-format-examples
	// In order of formatting:
	// |%-16s| --> sets left justification and length of each String set to maximum of 16 characters
	// which is +1 character more than the longest String in the List.
	// Quantity is adjusted with a 5 space left-padding and Price is formatted to a 2-point floating decimal.
	// Price has the same left padding as Quantity.
	return String.format(" Name = %-16s||Quantity: %-5d||Price %-5.2f|", this.getName(), this.getQuantity(), this.getPrice());
    }
    
    /**
     * @return - Returns an integer value of -1, 0, or 1 for less than, equal to, or greater than. This is a comparative
     * value that's calculated using the Comparable interface which checks the String values' against each other lexicographically.
     */
    @Override
    public int compareTo(GroceryItem other){
	return this.getName().compareToIgnoreCase(other.getName());
    }
    
    /*Getters for private data*/
    /**	@return - Returns String value of the specified Object's name.	*/
    public String getName(){	return this.g_Name;	}
    
    /**	@return - Returns integer value of current stock availability of the item.	*/
    public int getQuantity(){	return this.g_Quantity;	}
    
    /** @return - Returns the value, as a double, of the price for any item.	*/
    public double getPrice(){	return this.g_Price;	}
}
