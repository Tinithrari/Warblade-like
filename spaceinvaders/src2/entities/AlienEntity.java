package entities;

import java.util.ArrayList;

import shoot.AlienShootStrategy;
import movement.Movement;
import base.Application;

/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class AlienEntity extends EnemyEntity {
	/** The speed at which the alient moves horizontally */
	/** The game in which the entity exists */
	private Application game;
	private AlienShootStrategy attack;
	
	/**
	 * Create a new alien entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The intial x location of this alien
	 * @param y The intial y location of this alient
	 */
	public AlienEntity(Application game,String ref, Movement strategy, AlienShootStrategy attack) {
		super(ref,strategy);
		this.game = game;
		this.attack = attack;
	}

	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// if we have reached the left hand side of the screen and
		// are moving left then request a logic update 
		if ((getMoveStrategy().getDx() < 0) && (getMoveStrategy().getX() < 10)) {
			game.updateLogic();
		}
		// and vice vesa, if we have reached the right hand side of 
		// the screen and are moving right, request a logic update
		if ((getMoveStrategy().getDx() > 0) && (getMoveStrategy().getX() > 750)) {
			game.updateLogic();
		}
		
		if ((getMoveStrategy().getDy() > 0) && (getMoveStrategy().getY() > 570))
			game.updateLogic();
		
		if ((getMoveStrategy().getDy() < 0) && (getMoveStrategy().getY() < sprite.getHeight()))
			game.updateLogic();
		
		// proceed with normal move
		getMoveStrategy().move(delta);
	}
	
	/**
	 * Update the game logic related to aliens
	 */

	public void doLogic() {
		// swap over horizontal movement and move down the
		// screen a bit
		getMoveStrategy().doLogic();
		
		// if we've reached the bottom of the screen then the player
		// dies
		if (getMoveStrategy().getY() > 570) {
			game.notifyDeath();
		}
	}
	
	public void fire() {
		ArrayList<AlienShotEntity> shot = attack.tryToFire(game, getX(), getY());
		
		if (shot != null)
		{
			for (int i = 0; i < shot.size();i++)
			{
				game.getEnemyEntities().add(shot.get(i));
			}
		}
	}
	
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(PlayersEntity other) {
		// collisions with aliens are handled elsewhere
	}
}