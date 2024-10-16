package com.beyastudio.boss_A_bullets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Bullet_sakura extends Bullet{
	
	private double xOrigin, yOrigin;
	private float spdAdd = 1f;
	private double angle;
	private int lifeTime;
	public static int LIFE_TIME = 720;
	
	private int playerY = 0, playerX = 0;
	
	private boolean canCalculate = true;
	
	private List<Bullet_sakura> bullets;
	
	

	private double rotateAngle = 0, rotateAux = .01; 


	private double radius = 32;
	
	public Bullet_sakura(int x, int y, int width, int height, BufferedImage sprite, double xOrigin, double yOrigin, List<Bullet_sakura> bullets) {
		super(x, y, width, height, sprite, xOrigin, yOrigin);
		
		Main.BossBullets.add(this);
		
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		
		this.maskx = 4;
		this.masky = 4;
		
		this.mwidth = 8;
		this.mheight = 8;
		
		this.damage = 37;
		
		this.bullets = bullets;
		
		lifeTime = 720;
	}
	
	
	
	@Override
	public void tick() {
		
		
		rotateAngle += rotateAux;
		if(angle >= 360) {
			angle = 0;
		}
		
		
		
		lifeTime--;
		if(lifeTime <= 0) {
//			Main.BossBullets.remove(this);
//			bullets.remove(this);
			

			if (canCalculate) {
				playerY = Main.player.getY();
				playerX = Main.player.getX();
				angle = Math.atan2(playerY- y, playerX - x);
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				canCalculate = false;
			}
				
				spd = .5;
				

			
				x += dx * spd;
				y += dy * spd;
				
			
		}
		else {
		
			spd += spdAdd;
			
			angle = Math.toRadians(90 + spd);
	
			dy = Math.sin(angle);
			dx = Math.cos(angle);
			
			x = xOrigin + (radius*dx);
			y = yOrigin + (radius*dy);
			
		}
		
		isHitting();
	}
	
	
	@Override
	public void isHitting() {
		if (isColliding(this, Main.player)) {
			//Sound.hurtPlayer.play();
			Main.BossBullets.remove(this);
			bullets.remove(this);
			Main.player.life -= damage;
		}
		
		if (isColliding(this, Main.player)) {
			//Sound.hurtPlayer.play();
			Main.BossBullets.remove(this);
			bullets.remove(this);
		}
	}
	
	

	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(rotateAngle, this.getX() - Camera.x + 8, this.getY() + 8 - Camera.y);
		
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		g2.rotate( - rotateAngle, this.getX() - Camera.x + 8, this.getY() + 8 - Camera.y);

		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
	}


}
