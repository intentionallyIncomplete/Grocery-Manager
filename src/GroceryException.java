/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018
 * 
 * A custom exception that may be thrown during runtime where errors occur and result in an exception of some kind.
 */
public class GroceryException extends RuntimeException{
    
    /**
     * @param messageOut - A String that holds the data from the try-catch clause in another class.
     * @param errorThrown - Represents an error that happened during runtime that is thrown.
     * 
     * Constructor that takes in two parameter arguments for a message and the throwable
     * type from the runtime error.
     * */
    public GroceryException(String messageOut, Throwable errorThrown){
	// Send data immediately to the parent class (Exception).
	super(messageOut,errorThrown);
    }
}
