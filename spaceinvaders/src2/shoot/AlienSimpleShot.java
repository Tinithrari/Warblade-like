package shoot;

import java.util.ArrayList;

import movement.AlienSimpleShotMovement;
import base.Application;
import entities.AlienShotEntity;

public class AlienSimpleShot implements AlienShootStrategy {

	private double lastFire = System.currentTimeMillis();
	private int firingInterval = (int) (Math.random() * 15000) + 2000;
	
	public AlienSimpleShot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<AlienShotEntity> tryToFire(Application g, double x, double y) {
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
