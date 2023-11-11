package com.beyastudio.boss_1;

import java.awt.image.BufferedImage;

public class Bullet_sword_h extends Bullet {

	public Bullet_sword_h(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);

		this.maskx = 7;
		this.masky = 2;
		this.mwidth = 4;
		this.mheight = 12;

		this.damage = 10;
		this.spd = 3;

	}
}
