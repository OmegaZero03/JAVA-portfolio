package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Finn extends Entity{

	public int rangeWalk = 8 * 2;
	
	public double spd = 1;
	private double atackSpeed = 4;
	
	private double anglep, anglepp;
	
	public int range, negaRange;
	int i = 0;
	
	private double dx, dy, nextShoot;
	
	public Finn(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		this.range = x + rangeWalk;
		this.negaRange = x - rangeWalk;
		this.life = 600;
		
		this.anglep = Math.toRadians(25);
		this.anglepp = Math.toRadians(50);
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
		
		double angle = Math.atan2(Main.player.getY() - this.getY() ,Main.player.getX() - this.getX());
	
		//double angle = Math.toRadians(90 + i);
		//i += 10;
		
		dx = Math.cos(angle);
		dy = Math.sin(angle);
		
		
		Bullet b = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
		Main.finnBullets.add(b);
		/****************************/
		
		dx = Math.cos(angle + anglep);
		dy = Math.sin(angle + anglep);
		
		Bullet b1 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
		Main.finnBullets.add(b1);
		/****************************/
		
		dx = Math.cos(angle + anglepp);
		dy = Math.sin(angle + anglepp);
		
		Bullet b2 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
		Main.finnBullets.add(b2);
		/****************************/
		
		dx = Math.cos(angle - anglep);
		dy = Math.sin(angle -  anglep);
		
		Bullet b3 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
		Main.finnBullets.add(b3);
		/****************************/
		dx = Math.cos(angle - anglepp);
		dy = Math.sin(angle - anglepp);
		
		Bullet b4 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
		Main.finnBullets.add(b4);
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
