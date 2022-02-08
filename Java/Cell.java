import java.awt.Graphics2D;
import java.awt.Color;

public class Cell {
    private int x,y;                //object coordinate
    private int size;               //object size in px
    private Color color;            //object color
    
    public Cell(int x, int y, int size, Color color) {
        set(x,y);                   //init coordinate
        this.size = size;           //init size
        this.color = color;         //init color
    }
    
    public void set(int x,int y) {  //set coordinates
        this.x = x;
        this.y = y;
    }
    
    public int getX() {  // get the X coordinate
        return x;
    }
    
    public int getY() { //get the Y coordinate
        return y;
    }
    
    public void paint(Graphics2D g) {  //object rendering
        g.setColor(color);
        g.fillOval(x * size, y * size, //upper left corner
                size, size); //width and height
    }
}