package movement.allyMovement;

import entities.allyEntities.ShipEntity;
import movement.Movement;

public class ShieldMovement extends Movement {

	private ShipEntity ship;
	
	public ShieldMovement(ShipEntity ship, float x, float y) {
		super(x, y);
		this.ship = ship;
	}

	@Override
	public void move(long delta) {
		setX(ship.getX() - 25);
		setY(ship.getY() - 12);
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

}
