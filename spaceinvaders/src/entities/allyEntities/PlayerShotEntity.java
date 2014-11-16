package entities.allyEntities;

import store.SoundStore;
import entities.ExplosionEntity;
import entities.enemyEntities.EnemyEntity;
import entityManager.GameScene;
import movement.Movement;
import movement.enemyMovement.NoMovement;

/**
 * An entity representing a shot fired by the player's ship
 * 
 * @author Kevin Glass
 */
public class PlayerShotEntity extends PlayerEntity {
	/** The vertical speed at which the players shot moves */
	/** The game in which this entity exists */
	private GameScene gameScene;
	/** True if this shot has been "used", i.e. its hit something */
	private int damage;
	private boolean used = false;
	
	/**
	 * Create a new shot from the player
	 * 
	 * @param gameScene The game in which the shot has been created
	 * @param sprite The sprite representing this shot
	 * @param strategy TODO
	 */
	public PlayerShotEntity(GameScene gameScene,String sprite,Movement strategy, int damage) {
		super(sprite,strategy);
		
		this.gameScene = gameScene;
		this.damage = damage;
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
			gameScene.removeEntity(this);
		}
	}
	
	
	public void collidedWith(EnemyEntity other) {
		// prevents double kills, if we've already hit something,
		// don't collide
		if (used) {
			return;
		}
		
		gameScene.removeEntity(this);
		other.setlP(other.getlP() - damage);
		
		if (other.getlP() <= 0)
		{
			// notify the game that the alien has been killed
			if (!other.isNotAMonster())
			{
				gameScene.notifyEnemyKilled();
				other.drop();
			}
			gameScene.getRemoveList().add(other);
			gameScene.getRemoveList().add(this);
			used = true;
		}
		else
		{
			gameScene.getSoundList().add(SoundStore.get().getSound("sound/explosion.wav"));
		}
		gameScene.getLevel().getEnemyEntities().add(new ExplosionEntity(gameScene, "sprites/explosion.png", new NoMovement(other.getX() - 60, other.getY() - 60)));
	}

    @Override
    public void doLogic() {
        // FIXME Auto-generated method stub
        
    }
}