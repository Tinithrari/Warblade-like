package entities;

import movement.AbstractMovement;

public abstract class EnemyEntity extends Entity {

	public EnemyEntity(String ref, AbstractMovement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(PlayersEntity other);
}
