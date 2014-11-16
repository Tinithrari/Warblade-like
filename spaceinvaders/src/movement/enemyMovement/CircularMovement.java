package movement.enemyMovement;

import movement.Movement;

public class CircularMovement extends Movement {

	private boolean circle = false;
	
	public CircularMovement(float x, float y) {
		super(x, y);
		setDx(300);
	}

	@Override
	public void move(long delta) {
		if (circle)
		{
			float tmpX = getX();
			float tmpY = getY();
			float resX, resY;
			
			resX = (float) (((tmpX - 400)*Math.cos(0.04) - (tmpY - 200)*Math.sin(0.04)) + 400);
			resY = (float) (((tmpX - 400)*Math.sin(0.04) + (tmpY - 200)*Math.cos(0.04)) + 200);
			
			//On applique les modifications.
			setX(resX);
			setY(resY);
		}
		else
		{
			setX(getX() + ((delta * getDx()) / 1000));
			if (getX() >= 400)
				circle = true;
		}
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

}
