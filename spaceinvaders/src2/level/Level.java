package level;

import java.util.ArrayList;

import org.jsfml.graphics.RenderWindow;

import entities.EnemyEntity;


public abstract class Level {
	
	private ArrayList<EnemyEntity> enemyEntities;
	private int nbEnemy;
	
	public Level() {
		enemyEntities = new ArrayList<EnemyEntity>();
	}
	
	public abstract void initEnemy();
	public abstract void processEvent();
	public abstract void update(long delta);
	public abstract void updateLogic();
	
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
	}
	
}
