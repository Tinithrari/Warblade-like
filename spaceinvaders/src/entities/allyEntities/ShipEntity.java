package entities.allyEntities;

import java.util.ArrayList;

import org.jsfml.audio.Sound;
import org.jsfml.graphics.RenderWindow;

import entities.enemyEntities.EnemyEntity;
import entityManager.GameScene;
import movement.Movement;
import shoot.PlayerShootStrategy;
import shoot.PlayerSimpleShot;
import store.SoundStore;

/**
 * The entity that represents the players ship
 * 
 * @author Kevin Glass
 */
public class ShipEntity extends PlayerEntity {
	/** The game in which the ship exists */
	private GameScene gameScene;
	private PlayerShootStrategy shootStrategy;
	private ArrayList<PlayerEntity> bonus;
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
		player.setBuffer(SoundStore.get().getSound("sound/laser1.wav"));
		player.setVolume(50.0f);
		
		bonus = new ArrayList<PlayerEntity>();
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
				player.play();
			}
		}
	}
	
	public void addBonus(PlayerEntity powerUp) {
		bonus.add(powerUp);
	}
	
	public void removeBonus(PlayerEntity powerUp) {
		bonus.remove(powerUp);
	}
	
	public void collidedWith(EnemyEntity other) {
		for (int i = 0; i < bonus.size(); i++)
		{
			if (bonus.get(i).collidesWith(other))
				bonus.get(i).collidedWith(other);
		}
	}

    @Override
    public void doLogic() {
        // FIXME Auto-generated method stub
        
    }

	@Override
	public void move(long delta) {
		super.move(delta);
		for (PlayerEntity powerUp : bonus)
		{
			powerUp.move(delta);
		}
	}

	@Override
	public void draw(RenderWindow renderer) {
		// TODO Auto-generated method stub
		super.draw(renderer);
		for (PlayerEntity powerUp : bonus)
		{
			powerUp.draw(renderer);
		}
	}

	public Sound getPlayer() {
		return player;
	}

	public void setShootStrategy(PlayerShootStrategy shootStrategy) {
		this.shootStrategy = shootStrategy;
	}
	
	
}