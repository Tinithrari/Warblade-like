package movement;

public class BonusMovement extends Movement {

	public BonusMovement(float x, float y) {
		super(x, y);
		setDy(75);
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
