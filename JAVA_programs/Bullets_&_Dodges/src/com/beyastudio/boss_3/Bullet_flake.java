package com.beyastudio.boss_3;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;

public class Bullet_flake extends Bullet{

	public Bullet_flake(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		this.maskx = 2;
		this.masky = 2;
		this.mwidth = 11;
		this.mheight = 11;
		
		this.spd = 2;
		this.damage = 20;
	}

	

}
