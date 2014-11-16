package entityManager;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import store.FontStore;
import window.Application;
import entities.ButtonEntity;

public class MenuScene implements Scene {

	private ButtonEntity playButton;
	private Text titre;
	
	public MenuScene() {
		super();
		titre = new Text("Warblade-Like", FontStore.get().getFont("font/neuropol.ttf"));
		titre.setCharacterSize(32);
		titre.setPosition(400 - titre.getString().length() * 10, 5);
		titre.setColor(Color.WHITE);
		
		playButton = new ButtonEntity(new Vector2f(339.0f,286.0f),"Play",FontStore.get().getFont("font/neuropol.ttf"));
	}

	@Override
	public void processEvent(Application app) {
		playButton.processEvent(app.getWindow());
		if (playButton.isClicked())
			app.setScene(new GameScene());
	}

	@Override
	public void update(long delta) {
		playButton.update();
	}

	@Override
	public void render(RenderWindow renderer) {
		renderer.draw(titre);
		playButton.draw(renderer);
	}

}
