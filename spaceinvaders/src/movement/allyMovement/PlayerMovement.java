package movement.allyMovement;

import movement.Movement;

public class PlayerMovement extends Movement {

	private float speed = 300;
	
	public PlayerMovement(float x, float y) {
		super(x, y);
		setDx(0);
	}

	@Override
	public void move(long delta) {
		if ((getDx() < 0) && (getX() < 0)) {
			return;
		}

		if ((getDx() > 0) && (getX() > 750)) {
			return;
		}
		setX(getX() + ((delta * getDx()) / 1000));
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	

}
