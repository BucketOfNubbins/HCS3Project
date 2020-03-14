package mscjmm.gui.sprites;

public abstract class Drawable {
	
	private int depth;

	public Drawable(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public abstract void draw(int frameSpeed);
	
}
