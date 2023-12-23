package com.beyastudio.boss_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Bullet_slash extends Bullet{

	
	private double angle = 0, aux; 

	public Bullet_slash(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite, dx, dy);
		
		this.maskx = 6;
		this.masky = 5;
		
		this.mwidth = 4;
		this.mheight = 5;
		
		this.spd = .3;
		this.damage = 34;
		
		this.aux = Main.ran.nextDouble(0.5);
		
	}

	@Override
	public void tick() {
		
		super.tick();
		
		angle += aux;
		if(angle >= 360) {
			angle = 0;
		}

	}
	
	
	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(angle, this.getX() - Camera.x + 7, this.getY() + 7 - Camera.y);
		
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		g2.rotate( - angle, this.getX() - Camera.x + 7, this.getY() + 7 - Camera.y);

		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
		
	}
	
	
}
