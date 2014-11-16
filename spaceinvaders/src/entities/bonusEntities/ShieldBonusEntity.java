package entities.bonusEntities;

import movement.Movement;
import movement.allyMovement.ShieldMovement;
import entities.allyEntities.ShieldEntity;
import entities.allyEntities.ShipEntity;
import entityManager.GameScene;

public class ShieldBonusEntity extends BonusEntities {
	
	private GameScene gameScene;
	
	public ShieldBonusEntity(GameScene gameScene, String ref, Movement strategy) {
		super(ref, strategy);
		this.gameScene = gameScene;
	}

	@Override
	public void collidedWith(ShipEntity other) {
		other.addBonus(new ShieldEntity(gameScene, other, "sprites/shieldanime.png", new ShieldMovement(other, other.getX()-22, other.getY()-12)));
		gameScene.removeBonus(this);
	}

	@Override
	public void doLogic() {
		if (getMoveStrategy().getY() >= 600)
			gameScene.removeBonus(this);
	}
}
