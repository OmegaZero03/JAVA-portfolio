package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Finn extends Entity{

	public int rangeWalk = 8 * 2;
	public double spd = 1;
	public int range, negaRange;
	
	public Finn(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		this.range = x + rangeWalk;
		this.negaRange = x - rangeWalk;
		this.life = 600;
	}

	@Override
	public void tick() {
		
		if(this.life < 0) {
			Main.entities.remove(this);
		}
		
		x += spd;
		
		if(x >= range) {
			spd = spd * (-1);
			}
		else if(x <= negaRange) {
			spd = spd * (-1);
		}
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.red);
		g.fillRect((int)x - Camera.x + 3, (int)y - 4 - Camera.y, 10, 2);
		g.setColor(Color.ORANGE);
		g.fillRect((int)x - Camera.x + 3, (int)y - 4 - Camera.y, (int)((life/600)*10) , 2);
		
	}
	
}
