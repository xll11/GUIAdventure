package tm.info.bigbass1997.guia.listeners;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import tm.info.bigbass1997.guia.MainDisplay;
import tm.info.bigbass1997.guia.objects.CustomButton;
import tm.info.bigbass1997.guia.states.GamePlayState;
import tm.info.bigbass1997.guia.states.MainMenuState;

public class MouseListenerClass implements MouseListener {

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

	public static int mx, my;

	public MouseListenerClass() {

	}

	@Override
	public void inputEnded() {

	}

	@Override
	public void inputStarted() {

	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input arg0) {

	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		MainDisplay.logger.info("MouseClicked | button: " + button + " | X: "
				+ x + " | Y: " + y + " | count: " + clickCount);
		/*
		 * Random rand = new Random(); if(x >= Canvas.cX && x <= Canvas.cX + 100
		 * && y >= Canvas.cY && y <= Canvas.cY + 100){ Canvas.cX =
		 * rand.nextInt(800); Canvas.cY = rand.nextInt(800); }
		 * System.out.println("X: " + Canvas.cX + " | Y: " + Canvas.cY);
		 */

		CustomButton pb = MainMenuState.playButton;
		if (checkBounds(x, y, pb.getX(), pb.getY(), pb.getWidth(),
				pb.getHeight())
				&& MainDisplay.sbg.getCurrentState().getID() == 0) {
			MainDisplay.sbg.enterState(1);
		}

		CustomButton cb = MainMenuState.creditsButton;
		if (checkBounds(x, y, cb.getX(), cb.getY(), cb.getWidth(),
				cb.getHeight())
				&& MainDisplay.sbg.getCurrentState().getID() == 0) {
			MainDisplay.sbg.enterState(3);
		}

		if (MainDisplay.sbg.getCurrentState().getID() == 1) {
			CustomButton mmb = GamePlayState.mainMenuButton;
			if (checkBounds(x, y, mmb.getX(), mmb.getY(), mmb.getWidth(),
					mmb.getHeight())) {
				MainDisplay.sbg.enterState(0); // Changes to MainMenuState
			}

			CustomButton tb = GamePlayState.travelButton;
			if (checkBounds(x, y, tb.getX(), tb.getY(), tb.getWidth(),
					tb.getHeight())
					&& MainDisplay.sbg.getCurrentState().getID() == 1) {
				// TODO Add TravelState and add change to state here
			}
		}

		// TODO Add detection functions for all menu buttons in the
		// GmaePlayState!
	}

	private boolean checkBounds(int mx, int my, int x, int y, int width,
			int height) {
		if (mx >= x && mx <= x + width && my >= y && my <= y + height) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {

	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY) {
		mx = newX;
		my = newY;
	}

	@Override
	public void mousePressed(int button, int x, int y) {

	}

	@Override
	public void mouseReleased(int button, int x, int y) {

	}

	@Override
	public void mouseWheelMoved(int change) {

	}
}
