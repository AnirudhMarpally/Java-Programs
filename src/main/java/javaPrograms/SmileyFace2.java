package javaPrograms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SmileyFace2 extends JFrame implements MouseMotionListener {
    private int mouseX;
    private int mouseY;
    
    public SmileyFace2() {
        super("Smiley Face");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        addMouseMotionListener(this);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        // draw face
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 200, 200);
        
        // draw eyes
        int leftEyeX = 100;
        int rightEyeX = 170;
        int eyeY = 100;
        int eyeSize = 30;
        
        int deltaX = mouseX - leftEyeX;
        int deltaY = mouseY - eyeY;
        double angle = Math.atan2(deltaY, deltaX);
        int pupilX = (int) (leftEyeX + Math.cos(angle) * (eyeSize / 2));
        int pupilY = (int) (eyeY + Math.sin(angle) * (eyeSize / 2));
        
        g.setColor(Color.BLACK);
        g.fillOval(leftEyeX, eyeY, eyeSize, eyeSize);
        g.fillOval(rightEyeX, eyeY, eyeSize, eyeSize);
        
        g.setColor(Color.WHITE);
        g.fillOval(pupilX - 5, pupilY - 5, 10, 10);
        g.fillOval(pupilX + 15, pupilY - 5, 10, 10);
        
        // draw mouth
        g.setColor(Color.BLACK);
        g.drawArc(75, 125, 150, 100, 180, 180);
    }
    
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }
    
    public void mouseDragged(MouseEvent e) {}
    
    public static void main(String[] args) {
        new SmileyFace2();
    }
}
