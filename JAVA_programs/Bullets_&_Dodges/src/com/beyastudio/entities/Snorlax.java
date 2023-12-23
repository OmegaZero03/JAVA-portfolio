package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Snorlax extends Entity{

	
	public Snorlax(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		this.life = 30;
		Grass_orbital o = new Grass_orbital(this.getX() - 8, this.getY(), 8, 8, Entity.GRASS_ORB);
		Main.entities.add(o);
		
		Ice_orbital o2 = new Ice_orbital(this.getX() + 24, this.getY(), 8, 8, Entity.ICE_ORB);
		Main.entities.add(o2);
	}

	@Override
	public void tick() {
		if(this.life < 0) {
			Main.entities.remove(this);

		}
		
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if(life != 30) {
			g.setColor(Color.red);
			g.fillRect((int)x - Camera.x + 3, (int)y - 4 - Camera.y, 10, 2);
			g.setColor(Color.ORANGE);
			g.fillRect((int)x - Camera.x + 3, (int)y - 4 - Camera.y, (int)((life/30)*10) , 2);
		}
		
	}
	
}
