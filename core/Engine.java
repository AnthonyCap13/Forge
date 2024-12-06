
package core;

import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame
{
	public final static int RESOLUTION_X = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * Toolkit.getDefaultToolkit().getScreenResolution() / 96.0f);
	public final static int RESOLUTION_Y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * Toolkit.getDefaultToolkit().getScreenResolution() / 96.0f);
	
    public static final int GAME_ID  = 1;
    
    private BasicGameState game;
    

	public Engine(String name)
	{
		super(name);
		game = new Game(GAME_ID);
	}

	public void initStatesList(GameContainer gc) throws SlickException{
//		gc.setTargetFrameRate(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate());
//		gc.setVSync(true);
	    addState(game);
	}

	public static void main(String[] args) 
	{
		try {
			AppGameContainer appgc = new AppGameContainer(new Engine("Sample Slick Game"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(RESOLUTION_X, RESOLUTION_Y, false);
//			appgc.setTargetFrameRate(FRAMES_PER_SECOND);
			appgc.start();
			appgc.setVSync(true);

		} catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}