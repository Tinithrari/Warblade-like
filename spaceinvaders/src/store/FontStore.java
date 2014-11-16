package store;

import java.io.IOException;
import java.util.HashMap;

import org.jsfml.graphics.Font;

public class FontStore {
	
	private static FontStore single = new FontStore();
	private HashMap<String,Font> fonts = new HashMap<String,Font>();
	
	public static FontStore get() {
		return single;
	}
	
	public Font getFont(String ref) {
		if (fonts.get(ref) == null) {
			try {
				Font font = new Font();
				font.loadFromStream(this.getClass().getClassLoader().getResourceAsStream(ref));
				fonts.put(ref, font);
			} catch (IOException e) {
				e.printStackTrace();
				fail("Loading error for : "  + ref);
			}
		}
		return (Font) fonts.get(ref);
	}
	
	private void fail(String message) {
		// we're pretty dramatic here, if a resource isn't available
		// we dump the message and exit the game
		System.err.println(message);
		System.exit(0);
	}
}
