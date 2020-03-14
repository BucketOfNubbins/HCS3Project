package mscjmm.gui.control;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {
	
	public GameCanvas(int width, int height) {
		this.setBackground(Color.WHITE);
		this.updateBounds(width, height);
	}
	
	public void updateBounds(int newWidth, int newHeight) {
		this.setSize(newWidth, newHeight); 
	}
	
	public void update() {
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		CanvasUtils.setG2(g2);
		//CanvasUtils.clear();
	}
	
}