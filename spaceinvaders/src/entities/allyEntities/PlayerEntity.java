package entities.allyEntities;

import entities.Entity;
import entities.enemyEntities.EnemyEntity;
import movement.Movement;

public abstract class PlayerEntity extends Entity {

	public PlayerEntity(String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(EnemyEntity other);
}
