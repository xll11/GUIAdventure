package tm.info.bigbass1997.guia.managers;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class FontManager {

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

	public static AngelCodeFont PK8, PK10, PK12, PK16, PK22, PK32, PK50;

	public FontManager() {

	}

	public static void initAllFonts() {
		PK8 = getPesagiKuruFontACF8();
		PK10 = getPesagiKuruFontACF10();
		PK12 = getPesagiKuruFontACF12();
		PK16 = getPesagiKuruFontACF16();
		PK22 = getPesagiKuruFontACF22();
		PK32 = getPesagiKuruFontACF32();
		PK50 = getPesagiKuruFontACF50();
	}

	private static AngelCodeFont getPesagiKuruFontACF8() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru8.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru8.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static AngelCodeFont getPesagiKuruFontACF10() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru10.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru10.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static AngelCodeFont getPesagiKuruFontACF12() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru12.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru12.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static AngelCodeFont getPesagiKuruFontACF16() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru16.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru16.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static AngelCodeFont getPesagiKuruFontACF22() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru22.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru22.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static AngelCodeFont getPesagiKuruFontACF32() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru32.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru32.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static AngelCodeFont getPesagiKuruFontACF50() {

		try {
			AngelCodeFont font = new AngelCodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru50.fnt",
					new Image(
							"source/GUIAdventure/resources/fonts/pesagi_kuru/pesagi_kuru50.png"));
			return font;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static UnicodeFont getPesagiKuruFont(int size) {
		try {
			UnicodeFont font = new UnicodeFont(
					"source/GUIAdventure/resources/fonts/pesagi_kuru.ttf",
					size, false, false);
			font.addGlyphs(0, 9999);
			font.getEffects().add(new ColorEffect());
			font.loadGlyphs();
			return font;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
}
