package com.beyastudio.boss_A;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.beyastudio.boss_A_bullets.SakuraShoter;
import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Spooky extends Entity{
	
	int time = 0;
	int dir = 0;
	
	
	private double dx, dy, angle;
	private String estado = "parado";
	
	private boolean att = true, canCreat = true;
	
	//Controle das animações por switch_case
	/*
	 * idle
	 * blink
	 * attack
	 */
	
	private double nextShoot, attackSpeed = 5;
	
	
	
	private String animationState = "idle";
	
	public int damageFrames = 5, currentFrames = 0;
	
	private BufferedImage[] animationSprites, attAnimationSprites;
	
	private int frames = 0,
			maxFrames = 20,
			index = 0,
			maxIndex = 3;
	
	private int idlespriteNum, blinkspriteNum, attSpriteNum;

	public Spooky(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		
		
		this.life = 10000;
		this.maxLife = 10000;
		
		this.idlespriteNum = 4;
		this.blinkspriteNum = 4;
		this.attSpriteNum = 8;
		
		
		animationSprites = new BufferedImage[idlespriteNum];
		attAnimationSprites = new BufferedImage[attSpriteNum];

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
		
		//super.render(g);
		
		if(!isDamaged) {
			switch(this.animationState) {
			
				case "idle":
					
					for(int i=0; i < this.idlespriteNum; i++) {
					animationSprites[i] = Main.boss_samurai.getSpritesheet(0 + (16 * i),0, 16, 16);
					g.drawImage(animationSprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}
					
					break;
					
					
				case "blink":
					
					if(index == 3) {
						maxFrames = 45;
					}else {
						maxFrames = 25;
					}
					
					for(int i=0; i < this.blinkspriteNum; i++) {
					animationSprites[i] = Main.boss_samurai.getSpritesheet(0 + (i*16), 16, 16, 16);
					g.drawImage(animationSprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				}
					
					break;
					
					
				case "attack":
					for(int i=0; i < this.attSpriteNum; i++) {
					attAnimationSprites[i] = Main.boss_samurai.getSpritesheet(0 + (i*32), 32, 32, 32);
					g.drawImage(attAnimationSprites[index], this.getX() - Camera.x - 16, this.getY() - Camera.y - 16, null);
					}
					
					break;
			}
			
		}else {
		
		}
		
		
		if (life != maxLife) {
			
			int yOffSet = -17;
			int xOffSet = 2;
			
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x - xOffSet, (int) y - yOffSet - Camera.y, 20, 2);
			g.setColor(new Color(0xff5c31ab));
			g.fillRect((int) x - Camera.x - xOffSet, (int) y - yOffSet - Camera.y, (int) ((life / maxLife) * 20), 2);
		}

	}
	
	
	public void setAnimation(String animationState) {
		
		this.animationState = animationState;
		index = 0;
		frames = 0;
		
		switch(animationState) {
		
			case "idle":
				maxIndex = 3;
				maxFrames = 20;
				break;
				
			case "blink":
				maxIndex = 3;
				maxFrames = 25;
				break;
				
				
			case "attack":
				maxIndex = 7;
				maxFrames = 10;
				break;
		}
		
	}
	
	public void generateSakuras() {
		
		Sakura s;
		SakuraShoter ss;
		List<Integer> choosen;
		choosen = new ArrayList<Integer>();
		int xx = 0, yy = 0;
		
		
		for(int i=0; i<4; i++) {
			
			if(i == 0) {
				s = new MechSakura(0, 0, 16, 32, Entity.METAL_SAKURA_DOWN, Entity.METAL_SAKURA_UP);
				ss = new SakuraShoter(0, 0, 8, 8, null);
			}
			
			else if(i == 1) {
				s = new Sakura(0, 0, 16, 32, Entity.SAKURA_0_DOWN, Entity.SAKURA_0_UP);
				ss = new SakuraShoter(0, 0, 8, 8, null);
			}
			
			else if(i == 2) {
				s = new Sakura(0, 0, 16, 32, Entity.SAKURA_1_DOWN, Entity.SAKURA_1_UP);
				ss = new SakuraShoter(0, 0, 8, 8, null);
			}
			
			else {
				s = new Sakura(0, 0, 16, 32, Entity.SAKURA_2_DOWN, Entity.SAKURA_2_UP);
				ss = new SakuraShoter(0, 0, 8, 8, null);
			}
			
			
			int ranLocation = Main.ran.nextInt(0, 4);
			
			while(choosen.contains(ranLocation)) ranLocation = Main.ran.nextInt(0, 4);
			
			choosen.add(ranLocation);
			
			switch(ranLocation) {
			
			case 0:
				xx = 408;
				yy = 536;
				break;
				
			case 1:
				xx = 520;
				yy = 536;
				break;
				
			case 2:
				xx = 520;
				yy = 424;
				break;
				
			case 3:
				xx = 408;
				yy = 424;
				break;
			}
			
			ss.setX(xx+12);
			ss.setY(yy);
			s.setX(xx);
			s.setY(yy - 4);
			s.setUp(xx, yy-4);
		}
	}
	
	
	
	
	public void stateMachine() {
		
		switch(estado) {
		
		case "parado":
			
			if(canCreat) {
				
				generateSakuras();
				
				canCreat = false;
			}
			
			att = true;
		
			
			if(life != maxLife) {
			this.estado = "fase_1";
				canCreat = true;
				setAnimation("blink");
			}
			
			break;
			
			
		case "fase_1":
			
			
			
			if(life < 9990)
			{
				
				if(canCreat) {
					setAnimation("attack");
					canCreat = false;
				}
				
				

			}
			
			
			
//         SE QUISER Q ELE ANDE EM UM LOSANGULO
//			time++;
//			
//			
//			float spd = .5f;
//			
//			switch(dir) {
//				case 0:
//					y+=spd;
//					x-=spd;
//					
//					if(time >= 100) {
//						dir = 1;
//					}
//					
//					break;
//					
//				case 1:
//					y+=spd;
//					x+=spd;
//					System.out.println("???");
//					if(time >= 200) {
//						dir = 2;
//					}
//					
//					break;
//					
//				case 2:
//					y-=spd;
//					x+=spd;
//					
//					if(time > 300) {
//						dir = 3;
//					}
//					
//					break;
//					
//				case 3:
//					y-=spd;
//					x-=spd;
//					
//					if(time > 400) {
//						time = 0;
//						dir = 0;
//					}
//					
//					break;
//				
//			}
//			
//			
//
//			
//			int playerY = Main.player.getY() - 5;
//			int playerX = Main.player.getX() - 3;
//			double dis = this.calculateDistance(this.getX(), this.getY(), Main.player.getX(), Main.player.getY());
//			
//			if(dis > 0) {
//				
////				walking = false;
////				attacking = true;
//				
//				spd = .5f;
//
//				angle = Math.atan2(playerY- y, playerX - x);
//
//				dx = Math.cos(angle);
//				dy = Math.sin(angle);
//			
//				x += dx * spd;
//				y += dy * spd;
//			}
//			
//			break;
		}
	}

}
