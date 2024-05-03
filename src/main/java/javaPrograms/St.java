package javaPrograms;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

public class St extends Canvas {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final int MAX_ITERATIONS = 50000;
    private static final int X1 = 512;
    private static final int Y1 = 109;
    private static final int X2 = 146;
    private static final int Y2 = 654;
    private static final int X3 = 876;
    private static final int Y3 = 654;
    private static final int START_X = 512;
    private static final int START_Y = 382;

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        int x = START_X;
        int y = START_Y;
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            g.drawLine(x, y, x, y);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int r = new Random().nextInt(3) + 1;
            int dx, dy;
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
            x -= dx / 2;
            y -= dy / 2;
        }
        g.drawString("Sierpinski Triangle", 462, 484);
    }

    public static void main(String[] args) {
        SierpinskiTriangle triangle = new SierpinskiTriangle();
        //triangle.setSize(WIDTH, HEIGHT);
        Frame frame = new Frame("Sierpinski Triangle");
        //frame.add(triangle);
        frame.pack();
        frame.setVisible(true);
    }
}