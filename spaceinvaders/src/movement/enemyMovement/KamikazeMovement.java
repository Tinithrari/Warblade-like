package movement.enemyMovement;

import movement.Movement;

public class KamikazeMovement extends Movement {
	
	public KamikazeMovement(float x, float y) {
		super(x, y);
		setDy(250);
	}

	@Override
	public void move(long delta) {
		setY(getY() + ((delta * getDy()) / 1000));

		if (getY() > 500)
			doLogic();
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		setDy(- getDy());
	}

}
