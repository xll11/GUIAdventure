package tm.info.bigbass1997.guia.managers;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import tm.info.bigbass1997.guia.MainDisplay;

public class Util {

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

	public static boolean debug = true;
	private static String FPSs;

	public static int getFPS() {
		int FPS = MainDisplay.appGC.getFPS();
		return FPS;
	}

	public static void drawDebug(Graphics g) {
		FPSs = "FPS: " + getFPS();

		int SWIDTH = MainDisplay.SWIDTH;
		int SHEIGHT = MainDisplay.SHEIGHT;

		int mouseX = MainDisplay.appGC.getInput().getMouseX();
		int mouseY = MainDisplay.appGC.getInput().getMouseY();

		// DEBUG INFORMATION\\
		g.setFont(FontManager.PK22);
		if (debug) {
			g.setColor(new Color(0xFFFFFFFF));
			g.drawString(FPSs, SWIDTH - g.getFont().getWidth(FPSs) - 5, SHEIGHT
					- g.getFont().getLineHeight());
			g.drawString("MX: " + mouseX, 1, SHEIGHT
					- (g.getFont().getLineHeight() * 2) + 6);
			g.drawString("MY: " + mouseY, 1, SHEIGHT
					- g.getFont().getLineHeight());
		} else if (!debug) {
			g.setColor(new Color(0xFFFFFFFF));
			g.drawString(
					"Copywrite 2013, Luke \"Bigbass\" Stadem",
					SWIDTH
							- g.getFont().getWidth(
									"Copywrite 2013, Luke \"Bigbass\" Stadem")
							- 3, SHEIGHT - g.getFont().getLineHeight());
			g.drawString("Ver " + MainDisplay.version, 2, SHEIGHT
					- g.getFont().getLineHeight());
		}
	}
}
