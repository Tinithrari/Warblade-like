package level;

import java.util.ArrayList;

import movement.ClassicMovement;
import base.Game;
import entities.AlienEntity;
import entities.EnemyEntity;
import entities.Entity;

public class Level1 implements LevelInterface {

	private Game game;
	
	public Level1(Game game) {
		this.game = game;
	}

	@Override
	public int initAlien(ArrayList<EnemyEntity> entities) {
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				EnemyEntity alien = new AlienEntity(game,"sprites/alien.gif",new ClassicMovement(100+(x*50),(50)+row*30));
				entities.add(alien);
			}
		}
		return 30;
	}

}
