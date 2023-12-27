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
	
	public boolean isDamaged = false, canCreat = false;
	
	public int count = 0;
	
	public int damageFrames = 5, currentFrames = 0;

	private boolean att = false;
	
	private double dx, dy;
	
	private double attackSpeed;
	private double nextShoot;
	
	private double angle;
	
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
			this.estado = "fase_4";
				attackSpeed = 4;
				att = true;
				canCreat = true;
				count = 0;
			}
			
			break;
			
			
			
		case "fase_1":
			
			count ++;
			
			if(canCreat) {
				
				canCreat = false;
			}
			
			if (System.currentTimeMillis() < nextShoot) {
				return;
			}
			 

			nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
			
			angle = Math.toRadians(45 + count);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			Bullet_blue_fire fb = new Bullet_blue_fire(this.getX(), this.getY(), 16, 16, Entity.BULLET_BLUE_FIRE, dx, dy, -angle);
			Main.BossBullets.add(fb);
			
			
			angle = Math.toRadians(225 + count);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			Bullet_blue_fire fb1 = new Bullet_blue_fire(this.getX(), this.getY(), 16, 16, Entity.BULLET_BLUE_FIRE, dx, dy, -angle);
			Main.BossBullets.add(fb1);
			
			
			
			angle = Math.toRadians(315 + count);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			Bullet_fire_blast b = new Bullet_fire_blast(this.getX(), this.getY(), 16, 16, Entity.BULLET_FIRE_BLAST, dx, dy, -angle);
			Main.BossBullets.add(b);
			
			
			angle = Math.toRadians(135 + count);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			Bullet_fire_blast b1 = new Bullet_fire_blast(this.getX(), this.getY(), 16, 16, Entity.BULLET_FIRE_BLAST, dx, dy, -angle);
			Main.BossBullets.add(b1);
			
			angle = Math.toRadians(90 + count);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			Bullet_blue_rock blue = new Bullet_blue_rock(this.getX(), this.getY(), 8, 8, Entity.BULLET_BLUE_ROCK, dx, dy);
			Main.BossBullets.add(blue);
			
			angle = Math.toRadians(270 + count);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);
			
			Bullet_blue_rock red = new Bullet_blue_rock(this.getX(), this.getY(), 8, 8, Entity.BULLET_RED_ROCK, dx, dy);
			Main.BossBullets.add(red);
			
			if(life <= (maxLife * .8)){
			this.estado = "fase_2";
				attackSpeed = 0;
				canCreat = true;
			}
			
			break;
			
			
			
			
		case "fase_2":
			
			if(canCreat) {
				
				
				canCreat = false;
			}
			
			
			
			
			
			
			
			
			
			
			if(life <= (maxLife * .5)){
			this.estado = "fase_3";
				attackSpeed = 0;
				canCreat = true;
			}
			
			
			break;
			
			
		case "fase_3":
			
			if(canCreat) {
				
				canCreat = false;
			}
			
			if(life <= (maxLife * .3)){
			this.estado = "fase_4";
				attackSpeed = 1.5;
				canCreat = true;
			}
			
			break;
		
			
		case "fase_4":
			
			
			if(canCreat) {
				

				
				Fire_pilar p = new Fire_pilar(30, 728 + 32,Entity.RED_FIRE_PILAR, 180, "red");
				Main.shootWalls.add(p);
				
				Fire_pilar p1 = new Fire_pilar(30, 640 - 32,Entity.RED_FIRE_PILAR, 270, "blue");
				Main.shootWalls.add(p1);
				
				
				Fire_pilar p2 = new Fire_pilar(272, 616 - 8,Entity.RED_FIRE_PILAR, 179, "red");
				Main.shootWalls.add(p2);
				
				Fire_pilar p3 = new Fire_pilar(272, 768-8 ,Entity.RED_FIRE_PILAR, 180, "blue");
				Main.shootWalls.add(p3);
				
				
				canCreat = false;
			}
			
			
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
			if (estado == "fase_2") sprites[1] = Entity.FLIP_FIRE;
			else sprites[1] = Main.spritesheet.getSpritesheet(104, 208, 16, 16);
			
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
