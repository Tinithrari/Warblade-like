package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import movement.MovementAbstract;
import base.Sprite;
import base.SpriteStore;

/**
 * An entity represents any element that appears in the game. The
 * entity is responsible for resolving collisions and movement
 * based on a set of properties defined either by subclass or externally.
 * 
 * Note that doubles are used for positions. This may seem strange
 * given that pixels locations are integers. However, using double means
 * that an entity can move a partial pixel. It doesn't of course mean that
 * they will be display half way through a pixel but allows us not lose
 * accuracy as we move.
 * 
 * @author Kevin Glass
 */
public abstract class Entity {
	
	protected Sprite sprite;
	/** The current speed of this entity horizontally (pixels/sec) */
	private MovementAbstract moveStrategy;
	/** The rectangle used for this entity during collisions  resolution */
	private Rectangle me = new Rectangle();
	/** The rectangle used for other entities during collision resolution */
	private Rectangle him = new Rectangle();
	
	/**
	 * Construct a entity based on a sprite image and a location.
	 * 
	 * @param ref The reference to the image to be displayed for this entity
	 * @param strategy TODO
	 */
	public Entity(String ref,MovementAbstract strategy) {
		this.sprite = SpriteStore.get().getSprite(ref);
		moveStrategy = strategy;
	}
	
	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 * 
	 * @param delta The ammount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		moveStrategy.move(delta);	
	}
	
	/**
	 * Set the horizontal speed of this entity
	 * 
	 * @param dx The horizontal speed of this entity (pixels/sec)
	 */
	public void setHorizontalMovement(double dx) {
		moveStrategy.setDx(dx);
	}

	/**
	 * Set the vertical speed of this entity
	 * 
	 * @param dx The vertical speed of this entity (pixels/sec)
	 */
	public void setVerticalMovement(double dy) {
		moveStrategy.setDy(dy);
	}
	
	/**
	 * Get the horizontal speed of this entity
	 * 
	 * @return The horizontal speed of this entity (pixels/sec)
	 */
	public double getHorizontalMovement() {
		return moveStrategy.getDx();
	}

	/**
	 * Get the vertical speed of this entity
	 * 
	 * @return The vertical speed of this entity (pixels/sec)
	 */
	public double getVerticalMovement() {
		return moveStrategy.getDy();
	}
	
	/**
	 * Draw this entity to the graphics context provided
	 * 
	 * @param g The graphics context on which to draw
	 */
	public void draw(Graphics g) {
		sprite.draw(g,(int) moveStrategy.getX(),(int) moveStrategy.getY());
	}
	
	/**
	 * Do the logic associated with this entity. This method
	 * will be called periodically based on game events
	 */
	public abstract void doLogic();
	
	/**
	 * Get the x location of this entity
	 * 
	 * @return The x location of this entity
	 */
	public int getX() {
		return (int) moveStrategy.getX();
	}

	/**
	 * Get the y location of this entity
	 * 
	 * @return The y location of this entity
	 */
	public int getY() {
		return (int) moveStrategy.getY();
	}
	
	/**
	 * Check if this entity collised with another.
	 * 
	 * @param other The other entity to check collision against
	 * @return True if the entities collide with each other
	 */
	public boolean collidesWith(Entity other) {
		me.setBounds((int) moveStrategy.getX(),(int) moveStrategy.getY(),sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.getMoveStrategy().getX(),(int) other.getMoveStrategy().getY(),other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}
	
	public MovementAbstract getMoveStrategy() {
		return moveStrategy;
	}

	public void setMoveStrategy(MovementAbstract moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	/**
	 * Notification that this entity collided with another.
	 * 
	 * @param other The entity with which this entity collided.
	 */
	public abstract void collidedWith(Entity other);
}