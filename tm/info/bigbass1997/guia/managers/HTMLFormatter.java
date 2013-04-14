package tm.info.bigbass1997.guia.managers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

//This custom formatter formats parts of a log record to a single line
public class HTMLFormatter extends Formatter {

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

	// This method is called for every log records
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
		if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
			buf.append("<b>");
			buf.append("[" + rec.getLevel() + "]");
			buf.append(' ');
			Date date = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("HH.mm.ss");
			buf.append("[" + ft.format(date) + "]");
			buf.append(' ');
			buf.append(formatMessage(rec));
			buf.append("</b>");
			buf.append('\n');
		} else {
			buf.append("[" + rec.getLevel() + "]");
			buf.append(' ');
			Date date = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("HH.mm.ss");
			buf.append("[" + ft.format(date) + "]");
			buf.append(' ');
			buf.append(formatMessage(rec));
			buf.append('\n');
		}
		return buf.toString();
	}

	// This method is called just after the handler using this
	// formatter is created
	public String getHead(Handler h) {
		return "<HTML><HEAD><META HTTP-EQUIV=\"refresh\" CONTENT=\"0\">"
				+ "<script type=\"text/javascript\">function moveWin(){window.scroll(0,999999999);setTimeout('moveWin();',1000);}</script>"
				+ (new Date()) + "</HEAD><BODY onLoad=\"moveWin();\"><PRE>\n";
	}

	// This method is called just after the handler using this
	// formatter is closed
	public String getTail(Handler h) {
		return "</PRE></BODY></HTML>\n";
	}
}