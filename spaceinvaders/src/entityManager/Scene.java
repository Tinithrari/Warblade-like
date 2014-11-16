package entityManager;

import org.jsfml.graphics.RenderWindow;

import window.Application;

public interface Scene{
	public void processEvent(Application app);
	public void update(long delta);
	public void render(RenderWindow renderer);
}
