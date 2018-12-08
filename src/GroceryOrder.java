import java.util.ArrayList;

/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018.
 * 
 * @param <Object> - A generic type argument that is replaced with the limit
 * of GroceryItem when GroceryOrder is instantiated with the access to ArrayList
 * methods from Java's util library. 
 * 
 * Generic type argument parameterizes GroceryOrder which limits the
 * data manipulation that can happen while the program evaluates data.
 */
public class GroceryOrder<Object> extends ArrayList<GroceryItem>{	/* hope I did this right*/	}
