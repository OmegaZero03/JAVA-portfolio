package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.Tile;

public class PlayerBullet extends Entity{

	private double dx, dy;
	
	/******STATUS**********/
	private int spd = 2;
	private int damage = 3;
	private int range = 5;
	/**********************/
	
	private int range_mux = 8 * range;
	private double lifeTime_right, lifeTime_left, lifeTime_up, lifeTime_down;
	
	
	public PlayerBullet(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
		lifeTime_right = x + range_mux;
		lifeTime_left = x - range_mux;
		lifeTime_up = y + range_mux;
		lifeTime_down = y - range_mux;
		}
	
	@Override
	public void tick() {
		x += dx * spd;
		y += dy * spd;
		collidingEnemy();
		selfDestroy();
		collidingWall();
		
		if((x >= lifeTime_right) || (x <= lifeTime_left)
		|| (y >= lifeTime_up) 	 || (y <= lifeTime_down)) {
			Main.playerBullets.remove(this);
		}

	}
	
	public void setRange(int range) {
		this.range = range;
	}

	public void selfDestroy() {
		if((this.getX() >= (Main.width + Camera.x) - 8) || (this.getX() <= 0) 
		|| (this.getY() >= (Main.height + Camera.y) - 8) || (this.getY() <= 0)) {
			Main.playerBullets.remove(this);
		}
		
		
	}
	public void collidingWall() {
		for(int i = 0; i < Main.walls.size(); i++) {
			Tile atual = Main.walls.get(i);
			
			if(Tile.isColliding(this, atual)) {
				Main.playerBullets.remove(this);
				return;
				}
			}
	}
	
	public void collidingEnemy() {
		for(int i = 0; i < Main.entities.size(); i++) {
			Entity atual = Main.entities.get(i);
			boolean isEnemy = atual instanceof Enemy;
			boolean isFinn = atual instanceof Finn;
			boolean isPikachu = atual instanceof Pikachu;
			
			if(isEnemy || isFinn || isPikachu) {
			if(Entity.isColliding(this, atual)) {
				atual.life -= damage;
				System.out.println("vida = "+atual.life);
				Main.playerBullets.remove(this);
				return;
				}
			}
		}
	}
	

}