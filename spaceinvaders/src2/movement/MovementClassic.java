package movement;

public class MovementClassic extends MovementAbstract{
	
	public MovementClassic(double x, double y) {
		super(x,y);
		setDx(75);
	}

	@Override
	public void move(long delta) {
		setX(getX() + ((delta * getDx()) / 1000));
	}

	@Override
	public void doLogic() {
		setDx(-getDx());
		setY(getY()+10);
	}

}
