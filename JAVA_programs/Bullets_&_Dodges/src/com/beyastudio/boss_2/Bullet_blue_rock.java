package com.beyastudio.boss_2;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;

public class Bullet_blue_rock extends Bullet{

	public Bullet_blue_rock(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		
		this.maskx = 1;
		this.masky = 1;
		
		this.mwidth = 6;
		this.mheight = 6;
		
		this.spd = .4;
		
		this.damage = 15;
	}

}
