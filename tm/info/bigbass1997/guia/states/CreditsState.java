package tm.info.bigbass1997.guia.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import tm.info.bigbass1997.guia.MainDisplay;
import tm.info.bigbass1997.guia.managers.ImageManager;

public class CreditsState extends BasicGameState {

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

	public static int pointerx = -1000, pointery = -1000;
	public static int mouseX = 0, mouseY = 0;

	int stateID = -1;

	public CreditsState(int stateID) {
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
		g.drawImage(ImageManager.getImage(2), CreditsState.pointerx,
				CreditsState.pointery);
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
