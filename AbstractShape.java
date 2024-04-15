
import java.awt.Color;

public abstract class AbstractShape implements Shape {
	
	protected int level;
	protected int maxLevel;
	protected AbstractShape[] children;
	protected Color color;
	protected AbstractShape parent;
	
	public AbstractShape() { 
		level = 1;
		
	}
	
	// The fields may be initialized by the AbstractShape constructor with the values
	// received from the super() calls in the constructors of the concrete shape classes.
	// For instance, the SierpinskiTriangle constructor may call the AbstractShape constructor with
	// the a max level value of 10 and a children array length of 3
	// Alternatively the fields may be initialized in the concrete class constructors (they are visible by
	// the concrete classes since they are declared protected)
	
	public boolean addLevel() { 

		// base case (there are no children) 
		// do we create new children? 
		if(children[0] == null) { 
			if(level < maxLevel) { 
				level++;
				createChildren();				
				return true;
			} else { 
				return false;
			}
		} else { 
		// recursion (call addLevel on the children)	
			boolean b = true;
			for(int i = 0; i < children.length; i++) { 
				b = b && children[i].addLevel();

			}
			//System.out.println(level);
			return b;
		}
		
	}
	
	//Removes a level from this shape. Returns true if the operation was successful 
	//or false if the shape was at level 1.
	public boolean removeLevel() {
		//update the level 
		//base case
		if(children[0] != null) {
			if(children[0].children[0] == null) { 
				for(int i = 0; i < children.length; i++) {
					children[i] = null;					
				}
				level--;
				return true;
			} else {
				for(int i = 0; i < children.length; i++) { 
					children[i].removeLevel();
				}
				
				level--;
				return true;
			}					
		}
		return false;
	}

		
	//Returns the total number of shapes of this shape (e.g. 57 for the H shape at level 2).
	public int countShapes() { 
		if(children[0]==null){
	        return 1;
	    }
	    else {
	        return children.length* children[1].countShapes();
	    }
	}

}
