import java.awt.Color;
import java.awt.Graphics;

public class MyShape extends AbstractShape {
	//Dimensions and location
    private int topLeftX;
    private int topLeftY;
    private int width;
    private int height;

    //Color
    private Color color;

    /**
     * Create an H-Shape of a given width, height, location, color
     * @param topLeftX the x coordinate of the top left of the shape.
     * @param topLeftY the y coordinate of the top left of the shape.
     * @param width   the width of the shape.
     * @param height   the width of the shape.
     */


    public MyShape(int topLeftX, int topLeftY, int width, int height, Color color){
//        System.out.println("new hshape");
        //some parameters, e.g. size, can set number of levels, 7 for example
        maxLevel = 5;
        this.color = color;
        this.width = width;
        this.height = height;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        children = new AbstractShape[8];
    }
    @Override
    public void draw(Graphics g) {
//        System.out.println("draw");

        if(children[0]==null){
            g.setColor(color);
            //bottom of Carpet
            int y1 = topLeftY + 2*(height/3);
            //middle left square
            int y2 = topLeftY + (height/3);
            //middle right square
            int x2 = topLeftX + 2*(width/3);
            int y3 = topLeftY + (height/3);

            //top of Carpet, fill
            g.fillRect(topLeftX,topLeftY,width,height/3);
            //bottom of Carpet, fill
            g.fillRect(topLeftX,y1,width,height/3);
            //middle left square of Carpet, fill
            g.fillRect(topLeftX,y2,(width/3),(height/3));
            //middle right square of Carpet, fill
            g.fillRect(x2,y3,width/3,height/3);
        }
        else{
            for(int i =0; i<children.length; i++){
                if(children[i]!=null){
                    children[i].draw(g);
                }
            }
        }
    }

    @Override
    public void update(int value) {   
    	
    }


    @Override
    public void createChildren() {
        int index =0;

        for(int dx =0; dx<3; dx++){
            for(int dy =0; dy<3; dy++){
                int x = topLeftX + (dx*width/3);
                int y = topLeftY + (dy*height/3);
                if((dx!= 1 || dy!=1)){
                    children[index] = new MyShape(x, y, width/3,height/3, color.darker());
                    children[index].parent = this;
                    children[index].level = level-1;
                    children[index].maxLevel= maxLevel-1;
                    index+=1;
                }
            }
        }
    }
}
