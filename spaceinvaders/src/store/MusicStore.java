package store;

import java.io.InputStream;

public class MusicStore {

	private static MusicStore single = new MusicStore();
	
	public static MusicStore get() {
		return single;
	}
	
	public InputStream getStream(String ref) {
		return this.getClass().getClassLoader().getResourceAsStream(ref);
	}
}
