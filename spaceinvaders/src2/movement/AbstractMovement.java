package movement;

public abstract class AbstractMovement {

	private double x;
	private double y;
	private double dx;
	private double dy;
	
	public AbstractMovement(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void move(long delta);
	public abstract void doLogic();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}
	
	

}
