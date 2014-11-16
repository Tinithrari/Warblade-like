package entities;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public class ButtonEntity {
	
	private RectangleShape bouton;
	private Text text;
	private boolean pressed = false;
	private boolean clicked = false;
	
	public ButtonEntity(Vector2f position, String text, Font font) {
		this.text = new Text(text, font);
		bouton = new RectangleShape();
		
		bouton.setOutlineThickness(1.0f);
		bouton.setPosition(position);
		
		this.text.setCharacterSize(28);
		this.text.setPosition(position.x+20, position.y+20);
		
		bouton.setSize(new Vector2f(text.length() * 28 , 28 + 50));
	}
	
	public void processEvent(RenderWindow renderer) {
		clicked = false;
		if (bouton.getGlobalBounds().contains(new Vector2f(Mouse.getPosition(renderer))))
		{
			if (Mouse.isButtonPressed(Mouse.Button.LEFT))
				pressed = true;
			else if (pressed)
			{
				clicked = true;
				pressed = false;
			}
		}
		else
		{
			pressed = false;
			clicked = false;
		}
	}
	
	public void update() {
		if (pressed)
		{
			bouton.setFillColor(Color.WHITE);
			text.setColor(Color.BLACK);
		}
		else
		{
			bouton.setFillColor(new Color(0, 102, 255));
			text.setColor(Color.WHITE);
		}
	}
	
	public boolean isClicked() {
		return clicked;
	}
	
	public void draw(RenderWindow renderer) {
		renderer.draw(bouton);
		renderer.draw(text);
	}
}
