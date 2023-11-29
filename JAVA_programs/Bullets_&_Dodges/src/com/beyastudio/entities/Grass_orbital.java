package com.beyastudio.entities;

import java.awt.image.BufferedImage;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Grass_orbital extends Entity{
	
	private double atackSpeed = 1.1;
	private int spdAdd = 2;
	
	
	private int spd;
	private double mx, my, angle;
	private double nextShoot = 0,
				   dx, dy;
	
	public Grass_orbital(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	@Override
	public void tick() {
		
		if(Main.player.haveGrass) {
			spd += spdAdd;
			
			angle = Math.toRadians(90 + spd);
			double radius = 16;

			dy = Math.sin(angle);
			dx = Math.cos(angle);
			
			x = Main.player.getX() + (radius*dx);
			y = Main.player.getY() + (radius*dy);
			
			
			this.mx = Main.player.mx;
			this.my = Main.player.my;
		
			if(System.currentTimeMillis()< nextShoot) {
				return;
			}
			
			nextShoot = System.currentTimeMillis() + (atackSpeed * 100);
	
			double angle = Math.atan2(my - (this.getY() - Camera.y + 5) , mx - (this.getX() - Camera.x + 5));
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			if(Main.player.shoot || Main.player.autoShoot) {
				Bullet_grass_orb g = new Bullet_grass_orb(this.getX(), this.getY(), 8, 8, Entity.BULLET_GRASS_ORB, dx, dy);
				Main.playerBullets.add(g);
			}
		}else {
			if(Entity.isColliding(this, Main.player)) {
				Main.player.haveGrass = true;
			}
			
		}
		
	}
	
	
}
