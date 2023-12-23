package com.beyastudio.boss_3;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;

public class Bullet_penguin extends Bullet{

	public Bullet_penguin(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		this.maskx = 1;
		this.masky = 1;
		this.mwidth = 6;
		this.mheight = 7;
		this.spd = .7;
		
		this.damage = 15;
	}

}
