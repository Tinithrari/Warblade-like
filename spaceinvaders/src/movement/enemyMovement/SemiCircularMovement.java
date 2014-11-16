package movement.enemyMovement;

import movement.Movement;

public class SemiCircularMovement extends Movement{

	private boolean semiCircle = false;
	private boolean left = true;
	private boolean right = false;
	private boolean inWait = true;
	private long waitTime = 1200;
	private long lastWaitTime;
	
	public SemiCircularMovement(float x, float y) {
		super(x, y);
		setDy(50);
	}

	@Override
	public void move(long delta) {
		if (semiCircle)
		{
			if (inWait)
			{
				long lastLoop = System.currentTimeMillis();
				
				if (lastLoop - lastWaitTime > waitTime)
				{
					inWait = false;
				}
			}
			if (!inWait)
			{
				float tmpX = getX();
				float tmpY = getY();
				float resX, resY;
				
				if (right)
				{
					resX = (float) (((tmpX - 300)*Math.cos(0.04) - (tmpY - 300)*Math.sin(0.04)) + 300);
					resY = (float) (((tmpX - 300)*Math.sin(0.04) + (tmpY - 300)*Math.cos(0.04)) + 300); 
					//On applique les modifications.
					setX(resX);
					setY(resY);
				}
				
				if (left)
				{
					tmpX = getX();
					tmpY = getY();
	
					resX = (float) (((tmpX - 300)*Math.cos(0.04) + (tmpY - 300)*Math.sin(0.04)) + 300);
					resY = (float) (((tmpX - 300)*(-Math.sin(0.04)) + (tmpY - 300)*Math.cos(0.04)) + 300);
					
					//On applique les modifications.
					setX(resX);
					setY(resY);
				}
				if (getY() >= 250)
				{
					left = !left;
					right = !right;
					inWait = true;
					lastWaitTime = System.currentTimeMillis();
				}
			}
		}
		else 
		{
			setY(getY() + ((delta * getDy()) / 1000));
			if (getY() >= 0)
				semiCircle = true;
		}
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}

}
