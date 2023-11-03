package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Bullet extends Entity{

	private double dx, dy;
	private int spd = 2;
	
	
	
	public Bullet(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public void tick() {
		x += dx * spd;
		y += dy * spd;
		CollidingEnemy();
		selfDestroy();
		
	}
	
	public void selfDestroy() {
		if((this.getX() >= (Main.width + Camera.x) - 8) || (this.getX() <= 0) 
		|| (this.getY() >= (Main.height + Camera.y) - 8) || (this.getY() <= 0)) {
			Main.bullets.remove(this);
		}
		
		
	}
	

	public void CollidingEnemy() {
		for(int i = 0; i < Main.entities.size(); i++) {
			Entity atual = Main.entities.get(i);
			boolean isEnemy = atual instanceof Enemy;
			
			if(isEnemy) {
			if(Entity.isColliding(this, atual)) {
				Main.entities.remove(atual);
				Main.bullets.remove(this);
				return;
				}
			}
		}
	}
	

}
