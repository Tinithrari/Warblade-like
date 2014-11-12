package entityManager;

import java.awt.Canvas;

public abstract class Scene extends Canvas{
	public abstract void processEvent();
	public abstract void update(long delta);
	public abstract void render();
}
