package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class IceKing extends Entity{
	
	private String estado = "parado";
	
	private double spd = 0;
	
	private double attackSpeed = 8,
				nextShoot = 0,
				angle, anglep, anglepp,
				dx, dy;
	
	private boolean canCreat, att = false;
	
	private int frames = 0,
			maxFrames = 8,
			index = 0,
			maxIndex = 1;
	
	private int count = 0, aux = 30;
	
	private BufferedImage[] sprites;

	public IceKing(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		this.life = 550;
		this.maxLife = 550;
		
		sprites = new BufferedImage[2];
		sprites[0] = Main.spritesheet.getSpritesheet(0, 192, 16, 16);
		sprites[1] = Main.spritesheet.getSpritesheet(16, 192, 16, 16);
			
	}
	
	public void tick() {
		if (life <= 0) {
			Main.isBossI = false;
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

	}
	
	
	public void stateMachine() {
		
		switch(estado){
			case "parado":
				spd = 1;
				
				if(life!=maxLife) {
					this.estado = "fase_1"; 
					this.setAttackSpeed(.7);
					canCreat = true;
					att = true;
				}
				break;
				
				
			case "fase_2":
				
//				 if(canCreat) {
//
//					 canCreat = false;
//				 }
				 
				//anglep = Main
				angle = Math.toRadians(90);
				
				if (System.currentTimeMillis() < nextShoot) return;
					
				nextShoot = System.currentTimeMillis() + (attackSpeed * 100);

				

				
				for(int i = 0; i < 4; i++) {
					
					dx = Math.cos(angle + (i * angle));
					dy = Math.sin(angle + (i * angle));
					if(i == 0) {
						Bullet_spear bs = new Bullet_spear(this.getX() + 4, this.getY(), 16, 16, Entity.BULLET_ICE_SPEAR_90, dx, dy);
						Main.BossBullets.add(bs);
					}else if(i == 1) {
						Bullet_spear bs = new Bullet_spear(this.getX(), this.getY() + 4, 16, 16, Entity.BULLET_ICE_SPEAR_180, dx, dy);
						Main.BossBullets.add(bs);
					}else if(i == 2) {
						Bullet_spear bs = new Bullet_spear(this.getX() - 4, this.getY(), 16, 16, Entity.BULLET_ICE_SPEAR_270, dx, dy);
						Main.BossBullets.add(bs);
					}else {
						Bullet_spear bs = new Bullet_spear(this.getX(), this.getY() - 4, 16, 16, Entity.BULLET_ICE_SPEAR_0, dx, dy);
						Main.BossBullets.add(bs);
					}
					
				}//for
				
				
				if(this.getX() > Main.player.getX()) {
					x -= spd;
				}
				else if(this.getX() < Main.player.getX()) {
					x+=spd;
				}
				if(this.getY() > Main.player.getY()) {
					y-=spd;
				}
				else if(this.getY() < Main.player.getY()) {
					y+=spd;
				}
				
				
				break;	
				
				
				
			case "fase_1":
				
//				
//				if (System.currentTimeMillis() < nextShoot) return;
//				
//				nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
//				
				
				if(count < aux) {
					
					if (System.currentTimeMillis() < nextShoot) return;
					
					nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
					
				anglep += 9;

				angle = Math.toRadians(330 +  anglep);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_flake bf = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
				Main.BossBullets.add(bf);
				
				angle = Math.toRadians(90 +  anglep);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_flake bf2 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
				Main.BossBullets.add(bf2);
				
				angle = Math.toRadians(210 +  anglep);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_flake bf3 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
				Main.BossBullets.add(bf3);
				
				}
				
				if (count > aux){
					
					
					if (System.currentTimeMillis() < nextShoot) return;
					
					nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
					
					anglepp -= 9;

					angle = Math.toRadians(330 +  anglepp);
					
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					
					Bullet_flake bf = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
					Main.BossBullets.add(bf);
					
					angle = Math.toRadians(90 +  anglepp);
					
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					
					Bullet_flake bf2 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
					Main.BossBullets.add(bf2);
					
					angle = Math.toRadians(210 +  anglepp);
					
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					
					Bullet_flake bf3 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
					Main.BossBullets.add(bf3);
					
					if(count > aux * 2) {
						count = 0;
					}
					
				}
				
				System.out.println(count);
				count++;
				
				
				if(this.life <= maxLife * 0.8) {
					estado = "fase_2";
					canCreat = true;
					this.setAttackSpeed(8);
					spd = 4;
				}
				

				
				break;
				
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
		super.render(g);
		if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, 10, 2);
			g.setColor(Color.GREEN);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 10), 2);
		}

	}
	
}
