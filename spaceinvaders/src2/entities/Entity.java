package entities;

import java.awt.Rectangle;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import movement.Movement;
import base.SpriteStore;

/**
 * An entity represents any element that appears in the game. The
 * entity is responsible for resolving collisions and movement
 * based on a set of properties defined either by subclass or externally.
 * 
 * Note that floats are used for positions. This may seem strange
 * given that pixels locations are integers. However, using float means
 * that an entity can move a partial pixel. It doesn't of course mean that
 * they will be display half way through a pixel but allows us not lose
 * accuracy as we move.
 * 
 * @author Kevin Glass
 */
public abstract class Entity {
	
	protected Sprite sprite;
	/** The current speed of this entity horizontally (pixels/sec) */
	private Movement moveStrategy;
	/** The rectangle used for this entity during collisions  resolution */
	private Rectangle me = new Rectangle();
	/** The rectangle used for other entities during collision resolution */
	private Rectangle him = new Rectangle();
	private String ref;
	
	/**
	 * Construct a entity based on a sprite image and a location.
	 * 
	 * @param ref The reference to the image to be displayed for this entity
	 * @param strategy TODO
	 */
	public Entity(String ref,Movement strategy) {
		this.sprite = new Sprite();
		moveStrategy = strategy;
		sprite.setPosition(getX(), getY());
		this.ref = ref;
		sprite.setTexture(SpriteStore.get().getSprite(ref));
		sprite.setPosition(getX(),getY()); 
	}
	
	public Sprite getSprite() {
		return sprite;
	}



	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 * 
	 * @param delta The ammount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		moveStrategy.move(delta);
		sprite.setPosition(getX(),getY());
	}
	
	/**
	 * Set the horizontal speed of this entity
	 * 
	 * @param dx The horizontal speed of this entity (pixels/sec)
	 */
	public void setHorizontalMovement(float dx) {
		moveStrategy.setDx(dx);
	}

	/**
	 * Set the vertical speed of this entity
	 * 
	 * @param dx The vertical speed of this entity (pixels/sec)
	 */
	public void setVerticalMovement(float dy) {
		moveStrategy.setDy(dy);
	}
	
	/**
	 * Get the horizontal speed of this entity
	 * 
	 * @return The horizontal speed of this entity (pixels/sec)
	 */
	public float getHorizontalMovement() {
		return moveStrategy.getDx();
	}

	/**
	 * Get the vertical speed of this entity
	 * 
	 * @return The vertical speed of this entity (pixels/sec)
	 */
	public float getVerticalMovement() {
		return moveStrategy.getDy();
	}
	
	public void draw(RenderWindow renderer) {
		renderer.draw(sprite);
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
	public float getX() {
		return moveStrategy.getX();
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
		me.setBounds((int)getMoveStrategy().getX(), (int)getMoveStrategy().getY(), (int)sprite.getGlobalBounds().width, (int)sprite.getGlobalBounds().height);
		him.setBounds((int) other.getMoveStrategy().getX(),(int) other.getMoveStrategy().getY(),(int) other.sprite.getGlobalBounds().width ,(int)other.sprite.getGlobalBounds().height);

		return me.intersects(him);
	}
	
	public Movement getMoveStrategy() {
		return moveStrategy;
	}

	public void setMoveStrategy(Movement moveStrategy) {
		this.moveStrategy = moveStrategy;
	}
}