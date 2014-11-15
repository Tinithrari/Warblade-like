package level;

import java.util.ArrayList;

import org.jsfml.audio.Sound;
import org.jsfml.graphics.RenderWindow;

import base.SoundStore;
import entities.EnemyEntity;


public abstract class Level {
	
	private ArrayList<EnemyEntity> enemyEntities;
	private int nbEnemy;
	private Sound player;
	
	public Level() {
		enemyEntities = new ArrayList<EnemyEntity>();
		player = new Sound();
	}
	
	public abstract void initEnemy();
	public abstract void processEvent();
	public abstract void updateLogic();
	
	public void update(long delta) {
		for (int i = 0; i < getEnemyEntities().size(); i++)
		{
			getEnemyEntities().get(i).move(delta);
			getEnemyEntities().get(i).fire();
		}
	}
	
	public void render(RenderWindow renderer){
		 for (EnemyEntity entity : enemyEntities)
         	entity.draw(renderer);
	}
	public int getNbEnemy() {
		return nbEnemy;
	}
	public void setNbEnemy(int nbEnemy) {
		this.nbEnemy = nbEnemy;
	}
	public ArrayList<EnemyEntity> getEnemyEntities() {
		return enemyEntities;
	}
	
	public void notifyEnemyKilled() {
		nbEnemy--;
		player.setBuffer(SoundStore.get().getSound("sound/explosion.wav"));
		player.play();
	}
	
}
