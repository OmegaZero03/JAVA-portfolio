package com.beyastudio.boss_3;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.main.Main;


public class Bullet_spear extends Bullet{
	
	protected double range = 1.7;
	/**********************/

	private double range_mux = 8 * range;
	
	private double lifeTime_right, lifeTime_left, lifeTime_up, lifeTime_down;
	
	public Bullet_spear(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		
		this.maskx = 6;
		this.masky = 2;
		this.mwidth = 5;
		this.mheight = 11;
		this.spd = .3;
		this.damage = 34;

		lifeTime_right = x + range_mux;
		lifeTime_left = x - range_mux;
		lifeTime_up = y + range_mux;
		lifeTime_down = y - range_mux;

	}
	
	@Override
	public void tick() {
		super.tick();
		selfDestroy();
	}
	
	public void selfDestroy() {
		if ((x >= lifeTime_right) || (x <= lifeTime_left) || (y >= lifeTime_up) || (y <= lifeTime_down)) {
			Main.BossBullets.remove(this);
		}
	}
	
}
