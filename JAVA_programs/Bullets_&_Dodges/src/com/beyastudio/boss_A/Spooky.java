package com.beyastudio.boss_A;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Spooky extends Entity{
	
	int time = 0;
	int dir = 0;
	
	
	private double dx, dy, angle;
	private String estado = "parado";
	
	private boolean att = false, canCreat = false, attacking = false, walking = false;
	
	public int damageFrames = 5, currentFrames = 0;
	
	private BufferedImage[] sprites, spritesAtt; 
	
	private int frames = 0,
			maxFrames = 9,
			index = 0,
			maxIndex = 2;

	public Spooky(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.life = 1000;
		this.maxLife = 1000;
		
		sprites = new BufferedImage[3];
		
		
		for (int i=0; i<3; i++) {
			sprites[i] = Main.spritesheet.getSpritesheet(0 + (i*16), 16, 16, 16);
		}
		
		
		spritesAtt = new BufferedImage[3];
		
		for (int i=0; i<3; i++) {
			sprites[i] = Main.spritesheet.getSpritesheet(64 + (i*16), 16, 16, 16);
		}
	}
	
	
	@Override
	public void tick() {
		
		
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
		
		
		
		
		stateMachine();
	}
	
	
	@Override
	public void render(Graphics g) {
		
		super.render(g);
		
		if(!isDamaged) {
			if(attacking) {
				
				spritesAtt[0] = Main.boss_placeholders.getSpritesheet(64, 16, 16, 16);
				spritesAtt[1] = Main.boss_placeholders.getSpritesheet(80, 16, 16, 16);
				spritesAtt[2] = Main.boss_placeholders.getSpritesheet(96, 16, 16, 16);
				
				if(index == 0) g.drawImage(spritesAtt[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(spritesAtt[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 2) g.drawImage(spritesAtt[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}
			if(walking) {
				
				sprites[0] = Main.boss_placeholders.getSpritesheet(0, 16, 16, 16);
				sprites[1] = Main.boss_placeholders.getSpritesheet(16, 16, 16, 16);
				sprites[2] = Main.boss_placeholders.getSpritesheet(32, 16, 16, 16);
				
				if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 2) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
		}else {
		
			if(walking) {
				
				sprites[0] = Entity.ICE_DAMAGED_ATT_1;
				sprites[1] = Entity.ICE_DAMAGED_ATT_2;
				sprites[2] = Entity.ICE_DAMAGED_ATT_2;
				
				if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 2) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			if(attacking) {
				
				spritesAtt[0] = Entity.ICE_DAMAGED_WALK_1;
				spritesAtt[1] = Entity.ICE_DAMAGED_WALK_2;
				
				if(index == 0) g.drawImage(spritesAtt[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(spritesAtt[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			
		
		}
		
		
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, 20, 2);
			g.setColor(new Color(0xff5c31ab));
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
		}

	}
	
	
	public void stateMachine() {
		
		switch(estado) {
		
		case "parado":
			
			
			walking = true;
			attacking = false;
			
			att = true;
			
			time++;
			
			
			float spd = .5f;
			
			switch(dir) {
				case 0:
					y+=spd;
					x-=spd;
					
					if(time >= 100) {
						dir = 1;
					}
					
					break;
					
				case 1:
					y+=spd;
					x+=spd;
					System.out.println("???");
					if(time >= 200) {
						dir = 2;
					}
					
					break;
					
				case 2:
					y-=spd;
					x+=spd;
					
					if(time > 300) {
						dir = 3;
					}
					
					break;
					
				case 3:
					y-=spd;
					x-=spd;
					
					if(time > 400) {
						time = 0;
						dir = 0;
					}
					
					break;
				
			}

			
			
			
			if(life != maxLife) {
			this.estado = "fase_1";
				canCreat = true;

			}
			
			break;
			
			
		case "fase_1":
			
			
			System.out.println(walking);
			System.out.println(attacking);
			
			int playerY = Main.player.getY() - 5;
			int playerX = Main.player.getX() - 3;
			double dis = this.calculateDistance(this.getX(), this.getY(), Main.player.getX(), Main.player.getY());
			
			if(dis > 0) {
				
				walking = false;
				attacking = true;
				
				spd = .5f;

				angle = Math.atan2(playerY- y, playerX - x);

				dx = Math.cos(angle);
				dy = Math.sin(angle);
			
				x += dx * spd;
				y += dy * spd;
			}
			
			break;
		}
	}

}
