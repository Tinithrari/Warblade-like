package level;

import java.util.ArrayList;

import movement.enemyMovement.KamikazeMovement;
import shoot.AlienSimpleShot;
import entities.enemyEntities.AlienEntity;
import entities.enemyEntities.EnemyEntity;
import entityManager.GameScene;

public class Level4 extends Level {
	
	private long lastWaveTime = 0;
	private int compteur = 0;
	private ArrayList<EnemyEntity> prepareEnemy;
	
	public Level4(GameScene gameScene) {
		super(gameScene);
		prepareEnemy = new ArrayList<EnemyEntity>();
		initEnemy();
	}

	@Override
	public void initEnemy() {
		int count = 0;
		int offset = 0;
		
		for (int i = 0; i < 20; i++)
		{
			prepareEnemy.add(new AlienEntity(getGameScene(), "sprites/alien.png", new KamikazeMovement(50*offset + (i*(25)), -50), new AlienSimpleShot()));
			count++;
			if (count % 5 == 0)
				offset++;
		}
		setNbEnemy(20);
	}

	@Override
	public void processEvent() {
		long currentTime = System.currentTimeMillis();
		
		if (currentTime - lastWaveTime > 6000)
		{
			for (int i = compteur * 5; i < (compteur+1) * 5; i++)
			{
				getEnemyEntities().add(prepareEnemy.get(i));
			}
			lastWaveTime = System.currentTimeMillis();
			compteur++;
		}
		for (EnemyEntity entity : getEnemyEntities())
		{
			if (entity.getY() <= -50 && entity.getVerticalMovement() < 0)
			{
				getGameScene().getRemoveList().add(entity);
				setNbEnemy(getNbEnemy() - 1);
			}
		}
		
		if (getNbEnemy() == 0)
			getGameScene().setLevel(new Level5(getGameScene()));
	}

	@Override
	public void updateLogic() {
		// TODO Auto-generated method stub

	}

}
