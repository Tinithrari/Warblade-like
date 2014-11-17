package entities.enemyEntities;

import java.util.ArrayList;

import org.jsfml.audio.Sound;

import shoot.AlienShootStrategy;
import store.SoundStore;
import movement.Movement;
import entities.allyEntities.PlayerEntity;
import entityManager.GameScene;

public class BlackShip extends EnemyEntity {
	
	private GameScene gameScene;
	private AlienShootStrategy attack;
	private Sound player;
	
	public BlackShip(GameScene gameScene, String ref, Movement strategy, AlienShootStrategy attack) {
		super(ref, strategy);
		player = new Sound();
		player.setBuffer(SoundStore.get().getSound("sound/doublelaseralien.wav"));
		player.setVolume(50.0f);
		this.gameScene = gameScene;
		this.attack = attack;
		this.setlP(2200);
	}

	@Override
	public void collidedWith(PlayerEntity other) {
	}

	@Override
	public void fire() {
		if (getY() >= 250)
		{
			ArrayList<AlienShotEntity> shot = attack.tryToFire(gameScene, getX(), getY());
			
			if (shot != null)
			{
				for (int i = 0; i < shot.size();i++)
				{
					gameScene.getLevel().getEnemyEntities().add(shot.get(i));
					player.play();
				}
			}
		}
		int alea = (int) (Math.random() * 11);
		
		if (alea == 10)
		{
			ArrayList<AlienShotEntity> shot = attack.tryToFire(gameScene, getX(), getY());
			
			if (shot != null)
			{
				for (int i = 0; i < shot.size();i++)
				{
					gameScene.getLevel().getEnemyEntities().add(shot.get(i));
					player.setBuffer(SoundStore.get().getSound("sound/doublelaseralien.wav"));
					player.play();
				}
			}
		}
	}

	@Override
	public void drop() {
		// TODO Pour plus tard

	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

}
