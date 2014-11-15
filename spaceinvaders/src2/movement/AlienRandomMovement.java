package movement;

public class AlienRandomMovement extends Movement {

	private long delta;
	private float intervalle;
	private long lastInvoke;
	
	public AlienRandomMovement(float x, float y) {
		super(x, y);
		intervalle = (float) (Math.random() * 1000);
		
		setDx((float) ((Math.random() * 300) - 150));
		setDy((float) ((Math.random() * 300) - 150));
		
		lastInvoke = System.currentTimeMillis();
	}

	@Override
	public void move(long time) {
		delta = System.currentTimeMillis() - lastInvoke;
		
		//System.out.println(getX() < 0 || getX() > 750 || getY() < 0 || getY() > 550 );
		
		if (getX() < 0 || getX() > 750 || getY() < 0 || getY() > 550)
			doLogic();
		if (delta > intervalle)
		{
			intervalle = (float) (Math.random() * 1000);
			
			this.setDx((float) ((Math.random() * 300) - 150));
			this.setDy((float) ((Math.random() * 300) - 150));
			
			lastInvoke = System.currentTimeMillis();
		}
		
		setX((float)(getX() + ((time * getDx()) / 1000)));
		setY((float)(getY() + ((time * getDy()) / 1000)));
	}

	@Override
	public void doLogic() {
		setDy(-getDy());
		setDx(-getDx());
	}

}
