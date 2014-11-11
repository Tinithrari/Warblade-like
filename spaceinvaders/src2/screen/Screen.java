package screen;

import entityManager.Scene;

public abstract class Screen {

	private Scene scene;
	
	public Screen(Scene scene) {
		// TODO Auto-generated constructor stub
		this.scene = scene;
	}

	public abstract void display(); //This loop contain all orocedure of scene execution

	//TODO Implements screen strategy
}
