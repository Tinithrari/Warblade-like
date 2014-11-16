package entities.enemyEntities;

import java.util.ArrayList;

import org.jsfml.audio.Sound;

import entities.allyEntities.PlayerEntity;
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
	/** The speed at which the alient moves horizontally */
	/** The game in which the entity exists */
	private GameScene gameScene;
	private AlienShootStrategy attack;
	private Sound player;
	
	/**
	 * Create a new alien entity
	 * 
	 * @param gameScene The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The intial x location of this alien
	 * @param y The intial y location of this alient
	 */
	public AlienEntity(GameScene gameScene,String ref, Movement strategy, AlienShootStrategy attack) {
		super(ref,strategy);
		this.gameScene = gameScene;
		this.attack = attack;
		player = new Sound();
	}

	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		super.move(delta);
	}
	
	/**
	 * Update the game logic related to aliens
	 */

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
				player.play();
			}
		}
	}
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(PlayerEntity other) {
		gameScene.getRemoveList().add(other);
	}

	@Override
	public void drop() {
		int chance = (int) (Math.random() * 11);
		
		if (chance == 10)
			gameScene.addBonus(new ShieldBonusEntity(gameScene, "sprites/shieldbonus.png", new BonusMovement(getX(), getY())));
	}
}