package entities;

import entityManager.GameScene;
import movement.Movement;

public class AlienShotEntity extends EnemyEntity {

	private GameScene gameScene;
	private boolean used = false;
	
	public AlienShotEntity(GameScene gameScene, String ref, Movement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
		this.gameScene =  gameScene;
	}

	@Override
	public void collidedWith(PlayerEntity other) {
		if (used) {
			return;
		}
		
		gameScene.removeEntity(this);
		gameScene.removeEntity(other);
		
		used = true;
		
	}

	@Override
	public void move(long delta) {
		super.move(delta);
		// if we shot off the screen, remove ourselfs
		if (getMoveStrategy().getY() > 600 + 100) {
			gameScene.removeEntity(this);
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
	public boolean isNotAMonster() {
		// TODO Auto-generated method stub
		return true;
	}

}
