package window;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;

import entityManager.MenuScene;
import entityManager.Scene;

public class Application {
	
	private RenderWindow window;
	private Scene scene;
	
	public Application() {
		window = new RenderWindow(new VideoMode(800, 600, 32), "Warblade-like", WindowStyle.NONE | WindowStyle.TITLEBAR | WindowStyle.CLOSE);
		window.setFramerateLimit(60);
		scene = new MenuScene();
	}
	
	public void processEvent() {
		Event event;
        while ((event = window.pollEvent()) != null)
        {
            if (event.type == Type.CLOSED)
                window.close();
        }
        
		scene.processEvent(this);
	}
	
	public void update(long delta) {
		scene.update(delta);
	}
	
	
	
	public RenderWindow getWindow() {
		return window;
	}

	public void render() {
		window.clear(Color.BLACK);
		scene.render(window);
		window.display();
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void run () {
		long time = System.currentTimeMillis();
		while(window.isOpen())
		{
			long delta = System.currentTimeMillis() - time;
			time = System.currentTimeMillis();
			processEvent();
			update(delta);
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) {
		Application app = new Application();
		app.run();
	}
}
