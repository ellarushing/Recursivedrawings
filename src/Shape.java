
import java.awt.Graphics;

public interface Shape {
	// Draws this shape
	void draw(Graphics g);
	
	//Adds a level to this shape. Returns true if the operation was successful 
	//or false if the maximum level has been reached.
	boolean addLevel();
	
	//Removes a level from this shape. Returns true if the operation was successful 
	//or false if the shape was at level 1.
	boolean removeLevel();
	
	//Returns the total number of shapes of this shape (e.g. 57 for the H shape at level 2).
	int countShapes();
	
	//Modifies this shape in an interesting way given a value in the range 0-100. 
	//This method is only required for the extra-credit part.
	void update(int value);
	
	// Creates children for the shape
	void createChildren();
	

}
