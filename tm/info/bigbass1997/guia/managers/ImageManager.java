package tm.info.bigbass1997.guia.managers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageManager {

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

	private static Image background; // #1
	private static Image pointer; // #2

	public static void loadImages() {
		try {
			// TO-BE-LOADED IMAGES HERE\\
			pointer = new Image(
					"source/GUIAdventure/resources/images/pointer.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static Image getImage(String path) {
		try {
			return new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Image getImage(int imagenum) {
		switch (imagenum) {
		case 1:
			return background;
		case 2:
			return pointer;
		}
		return null;
	}
}
