package entities;

import movement.AbstractMovement;

public abstract class PlayersEntity extends Entity {

	public PlayersEntity(String ref, AbstractMovement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(EnemyEntity other);
}
