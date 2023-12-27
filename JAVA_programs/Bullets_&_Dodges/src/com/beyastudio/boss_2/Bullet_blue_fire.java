package com.beyastudio.boss_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.beyastudio.wolrd.Camera;

public class Bullet_blue_fire extends Bullet_fire_blast{

	public Bullet_blue_fire(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy,
			double angle) {
		super(x, y, width, height, sprite, dx, dy, angle);
		
		this.maskx = 4;
		this.masky = 6;
		
		this.mwidth = 10;
		this.mheight = 11;
		
		this.spd = 2;
		
		this.damage = 35;
	}
	
	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(angle, this.getX() - Camera.x + 7, this.getY() + 10 - Camera.y);
		
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		g2.rotate( - angle, this.getX() - Camera.x + 7, this.getY() + 10 - Camera.y);

		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
		
	}

}
