package entityManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.jsfml.audio.Sound;
import org.jsfml.audio.SoundBuffer;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.Keyboard;

import base.SpriteStore;
import level.Level;
import level.Level1;
import movement.PlayerMovement;
import entities.EnemyEntity;
import entities.Entity;
import entities.PlayerEntity;
import entities.ShipEntity;

public class GameScene implements Scene {
	
	private Level level;
	private ArrayList<PlayerEntity> playerEntities = new ArrayList<PlayerEntity>();
	private ArrayList<Entity> removeList = new ArrayList<Entity>();
	private Queue<SoundBuffer> soundList;
	private Sound soundReader;
	private ShipEntity ship;
	private Sprite background;
	
	public GameScene() {
		
		background = new Sprite();
		background.setTexture(SpriteStore.get().getSprite("sprites/background.jpg"));
		background.setPosition(0,0);
		
		soundList = new LinkedList<SoundBuffer>();
		soundReader = new Sound();
		
		ship = new ShipEntity(this,"sprites/ship.png",new PlayerMovement(370,500));
		playerEntities.add(ship);
		
		level = new Level1(this);
		level.initEnemy();
	}

	@Override
	public void processEvent() {
		
		ship.setHorizontalMovement(0);
		
		if (Keyboard.isKeyPressed(Keyboard.Key.LEFT) && !Keyboard.isKeyPressed(Keyboard.Key.RIGHT)) {
			ship.setHorizontalMovement(-300);
		}
		else if (Keyboard.isKeyPressed(Keyboard.Key.RIGHT) && !Keyboard.isKeyPressed(Keyboard.Key.LEFT)) {
			ship.setHorizontalMovement(300);
		}

		if (Keyboard.isKeyPressed(Keyboard.Key.SPACE)) {
			 ship.tryToFire();
		}
		
		if (Keyboard.isKeyPressed(Keyboard.Key.ESCAPE)) {
			 System.exit(0);
		}
		
		for (PlayerEntity me : playerEntities)
		{
			for (EnemyEntity him : level.getEnemyEntities())
			{
				if (me.collidesWith(him)) {
					me.collidedWith(him);
					him.collidedWith(me);
				}
			}
		}
		
		level.processEvent();
	}

	@Override
	public void update(long delta) {
		if (removeList.contains(ship))
			System.exit(0);
		
		playerEntities.removeAll(removeList);
		level.getEnemyEntities().removeAll(removeList);
		
		level.update(delta);
		
		for (PlayerEntity entities : playerEntities) {
			entities.move(delta);
		}
	}

	@Override
	public void render(RenderWindow renderer) {
		renderer.draw(background);
		for (PlayerEntity entities : playerEntities) {
			entities.draw(renderer);
		}
		level.render(renderer);
		
		for (SoundBuffer sound : soundList)
		{
			soundReader.setBuffer(sound);
			soundReader.play();
		}
		soundList.clear();
	}
	
	public void updateLogic() {
		level.updateLogic();
	}
	
	public ArrayList<PlayerEntity> getPlayerEntities() {
		return playerEntities;
	}

	public ArrayList<Entity> getRemoveList() {
		return removeList;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void removeEntity(Entity entity) {
		removeList.add(entity);	
	}
	
	public void notifyEnemyKilled() {
		level.notifyEnemyKilled();
	}

	public Queue<SoundBuffer> getSoundList() {
		return soundList;
	}
	
	
}
