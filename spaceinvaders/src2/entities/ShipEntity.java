package entities;

import movement.MovementAbstract;
import base.Game;

/**
 * The entity that represents the players ship
 * 
 * @author Kevin Glass
 */
public class ShipEntity extends Entity {
	/** The game in which the ship exists */
	private Game game;
	
	/**
	 * Create a new entity to represent the players ship
	 *  
	 * @param game The game in which the ship is being created
	 * @param ref The reference to the sprite to show for the ship
	 * @param strategy TODO
	 */
	public ShipEntity(Game game,String ref,MovementAbstract strategy) {
		super(ref,strategy);
		
		this.game = game;
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
	
	/**
	 * Notification that the player's ship has collided with something
	 * 
	 * @param other The entity with which the ship has collided
	 */
	public void collidedWith(Entity other) {
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