package entities.allyEntities;

import org.jsfml.audio.Sound;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;

import store.SoundStore;
import movement.Movement;
import entities.enemyEntities.EnemyEntity;
import entityManager.GameScene;

public class ShieldEntity extends PlayerEntity {

	private ShipEntity entity;
	private GameScene gameScene;
	private Sound player;
	private boolean toAnime = true;
	private int counter = 0;
	
	public ShieldEntity(GameScene gameScene, ShipEntity entity, String ref, Movement strategy) {
		super(ref, strategy);
		this.entity = entity;
		this.gameScene = gameScene;
		player = new Sound();
		player.setBuffer(SoundStore.get().getSound("sound/shieldpick.wav"));
		player.play();
	}

	@Override
	public void collidedWith(EnemyEntity other) {
		gameScene.getSoundList().add(SoundStore.get().getSound("sound/shielddestroy.wav"));
		if (other.isNotAMonster())
		{
			gameScene.removeEntity(other);
		}
		entity.removeBonus(this);
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(RenderWindow renderer) {
		if (toAnime == true)
		{
			getSprite().setTextureRect(new IntRect(counter * 90, 0, 90, 78));
			counter++;
		}
		if (counter == 10)
			toAnime = false;
		super.draw(renderer);
	}

	
}
