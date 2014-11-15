package shoot;

import java.util.ArrayList;

import movement.AlienSimpleShotMovement;
import base.Deprecated;
import entities.AlienShotEntity;
import entityManager.GameScene;

public class AlienSimpleShot implements AlienShootStrategy {

	private long lastFire;
	private int firingInterval;
	
	public AlienSimpleShot() {
		lastFire = System.currentTimeMillis();
		firingInterval = (int) (Math.random() * 15000) + 2000;
	}

	@Override
	public ArrayList<AlienShotEntity> tryToFire(GameScene g, float x, float y) {
		
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return null;
		}
		
		ArrayList<AlienShotEntity> shot = new ArrayList<AlienShotEntity>();
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		AlienShotEntity bullet = new AlienShotEntity(g,"sprites/shot.gif",new AlienSimpleShotMovement(x+10,y+30));
		shot.add(bullet);
		return shot;
	}

}
