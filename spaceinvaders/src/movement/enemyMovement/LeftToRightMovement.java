package movement.enemyMovement;

import movement.Movement;

public class LeftToRightMovement extends Movement {
	
	public LeftToRightMovement(float x, float y) {
		super(x, y);
		setDx(150);
	}

	@Override
	public void move(long delta) {
		setX(getX() + ((delta * getDx()) / 1000));
		if (getX() > 800)
			doLogic();
	}

	@Override
	public void doLogic() {
		setX(-50);
	}

}
