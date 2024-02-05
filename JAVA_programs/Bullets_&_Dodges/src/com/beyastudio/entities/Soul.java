package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Soul extends Entity{

	private int spdAdd = 1;
	private int spd;
	private double dx, dy, angle;
	
	private int true_life = 66;
	private boolean goMore;
	private int amp = 70;
	private String type;
	private int lado = 1;
	private boolean drawShape = false;
	private int count;
	public int damageFrames = 5, currentFrames = 0;
	private int chance, roll;
	private int rollArt;
	
	public Soul(int x, int y, int width, int height, BufferedImage sprite, String type) {
		super(x, y, width, height, null);
		
		this.type = type;
		this.life = true_life;
		this.maxLife = true_life;
		
		roll = Main.ran.nextInt(100);
		rollArt = Main.ran.nextInt(100);
		chance = 0;
	}
	
	@Override
	public void tick() {
		
		if(life <= 0) {
			
			//System.out.println("SEU ROLL FOI DE = "+roll);
			System.out.println("SEU ROLL FOI DE = "+rollArt);
			
			if(rollArt >= 85) {
				
				switch(type) {
				
				case"grass":
					if(Main.flower) {
						Flower f = new Flower(getX(), this.getY(), 8, 8, Entity.FLOWER);
						Main.entities.add(f);
						Main.flower = false;
					}
					break;
					
					
				case"fire":
					if(Main.beeCreab) {
						BeeCrab bc = new BeeCrab(getX(), this.getY(), 8, 8, Entity.BEE);
						Main.entities.add(bc);
						Main.beeCreab = false;
					}
					break;
					
					
				case"ice":
					if(Main.crown) {
						Crown c = new Crown(getX(), this.getY(), 8, 8, Entity.CROWN_DIR);
						Main.entities.add(c);
						Main.crown = false;
					}

					break;
					
				}
			}
			
			if(roll <= 30) {
				Dmg_up dmg = new Dmg_up(this.getX() - 16, this.getY(), 8,8, Entity.DMG_UP);
				Main.entities.add(dmg);
				Heal_up heal = new Heal_up(this.getX() + 16, this.getY(), 8,8, Entity.HEAL_UP);
				Main.entities.add(heal);
			}
			else if(roll <= 60) {
				Dmg_up dmg1 = new Dmg_up(this.getX() - 16, this.getY(), 8,8, Entity.DMG_UP);
				Main.entities.add(dmg1);
				Attspd_up attspd1 = new Attspd_up(this.getX() + 16, this.getY(), 8,8, Entity.ATTSPD_UP);
				Main.entities.add(attspd1);

			}
			else if(roll <= 80) {
				Heal_up heal12 = new Heal_up(this.getX() + 16, this.getY(), 8,8, Entity.HEAL_UP);
				Main.entities.add(heal12);
				Attspd_up attspd = new Attspd_up(this.getX() - 16, this.getY(), 8,8, Entity.ATTSPD_UP);
				Main.entities.add(attspd);
			}else {
				Dmg_up dmg21 = new Dmg_up(this.getX() + 16, this.getY(), 8,8, Entity.DMG_UP);
				Main.entities.add(dmg21);
				Spd_up spd = new Spd_up(this.getX() - 16, this.getY(), 8,8, Entity.SPD_UP);
				Main.entities.add(spd);
			}		
			
			Main.entities.remove(this);
		}
		
		switch(type) {
			
		case "grass":
			if(drawShape == false) {
				count++;
				y += 1;
				
				if(count >= amp + 60) {
					drawShape = true;
					count = 0;
				}
			}else {
				switch(lado) {
				case 1:
					count++;
					x-=1;
					
					if(goMore == false) {
						if(count >= amp) {
							lado = 2;
							count = 0;
						}
					}else {
						if(count >= amp + amp) {
							lado = 2;
							count = 0;
						}
					}
					
					break;
					
				case 2:
					count++;
					y-=1;
					
					if(count >= amp) {
						lado = 3;
						count = 0;
					}
					break;
					
					
				case 3:
					count++;
					x+=1;
					
					if(count >= amp + amp) {
						lado = 4;
						count = 0;
					}
					break;
					
				case 4:
					count++;
					y+=1;
					
					if(count >= amp) {
						lado = 1;
						count = 0;
						goMore = true;
						
					}
					break;
				}
			}
			
			break;
			
			
		case "ice":
			if(drawShape == false) {
				count++;
				y -= 1;
				
				if(count >= amp) {
					drawShape = true;
					count = 0;
				}
			}else {
				switch(lado) {
				case 1:
					count++;
					x-=1;

					if(count >= amp) {
						lado = 2;
						count = 0;
					}
					
					
					break;
					
				case 2:
					count++;
					y-=1;
					x+=1;
					
					if(count >= amp) {
						lado = 3;
						count = 0;
					}
					break;
					
					
				case 3:
					count++;
					x-=1;
					
					if(count >= amp) {
						lado = 4;
						count = 0;
					}
					break;
					
				case 4:
					count++;
					y+=1;
					x+=1;
					
					if(count >= amp) {
						lado = 1;
						count = 0;
						
					}
					break;
				}
			}
			
			break;
		
			
		case "fire":
			
			spd += spdAdd;
			
			angle = Math.toRadians(90 + spd);
			double radius = 40;

			dy = Math.sin(angle);
			dx = Math.cos(angle);
			
			x = 140 + (radius*dx);
			y = 660 + (radius*dy);
			
			break;
		
		}
		
		if(isDamaged) {
			this.currentFrames++;
			if(this.currentFrames == this.damageFrames) {
				this.currentFrames = 0;
				isDamaged = false;
				
			}
			
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
		switch(this.type) {
		
		case "grass":
			
			if(!isDamaged) {
				sprite = Entity.GRASS_SOUL;
			}else {
				this.setSprite(Entity.HURT_GRASS_SOUL);
				g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			
			break;
			
			
		case "ice":
			
			if(!isDamaged) {
				sprite = Entity.ICE_SOUL;
			}else {
				
				this.setSprite(Entity.HURT_ICE_SOUL);
				g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}
			break;
		
			
		case "fire":
			if(!isDamaged) {
				sprite = Entity.FIRE_SOUL;
			}else {
				
				this.setSprite(Entity.HURT_FIRE_SOUL);
				g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}
			break;
	
	}
		
		g.setColor(Color.red);
		g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, 20, 2);
		if(type == "grass") {
			g.setColor(Color.ORANGE);
		}else if(type == "ice") {
			g.setColor(Color.GREEN);
		}else if(type == "fire") {
			g.setColor(new Color(0xff249fde));
		}
		g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
		
		
			super.render(g);
	}
	

}
