package tm.info.bigbass1997.guia;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.state.StateBasedGame;

import tm.info.bigbass1997.guia.managers.HTMLFormatter;
import tm.info.bigbass1997.guia.states.CreditsState;
import tm.info.bigbass1997.guia.states.GamePlayState;
import tm.info.bigbass1997.guia.states.HelpState;
import tm.info.bigbass1997.guia.states.MainMenuState;

public class MainDisplay extends StateBasedGame {

	/*
	 * GUIAdventure is a text-rpg style game but adds in more GUIs. Copyright
	 * (C) 2013 Bigbass1997
	 * 
	 * This program is free software: you can redistribute it and/or modify it
	 * under the terms of the GNU General Public License as published by the
	 * Free Software Foundation, either version 3 of the License, or (at your
	 * option) any later version.
	 * 
	 * This program is distributed in the hope that it will be useful, but
	 * WITHOUT ANY WARRANTY; without even the implied warranty of
	 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
	 * Public License for more details.
	 * 
	 * You should have received a copy of the GNU General Public License along
	 * with this program. If not, see <http://www.gnu.org/licenses/>
	 */

	// SPECIAL VARIABLES\\
	public static AppGameContainer appGC;
	public static final int SWIDTH = 1000, SHEIGHT = 600;
	public static final String title = "GUI Adventure ",
			version = "0.0.0.0(INFDEV)";
	public static boolean debug = true;

	public static Graphics g;
	public static GameContainer mgc;

	public static Logger logger = Logger.getLogger("Logger");
	public static FileHandler fh;

	public static StateBasedGame sbg;

	// INTS\\
	public static int mouseX = 0, mouseY = 0;

	public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;
	public static final int GAMEOVERSTATE = 2;
	public static final int CREDITSSTATE = 3;
	public static final int HELPSTATE = 4;

	// STRINGS\\

	// IMAGES\\

	// BOOLEANS\\

	// CONSTRUCTOR\\
	public MainDisplay() {
		super(title + version);
	}

	public static void main(String[] args) {
		try {
			fh = new FileHandler("log.html");
			fh.setFormatter(new HTMLFormatter());
			logger.addHandler(fh);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Renderer.setRenderer(Renderer.VERTEX_ARRAY_RENDERER); // EXPERIMENTAL FUNCTION >> http://slick.cokeandcode.com/wiki/doku.php?id=performance_memory_tips
			appGC = new AppGameContainer(new MainDisplay());
			appGC.setTitle(title);
			appGC.setDisplayMode(SWIDTH, SHEIGHT, false);
			appGC.setShowFPS(false);
			appGC.setVerbose(false);
			appGC.setTargetFrameRate(700);
			appGC.setAlwaysRender(true);
			logger.info("Main Method Loaded!");
			appGC.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

		/*
		 * try { } catch (SlickException e) { System.out.println("ERROR: " +
		 * e.getMessage()); if(e.getMessage().contains("Failed to set mouse")){
		 * System.out.println("ERROR-BBCODE: 404"); } e.printStackTrace(); }
		 */
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		sbg = this;
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.addState(new GamePlayState(GAMEPLAYSTATE));
		this.addState(new CreditsState(CREDITSSTATE));
		this.addState(new HelpState(HELPSTATE));
	}

	public void exit(GameContainer gc) {
		gc.exit();
	}
}
