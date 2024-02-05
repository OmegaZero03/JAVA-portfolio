package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Fire_orbital extends Entity{
	
	private int frames = 0,
			maxFrames = 10,
			index = 0,
			maxIndex = 5;
	
	private double atackSpeed = 1.8;
	private int spdAdd = 4;
	
	private int bullet_range = 7;
	
	private int spd;
	private double mx, my, angle;
	private double nextShoot = 0,
				   dx, dy;
	
	private BufferedImage [] sprites;
	
	public Fire_orbital(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		
		sprites = new BufferedImage[6];
		
		for(int i = 0; i < 6; i++) {
			sprites[i] = Main.spritesheet.getSpritesheet(144 + (i * 8), 8, 8, 8);
		}

	}

	@Override
	public void tick() {
		
		if(Main.player.haveFire) {
			spd += spdAdd;
			
			angle = Math.toRadians(90 + spd);
			double radius = 10;

			dy = Math.sin(angle);
			dx = Math.cos(angle);
			
			x = Main.player.getX() + (radius*dx);
			y = Main.player.getY() + (radius*dy);
			
			
			this.mx = Main.player.mx;
			this.my = Main.player.my;
		
			if(System.currentTimeMillis()< nextShoot) {
				return;
			}
			
			nextShoot = System.currentTimeMillis() + (atackSpeed * 100);
	
			double angle = Math.atan2(my - (this.getY() - Camera.y + 5) , mx - (this.getX() - Camera.x + 5));
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			if(Main.player.shoot || Main.player.autoShoot) {
				Bullet_fire_orb g = new Bullet_fire_orb(this.getX(), this.getY(), 8, 8, Entity.BULLET_FIRE_ORB, dx, dy,bullet_range);
				Main.playerBullets.add(g);
			}
		}else {
			
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			
			}
			
			if(Entity.isColliding(Main.player,this)) {
				Main.ui.orbF = true;
				Main.player.haveFire = true;
			}
		}
	}
	
	
	
	
	@Override 
	public void render(Graphics g) {
		
		
		if(Main.player.haveFire) {
			g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
			
			if(geralDebug) {
				g.setColor(Color.RED);
				g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
			}
		}
		
		else {
			
			g.setColor(new Color(0xff450068));
			g.fillRect(this.getX() - Camera.x, this.getY() - Camera.y, 8, 8);
			g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		
	}
}