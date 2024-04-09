package com.beyastudio.wolrd;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.boss_1.Bullet_sword_slow;
import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class ShootTileSlow extends WallTile{	
	
	private double angle, dx, dy;
	private double attackSpeed = 8.5;
	private double nextShoot = 0;
	
	
	
	public ShootTileSlow(int x, int y, BufferedImage sprite) {
		super(x, y, sprite);

		this.angle = Math.toRadians(90);
	}

	
	public void tick(){
		

		int random = Main.ran.nextInt(101);
		if(System.currentTimeMillis()< nextShoot) return;
		
		nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
		
		dx = Math.cos(angle);
		dy = Math.sin(angle);
		
		
		if(random < 80) {
		Bullet bs = new Bullet_sword_slow(this.getX(), this.getY() + 17, 16, 16, Entity.BULLET_FINN_SWORD_270, dx, dy, .6);
		Main.BossBullets.add(bs);
		}
		return;

	}


	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	
}
