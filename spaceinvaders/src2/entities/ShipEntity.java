package entities;

import java.util.ArrayList;

import movement.Movement;
import base.Application;
import shoot.PlayerShootStrategy;
import shoot.PlayerSimpleShot;

/**
 * The entity that represents the players ship
 * 
 * @author Kevin Glass
 */
public class ShipEntity extends PlayersEntity {
	/** The game in which the ship exists */
	private Application game;
	private PlayerShootStrategy shootStrategy;
	
	/**
	 * Create a new entity to represent the players ship
	 *  
	 * @param game The game in which the ship is being created
	 * @param ref The reference to the sprite to show for the ship
	 * @param strategy TODO
	 */
	public ShipEntity(Application game,String ref,Movement strategy) {
		super(ref,strategy);
		
		this.game = game;
		
		shootStrategy = new PlayerSimpleShot();
	}
	
	/**
	 * Request that the ship move itself based on an elapsed ammount of
	 * time
	 * 
	 * @param delta The time that has elapsed since last move (ms)
	 */
	public void move(long delta) {
		// if we're moving left and have reached the left hand side
		// of the screen, don't move
		if ((getMoveStrategy().getDx() < 0) && (getMoveStrategy().getX() < 10)) {
			return;
		}
		// if we're moving right and have reached the right hand side
		// of the screen, don't move
		if ((getMoveStrategy().getDx() > 0) && (getMoveStrategy().getX() > 750)) {
			return;
		}
		
		super.move(delta);
	}
	
	public void tryToFire(){
		ArrayList<PlayerShotEntity> shot = shootStrategy.tryToFire(game, getMoveStrategy().getX(), getMoveStrategy().getY());
		
		if (shot != null)
		{
			for (int i = 0; i < shot.size(); i++)
				game.getPlayersEntities().add(shot.get(i));
		}
	}
	
	
	/**
	 * Notification that the player's ship has collided with something
	 * 
	 * @param other The entity with which the ship has collided
	 */
	public void collidedWith(EnemyEntity other) {
		// if its an alien, notify the game that the player
		// is dead
		if (other instanceof AlienEntity) {
			game.notifyDeath();
		}
	}

    @Override
    public void doLogic() {
        // FIXME Auto-generated method stub
        
    }
}