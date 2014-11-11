package shoot;

import java.util.ArrayList;

import base.Game;
import entities.PlayerShotEntity;

public interface ShootStrategy{
	public ArrayList<PlayerShotEntity> tryToFire(Game g, double x, double y);
}
