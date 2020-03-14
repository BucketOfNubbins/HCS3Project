package mscjmm.gui.sprites;

import java.awt.Image;

import mscjmm.gui.control.CanvasUtils;
import mscjmm.gui.control.GUIHandler;
import mscjmm.gui.resources.Images;

public class SpriteBackground extends Drawable {
	
	private Image bgImage;

	public SpriteBackground(Images bg) {
		super(Integer.MAX_VALUE);
		bgImage = bg.get();
	}

	@Override
	public void draw(int frameSpeed) {
		CanvasUtils.drawImage2(bgImage, 0, 0, GUIHandler.REF_WIDTH, GUIHandler.REF_HEIGHT);
	}

}
