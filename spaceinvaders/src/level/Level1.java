package level;

import shoot.AlienSimpleShot;
import movement.enemyMovement.AlienRandomMovement;
import movement.enemyMovement.ClassicMovement;
import entities.enemyEntities.AlienEntity;
import entities.enemyEntities.EnemyEntity;
import entityManager.GameScene;

public class Level1 extends Level {

	private boolean moveChanged = false;

	public Level1(GameScene gameScene) {
		super(gameScene);
	}

	@Override
	public void initEnemy() {
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				EnemyEntity alien = new AlienEntity(getGameScene(),"sprites/alien.png",new ClassicMovement(100+(x*50),(50)+row*30, this), new AlienSimpleShot());
				getEnemyEntities().add(alien);
			}
		}
		setNbEnemy(30);
	}

	@Override
	public void processEvent() {
		
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
			getGameScene().setLevel(new Level2(getGameScene()));
		}
	}

	@Override
	public void updateLogic() {
		for (int i = 0; i < getEnemyEntities().size(); i++)
		{
			getEnemyEntities().get(i).doLogic();
		}
	}

	@Override
	public void notifyEnemyKilled() {
		// TODO Auto-generated method stub
		super.notifyEnemyKilled();
		if (getNbEnemy() > 5)
		{
			for(EnemyEntity entity : getEnemyEntities()) 
			{
				if (!entity.isNotAMonster())
				{
					entity.setHorizontalMovement((float) (entity.getHorizontalMovement() * 1.02));
				}
			}
		}
	}
}
