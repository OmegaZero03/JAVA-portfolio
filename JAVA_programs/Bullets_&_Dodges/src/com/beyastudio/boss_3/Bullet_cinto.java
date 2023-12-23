package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.wolrd.Camera;

public class Bullet_cinto extends Bullet{
	
	
	private double angle = 360, aux = .23; 

	public Bullet_cinto(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		this.maskx = 4;
		this.masky = 4;
		
		this.mwidth = 8;
		this.mheight = 8;
		
		this.spd = 2.7;
		
		this.damage = 37;
		
	}
	
	
	@Override
	public void tick() {
		super.tick();
		
		angle -= aux;
		if(angle <= 0) {
			angle = 360;
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
