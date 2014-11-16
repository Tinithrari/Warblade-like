package entityManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.jsfml.audio.Music;
import org.jsfml.audio.Sound;
import org.jsfml.audio.SoundBuffer;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.Keyboard;

import store.MusicStore;
import store.SpriteStore;
import window.Application;
import level.Level;
import level.Level1;
import movement.allyMovement.PlayerMovement;
import entities.Entity;
import entities.allyEntities.PlayerEntity;
import entities.allyEntities.ShipEntity;
import entities.bonusEntities.BonusEntities;

public class GameScene implements Scene {
	
	private Level level;
	private ArrayList<PlayerEntity> playerEntities = new ArrayList<PlayerEntity>();
	private ArrayList<BonusEntities> bonus = new ArrayList<BonusEntities>();
	private ArrayList<Entity> removeList = new ArrayList<Entity>();
	private Queue<SoundBuffer> soundList;
	private Sound soundReader;
	private Music musicPlayer;
	private ShipEntity ship;
	private Sprite background;
	
	public GameScene() {
		
		background = new Sprite();
		background.setTexture(SpriteStore.get().getSprite("sprites/background.jpg"));
		background.setPosition(0,0);
		
		soundList = new LinkedList<SoundBuffer>();
		soundReader = new Sound();
		soundReader.setVolume(50.0f);
		
		musicPlayer = new Music();
		try {
			musicPlayer.openFromStream(MusicStore.get().getStream("music/level1-4music.ogg"));
			musicPlayer.setVolume(100);
			musicPlayer.play();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		ship = new ShipEntity(this,"sprites/ship.png",new PlayerMovement(370,500));
		playerEntities.add(ship);
		
		level = new Level1(this);
		level.initEnemy();
	}

	@Override
	public void processEvent(Application app) {
		
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
			for (int i = 0; i < level.getEnemyEntities().size(); i++)
			{
				if (me.collidesWith(level.getEnemyEntities().get(i))) 
				{
					if (! removeList.contains(level.getEnemyEntities().get(i)))
						me.collidedWith(level.getEnemyEntities().get(i));
					if (! removeList.contains(level.getEnemyEntities().get(i)))
						level.getEnemyEntities().get(i).collidedWith(me);
				}
			}
		}
		
		for (int i = 0; i < bonus.size(); i++)
			if (bonus.get(i).collidesWith(ship))
				bonus.get(i).collidedWith(ship);
		
		level.processEvent();
		
		if (removeList.contains(ship) || level == null)
		{
			musicPlayer.stop();
			app.setScene(new MenuScene());
		}
	}

	@Override
	public void update(long delta) {
		
		playerEntities.removeAll(removeList);
		bonus.removeAll(removeList);
		level.getEnemyEntities().removeAll(removeList);
		
		level.update(delta);
		
		for (PlayerEntity entities : playerEntities) {
			entities.move(delta);
		}
		
		for (BonusEntities powerUp : bonus)
				powerUp.move(delta);
	}

	@Override
	public void render(RenderWindow renderer) {
		renderer.draw(background);
		for (PlayerEntity entities : playerEntities) {
			entities.draw(renderer);
		}
		
		for (BonusEntities entities : bonus) {
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
	
	public void setMusic(String ref) {
		try {
			musicPlayer.openFromStream(MusicStore.get().getStream(ref));
			musicPlayer.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateLogic() {
		level.updateLogic();
	}
	
	public void addBonus(BonusEntities drop) {
		bonus.add(drop);
	}
	
	public void removeBonus(BonusEntities drop) {
		bonus.remove(drop);
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

	public void setLevel(Level level) {
		this.level = level;
	}

	public ShipEntity getShip() {
		return ship;
	}
	
	
}
