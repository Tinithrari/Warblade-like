package level;

import shoot.AlienSimpleShot;
import movement.AlienRandomMovement;
import movement.LeftToRightMovement;
import entities.AlienEntity;
import entities.EnemyEntity;
import entityManager.GameScene;

public class Level2 extends Level {

	private GameScene gameScene;
	private boolean moveChanged = false;
	
	public Level2(GameScene gameScene) {
		this.gameScene = gameScene;
		initEnemy();
	}

	@Override
	public void initEnemy() {
		for (int i = 0; i <= 20; i++)
		{
			getEnemyEntities().add(new AlienEntity(gameScene, "sprites/alien.png", new LeftToRightMovement(-50 + (i*(-50)), 50), new AlienSimpleShot()));
		}
		setNbEnemy(20);
	}

	@Override
	public void processEvent() {
		// TODO Auto-generated method stub

		if (getNbEnemy() == 5 && !moveChanged) {
			for(EnemyEntity entity : getEnemyEntities()) 
			{
				if (! entity.isNotAMonster()){
					entity.setMoveStrategy(new AlienRandomMovement(entity.getMoveStrategy().getX(), entity.getMoveStrategy().getY()));
					moveChanged = true;
				}
			}
		}
		
		if (getNbEnemy() == 0)
		{
			gameScene.setLevel(null);
		}
	}

	@Override
	public void update(long delta) {
		// TODO Auto-generated method stub
		for (int i = 0; i < getEnemyEntities().size(); i++)
		{
			getEnemyEntities().get(i).move(delta);
			getEnemyEntities().get(i).fire();
		}	
	}

	@Override
	public void updateLogic() {
		// TODO Auto-generated method stub

	}

}
