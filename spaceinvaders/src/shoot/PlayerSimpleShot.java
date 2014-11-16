package shoot;

import java.util.ArrayList;

import movement.allyMovement.PlayerSimpleShotMovement;
import entities.allyEntities.PlayerShotEntity;
import entityManager.GameScene;

public class PlayerSimpleShot implements PlayerShootStrategy {

	/** The time at which last fired a shot */
	private long lastFire = 0;
	/** The interval between our players shot (ms) */
	private long firingInterval = 500;
	
	public PlayerSimpleShot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<PlayerShotEntity> tryToFire(GameScene g, float x, float y) {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return null;
		}
		ArrayList<PlayerShotEntity> shot = new ArrayList<PlayerShotEntity>();
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		PlayerShotEntity bullet = new PlayerShotEntity(g,"sprites/shot.png",new PlayerSimpleShotMovement(x+15,y-15));
		shot.add(bullet);
		return shot;

	}

}
