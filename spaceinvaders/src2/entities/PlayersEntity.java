package entities;

import movement.Movement;

public abstract class PlayersEntity extends Entity {

	public PlayersEntity(String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(EnemyEntity other);
}
