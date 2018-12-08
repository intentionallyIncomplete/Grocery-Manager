/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018.
 * 
 * This class represents and item of type Produce. It extends its parent (super) class GroceryItem
 * which allows for use of the super() to send data. Contains a lot of the same methods as the other
 * two subclasses of GroceryItem.
 */
public class Produce extends GroceryItem{

    /*Data members of the class.*/
    private boolean p_isOrganic;

    /**
     * @param name
     * @param quantity
     * @param price
     * @param isOrganic
     * 
     * Constructor that handles four parameter arguments to be processed by the super
     * class constructor for name,quantity, and price
     */
    public Produce(String name, int quantity, double price, boolean isOrganic){
	super(name,quantity,price);
	this.p_isOrganic = isOrganic;
    }

    /**
     * @param name
     * @param quantity
     */
    public Produce (String name, int quantity){
	super.setName(name);
	super.setQuantity(quantity);
    }
    
    /**
     * @param inputLine
     */
    public Produce (String inputLine){
	// Array to store the data parsed from the text line.
	String[] delimitedOutput;
	// Start from position 1 because position 0 is just the type of item.
	delimitedOutput = inputLine.split(" ");
	// Going in order of TYPE | NAME | QUANTITY | PRICE | IS_ORGANIC
	super.setName(delimitedOutput[1]); // Name
	super.setQuantity(Integer.parseInt(delimitedOutput[2])); // Quantity
	super.setPrice(Double.parseDouble(delimitedOutput[3])); // Price
	this.p_isOrganic = Boolean.parseBoolean(delimitedOutput[4]); // Is it organic?
    }
    
    /**
     * @param organic - A boolean value that holds true when the Produce is organic, otherwise it's false.
     * 
     * Sets the value of 
     */
    public void isOrganic(boolean organic){	this.p_isOrganic = organic;	}
    
    /**
     * @return - Returns a boolean value that is checked against the condition of
     * the inputFile listing the Produce item as "true" for organic.
     */
    public boolean getIsOrganic(){	return this.p_isOrganic;	}
    
    /**
     * @return
     * */
    @Override
    public String toString(){
	return "Item|=" + super.toString() + " Organic: (True|False) " + this.p_isOrganic;
    }
}
