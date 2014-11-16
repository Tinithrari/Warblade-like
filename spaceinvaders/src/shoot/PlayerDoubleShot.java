package shoot;

import java.util.ArrayList;

import movement.allyMovement.PlayerSimpleShotMovement;
import entities.allyEntities.PlayerShotEntity;
import entityManager.GameScene;

public class PlayerDoubleShot implements PlayerShootStrategy {
	
	private long lastFire;
	private int firingInterval = 400;

	public PlayerDoubleShot() {
		lastFire = System.currentTimeMillis();
	}

	@Override
	public ArrayList<PlayerShotEntity> tryToFire(GameScene gameScene, float x, float y) {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return null;
		}
		ArrayList<PlayerShotEntity> shot = new ArrayList<PlayerShotEntity>();
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		PlayerShotEntity bullet = new PlayerShotEntity(gameScene,"sprites/doubleshot.png",new PlayerSimpleShotMovement(x+20,y-15), 20);
		shot.add(bullet);
		bullet = new PlayerShotEntity(gameScene,"sprites/doubleshot.png",new PlayerSimpleShotMovement(x+10,y-15), 20);
		shot.add(bullet);
		return shot;
	}

}
