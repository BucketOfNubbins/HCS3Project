package mscjmm.gui.control;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Timer;

import mscjmm.gui.scenes.Scene;
import mscjmm.gui.scenes.SceneTitle;

public class GUIHandler {
	
	public static final int REF_WIDTH = 1200;
	public static final int REF_HEIGHT = 900;
	
	public static final String TITLE = "Relic Race";
	
	private static GameCanvas canvas;
	private static Frame frame;
	private static Timer timer;
	
	private static Scene activeScene;
	private static KeyBoardHandler kbh;
	private static MouseHandler mh;

	/** launches the GUI
	 * 
	 * @param actWidth the starting width of the window
	 * @param actHeight the starting height of the window
	 */
	public static void launch(int actWidth, int actHeight) {
		CanvasUtils.setReferences(REF_WIDTH, REF_HEIGHT);
		CanvasUtils.resize(actWidth, actHeight);
		
		frame = new Frame(TITLE);
		frame.setResizable(true);
		frame.add(canvas = new GameCanvas(actWidth, actHeight));
		frame.setSize(actWidth, actHeight);
		frame.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                shutdown();
            }
        } );
		
		activeScene = new SceneTitle();
		createListeners();
		addTimer();
		
		frame.setVisible(true);
	}
	
	/** changes the active scene to display
	 * 
	 * @param newScene the new scene
	 */
	public static void setScene(Scene newScene) {
		activeScene = newScene;
	}
	
	/** calls the scene's onClick method
	 * 
	 * @param x the x-coordinate of the click
	 * @param y the y-coordinate of the click
	 * @param clickType the id (1: left click, 2: right click, 3: anything else, such as scroll wheel move)
	 */
	public static void fireClick(int x, int y, int clickType) {
		activeScene.onClick(CanvasUtils.toRefW(x), CanvasUtils.toRefH(y), clickType);
	}
	
	/** creates listeners for the window
	 * 
	 */
	private static void createListeners() {
		// mouse click listener
		mh = new MouseHandler();
		
		frame.addMouseMotionListener(mh);
		frame.addMouseWheelListener(mh);
		frame.addMouseListener(mh);
		
		// window listener (resize)
		frame.addComponentListener(new WindowHandler());
		
		// key press / release listener
		kbh = new KeyBoardHandler();
		frame.addKeyListener(kbh);
	}
	
	/** Initiates GUI Timer
	 * 
	 */
	private static void addTimer() {
		// initiate timer.
		timer = new Timer(20, ae -> {
			canvas.update(); // effectively resets the canvas.
			activeScene.onUpdate(mh.getMouseX(), mh.getMouseY(), kbh.getActiveKeys(), 20);
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	/** Ends application
	 * 
	 */
	private static void shutdown() {
		timer.stop();
		System.out.println("Shutting Down.");
		System.exit(0);
	}
}
