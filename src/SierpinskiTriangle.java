import java.awt.Color;
import java.awt.Graphics;

public class SierpinskiTriangle extends AbstractShape {
	
	
	protected int x1;
	protected int x2;
	protected int x3;
	
	protected int y1;
	protected int y2;
	protected int y3;
	
	
	public SierpinskiTriangle( int x1, int x2, int x3, int y1, int y2, int y3, Color color) { 
		maxLevel = 10;
		children = new AbstractShape[3];
		this.color = color;
		
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;

	}

	// Draws this shape
	public void draw(Graphics g) {
		
		if(children[0] == null) { 
			g.setColor(color);
			
			int[] x = {x1, x2, x3};
			int[] y = {y1, y2, y3};
			
			g.drawPolygon(x,y,3);
			
		} else { 
			for(int i = 0; i < children.length; i++) { 
				if(children[i] != null) { 
					children[i].draw(g);
				}
			}			
		}
	}

	//Modifies this shape in an interesting way given a value in the range 0-100. 
	//This method is only required for the extra-credit part.
	public void update(int value) {
	}
	
	@Override
	public void createChildren() {
		int x12 = (x1+x2)/2;
		int x23 = (x2+x3)/2;
		int x13 = (x1+x3)/2;
		int y12 = (y1+y2)/2;
		int y23 = (y2+y3)/2;
		int y13 = (y1+y3)/2;

		children[0] = new SierpinskiTriangle(x1,x12,x13,y1, y12, y13,color.darker());
		children[1] = new SierpinskiTriangle(x2,x12,x23,y2, y12, y23, color.darker());
		children[2] = new SierpinskiTriangle(x3,x13,x23,y3, y13, y23,color.darker());

		for(int i=0; i<3; i++){
			children[i].parent = this;
			children[i].level = level - 1;
			children[i].maxLevel = maxLevel - 1;
		}
	}
}
