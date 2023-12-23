package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Bullet_grass_orb extends PlayerBullet{

	public Bullet_grass_orb(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, int range) {
		super(x, y, width, height, sprite, dx, dy, range);
		
		this.maskx = 2;
		this.masky = 2;
		this.mwidth = 4;
		this.mheight = 4;
		
		this.damage = 2;
		this.spd = 2;
		this.range = 9;
		
		this.heal = 0;
	}

	@Override
	public void tick() {
		super.tick();
		
		
		if (Main.boss_3 == null)return;
		if(Entity.isColliding(this, Main.boss_3)) {
			Main.boss_3.life -= damage;
		}
	}
	
}
