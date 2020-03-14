import java.util.Arrays;
import java.util.Comparator;

/**
 * General class to run a specified level of the game
 */
public class LevelRunner {
    private static final int bufferSize = 8;

    private boolean isVertical;
    Drawable[] objects;
    int leftIndex;
    int rightIndex;
    int frameWidth;
    int frameHeight;
    int frameBuffer;

    public LevelRunner(String levelID, int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        //Read or otherwise load things in level
        isVertical = false;
        objects = new Drawable[10 + 1];
        Arrays.sort(objects, Comparator.comparingInt(Drawable::getBound));
        frameBuffer = (isVertical ? frameHeight : frameWidth) / bufferSize;
        leftIndex = 0;
        rightIndex = 0;
        while (objects[rightIndex] != null && objects[rightIndex].getBound() < frameWidth + bufferSize) {
            rightIndex++;
        }
        //Create timers and such to manage events, launches the timers as well
    }
}
