package com.beyastudio.boss_1;

import java.awt.image.BufferedImage;

public class Bullet_sword_slow extends Bullet {

	public Bullet_sword_slow(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, double spd) {
		super(x, y, width, height, sprite, dx, dy);

		this.maskx = 7;
		this.masky = 2;
		this.mwidth = 4;
		this.mheight = 12;

		this.damage = 25;
		this.spd = spd;

	}
	
}

