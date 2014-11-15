package shoot;

import java.util.ArrayList;

import base.Deprecated;
import entities.PlayerShotEntity;
import entityManager.GameScene;

public interface PlayerShootStrategy{
	public ArrayList<PlayerShotEntity> tryToFire(GameScene gameScene, float x, float y);
}
