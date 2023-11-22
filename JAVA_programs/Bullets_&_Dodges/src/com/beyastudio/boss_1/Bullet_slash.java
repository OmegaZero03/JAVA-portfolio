package com.beyastudio.boss_1;

import java.awt.image.BufferedImage;

public class Bullet_slash extends Bullet{

	
	
	
	public Bullet_slash(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		this.maskx = 6;
		this.masky = 5;
		
		this.mwidth = 4;
		this.mheight = 5;
		
		this.spd = .3;
		this.damage = 34;
		
	}

}
