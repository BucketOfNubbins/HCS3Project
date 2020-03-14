package mscjmm.gui.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseHandler implements MouseListener, MouseWheelListener, MouseMotionListener {
	
	private int mouseX, mouseY;
	
	public MouseHandler() {
		this.mouseX = this.mouseY = -1;
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println("hi");
		switch(me.getButton()) {
		case 0:
			break;
		case 1:
			GUIHandler.fireClick(me.getX(), me.getY(), 1);
			break;
		case 2:
			GUIHandler.fireClick(me.getX(), me.getY(), 2);
			break;
		default:
			GUIHandler.fireClick(me.getX(), me.getY(), 3);
		}
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent mwe) {
		GUIHandler.fireClick(mwe.getX(), mwe.getY(), 3);
	}
	
	@Override
	public void mouseMoved(MouseEvent me) {
		this.mouseX = me.getX();
		this.mouseY = me.getY();
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	// ==================
	//   UNUSED METHODS
	// ==================
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("hi2");
	}

}
