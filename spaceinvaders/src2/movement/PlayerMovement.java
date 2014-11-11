package movement;

public class PlayerMovement extends AbstractMovement {

	public PlayerMovement(double x, double y) {
		super(x, y);
		setDx(0);
	}

	@Override
	public void move(long delta) {
		setX(getX() + ((delta * getDx()) / 1000));

	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

}
