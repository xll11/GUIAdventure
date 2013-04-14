package tm.info.bigbass1997.guia.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import tm.info.bigbass1997.guia.MainDisplay;
import tm.info.bigbass1997.guia.listeners.KeyListenerClass;
import tm.info.bigbass1997.guia.listeners.MouseListenerClass;
import tm.info.bigbass1997.guia.managers.FontManager;
import tm.info.bigbass1997.guia.managers.ImageManager;
import tm.info.bigbass1997.guia.managers.ShapeManager;
import tm.info.bigbass1997.guia.objects.CustomButton;

public class MainMenuState extends BasicGameState {

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

	private static int SWIDTH, SHEIGHT;
	public static int pointerx = -1000, pointery = -1000;

	public static CustomButton playButton;
	public static CustomButton helpButton;
	public static CustomButton creditsButton;

	private int px = 170, py = 70, pwidth = 300, pheight = 50;
	private int hx = 530, hy = 70, hwidth = 300, hheight = 50;
	private int cx = 350, cy = 140, cwidth = 300, cheight = 50;

	public static int FPS = 0;

	public static int mouseX = 0, mouseY = 0;

	@SuppressWarnings("unused")
	private static String FPSs;

	int stateID = -1;

	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		MainDisplay.mgc = gc;

		SWIDTH = MainDisplay.SWIDTH;
		SHEIGHT = MainDisplay.SHEIGHT;

		FontManager.initAllFonts();

		// gc.setMinimumLogicUpdateInterval(80);
		// gc.setMaximumLogicUpdateInterval(160);

		gc.getInput().addMouseListener(new MouseListenerClass());
		gc.getInput().addKeyListener(new KeyListenerClass());

		FPS = MainDisplay.appGC.getFPS();
		FPSs = "FPS: " + FPS;

		ImageManager.loadImages();

		// SubmitScore.submit("Testin Dude", 13);

		MainDisplay.logger.info("MainMenu Initialization Method Loaded!");
		MainDisplay.logger.info("Debug: " + MainDisplay.debug);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		// g.fill(ShapeManager.Rect(g, 0, 0, SWIDTH, SHEIGHT, 0x99131356));
		g.fill(ShapeManager.Rect(g, 0, 0, SWIDTH, SHEIGHT, 0xFF131356));

		playButton = new CustomButton(g, px, py, pwidth, pheight, 100, 0,
				"Play!", 0xFF444444, 0xFFFFFFFF, FontManager.PK50);
		helpButton = new CustomButton(g, hx, hy, hwidth, hheight, 100, 0,
				"Help!", 0xFF444444, 0xFFFFFFFF, FontManager.PK50);
		creditsButton = new CustomButton(g, cx, cy, cwidth, cheight, 78, 0,
				"Credits!", 0xFF444444, 0xFFFFFFFF, FontManager.PK50);

		// g.draw(ShapeManager.Rect(50, 200, SWIDTH - 100, SHEIGHT - 250,
		// 0xFFFFFFFF));
		// g.drawImage(ImageManager.getImage("res/images/gamesummary.png"), 50,
		// 200);

		g.drawImage(ImageManager.getImage(2), MainMenuState.pointerx,
				MainMenuState.pointery);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		pointerx = mouseX;
		pointery = mouseY;

		mouseX = MainDisplay.appGC.getInput().getMouseX();
		mouseY = MainDisplay.appGC.getInput().getMouseY();
	}

	@Override
	public int getID() {
		return stateID;
	}
}
