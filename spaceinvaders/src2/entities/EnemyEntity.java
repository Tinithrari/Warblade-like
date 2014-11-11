package entities;

import movement.Movement;

public abstract class EnemyEntity extends Entity {

	public EnemyEntity(String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(PlayersEntity other);
	public abstract void fire();
	public boolean isABullet() {
		return false;
	}
}
