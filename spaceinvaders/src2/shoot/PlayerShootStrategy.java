package shoot;

import java.util.ArrayList;

import base.Application;
import entities.PlayerShotEntity;

public interface PlayerShootStrategy{
	public ArrayList<PlayerShotEntity> tryToFire(Application g, double x, double y);
}
