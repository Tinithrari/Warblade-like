package shoot;

import java.util.ArrayList;

import entities.AlienShotEntity;
import entityManager.GameScene;

public interface AlienShootStrategy {
	public ArrayList<AlienShotEntity> tryToFire(GameScene g, float x, float y);
}