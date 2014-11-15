package entities;

import movement.Movement;

public abstract class PlayerEntity extends Entity {

	public PlayerEntity(String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(EnemyEntity other);
}
