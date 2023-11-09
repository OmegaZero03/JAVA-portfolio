package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.Tile;

public class Bullet extends Entity{

private double dx, dy;
	
	/******STATUS**********/
	private double spd = 1.3;
	private int damage = 10;
	private int range = 5;
	/**********************/
	
	private int range_mux = 8 * range;
	private double lifeTime_right, lifeTime_left, lifeTime_up, lifeTime_down;
	
	
	public Bullet(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
		
		this.maskx = 4;
		this.masky = 4;
		this.mwidth = 8;
		this.mheight = 8;
		
		lifeTime_right = x + range_mux;
		lifeTime_left = x - range_mux;
		lifeTime_up = y + range_mux;
		lifeTime_down = y - range_mux;
		}
	
	@Override
	public void tick() {
		x += dx * spd;
		y += dy * spd;

		selfDestroy();
		collidingWall();
		isHitting();
		/*if((x >= lifeTime_right) || (x <= lifeTime_left)
		|| (y >= lifeTime_up) 	 || (y <= lifeTime_down)) {
			Main.playerBullets.remove(this);
		}
		*/
		
	}
	
	public void setRange(int range) {
		this.range = range;
	}

	public void selfDestroy() {
		if((this.getX() >= (Main.width + Camera.x) - 8) || (this.getX() <= 0) 
		|| (this.getY() >= (Main.height + Camera.y) - 8) || (this.getY() <= 0)) {
			Main.finnBullets.remove(this);
		}
		
		
	}
	public void collidingWall() {
		for(int i = 0; i < Main.walls.size(); i++) {
			Tile atual = Main.walls.get(i);
			
			if(Tile.isColliding(this, atual)) {
				Main.finnBullets.remove(this);
				return;
				}
			}
	}
	
	public void isHitting() {
		if(isColliding(this, Main.player)) {
			Main.finnBullets.remove(this);
			Main.player.life -= damage;
		}
	}
	
}

