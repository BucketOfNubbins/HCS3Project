package mscjmm.gui.scenes;

import java.util.List;

import mscjmm.gui.resources.Images;
import mscjmm.gui.sprites.SpriteBackground;

public class SceneTitle extends Scene {

	public SceneTitle() {
		super();
		this.addSprite(new SpriteBackground(Images.TEST));
	}
	
	@Override
	public void onClick(int mouseX, int mouseY, int type) {
		System.out.println("Holy cow!  YOu just clicked at " + mouseX + " " + mouseY + " with type " + type);
	}

	@Override
	public void update(int mouseX, int mouseY, List<String> activeKeys, int frameSpeed) {
		if (! activeKeys.isEmpty())
			System.out.println("Pressed Keys: " + activeKeys);
	}

}
