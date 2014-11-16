package entities;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2i;

import entities.allyEntities.PlayerEntity;
import entities.enemyEntities.EnemyEntity;
import entityManager.GameScene;
import movement.Movement;

public class ExplosionEntity extends EnemyEntity {
	
	private int frameCounter = 0;
	private GameScene gameScene;

	public ExplosionEntity(GameScene gameScene, String ref, Movement strategy) {
		super(ref, strategy);
		this.gameScene = gameScene;
	}

	@Override
	public void collidedWith(PlayerEntity other) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub

	}
	
	public void destroy() {
		gameScene.getRemoveList().add(this);
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(RenderWindow renderer) {
		if (frameCounter < 11) {
			getSprite().setTextureRect(new IntRect(new Vector2i(125*frameCounter, 0), new Vector2i(120,120)));
			frameCounter++;
			renderer.draw(sprite);
		}
		else
			destroy();	
	}

	@Override
	public boolean isNotAMonster() {
		return true;
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}
	
	

}
