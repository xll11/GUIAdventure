package tm.info.bigbass1997.guia.objects;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Graphics;

import tm.info.bigbass1997.guia.listeners.MouseListenerClass;
import tm.info.bigbass1997.guia.managers.ShapeManager;

public class CustomButton {

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

	private int mx, my;
	private int x, y, width, height;

	private static boolean highlight = false;

	public CustomButton() {

	}

	public CustomButton(Graphics g, int bx, int by, int bwidth, int bheight,
			int xOffSet, int yOffSet, String s, int argb, int sArgb,
			AngelCodeFont font) {
		this.x = bx;
		this.y = by;
		this.width = bwidth;
		this.height = bheight;

		g.fill(ShapeManager.Rect(g, x, y, width, height, argb));
		ShapeManager.String(g, s, x + xOffSet, y + yOffSet, sArgb, font);

		g.draw(ShapeManager.Rect(g, x, y, width, height, 0xFF000000));
		g.draw(ShapeManager.Rect(g, x + 1, y + 1, width - 2, height - 2,
				0xFF000000));
		g.draw(ShapeManager.Rect(g, x + 2, y + 2, width - 4, height - 4,
				0xFF000000));
		g.draw(ShapeManager.Rect(g, x + 3, y + 3, width - 6, height - 6,
				0xFF000000));

		mx = MouseListenerClass.mx;
		my = MouseListenerClass.my;

		if (mx >= x && mx <= (x + width) && my >= y && my <= (y + height)) {
			highlight = true;
		} else {
			highlight = false;
		}

		if (highlight)
			g.fill(ShapeManager.Rect(g, x, y, width, height, 0x47FFFFFF));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
