package entities;

import base.Application;
import movement.Movement;

public class AlienShotEntity extends EnemyEntity {

	private Application game;
	private boolean used = false;
	
	public AlienShotEntity(Application game, String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
		this.game =  game;
	}

	@Override
	public void collidedWith(PlayersEntity other) {
		if (used) {
			return;
		}
		
		game.removeEntity(this);
		game.removeEntity(other);
		
		used = true;
		
	}

	@Override
	public void move(long delta) {
		// TODO Auto-generated method stub
		super.move(delta);
		// if we shot off the screen, remove ourselfs
		if (getMoveStrategy().getY() > game.getHeight() + 100) {
			game.removeEntity(this);
		}
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isABullet() {
		// TODO Auto-generated method stub
		return true;
	}

}
