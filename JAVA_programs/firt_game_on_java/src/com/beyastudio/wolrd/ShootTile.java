package com.beyastudio.wolrd;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.boss_1.Bullet_sword_h;
import com.beyastudio.boss_1.Bullet_sword_slow;
import com.beyastudio.boss_1.Bullet_sword_w;
import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class ShootTile extends WallTile{	
	
	private double angle, dx, dy;
	private double attackSpeed = 2;
	private double nextShoot = 0;
	
	
	public ShootTile(int x, int y, BufferedImage sprite, int angle) {
		super(x, y, sprite);
		
		this.angle = Math.toRadians(angle);
	}

	
	public void tick(){
		
		if(System.currentTimeMillis()< nextShoot) return;
		
		nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
		
		dx = Math.cos(angle);
		dy = Math.sin(angle);
		
		if(angle == Math.toRadians(360)) {
			
			Bullet b = new Bullet_sword_w(this.getX() + 17, this.getY(), 16, 16, Entity.BULLET_FINN_SWORD_0, dx, dy);
			Main.finnBullets.add(b);
		}
		else if(angle == Math.toRadians(180)) {
			Bullet b1 = new Bullet_sword_w(this.getX() - 17, this.getY(), 16, 16, Entity.BULLET_FINN_SWORD_180, dx, dy);
			Main.finnBullets.add(b1);
		}
		else if(angle == Math.toRadians(90)) {
			Bullet b2 = new Bullet_sword_h(this.getX(), this.getY() + 17, 16, 16, Entity.BULLET_FINN_SWORD_270, dx, dy);
			Main.finnBullets.add(b2);
		}
		else if(angle == Math.toRadians(270)) {
			Bullet b3 = new Bullet_sword_h(this.getX(), this.getY() - 17, 16, 16, Entity.BULLET_FINN_SWORD_90, dx, dy);
			Main.finnBullets.add(b3);
		}
		
		
		
		
	}


	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	
}
