package things;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Ball {

	
	private int x;
	private int y;
	private int vel;
	private boolean up, down, left, right, dbug;
	private int size;
	
	public Ball() {
		
		x = Shell.WIDTH / 2;
		y = Shell.HEIGHT / 2;
		
		vel = 5;
		
		up = down = left = right = dbug =false;
		
		size = 20;
		
	}
	
	public void keyPressed(int k) {
		switch(k) {
		
			case KeyEvent.VK_W:
				up = true;
				break;
				
				
			case KeyEvent.VK_S:
				down = true;
				break;
				
				
			case KeyEvent.VK_A:
				left = true;
				break;
				
				
			case KeyEvent.VK_D:
				right = true;
				break;
			
			case KeyEvent.VK_ENTER:
				dbug = !dbug;
				break;
		}
	}
	
	public void keyReleased(int k) {
		
		switch(k) {
		
		case KeyEvent.VK_W:
			up = false;
			break;
			
			
		case KeyEvent.VK_S:
			down = false;
			break;
			
			
		case KeyEvent.VK_A:
			left = false;
			break;
			
			
		case KeyEvent.VK_D:
			right = false;
			break;
			
			
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(x, y, size, size);
		if(dbug) {
			g.drawString("X =" + x, x, y - 20);
			g.drawString("Y =" + y, x, y - 30);
		}
	}
	
	public void tick() {
		
		if(up) {
			y -= vel;
		}
		if(down) {
			y += vel;
		}
		if(right) {
			x += vel;
		}
		if(left) {
			x -= vel;
		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
