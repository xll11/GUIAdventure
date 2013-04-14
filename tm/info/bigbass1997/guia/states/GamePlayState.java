package tm.info.bigbass1997.guia.states;

import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import tm.info.bigbass1997.guia.MainDisplay;
import tm.info.bigbass1997.guia.managers.FontManager;
import tm.info.bigbass1997.guia.managers.ImageManager;
import tm.info.bigbass1997.guia.managers.PlayerStatManager;
import tm.info.bigbass1997.guia.managers.ShapeManager;
import tm.info.bigbass1997.guia.objects.CustomButton;

public class GamePlayState extends BasicGameState {

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

	public static float healthFillWidth = 0.0f;
	public static int healthBarWidth = 200;

	public static float manaFillWidth = 0.0f;
	public static int manaBarWidth = 200;

	public static float expFillWidth = 0.0f;
	public static int expBarWidth = 420;

	public static CustomButton mainMenuButton, travelButton, statsButton,
			shopButton, characterButton, inventoryButton, questsButton;

	private int elapsedTime;

	int stateID = -1;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		try {
			gc.setMouseCursor(
					ImageManager
							.getImage("source/GUIAdventure/resources/images/blankmouse.png"),
					0, 0);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		g.fill(ShapeManager.Rect(g, 0, 0, MainDisplay.SWIDTH,
				MainDisplay.SHEIGHT, 0xFFDDDDDD));

		// OUTER BOARDER\\
		g.draw(ShapeManager.Rect(g, 5, 5, MainDisplay.SWIDTH - 10,
				MainDisplay.SHEIGHT - 10, 0xFFBBBBBB));
		g.draw(ShapeManager.Rect(g, 6, 6, MainDisplay.SWIDTH - 12,
				MainDisplay.SHEIGHT - 12, 0xFFBBBBBB));
		g.draw(ShapeManager.Rect(g, 7, 7, MainDisplay.SWIDTH - 14,
				MainDisplay.SHEIGHT - 14, 0xFFBBBBBB));

		// PLAYER STATS BOARDER\\
		g.draw(ShapeManager.Rect(g, 10, 10, 440, 300, 0xFF000000));
		g.draw(ShapeManager.Rect(g, 11, 11, 438, 298, 0xFF000000));

		// BATTLE AREA BOARDER\\
		g.draw(ShapeManager.Rect(g, 10, 315, 440, 275, 0xFF000000));
		g.draw(ShapeManager.Rect(g, 11, 316, 438, 273, 0xFF000000));

		// ALL BARS\\
		ShapeManager.FillBar(g, 20, 30, healthBarWidth, 10, healthFillWidth,
				0xFFFFFFFF, 0xFF00FF00); // HEALTH
		ShapeManager.FillBar(g, 240, 30, manaBarWidth, 10, manaFillWidth,
				0xFFFFFFFF, 0xFF0000DD); // MANA
		ShapeManager.FillBar(g, 20, 290, expBarWidth, 10, expFillWidth,
				0xFFFFFFFF, 0xFF00EEEE); // EXPERIENCE

		// BAR TITLES\\
		ShapeManager
				.String(g, "Health: ", 20, 14, 0xFF000000, FontManager.PK16); // HEALTH
		ShapeManager.String(g, "" + (int) PlayerStatManager.health + "/"
				+ (int) PlayerStatManager.maxHealth, 188, 14, 0xFF000000,
				FontManager.PK16); // HEALTH

		ShapeManager.String(g, "Mana: ", 240, 14, 0xFF000000, FontManager.PK16); // MANA
		ShapeManager.String(g, "" + (int) PlayerStatManager.mana + "/"
				+ (int) PlayerStatManager.maxMana, 398, 14, 0xFF000000,
				FontManager.PK16); // MANA

		ShapeManager.String(g, "Experience: ", 20, 274, 0xFF000000,
				FontManager.PK16); // MANA
		ShapeManager.String(g, "" + (int) PlayerStatManager.exp + "/"
				+ (int) PlayerStatManager.requiredExp, 392, 274, 0xFF000000,
				FontManager.PK16); // MANA

		// STATS\\ //LEFT SIDE\\
		ShapeManager
				.String(g, "Defence:", 20, 60, 0xFF000000, FontManager.PK22);
		ShapeManager.String(g, "" + PlayerStatManager.defence, 210, 60,
				0xFFFF0000, FontManager.PK22);

		ShapeManager.String(g, "Composure:", 20, 85, 0xFF000000,
				FontManager.PK22);
		ShapeManager.String(g, "" + PlayerStatManager.composure, 210, 85,
				0xFFFF0000, FontManager.PK22);

		ShapeManager.String(g, "Agility:", 20, 110, 0xFF000000,
				FontManager.PK22);
		ShapeManager.String(g, "" + PlayerStatManager.agility, 210, 110,
				0xFFFF0000, FontManager.PK22);

		// STATS\\ //RIGTH SIDE\\
		ShapeManager.String(g, "Power:", 240, 60, 0xFF000000, FontManager.PK22);
		ShapeManager.String(g, "" + PlayerStatManager.power, 430, 60,
				0xFFFF0000, FontManager.PK22);

		ShapeManager.String(g, "Intellect:", 240, 85, 0xFF000000,
				FontManager.PK22);
		ShapeManager.String(g, "" + PlayerStatManager.intellect, 430, 85,
				0xFFFF0000, FontManager.PK22);

		ShapeManager.String(g, "Wealth:", 240, 110, 0xFF000000,
				FontManager.PK22);
		ShapeManager.String(g, "" + PlayerStatManager.wealth, 430, 110,
				0xFFFF0000, FontManager.PK22);

		// STATECHANGE BUTTONS (MENUS)\\ //(x, y, width, height, xOffset,
		// yOffset, argb, sArgb, font)\\
		mainMenuButton = new CustomButton(g, 495, 20, 220, 60, 9, 4,
				"Main Menu", 0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		travelButton = new CustomButton(g, 735, 20, 220, 60, 42, 4, "Travel",
				0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		statsButton = new CustomButton(g, 495, 85, 220, 60, 54, 4, "Stats",
				0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		shopButton = new CustomButton(g, 735, 85, 220, 60, 59, 4, "Shop",
				0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		characterButton = new CustomButton(g, 495, 150, 220, 60, 13, 4,
				"Character", 0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		inventoryButton = new CustomButton(g, 735, 150, 220, 60, 9, 4,
				"Inventory", 0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		questsButton = new CustomButton(g, 495, 215, 220, 60, 40, 4, "Quests",
				0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);
		// CustomButton whateverButton = new CustomButton(g, 735, 215, 220, 60,
		// 9, 4, "whatever", 0xFF9900BB, 0xFFFFFFFF, FontManager.PK50);

		// MOUSE IMAGE CONTROLLER\\
		g.drawImage(ImageManager.getImage(2), MainMenuState.pointerx,
				MainMenuState.pointery);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		MainMenuState.pointerx = MainMenuState.mouseX;
		MainMenuState.pointery = MainMenuState.mouseY;

		MainMenuState.mouseX = MainDisplay.appGC.getInput().getMouseX();
		MainMenuState.mouseY = MainDisplay.appGC.getInput().getMouseY();

		elapsedTime += delta;
		if (elapsedTime >= 1000) {
			elapsedTime = 0;
			trigger1Sec(); // The trigger method would be called every second
		}

		healthFillWidth = healthBarWidth
				* (PlayerStatManager.health / PlayerStatManager.maxHealth);
		manaFillWidth = manaBarWidth
				* (PlayerStatManager.mana / PlayerStatManager.maxMana);
		expFillWidth = expBarWidth
				* (PlayerStatManager.exp / PlayerStatManager.requiredExp);
	}

	public void trigger1Sec() {
		System.out.println("TICK! " + Sys.getTime() / 1000);
		// if (PlayerStatManager.health >= 1.0f) PlayerStatManager.health -=
		// 1.0f;
		// System.out.println("Health: " + PlayerStatManager.health +
		// "  |  Current/Max: " + (PlayerStatManager.health /
		// PlayerStatManager.maxHealth));
	}

	@Override
	public int getID() {
		return stateID;
	}
}
