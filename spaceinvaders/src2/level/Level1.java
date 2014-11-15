package level;

import org.jsfml.graphics.RenderWindow;

import shoot.AlienSimpleShot;
import movement.AlienRandomMovement;
import movement.ClassicMovement;
import entities.AlienEntity;
import entities.EnemyEntity;
import entityManager.GameScene;

public class Level1 extends Level {

	private boolean moveChanged = false;
	
	private GameScene gameScene;

	public Level1(GameScene gameScene) {
		this.gameScene = gameScene;
	}

	@Override
	public void initEnemy() {
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				EnemyEntity alien = new AlienEntity(gameScene,"sprites/alien.png",new ClassicMovement(100+(x*50),(50)+row*30, this), new AlienSimpleShot());
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
				if (! entity.isABullet()){
					entity.setMoveStrategy(new AlienRandomMovement(entity.getMoveStrategy().getX(), entity.getMoveStrategy().getY(), this));
					moveChanged = true;
				}
			}
		}
		
		//TODO nb ennemis à 0
		if (getNbEnemy() == 0)
		{
			System.exit(0);
		}
	}

	@Override
	public void update(long delta) {
		
		for (int i = 0; i < getEnemyEntities().size(); i++)
		{
			getEnemyEntities().get(i).move(delta);
			getEnemyEntities().get(i).fire();
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
				entity.setHorizontalMovement((float) (entity.getHorizontalMovement() * 1.02));
			}
		}
	}

	
}
