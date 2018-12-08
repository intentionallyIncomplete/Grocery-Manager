/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018.
 * 
 * This class represents and item of type Meat. It extends its parent (super) class GroceryItem
 * which allows for use of the super() to send data. Contains a lot of the same methods as the other
 * two subclasses of GroceryItem.
 */
public class Meat extends GroceryItem{

    /*Class data members*/
    private boolean m_isGround;

    /**
     * @param name - 
     * @param quantity - 
     * @param price - 
     * @param isGround - 
     * */
    public Meat(String name, int quantity, double price, boolean isGround){
	super(name, quantity, price);
	this.m_isGround = this.isGround(isGround);
    }

    /**
     * @param name - 
     * @param quantity - 
     * */
    public Meat (String name, int quantity){
	super.setName(name);
	super.setQuantity(quantity);
    }

    /**
     * @param inputLine
     */
    public Meat(String inputLine){
	// Array to store the data parsed from the text line.
	String[] delimitedOutput;
	// Start from position 1 because position 0 is just the type of item.
	delimitedOutput = inputLine.split(" ");
	// Going in order of TYPE | NAME | QUANTITY | PRICE | IS_GROUND
	super.setName(delimitedOutput[1]); // Name
	super.setQuantity(Integer.parseInt(delimitedOutput[2])); // Quantity
	super.setPrice(Double.parseDouble(delimitedOutput[3])); // Price
	this.m_isGround = Boolean.parseBoolean(delimitedOutput[4]); // Is it ground?
    }
    
    /**
     * @param c_Ground - A boolean value that holds a value of true or false. Is determined by value of boolean
     * handed to constructor.
     * @return - Returns the condition that was specified by the constructor's boolean paramter.
     */
    public boolean isGround(boolean c_Ground){
	this.m_isGround = c_Ground;
	return c_Ground;
    }

    /**
     * @return - Returns the value of whether the meat is ground or is not ground. (specified in text file).
     */
    public boolean getIsGround(){	return this.m_isGround;	}
    
    /**
     * @return
     * */
    @Override
    public String toString(){
	return "Item| " + super.toString() + ". Is the meat ground? (true|false) " + this.m_isGround;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {}

}