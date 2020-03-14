package mscjmm.gui.scenes;

import java.util.ArrayList;
import java.util.List;

import mscjmm.gui.sprites.Drawable;

public abstract class Scene {

	protected List<Drawable> activeSprites;
	
	public Scene() {
		activeSprites = new ArrayList<>();
	}
	
	public abstract void onClick(int mouseX, int mouseY, int type);
	public abstract void update(int mouseX, int mouseY, List<String> activeKeys, int frameSpeed);
	
	protected void renderSprites(int frameSpeed) {
		for (Drawable d : activeSprites)
			d.draw(frameSpeed);
	}
	
	protected void addSprite(Drawable d) {
		int size = activeSprites.size();
		for (int i = 0; i < size; i++)
			if (d.getDepth() > activeSprites.get(i).getDepth()) {
				activeSprites.add(i, d);
				return;
			}
		activeSprites.add(d);
	}
	
	protected void removeSprite(Drawable d) {
		if (this.activeSprites.contains(d))
			this.activeSprites.remove(d);
	}
	
	public void onUpdate(int mouseX, int mouseY, List<String> activeKeys, int frameSpeed) {
		this.renderSprites(frameSpeed);
		this.update(mouseX, mouseY, activeKeys, frameSpeed);
	}
	
}
