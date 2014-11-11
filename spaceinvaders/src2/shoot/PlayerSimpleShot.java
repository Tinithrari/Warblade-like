package shoot;

import java.util.ArrayList;

import base.Application;
import movement.PlayerSimpleShotMovement;
import entities.PlayerShotEntity;

public class PlayerSimpleShot implements PlayerShootStrategy {

	/** The time at which last fired a shot */
	private long lastFire = 0;
	/** The interval between our players shot (ms) */
	private long firingInterval = 500;
	
	public PlayerSimpleShot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<PlayerShotEntity> tryToFire(Application g, double x, double y) {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return null;
		}
		ArrayList<PlayerShotEntity> shot = new ArrayList<PlayerShotEntity>();
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		PlayerShotEntity bullet = new PlayerShotEntity(g,"sprites/shot.gif",new PlayerSimpleShotMovement(x+10,y-30));
		shot.add(bullet);
		return shot;

	}

}
