package movement;

import level.Level;

public class ClassicMovement extends Movement{
	
	private Level level;
	
	public ClassicMovement(float x, float y, Level level) {
		super(x,y);
		this.level = level;
		setDx(75);
	}

	@Override
	public void move(long delta) {
		if ((getDx() < 0) && (getX() < 10)) {
			level.updateLogic();
		}
		if ((getDx() > 0) && (getX() > 750)) {
			level.updateLogic();
		}
		
		setX(getX() + ((delta * getDx()) / 1000));
	}

	@Override
	public void doLogic() {
		setDx(-getDx());
		setY(getY()+10);
	}

}
