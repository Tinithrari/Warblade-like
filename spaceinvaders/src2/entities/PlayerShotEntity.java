package entities;

import movement.Movement;
import base.Application;

/**
 * An entity representing a shot fired by the player's ship
 * 
 * @author Kevin Glass
 */
public class PlayerShotEntity extends PlayersEntity {
	/** The vertical speed at which the players shot moves */
	/** The game in which this entity exists */
	private Application game;
	/** True if this shot has been "used", i.e. its hit something */
	private boolean used = false;
	
	/**
	 * Create a new shot from the player
	 * 
	 * @param game The game in which the shot has been created
	 * @param sprite The sprite representing this shot
	 * @param strategy TODO
	 */
	public PlayerShotEntity(Application game,String sprite,Movement strategy) {
		super(sprite,strategy);
		
		this.game = game;
	}

	/**
	 * Request that this shot moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// proceed with normal move
		super.move(delta);
		
		// if we shot off the screen, remove ourselfs
		if (getMoveStrategy().getY() < -100) {
			game.removeEntity(this);
		}
	}
	
	/**
	 * Notification that this shot has collided with another
	 * entity
	 * 
	 * @parma other The other entity with which we've collided
	 */
	public void collidedWith(EnemyEntity other) {
		// prevents double kills, if we've already hit something,
		// don't collide
		if (used) {
			return;
		}
		
		game.removeEntity(this);
		game.removeEntity(other);
		
		// notify the game that the alien has been killed
		if (!other.isABullet())
			game.notifyAlienKilled();
		used = true;
		
	}

    @Override
    public void doLogic() {
        // FIXME Auto-generated method stub
        
    }
}