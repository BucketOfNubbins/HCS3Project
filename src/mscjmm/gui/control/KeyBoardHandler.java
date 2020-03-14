package mscjmm.gui.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyBoardHandler implements KeyListener {
	
	private List<String> activeKeys;

	public KeyBoardHandler() {
		activeKeys = new ArrayList<>();
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		String code = KeyEvent.getKeyText(ke.getKeyCode());
		if (! activeKeys.contains(code))
			activeKeys.add(code);
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		String code = KeyEvent.getKeyText(ke.getKeyCode());
		if (activeKeys.contains(code))
			activeKeys.remove(code);
	}
	
	public List<String> getActiveKeys() {
		return activeKeys;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
