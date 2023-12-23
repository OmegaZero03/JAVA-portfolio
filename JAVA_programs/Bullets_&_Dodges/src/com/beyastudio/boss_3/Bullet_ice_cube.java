package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Bullet_ice_cube extends Bullet{

	
	
	private double angle = 360, aux = .1; 
	
	///////////////////
	public int range = 19;
	///////////////////
	private int range_mux = 8 * range;
	private double lifeTime_right, lifeTime_left, lifeTime_up, lifeTime_down;
	
	
	public Bullet_ice_cube(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);

		this.maskx = 5;
		this.masky = 4;
		this.mwidth = 7;
		this.mheight = 7;
		this.spd = 1;
		this.damage = 20;
		
		lifeTime_right = x + range_mux;
		lifeTime_left = x - range_mux;
		lifeTime_up = y + range_mux;
		lifeTime_down = y - range_mux;
	}
	
	
	
	
	@Override
	public void tick() {
		super.tick();
		angle -= aux;
		if(angle <= 0) {
			angle = 360;
		}
		
		
		if ((x >= lifeTime_right) || (x <= lifeTime_left) || (y >= lifeTime_up) || (y <= lifeTime_down)) {
			Main.BossBullets.remove(this);
		}
		

	}
	
	
	
	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(angle, this.getX() - Camera.x + 8, this.getY() + 8 - Camera.y);
		
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		g2.rotate( - angle, this.getX() - Camera.x + 8, this.getY() + 8 - Camera.y);

		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
		
	}
	
	
	
	

}
