package level;

import shoot.BlackShipDoubleShot;
import movement.enemyMovement.SemiCircularMovement;
import entities.enemyEntities.BlackShip;
import entityManager.GameScene;

public class Level5 extends Level {

	public Level5(GameScene gameScene) {
		super(gameScene);
		gameScene.setMusic("music/bossmusic.ogg");
		initEnemy();
	}

	@Override
	public void initEnemy() {
		getEnemyEntities().add(new BlackShip(getGameScene(), "sprites/boss1.png", new SemiCircularMovement(300,-200), new BlackShipDoubleShot()));
		setNbEnemy(1);
	}

	@Override
	public void processEvent() {
		if (getNbEnemy() == 0)
			getGameScene().setLevel(null);
	}

	@Override
	public void updateLogic() {
		// TODO Auto-generated method stub

	}

}
