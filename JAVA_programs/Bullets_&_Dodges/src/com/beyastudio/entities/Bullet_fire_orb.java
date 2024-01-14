package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Bullet_fire_orb extends PlayerBullet{

	public Bullet_fire_orb(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, int range) {
		super(x, y, width, height, sprite, dx, dy, range);
		
		this.maskx = 2;
		this.masky = 2;
		this.mwidth = 5;
		this.mheight = 5;
		
		this.damage = (int)3.5;
		this.spd = (int)1.5;
		this.range = 9;
		
		this.heal = 0;
	}

	@Override
	public void tick() {
		super.tick();
		
		
		if (Main.boss_1 == null)return;
		if(Entity.isColliding(this, Main.boss_1)) {
			Main.boss_1.life -= damage;
		}
	}
	
}