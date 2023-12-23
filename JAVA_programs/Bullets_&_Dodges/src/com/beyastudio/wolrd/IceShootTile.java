package com.beyastudio.wolrd;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_3.Bullet_ice_cube;
import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class IceShootTile extends WallTile{
	
	private double angle, dx, dy;
	private double attackSpeed = 6;
	private double nextShoot = 0;
	

	public IceShootTile(int x, int y, BufferedImage sprite, int angle) {
		super(x, y, sprite);
		
		this.angle = Math.toRadians(angle);

	}
	
	public void tick(){
		
		if(System.currentTimeMillis()< nextShoot) return;
		
		nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
		
		dx = Math.cos(angle);
		dy = Math.sin(angle);
		
		if(angle == Math.toRadians(360)) {
			
			Bullet_ice_cube b = new Bullet_ice_cube(this.getX() + 9, this.getY() + 4, 16, 16, Entity.BULLET_ICE_CUBE, dx, dy);
			Main.BossBullets.add(b);
		}
		else if(angle == Math.toRadians(180)) {
			Bullet_ice_cube b1 = new Bullet_ice_cube(this.getX() - 9, this.getY() + 4, 16, 16, Entity.BULLET_ICE_CUBE, dx, dy);
			Main.BossBullets.add(b1);
		}
		else if(angle == Math.toRadians(90)) {
			Bullet_ice_cube b2 = new Bullet_ice_cube(this.getX() - 4, this.getY() + 2, 16, 16, Entity.BULLET_ICE_CUBE, dx, dy);
			Main.BossBullets.add(b2);
		}
		else if(angle == Math.toRadians(270)) {
			Bullet_ice_cube b3 = new Bullet_ice_cube(this.getX() + 4, this.getY() + 2, 16, 16, Entity.BULLET_ICE_CUBE, dx, dy);
			Main.BossBullets.add(b3);
		}

	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	
	

}
