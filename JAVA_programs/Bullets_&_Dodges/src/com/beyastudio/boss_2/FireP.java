package com.beyastudio.boss_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class FireP extends Entity{
	
	private int frames = 0,
			maxFrames = 20,
			index = 0,
			maxIndex = 1;
	
	public boolean isDamaged = false;
	
	public int count = 0;
	
	public int damageFrames = 5, currentFrames = 0;

	private boolean att = false;
	
	private double dx, dy;
	
	private double attackSpeed;
	private double nextShoot;
	
	private BufferedImage[] sprites;
	
	private String estado = "parado";
	
	public FireP(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.life = 575;
		this.maxLife = 575;
		
		sprites = new BufferedImage[2];
		sprites[0] = Main.spritesheet.getSpritesheet(88, 208, 16, 16);
		sprites[1] = Main.spritesheet.getSpritesheet(104, 208, 16, 16);
	}
	
	@Override 
	public void tick() {
		
		
		if (life <= 0) {
			Main.isBossF = false;
		}
		
		stateMachine();
		
		
		if(att) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			
			}
		}
		
		if(isDamaged) {
			this.currentFrames++;
			if(this.currentFrames == this.damageFrames) {
				this.currentFrames = 0;
				isDamaged = false;
				
			}
			
		}
		
		
	}
	
	
	
	public void stateMachine() {
		
		switch(estado) {
		
		case "parado":
			
			
			if(life != maxLife) {
				this.estado = "fase_1";
				att = true;
				attackSpeed = 1.5;
			}
			
			break;
		
			
		case "fase_1":
			
			if (System.currentTimeMillis() < nextShoot) {
				return;
			}

			nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
			count++;
			
			if(count < 5) return;
			
			if(count < 50) {
				for(int i = 0; i < 4; i++) {
					double angle = Math.toRadians(45 + (i * 90));
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					Bullet_fire_star bf = new Bullet_fire_star(this.getX(), this.getY(), 16, 16, Entity.BULLET_FIRE_STAR, dx, dy);
					Main.BossBullets.add(bf);
				}
			}
			
			if(count < 55) return;
			else{
				
				for(int i = 0; i < 4; i++) {
					double angle = Math.toRadians(90+ (i * 90));
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					Bullet_fire_star bf = new Bullet_fire_star(this.getX(), this.getY(), 16, 16, Entity.BULLET_FIRE_STAR, dx, dy);
					Main.BossBullets.add(bf);
				}
				if(count > 90) {
					count  = 0;
				}
			}
			
			
			
			
			
			
			break;

		}
		
		
		
		
	}
	
	
	@Override
	public void render(Graphics g) {
		
		
		if(!isDamaged) {
			sprites[0] = Main.spritesheet.getSpritesheet(88, 208, 16, 16);
			sprites[1] = Main.spritesheet.getSpritesheet(104, 208, 16, 16);
			
			if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}else {
			
			sprites[0] = Entity.FIRE_DAMAGED_1;
			sprites[1] = Entity.FIRE_DAMAGED_2;
			
			if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			
		}
		
		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}		
		
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x - 2, (int) y - 4 - Camera.y, 20, 2);
			g.setColor(new Color(0xff249fde));
			g.fillRect((int) x - Camera.x - 2, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
		}
	}
}
