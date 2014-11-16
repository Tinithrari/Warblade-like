package entities.bonusEntities;

import movement.Movement;
import entities.Entity;
import entities.allyEntities.ShipEntity;

public abstract class BonusEntities extends Entity {

	public BonusEntities(String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

	public abstract void collidedWith(ShipEntity other);
}
