package level;

import movement.enemyMovement.CircularMovement;
import shoot.AlienSimpleShot;
import entities.enemyEntities.AlienEntity;
import entityManager.GameScene;

public class Level3 extends Level {

	public Level3(GameScene gameScene) {
		super(gameScene);
		initEnemy();
	}

	@Override
	public void initEnemy() {
		for (int i = 0; i < 15; i++)
		{
			getEnemyEntities().add(new AlienEntity(getGameScene(), "sprites/alien.png", new CircularMovement(-50 + (i*(-50)), 100), new AlienSimpleShot()));
		}
		setNbEnemy(15);
	}

	@Override
	public void processEvent() {
		if (getNbEnemy() == 0)
			getGameScene().setLevel(new Level4(getGameScene()));
	}

	@Override
	public void updateLogic() {
		
	}

}
