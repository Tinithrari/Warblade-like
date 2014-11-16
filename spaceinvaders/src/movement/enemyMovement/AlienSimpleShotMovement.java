package movement.enemyMovement;

import movement.Movement;

public class AlienSimpleShotMovement extends Movement {

	public AlienSimpleShotMovement(float x, float y) {
		super(x, y);
		this.setDy(300);
	}

	@Override
	public void move(long delta) {
		setY(getY() + ((delta * getDy()) / 1000));

	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

}
