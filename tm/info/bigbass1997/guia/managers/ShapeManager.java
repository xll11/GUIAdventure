package tm.info.bigbass1997.guia.managers;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class ShapeManager {

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

	public ShapeManager() {

	}

	public static Polygon Poly(Graphics g, int x1, int y1, int x2, int y2,
			int x3, int y3, int x4, int y4, int argb) {
		g.setColor(new Color(argb));

		Polygon rect = new Polygon();
		rect.addPoint(x1, y1);
		rect.addPoint(x2, y2);
		rect.addPoint(x3, y3);
		rect.addPoint(x4, y4);

		return rect;
	}

	public static Polygon Rect(Graphics g, int x, int y, int width, int height,
			int argb) {
		g.setColor(new Color(argb));

		Polygon rect = new Polygon();
		rect.addPoint(x, y);
		rect.addPoint(x + width, y);
		rect.addPoint(x + width, y + height);
		rect.addPoint(x, y + height);

		return rect;
	}

	public static void String(Graphics g, String s, int x, int y, int argb,
			AngelCodeFont f) {
		g.setFont(f);
		g.setColor(new Color(argb));
		g.drawString(s, x, y);
	}

	public static void FillBar(Graphics g, int x, int y, int width, int height,
			float fwidth, int argbLight, int argbDark) {
		// BACKGROUNDBAR\\
		g.setColor(new Color(argbLight));

		Polygon backgroundBar = new Polygon();
		backgroundBar.addPoint(x, y);
		backgroundBar.addPoint(x + width, y);
		backgroundBar.addPoint(x + width, y + height);
		backgroundBar.addPoint(x, y + height);
		g.fill(backgroundBar);

		// FOREGROUNDBAR\\
		g.setColor(new Color(argbDark));

		Polygon foregroundBar = new Polygon();
		foregroundBar.addPoint(x, y);
		foregroundBar.addPoint(x + fwidth, y);
		foregroundBar.addPoint(x + fwidth, y + height);
		foregroundBar.addPoint(x, y + height);
		g.fill(foregroundBar);

		g.draw(ShapeManager.Rect(g, x, y, width, height, 0xFF000000));
		g.draw(ShapeManager.Rect(g, x + 1, y + 1, width - 2, height - 2,
				0xFF000000));
	}
}
