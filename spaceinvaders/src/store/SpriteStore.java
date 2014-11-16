package store;

import java.io.IOException;
import java.util.HashMap;

import org.jsfml.graphics.Texture;

/**
 * A resource manager for sprites in the game. Its often quite important
 * how and where you get your game resources from. In most cases
 * it makes sense to have a central resource loader that goes away, gets
 * your resources and caches them for future use.
 * <p>
 * [singleton]
 * <p>
 * @author Kevin Glass
 */


//TODO Les aliens utilisent une même stratégie de mouvement
public class SpriteStore {
	/** The single instance of this class */
	private static SpriteStore single = new SpriteStore();
	
	/**
	 * Get the single instance of this class 
	 * 
	 * @return The single instance of this class
	 */
	public static SpriteStore get() {
		return single;
	}
	
	/** The cached sprite map, from reference to sprite instance */
	private HashMap<String,Texture> sprites = new HashMap<String,Texture>();
	
	/**
	 * Retrieve a sprite from the store
	 * 
	 * @param ref The reference to the image to use for the sprite
	 * @return A sprite instance containing an accelerate image of the request reference
	 */
	public Texture getSprite(String ref) {
		// if we've already got the sprite in the cache
		// then just return the existing version
		if (sprites.get(ref) == null) {
			try {
				Texture image = new Texture();
				image.loadFromStream(this.getClass().getClassLoader().getResourceAsStream(ref));
				sprites.put(ref, image);
			} catch (IOException e) {
				e.printStackTrace();
				fail("Loading error for : "  + ref);
			}
		}
		return (Texture) sprites.get(ref);
	}
	
	/**
	 * Utility method to handle resource loading failure
	 * 
	 * @param message The message to display on failure
	 */
	private void fail(String message) {
		// we're pretty dramatic here, if a resource isn't available
		// we dump the message and exit the game
		System.err.println(message);
		System.exit(0);
	}
}