package movement;

public class PlayerMovement extends Movement {

	private double speed = 300;
	
	public PlayerMovement(double x, double y) {
		super(x, y);
		setDx(0);
	}

	@Override
	public void move(long delta) {
		setX(getX() + ((delta * getDx()) / 1000));

	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	

}
