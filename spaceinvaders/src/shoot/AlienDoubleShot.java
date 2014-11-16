package shoot;

import java.util.ArrayList;

import movement.enemyMovement.AlienSimpleShotMovement;
import entities.enemyEntities.AlienShotEntity;
import entityManager.GameScene;

public class AlienDoubleShot implements AlienShootStrategy {

	private long lastFire;
	private int firingInterval;
	
	public AlienDoubleShot() {
		lastFire = System.currentTimeMillis();
		firingInterval = (int) (Math.random() * 10000) + 2000;
	}

	@Override
	public ArrayList<AlienShotEntity> tryToFire(GameScene g, float x, float y) {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return null;
		}
		
		ArrayList<AlienShotEntity> shot = new ArrayList<AlienShotEntity>();
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		AlienShotEntity bullet = new AlienShotEntity(g,"sprites/aliendoubleshot.png",new AlienSimpleShotMovement(x+30,y+30));
		shot.add(bullet);
		bullet = new AlienShotEntity(g,"sprites/aliendoubleshot.png",new AlienSimpleShotMovement(x-10,y+30));
		shot.add(bullet);
		return shot;
	}

}
