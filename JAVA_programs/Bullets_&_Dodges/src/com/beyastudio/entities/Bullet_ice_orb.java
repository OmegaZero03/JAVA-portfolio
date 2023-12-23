package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Bullet_ice_orb extends PlayerBullet{
	
	public Bullet_ice_orb(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, int range) {
		super(x, y, width, height, sprite, dx, dy, range);
		// TODO Auto-generated constructor stub
		
		this.maskx = 1;
		this.masky = 1;
		this.mwidth = 5;
		this.mheight = 5;
		
		this.damage = 4;
		this.spd = 1;
		
		this.heal = 0;
	}

	@Override
	public void tick() {
		super.tick();
		
		
		if (Main.boss_2 == null)return;
		if(Entity.isColliding(this, Main.boss_2)) {
			Main.boss_2.life -= damage;
		}
		
		if (Main.boss_1 == null)return;
		if(Entity.isColliding(this, Main.boss_1)) {
			Main.boss_1.life += 2;
		}
		
	}

}
