package store;

import java.io.IOException;
import java.util.HashMap;

import org.jsfml.audio.SoundBuffer;

public class SoundStore {
	
	private static SoundStore single = new SoundStore();
	private HashMap<String,SoundBuffer> sounds = new HashMap<String,SoundBuffer>();
	
	public static SoundStore get() {
		return single;
	}
	
	public SoundBuffer getSound(String ref) {
		
		if (sounds.get(ref) == null) {
			try {
				SoundBuffer sound = new SoundBuffer();
				sound.loadFromStream(this.getClass().getClassLoader().getResourceAsStream(ref));
				sounds.put(ref, sound);
			} catch (IOException e) {
				e.printStackTrace();
				fail("Loading error for : "  + ref);
			}
		}
		return (SoundBuffer) sounds.get(ref);
	}
	
	private void fail(String message) {
		// we're pretty dramatic here, if a resource isn't available
		// we dump the message and exit the game
		System.err.println(message);
		System.exit(0);
	}
}
