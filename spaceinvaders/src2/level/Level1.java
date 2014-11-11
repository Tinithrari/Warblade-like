package level;

import java.util.ArrayList;

import shoot.AlienSimpleShot;
import movement.ClassicMovement;
import base.Application;
import entities.AlienEntity;
import entities.EnemyEntity;
import entities.Entity;

public class Level1 implements Level {

	private Application game;
	
	public Level1(Application game) {
		this.game = game;
	}

	@Override
	public int initAlien(ArrayList<EnemyEntity> entities) {
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				EnemyEntity alien = new AlienEntity(game,"sprites/alien.gif",new ClassicMovement(100+(x*50),(50)+row*30), new AlienSimpleShot());
				entities.add(alien);
			}
		}
		return 30;
	}

}
