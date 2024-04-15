import java.awt.Graphics;
import java.awt.*;

public class HShape extends AbstractShape {
	
	protected int baseX;
	protected int baseY;
	protected int width;
	protected int height;
	
	
	public HShape(int baseX, int baseY,int width, int height, Color color) {
		maxLevel = 6;
		this.color = color;
		this.width = width;
		this.height = height;
		this.baseX = baseX;
		this.baseY = baseY;
		children = new AbstractShape[7];

		}

	// Draws this shape
	public void draw(Graphics g) {
		
		if(children[0] == null) { 
			g.setColor(color);
			
			int x = baseX + 2*(width/3);
			int y = baseX + (width/3);
			int z = baseY + (height/3);

			//left
			g.fillRect(baseX, baseY, (width/3), height);
			
			//right 
			g.fillRect(x,baseY, width/3, height);
			
			// middle
			g.fillRect(y,z,width/3,height/3);
		}
		else { 
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
		int index = 0;
		
		for(int i = 0; i < 3; i++) { 
			for(int j = 0; j < 3; j++) { 
				int x = baseX + (i*width/3);
				int y = baseY + (j * height/3);
				if(i != 1 || j == 1) { 
					children[index] = new HShape(x,y,width/3, height/3, Color.BLUE);
					children[index].parent = this;
					children[index].level = level - 1;
					children[index].maxLevel = maxLevel - 1;
					index += 1;					
				}
			}		
		}
	}	
}
