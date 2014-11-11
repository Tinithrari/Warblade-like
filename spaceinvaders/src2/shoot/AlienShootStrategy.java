package shoot;

import java.util.ArrayList;

import base.Application;
import entities.AlienShotEntity;

public interface AlienShootStrategy {
	public ArrayList<AlienShotEntity> tryToFire(Application g, double x, double y);
}
