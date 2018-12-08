/**
 * Class Description:
 * @author Ian Bryan
 * @version Dec 7th, 2018.
 * 
 * Generic type argument parameterizes GroceryOrder which extends GroceryItem. 
 * Helps limit the scope to only these objects (dairy, produce, meat).
 */
public class GroceryOrder<Object extends GroceryItem>{	}
