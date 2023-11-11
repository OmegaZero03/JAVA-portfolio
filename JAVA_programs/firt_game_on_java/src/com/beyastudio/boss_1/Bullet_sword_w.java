package com.beyastudio.boss_1;

import java.awt.image.BufferedImage;

public class Bullet_sword_w extends Bullet {

	public Bullet_sword_w(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);

		this.maskx = 2;
		this.masky = 7;
		this.mwidth = 12;
		this.mheight = 4;

		this.damage = 10;
		this.spd = 3;

	}

}
