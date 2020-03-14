package mscjmm.gui.control;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
public class WindowHandler implements ComponentListener {

	@Override
	public void componentHidden(ComponentEvent ce) {
	}

	@Override
	public void componentMoved(ComponentEvent ce) {
	}

	@Override
	public void componentResized(ComponentEvent ce) {
		CanvasUtils.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
	}

	@Override
	public void componentShown(ComponentEvent ce) {
	}


}
