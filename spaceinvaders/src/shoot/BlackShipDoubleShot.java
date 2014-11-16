package shoot;

import java.util.ArrayList;

import movement.enemyMovement.AlienSimpleShotMovement;
import entities.enemyEntities.AlienShotEntity;
import entityManager.GameScene;

public class BlackShipDoubleShot implements AlienShootStrategy {

	private long lastFire;
	private int firingInterval;
	
	public BlackShipDoubleShot() {
		lastFire = System.currentTimeMillis();
		firingInterval = 333;
	}

	@Override
	public ArrayList<AlienShotEntity> tryToFire(GameScene g, float x, float y) {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return null;
		}
		
		ArrayList<AlienShotEntity> shot = new ArrayList<AlienShotEntity>();
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		AlienShotEntity bullet = new AlienShotEntity(g,"sprites/aliendoubleshot.png",new AlienSimpleShotMovement(x+110,y+171));
		shot.add(bullet);
		bullet = new AlienShotEntity(g,"sprites/aliendoubleshot.png",new AlienSimpleShotMovement(x+70,y+171));
		shot.add(bullet);
		return shot;
	}

}
