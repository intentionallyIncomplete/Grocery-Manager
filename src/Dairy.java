/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018.
 * 
 * This is a dairy object that is a subclass of GroceryItem. This relationship represents a "has a" situation in which
 * a Dairy item "has a" name and "has a" price.
 */
public class Dairy extends GroceryItem{

    /*Data member(s) for this class.*/
    private int f_Temp;

    /**
     * @param name - A String value for the name of the Dairy item.
     * @param quantity - An integer value for the current quantity of the Dairy item.
     * @param price - A double value for the price of the Dairy item.
     * @param refrigerationTemperature - An integer value of the temperature to keep the Dairy item chilled to.
     * 
     * Constructor that takes four parameter arguments and sends the name,quantity,
     * and price to the super class.
     */
    public Dairy(String name, int quantity, double price, int refrigerationTemperature){
	super(name,quantity,price);
	this.f_Temp = this.setRefrigerationTemperature(refrigerationTemperature);
    }

    /**
     * @param name - 
     * @param quantity - 
     * 
     * Constructor that takes in two parameter arguments for only the name
     * and the quantity of some Dairy item.
     */
    public Dairy(String name, int quantity){
	super.setName(name); // Send name to super
	super.setQuantity(quantity);
    }

    /**
     * @param inputLine - An entire line from the groceryInventory.txt file. 
     * 
     * As the data is split on each delimiter in GroceryManager.java the
     * contents are parsed in the same sequence they're received.
     */
    public Dairy(String inputLine){
	// Array to store the data parsed from the text line.
	String[] delimitedOutput;
	// Start from position 1 because position 0 is just the type of item.
	delimitedOutput = inputLine.split(" ");
	// Going in order of TYPE | NAME | QUANTITY | PRICE | REFRIGERATION TEMP
	super.setName(delimitedOutput[1]); // Name
	super.setQuantity(Integer.parseInt(delimitedOutput[2])); // Quantity
	super.setPrice(Double.parseDouble(delimitedOutput[3])); // Price
	this.f_Temp = Integer.parseInt(delimitedOutput[4]); // Refrigeration Temp
    }

    /**
     * @param c_Temp
     * @return - Returns the integer value of the temperature of refrigeration for
     * the Dairy item passed in by the 4 argument overloaded constructor.
     */
    public int setRefrigerationTemperature(int c_Temp){
	if(c_Temp > 42){ // I used to be a chef @TheCheeseCake Factory and the temp to chill was always 42 from <= 32.
	    System.out.println("The tempurature is a bit warm for a Dairy product. Set it lower than 32 deg Fareinhight");
	    return -1;
	}else{
	    this.f_Temp = c_Temp;
	    return 1;
	}
    }

    /**
     * @return - Returns the integer value of the temperature at which this Dairy item was set to be chilled at/to.
     */
    public int getRefrigerationTemperature(){	return this.f_Temp;	}

    /**
     * @return
     * */
    @Override
    public String toString(){
	return "Item| " + super.toString() + " and should be stored at " + this.f_Temp + " to preserve.";
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {}
}
