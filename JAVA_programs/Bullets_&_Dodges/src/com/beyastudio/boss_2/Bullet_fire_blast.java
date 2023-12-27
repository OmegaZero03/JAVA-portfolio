package com.beyastudio.boss_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.wolrd.Camera;

public class Bullet_fire_blast extends Bullet{
	
	
	protected double angle;

	public Bullet_fire_blast(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, double angle) {
		super(x, y, width, height, sprite, dx, dy);
		
		this.maskx = 4;
		this.masky = 10;
		
		this.mwidth = 8;
		this.mheight = 8;
		
		this.spd = 2.7;
		
		this.damage = 30;
		
		this.angle = angle;
	}
	
	
	
	@Override
	public void tick() {
		super.tick();
		
	}
	
	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(angle, this.getX() - Camera.x + 8, this.getY() + 14 - Camera.y);
		
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		g2.rotate( - angle, this.getX() - Camera.x + 8, this.getY() + 14 - Camera.y);

		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
		
	}

}
