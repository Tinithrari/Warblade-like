package entities;

import base.Game;
import movement.AbstractMovement;

public class AlienShotEntity extends EnemyEntity {

	private Game game;
	private boolean used = false;
	
	public AlienShotEntity(Game game, String ref, AbstractMovement strategy) {
		super(ref, strategy);
		// TODO Auto-generated constructor stub
		this.game =  game;
	}

	@Override
	public void collidedWith(PlayersEntity other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}

}
