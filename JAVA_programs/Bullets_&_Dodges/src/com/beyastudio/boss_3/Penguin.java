package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Penguin extends Entity{

	
	private double attackSpeed = 9,
			nextShoot = 0,
			angle, anglep,
			dx, dy;
	
	private int add4 = 4;
	
	private Bullet_penguin b, b2;
	private BufferedImage penguin_hurt;
	
	public int damageFrames = 5, currentFrames = 0;
	
	public Penguin(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		this.life = 21;
		this.maxLife = 21;
		this.anglep = Math.toRadians(20);
		penguin_hurt = Entity.PENGUIN_HURT;
	}

	
	@Override
	public void tick(){
		
		if(life <= 0) {
			Main.entities.remove(this);
		}
		
		
		if(isDamaged) {
			this.currentFrames++;
			if(this.currentFrames == this.damageFrames) {
				this.currentFrames = 0;
				isDamaged = false;
				
			}
			
		}
		
		
		/******* Attackspeed system ********/
		if (System.currentTimeMillis() < nextShoot) return;
		
		nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
		
		angle = Math.atan2(Main.player.getY()- y, Main.player.getX() - x);
		
		dx = Math.cos(angle + anglep);
		dy = Math.sin(angle + anglep);
		
		b = new Bullet_penguin(this.getX() - add4, this.getY()  - add4, 8, 8, Entity.BULLET_PENGUIN_0, dx, dy);
		Main.BossBullets.add(b);
		
		dx = Math.cos(angle - anglep);
		dy = Math.sin(angle - anglep);
		
		b2 = new Bullet_penguin(this.getX() - add4, this.getY() - add4, 8, 8, Entity.BULLET_PENGUIN_0, dx, dy);
		Main.BossBullets.add(b2);
		
		turnSide(dx);
		
		
	}
	
	
	private void turnSide(double dx) {
		if(dx > 0) {
			this.setSprite(Entity.PENGUIN_EN);
			b.setSprite(Entity.BULLET_PENGUIN_0);
			b2.setSprite(Entity.BULLET_PENGUIN_0);
			this.add4 = -4;
			
		}
		else if(dx < 0) {
			this.setSprite(Entity.PENGUIN_EN_REV);
			b.setSprite(Entity.BULLET_PENGUIN_180);
			b2.setSprite(Entity.BULLET_PENGUIN_180);
		this.add4 = 4;
		}
		
	}
	
	
	
	
	public double getAttackSpeed() {
		return attackSpeed;
	}


	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}


	@Override
	public void render(Graphics g) {
			if(!isDamaged) {
				
				if(dx > 0) {
					this.setSprite(Entity.PENGUIN_EN);
				}
				else if(dx < 0) {
					this.setSprite(Entity.PENGUIN_EN_REV);
				}
				g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}else {
				
				this.setSprite(penguin_hurt);
				g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}
		
			if(geralDebug) {
				g.setColor(Color.RED);
				g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
			}

			g.setColor(Color.red);
			g.fillRect((int)x - Camera.x, (int)y - 4 - Camera.y, 10, 2);
			g.setColor(Color.GREEN);
			g.fillRect((int)x - Camera.x, (int)y - 4 - Camera.y, (int)((life/maxLife)*10) , 2);
	}
}
