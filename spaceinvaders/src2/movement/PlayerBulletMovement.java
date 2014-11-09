package movement;

public class PlayerBulletMovement extends MovementAbstract {

	public PlayerBulletMovement(double x, double y) {
		super(x, y);
		this.setDy(-300);
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
