package shoot;

import java.util.ArrayList;

import entities.allyEntities.PlayerShotEntity;
import entityManager.GameScene;

public interface PlayerShootStrategy{
	public ArrayList<PlayerShotEntity> tryToFire(GameScene gameScene, float x, float y);
}
