package javaPrograms;

//

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

/**
 * The program creates a SierpinskiTriangle class that extends the Canvas class.
 * The program specifies the width and height of the canvas as constants, 
 * As well as the triangle vertices and the starting point.
 * 
 * @author Anirudh Marpally
 *
 */
public class SierpinskiTriangle extends Canvas {

	// Setting the canvas width and height
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    
    // Maximum number of times to repeat the loop
    private static final int MAX_ITERATIONS = 50000;
    
    //Set the Constants for the triangle vertices for first point - 1
    private static final int X1 = 512;
    private static final int Y1 = 109;
    //Set the Constants for the triangle vertices for second point
    private static final int X2 = 146;
    private static final int Y2 = 654;
    //Set the Constants for the triangle vertices for third point
    private static final int X3 = 876;
    private static final int Y3 = 654;
    
    // Constants for the starting point
    private static final int START_X = 512;
    private static final int START_Y = 382;

    /**
     * This method finds the distance between the points 
     * and vertex for the point to be printed
     * by going through 'for' loop for the given iterations
     * 
     * @author Anirudh Marpally
     * 
     * @param g
     * @return null
     */
    public void paint(Graphics g) {
    	
        // Set the points printed to be black in color
        g.setColor(Color.black);
        
        // Set the starting point to the constant values
        int x = START_X;
        int y = START_Y;
        
        // Loop for MAX_ITERATIONS times
        for (int i = 0; i < MAX_ITERATIONS; i++) {
        	
            // Drawing the current point
            g.drawLine(x, y, x, y);
            
            // Delay for a bit (Although it's optional)
            try {
                Thread.sleep((long) 0.9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Choosing a random number from 1 to 3
            int r = new Random().nextInt(3) + 1;
            int dx, dy;
            // Finding the distance between the current point and the chosen vertex
            switch (r) {
            case 1:
                dx = x - X1;
                dy = y - Y1;
                break;
            case 2:
                dx = x - X2;
                dy = y - Y2;
                break;
            default:
                dx = x - X3;
                dy = y - Y3;
                break;
            }
            // Move the current point halfway to the chosen vertex
            x -= dx / 2;
            y -= dy / 2;
        }
        
        // Draw the string "Sierpinski Triangle"
        g.drawString("Sierpinski Triangle", 462, 484);
    }

    /**
     * 
     * The main method simply creates a new SierpinskiTriangle object to start the program.
     * 
     * @author Anirudh Marpally
     * 
     * @param args
     * @return null
     */
    public static void main(String[] args) {
    	
        // Create a new SierpinskiTriangle object
        SierpinskiTriangle triangle = new SierpinskiTriangle();
                
        // Create a new frame to hold the canvas and add the canvas to it
        Frame frame = new Frame("Sierpinski Triangle");
        
        //Adding the object to frame
        frame.add(triangle);
        frame.pack();
        
        // Set the frame size, make it visible
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
    }
}