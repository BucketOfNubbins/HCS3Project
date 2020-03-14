package mscjmm.gui.control;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class CanvasUtils {

	private static Graphics2D g2;
	private static int actHeight, actWidth, refHeight, refWidth;
	
	public static void setG2(Graphics2D next2D) {
		g2 = next2D;
	}
	
	public static void setReferences(int width, int height) {
		refHeight = height;
		refWidth = width;
	}
	
	public static void resize(int width, int height) {
		actHeight = height;
		actWidth = width;
	}
	
	public static int toActW(int width) {
		return (int) ((double) width * actWidth / refWidth);
	}
	
	public static int toActH(int height) {
		return (int) ((double) height * actHeight / refHeight);
	}
	
	public static int toRefW(int width) {
		return (int) ((double) width * refWidth / actWidth);
	}
	
	public static int toRefH(int height) {
		return (int) ((double) height * refHeight / actHeight);
	}
	
	public static void clear() {
		g2.clearRect(0, 0, actHeight, actWidth);
	}
	
	/**
	 * Draws a filled rectangle inside the box formed by the inputed points.
	 * @param x1 the x value of the leftmost side of the rectangle
	 * @param y1 the y value of the upmost side of the rectangle
	 * @param x2 the x value of the rightmost side of the rectangle
	 * @param y2 the y value of the bottommost side of the rectangle
	 * @param c the color the rectangle should be filled with
	 */
	public static void drawRect1(int x1, int y1, int x2, int y2, Color c) {
		if (x1 > x2) {
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if (y1 > y2) {
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		g2.setColor(c);
		g2.fillRect(toActW(x1), toActH(y1), toActW(x2 - x1), toActH(y2 - y1));
	}
	
	/**
	 * Draws a filled rectangle at a point with a specified width and height
	 * @param x the x value of the leftmost side of the rectangle
	 * @param y the y value of the upmost side of the rectangle
	 * @param w the width value of the width of the rectangle
	 * @param h the height value of the height of the rectangle
	 * @param c the color the rectangle should be filled with
	 */
	public static void drawRect2(int x, int y, int w, int h, Color c) {
		g2.setColor(c);
		g2.fillRect(toActW(x), toActH(y), toActW(w), toActH(h));
	}
	
	/**
	 * Connects two inputed coordinate points on the canvas by a 
	 * straight line of specified color and width
	 * @param x1 the x value of point 1
	 * @param y1 the y value of point 1
	 * @param x2 the x value of point 2
	 * @param y2 the y value of point 2
	 * @param width the width (thickness) of the line.
	 * @param c the color of the line
	 */
	public static void drawLine(int x1, int y1, int x2, int y2, int width, Color c) {
		g2.setStroke(new BasicStroke(toActW(width)));
		g2.setColor(c);
		g2.drawLine(toActW(x1), toActH(y1), toActW(x2), toActH(y2));
		g2.setStroke(null);
	}
	
	/**
	 * Draws an image inside the bounding box formed by the inputed points.
	 * @param img the image to draw, from the Images enumeration.
	 * @param x1 the x value of the leftmost side of the image
	 * @param y1 the y value of the upmost side of the image
	 * @param x2 the x value of the rightmost side of the image
	 * @param y2 the y value of the bottommost side of the image
	 */
	public static void drawImage1(Image img, int x1, int y1, int x2, int y2) {
		g2.drawImage(img, toActW(x1), toActH(y1), toActW(x2 - x1), toActH(y2 - y1), null);
	}
	
	/**
	 * Draws an image at a point with a specified width and height
	 * @param img the image to draw, from the Images enumeration.
	 * @param x the x value of the leftmost side of the image
	 * @param y the y value of the upmost side of the image
	 * @param w the width value of the width of the image
	 * @param h the height value of the height of the image
	 */
	public static void drawImage2(Image img, int x, int y, int w, int h) {
		g2.drawImage(img, toActW(x), toActH(y), toActW(w), toActH(h), null);
	}
	
	/**
	 * Draws an image centered on a point with an input width and height.
	 * @param img the image to draw, from the Images enumeration.
	 * @param centerX the x value of the center of the image
	 * @param centerY the y value of the center of the image
	 * @param w the width value of the width of the image
	 * @param h the height value of the height of the image
	 */
	public static void drawImage3(Image img, double centerX, double centerY, double w, double h) {
		//double adjW = w * stageW / referenceWidth, adjH = h * stageH / referenceHeight;
		//gc.drawImage(img, centerX * stageW / referenceWidth - adjW / 2, centerY * stageH / referenceHeight - adjH / 2, adjW, adjH);
	}
	
	/**
	 * Draws an image centered on a point with an input width and height.  This image will be rotated on counterclockwise about the center points at the input angle.
	 * @param img the image to draw, from the Images enumeration.
	 * @param centerX the x value of the center of the image
	 * @param centerY the y value of the center of the image
	 * @param w the width value of the width of the image
	 * @param h the height value of the height of the image
	 * @param angle the angle of rotation, in radians.
	 */
	public static void drawImageRotated(Image img, double centerX, double centerY, double w, double h, double angle) {
		// to be implemented
		
		//double adjW = w * stageW / referenceWidth, adjH = h * stageH / referenceHeight;
		//double adjX = centerX * stageW / referenceWidth, adjY = centerY * stageH / referenceHeight;
		//gc.save();
		//Rotate r = new Rotate(angle * -180 / Math.PI, adjX, adjY);
		//gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		//gc.drawImage(img, adjX - adjW / 2, adjY - adjH / 2, adjW, adjH);
		//gc.restore();
	}
	
	/**
	 * Draws a filled polygon formed by given coordinate points.
	 * @param c the color the polygon will be filled with
	 * @param points the xy points that make up the polygon.  It
	 * should be formatted with the first point x coord and then y
	 * coord, then the second point, etc.  The number of doubles inputed
	 * MUST be even.
	 */
	public static void drawPolygon(Color c, int... points) {
		g2.setColor(c);
		int[] xs = new int[points.length / 2], ys = new int[points.length / 2];
		for (int i = 0; i < points.length; i += 2) {
			xs[i / 2] = toActW(points[i]);
			ys[i / 2] = toActH(points[i + 1]);
		}
		g2.fillPolygon(xs, ys, xs.length);
	}
	
	/**	Draws an oval of specified color and location.
	 * 
	 * @param c	the color of the oval
	 * @param centerX	the center x coordinate
	 * @param centerY	the center y coordinate
	 * @param width		the width [ diameter, NOT radius; full width!]
	 * @param height	the height [ diameter, NOT radius; full height!]
	 */
	public static void drawOval(Color c, int centerX, int centerY, int width, int height) {
		//double adjW = width * stageW / referenceWidth, adjH = height * stageH / referenceHeight;
		//double adjX = centerX * stageW / referenceWidth, adjY = centerY * stageH / referenceHeight;
		g2.setColor(c);
		g2.drawOval(toActW(centerX - width / 2), toActH(centerY - height / 2), toActW(width * 2), toActH(height * 2));
		//gc.setFill(c);
		//gc.fillOval(adjX - adjW / 2, adjY - adjH / 2, adjW, adjH);
	}
	
	/**	Draws an circle of specified color and location.
	 * 
	 * @param c	the color of the outline
	 * @param centerX	the center x coordinate
	 * @param centerY	the center y coordinate
	 * @param radius	the radius of the circle
	 */
	public static void drawCircle(Color c, int centerX, int centerY, int radius) {
		drawOval(c, centerX, centerY, radius * 2, radius * 2);
	}
	
}
