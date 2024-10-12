package com.beyastudio.boss_A_bullets;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.main.Main;

public class Bullet_sakura extends Bullet{
	
	private int xOrigin, yOrigin;
	private float spdAdd = 1.5f;
	private double angle;
	
	public Bullet_sakura(int x, int y, int width, int height, BufferedImage sprite, int xOrigin, int yOrigin) {
		super(x, y, width, height, sprite, xOrigin, yOrigin);
		
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		
		this.maskx = 4;
		this.masky = 4;
		
		this.mwidth = 8;
		this.mheight = 8;
		
		this.damage = 37;
	}
	
	
	
	@Override
	public void tick() {
		spd += spdAdd;
		
		angle = Math.toRadians(90 + spd);
		double radius = 16;

		dy = Math.sin(angle);
		dx = Math.cos(angle);
		
		x = xOrigin + (radius*dx);
		y = yOrigin + (radius*dy);
		
		
		super.tick();
	}
	
	

}
