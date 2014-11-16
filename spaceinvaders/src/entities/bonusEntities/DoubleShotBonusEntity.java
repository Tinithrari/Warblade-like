package entities.bonusEntities;

import shoot.PlayerDoubleShot;
import store.SoundStore;
import movement.Movement;
import entities.allyEntities.ShipEntity;
import entityManager.GameScene;

public class DoubleShotBonusEntity extends BonusEntities{

	private GameScene gameScene;
	
	public DoubleShotBonusEntity(GameScene gameScene, String ref, Movement strategy) {
		super(ref, strategy);
		this.gameScene = gameScene;
	}

	@Override
	public void collidedWith(ShipEntity other) {
		other.setShootStrategy(new PlayerDoubleShot());
		other.getPlayer().setBuffer(SoundStore.get().getSound("sound/doublelaseralien.wav"));
		gameScene.removeBonus(this);
		gameScene.getSoundList().add(SoundStore.get().getSound("sound/change.wav"));
	}

	@Override
	public void doLogic() {
		if (getMoveStrategy().getY() >= 600)
			gameScene.removeBonus(this);
	}
}
