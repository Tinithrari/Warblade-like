package entities.enemyEntities;

import entities.Entity;
import entities.allyEntities.PlayerEntity;
import movement.Movement;

public abstract class EnemyEntity extends Entity {

	private int lP = 10;
	
	public EnemyEntity(String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void collidedWith(PlayerEntity other);
	public abstract void fire();
	public abstract void drop();
	public boolean isNotAMonster() {
		return false;
	}

	public int getlP() {
		return lP;
	}

	public void setlP(int lP) {
		this.lP = lP;
	}
	
	
}
