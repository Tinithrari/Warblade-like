package entityManager;

import org.jsfml.graphics.RenderWindow;

public interface Scene{
	public void processEvent();
	public void update(long delta);
	public void render(RenderWindow renderer);
}
