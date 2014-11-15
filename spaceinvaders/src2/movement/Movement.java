package movement;

import level.Level;

public abstract class Movement {

	private float x;
	private float y;
	private float dx;
	private float dy;
	private Level level;
	
	public Movement(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void move(long delta);
	public abstract void doLogic();

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
}
