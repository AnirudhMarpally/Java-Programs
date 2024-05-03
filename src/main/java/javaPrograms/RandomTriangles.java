package javaPrograms;

import java.util.Random;

public class RandomTriangles {
	public static void main(String[] args) {
		Random rand = new Random();
		
		for (int i = 0; i < 500; i++) {
			// Define random color
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			int color = (r << 16) | (g << 8) | b;
			
			// Define random points
			int x1 = rand.nextInt(1000);
			int y1 = rand.nextInt(1000);
			int x2 = rand.nextInt(1000);
			int y2 = rand.nextInt(1000);
			int x3 = rand.nextInt(1000);
			int y3 = rand.nextInt(1000);
			
			// Draw triangle
			drawTriangle(x1, y1, x2, y2, x3, y3, color); 
		}
	}

	// Method to draw a triangle using the given vertices and color
	public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int color) {
		// Draw lines between each vertex
		// ...
		// ...
	}
}