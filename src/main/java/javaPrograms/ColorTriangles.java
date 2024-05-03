package javaPrograms;

//

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Random;

/**
 * This program creates a RandomTriangles object, 
 * which extends JPanel to display the triangles on the screen. 
 * It also creates a JFrame to hold the RandomTriangles object.
 * 
 * @author Anirudh Marpally
 *
 */
public class ColorTriangles extends JFrame {
  
    /**
     * This ColorTriangles method prints some random 500 color triangles
     * 
     * @author Anirudh Marpally
     * @return null
     */
	public ColorTriangles() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The paintComponent method is called each time the panel needs to be repainted. 
     * It loops 500 times, choosing a random color and random vertices for each triangle. 
     * It then draws the triangle using the fillPolygon method.
     * 
     * @author Anirudh Marpally
     * 
     * @param g
     * @return null
     */
    public void paint(Graphics g) {
        for (int i = 0; i < 500; i++) {
            Random rand = new Random();
            
            //declare color variables
            int r = rand.nextInt(256);
            int gg = rand.nextInt(256);
            int b = rand.nextInt(256);
            //create new color with random values
            Color color = new Color(r, gg, b);
            //set the color to the randomColor
            g.setColor(color);
            
            //generate random value for x1
            int x1 = rand.nextInt(getWidth());
            int y1 = rand.nextInt(getHeight());
            int x2 = rand.nextInt(getWidth());
            int y2 = rand.nextInt(getHeight());
            int x3 = rand.nextInt(getWidth());
            int y3 = rand.nextInt(getHeight());
            //draw the triangle with vertices x1,y1, x2,y2, x3,y3
            g.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        }
    }
    
    /**
     * The main method simply creates a new ColorTriangles object to start the program.
     * 
     * @author Anirudh Marpally
     * 
     * @param args
     * @return null
     */
    public static void main(String[] args) {
        ColorTriangles colorTriangles = new ColorTriangles();
       
    }
}