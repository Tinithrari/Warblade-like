package entities.enemyEntities;

import java.util.ArrayList;

import org.jsfml.audio.Sound;

import entities.allyEntities.PlayerEntity;
import entities.bonusEntities.DoubleShotBonusEntity;
import entities.bonusEntities.ShieldBonusEntity;
import entityManager.GameScene;
import shoot.AlienShootStrategy;
import store.SoundStore;
import movement.BonusMovement;
import movement.Movement;

/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class AlienEntity extends EnemyEntity {
	
	private GameScene gameScene;
	private AlienShootStrategy attack;
	private Sound player;
	
	public AlienEntity(GameScene gameScene,String ref, Movement strategy, AlienShootStrategy attack) {
		super(ref,strategy);
		this.gameScene = gameScene;
		this.attack = attack;
		player = new Sound();
	}
	
	public void doLogic() {
		getMoveStrategy().doLogic();
	}
	
	public void fire() {
		ArrayList<AlienShotEntity> shot = attack.tryToFire(gameScene, getX(), getY());
		
		if (shot != null)
		{
			for (int i = 0; i < shot.size();i++)
			{
				gameScene.getLevel().getEnemyEntities().add(shot.get(i));
				player.setBuffer(SoundStore.get().getSound("sound/laser.wav"));
				player.setVolume(50);
				player.play();
			}
		}
	}


	public void collidedWith(PlayerEntity other) {
		gameScene.getRemoveList().add(other);
	}

	@Override
	public void drop() {
		int chance = (int) (Math.random() * 11);
		
		if (chance == 10)
			gameScene.addBonus(new ShieldBonusEntity(gameScene, "sprites/shieldbonus.png", new BonusMovement(getX(), getY())));
		
		chance = (int) (Math.random() * 51);
		
		if (chance == 50)
			gameScene.addBonus(new DoubleShotBonusEntity(gameScene, "sprites/doubleshotbonus.png", new BonusMovement(getX(), getY())));
	}
}