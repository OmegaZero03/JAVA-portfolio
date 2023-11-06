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
	
	
	private double dx, dy, nextShoot;
	private int atackSpeed = 8;
	
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
		
		//x += spd;
		
		/*
		if(x >= range) {
			spd = spd * (-1);
			}
		else if(x <= negaRange) {
			spd = spd * (-1);
		}
		*/
		
		if(System.currentTimeMillis()< nextShoot) {
			return;
		}
		
		nextShoot = System.currentTimeMillis() + (atackSpeed * 100);
		
		double angle = Math.atan2(Main.player.getY() - (this.getY() - Camera.y ) ,Main.player.getX() - (this.getX() - Camera.x));
		
		dx = Math.cos(angle);
		dy = Math.sin(angle);
		
		
		Bullet b = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
		Main.finnBullets.add(b);
		
		Bullet b1 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx - .5, dy);
		Main.finnBullets.add(b1);
		
		
		Bullet b2 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx - .7, dy);
		Main.finnBullets.add(b2);
		
		Bullet b3 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx - .2, dy);
		Main.finnBullets.add(b3);
		
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if(life != 600) {
			g.setColor(Color.red);
			g.fillRect((int)x - Camera.x + 3, (int)y - 4 - Camera.y, 10, 2);
			g.setColor(Color.ORANGE);
			g.fillRect((int)x - Camera.x + 3, (int)y - 4 - Camera.y, (int)((life/600)*10) , 2);
		}
		
	}
	
}
