package entities;

import java.util.ArrayList;

import org.jsfml.audio.Sound;

import entityManager.GameScene;
import movement.Movement;
import base.SoundStore;
import shoot.PlayerShootStrategy;
import shoot.PlayerSimpleShot;

/**
 * The entity that represents the players ship
 * 
 * @author Kevin Glass
 */
public class ShipEntity extends PlayerEntity {
	/** The game in which the ship exists */
	private GameScene gameScene;
	private PlayerShootStrategy shootStrategy;
	private Sound player;
	
	/**
	 * Create a new entity to represent the players ship
	 *  
	 * @param gameScene The game in which the ship is being created
	 * @param ref The reference to the sprite to show for the ship
	 * @param strategy TODO
	 */
	public ShipEntity(GameScene gameScene,String ref,Movement strategy) {
		super(ref,strategy);
		
		this.gameScene = gameScene;
		
		shootStrategy = new PlayerSimpleShot();
		
		player = new Sound();
	}
	
	/**
	 * Request that the ship move itself based on an elapsed ammount of
	 * time
	 * 
	 * @param delta The time that has elapsed since last move (ms)
	 */
	
	public void tryToFire(){
		ArrayList<PlayerShotEntity> shot = shootStrategy.tryToFire(gameScene, getMoveStrategy().getX(), getMoveStrategy().getY());
		
		if (shot != null)
		{
			for (int i = 0; i < shot.size(); i++)
			{
				gameScene.getPlayerEntities().add(shot.get(i));
				player.setBuffer(SoundStore.get().getSound("sound/laser1.wav"));
				player.play();
			}
		}
	}
	
	
	/**
	 * Notification that the player's ship has collided with something
	 * 
	 * @param other The entity with which the ship has collided
	 */
	public void collidedWith(EnemyEntity other) {
		// TODO gameScene.notifyDeath();
	}

    @Override
    public void doLogic() {
        // FIXME Auto-generated method stub
        
    }
}