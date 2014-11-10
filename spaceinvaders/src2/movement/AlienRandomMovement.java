package movement;

public class AlienRandomMovement extends MovementAbstract {

	private double delta;
	private double intervalle;
	private double lastInvoke;
	
	public AlienRandomMovement(double x, double y) {
		super(x, y);
		intervalle = Math.random() * 1000;
		
		setDx(((Math.random() * 300) - 150));
		setDy(((Math.random() * 30) - 150));
		
		lastInvoke = System.currentTimeMillis();
	}

	@Override
	public void move(long time) {
		delta = System.currentTimeMillis() - lastInvoke;
		
		if (delta > intervalle)
		{
			intervalle = Math.random() * 1000;
			
			this.setDx(((Math.random() * 300) - 150));
			this.setDy(((Math.random() * 300) - 150));
			
			lastInvoke = System.currentTimeMillis();
		}
		
		setX(getX() + ((time * getDx()) / 1000));
		setY(getY() + ((time * getDy()) / 1000));

	}

	@Override
	public void doLogic() {
		if (getX() < 10 || getX() > 750)
			setDx(-getDx());
		setDy(-getDy());
	}

}
