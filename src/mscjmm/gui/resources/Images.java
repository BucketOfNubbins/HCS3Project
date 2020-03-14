package mscjmm.gui.resources;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/* IMAGE FORMAT:
 * Frames should be stacked vertically, with the first frame at the top.
 */

public enum Images {
	TEST("src/resource/image/beauty.png", 1);
	
	private Image[] frames;
	
	/** Reads in image from specified file path,
	 *  creates frames array of all image frames.
	 * 
	 * @param path path to image file
	 * @param numFrames number of frames
	 */
	Images(String path, int numFrames) {
		try {
			BufferedImage in = ImageIO.read(new File(path));
			int width = in.getWidth(), height = in.getHeight();
			if (height % numFrames != 0) {
				System.out.println("EXCEPTION: " + path + " has an improper ratio!");
				frames = new Image[] {in};
				return;
			}
			frames = new Image[numFrames];
			int dy = height / numFrames;
			for (int j = 0; j < numFrames; j++)
				frames[j] = in.getSubimage(0, dy * j, width, dy);
		} catch (Exception e) {
			System.out.println("EXCEPTION: Error occured in reading file " + path + "!");
			e.printStackTrace();
		}
	}
	
	/** get image, assuming one frame
	 * 
	 * @return img
	 */
	public Image get() {
		return frames[0];
	}
	
	/** get specified frame of image
	 * 
	 * @param frameID the frame id, range 0 ... NUMFRAMES - 1
	 * @return the frame
	 */
	public Image get(int frameID) {
		return frames[frameID];
	}
	
	/** get num frames
	 * 
	 * @return number of frames in images
	 */
	public int getNumFrames() {
		return frames.length;
	}
}
