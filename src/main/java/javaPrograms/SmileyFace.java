package javaPrograms;

/* @author - Anirudh Marpally */

/*
* Name  : Anirudh Marpally
* Student Id : 999902489
* Course Name : Advanced Programming Concepts
* Section : MCIS-5103-033222S
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Anirudh Marpally
 *
 *This code creates a JPanel with a MouseMotionListener to track the position of the mouse
 * cursor. In the paintComponent method, it draws a yellow oval for the face, 
 * two black ovals for the eyes, and a black arc for the mouth. 
 * The position of the pupils in the eyes is calculated based on the position of the mouse
 * cursor relative to the center of each eye. The drawEye method is used to draw each eye,
 * taking in the Graphics2D object, the x and y position of the eye, 
 * and the size of the eye. It calculates the position of the pupil.
 *   
 */
public class SmileyFace extends JPanel implements MouseMotionListener {

    private int mouseX, mouseY;

    public SmileyFace() {
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(300, 300));
    }

    /**
     * @method - method to draw the smiley face and paint it
     * @param - Graphics g
     * @return - do not return anything.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        // set background color
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        
        // draw face
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(50, 50, 200, 200);
        
        // draw eyes
        int eyeX = 0;
        int eyeY = 0;
        int eyeSize = 40;
        
        //drawing the left eye
        eyeX = 100;
        eyeY = 100;
        drawEye(g2d, eyeX, eyeY, eyeSize);
        
        //drawing the right eye
        eyeX = 170;
        eyeY = 100;
        drawEye(g2d, eyeX, eyeY, eyeSize);
        
        // drawing the mouth
        g2d.setColor(Color.BLACK);
        g2d.drawArc(75, 125, 150, 100, 180, 180);
    }
    
    // class for drawing the eye of the smiley face
    /*
     * @method - class for drawing the eye of the smiley face
     * @param - g2d, eyeX, eyeY, eyeSize
     * @return - do not return anything.
     */
    private void drawEye(Graphics2D g2d, int eyeX, int eyeY, int eyeSize) {
    	//setting the pupil size
        int pupilSize = 25;
        
        // calculate position of pupil
        int deltaX = mouseX - eyeX;
        int deltaY = mouseY - eyeY;
        double angle = Math.atan2(deltaY, deltaX);
        int pupilX = (int) (eyeX + Math.cos(angle) * (eyeSize -eyeSize/2  ));
        int pupilY = (int) (eyeY + Math.sin(angle) * (eyeSize - eyeSize/2));
        
        // paint eye
        g2d.setColor(Color.WHITE);
        g2d.fillOval(eyeX, eyeY, eyeSize, eyeSize);
        
        // paint pupil
        g2d.setColor(Color.BLACK);
        g2d.fillOval(pupilX, pupilY, pupilSize, pupilSize);
    }

    
    /*
     * @method - public class for mouse movement
     * @param - MouseEvent e
     * @return - do not return anything.
     */
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {}

    /**
     * @author Anirudh Marpally
     * @method - main method to draw the smiley face
     * @param args
     */
    public static void main(String[] args) {
    	
    	//setting the Jframe to draw the smiley face
        JFrame frame = new JFrame("Smiley Face");
        
        //frame exit button on click
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //adding the smiley face to the frame
        frame.getContentPane().add(new SmileyFace());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
