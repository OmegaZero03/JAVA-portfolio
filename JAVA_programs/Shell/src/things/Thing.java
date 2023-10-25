package things;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Thing {

	private int x, y, size;
	private boolean dbug;
	
	public Thing() {
		
		
		x = 300;
		
		y = 200;
		
		size = 20;
		
		dbug = false;
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER) {
			dbug = !dbug;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, size, size);
		if(dbug){
			g.drawString("X =" + x, x + 20, y);
			g.drawString("Y =" + y, x + 20, y - 10);
		}
	}

	public void tick(Ball b) {
		if(x == b.getX()) {
			x = 0;
			y = 0;
		}
	}
}

