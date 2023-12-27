package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Entity {
								/*ANY ENTITY LOGIC*/
						/*********////////////////**********/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
						/*********SPRITES SIZE**********/
	private static int _8x8 = 8,
					   _16x_16 = 16;
						/*********/////////////////**********/

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static BufferedImage PUPPY_TALK_0 = Main.spritesheet.getSpritesheet(0, 208, _16x_16, _16x_16),
								PUPPY_TALK_1 = Main.spritesheet.getSpritesheet(0, 224, _16x_16, _16x_16),
								PUPPY_TALK_2 = Main.spritesheet.getSpritesheet(16, 224, _16x_16, _16x_16),
								PUPPY_TALK_3 = Main.spritesheet.getSpritesheet(32, 224, _16x_16, _16x_16);
									
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static BufferedImage CURSED_TOMB_STONE = Main.spritesheet.getSpritesheet(48, 208, _16x_16, _16x_16);
	public static BufferedImage HEAL_EN  	=Main.spritesheet.getSpritesheet(24, 8, _8x8, _8x8);
	public static BufferedImage ENEMY_EN  	=Main.spritesheet.getSpritesheet(32, 8, _8x8, _8x8);
	public static BufferedImage NEXT_LVL 	=Main.spritesheet.getSpritesheet(40, 16, _8x8, _8x8);
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
						/*********GRASS BOSS SPRITES**********/
	public static BufferedImage FINN_EN  	=Main.spritesheet.getSpritesheet(16, 24, _16x_16, _16x_16),
					BULLET_FINN_1 		 	=Main.spritesheet.getSpritesheet(48, 40, _16x_16, _16x_16),
					BULLET_FINN_SWORD_0  	=Main.spritesheet.getSpritesheet(48, 56, _16x_16, _16x_16),
					BULLET_FINN_SWORD_180   =Main.spritesheet.getSpritesheet(64, 56, _16x_16, _16x_16),
					BULLET_FINN_SWORD_90  	=Main.spritesheet.getSpritesheet(96, 56, _16x_16, _16x_16),
					BULLET_FINN_SWORD_270   =Main.spritesheet.getSpritesheet(80, 56, _16x_16, _16x_16),
					BULLET_FINN_SLASH  	 	=Main.spritesheet.getSpritesheet(32, 56, _16x_16, _16x_16),
					BULLET_FINN_FLOWER  	=Main.spritesheet.getSpritesheet(64,  8, _16x_16, _16x_16),
					GRASS_EN   				=Main.spritesheet.getSpritesheet(48, 24, _16x_16, _16x_16);
						/*********/////////////////**********/
	
	
						/*********DAMAGAGED GRASS BOSS SPRITES**********/	
	public static BufferedImage FINN_DAMAGED_CAP = Main.spritesheet.getSpritesheet(72, 160, 16, _16x_16),
								FINN_DAMAGED_CAP_ATT = Main.spritesheet.getSpritesheet(96, 160, 24, _16x_16),
								FINN_DAMAGED_NOT_CAP = Main.spritesheet.getSpritesheet(72, 176, 16, _16x_16),
								FINN_DAMAGED_NOT_CAP_ATT = Main.spritesheet.getSpritesheet(96, 176, 24, _16x_16);

								
	
						/*********/////////////////**********/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
						/*********ICE BOSS SPRITES**********/
	public static BufferedImage ICE_EN     	=Main.spritesheet.getSpritesheet(16, 40, _16x_16, _16x_16),
					BULLET_ICE_FLAKE 		=Main.spritesheet.getSpritesheet(32, 72, _16x_16, _16x_16),
					BULLET_ICE_SPEAR_270	=Main.spritesheet.getSpritesheet(48, 72, _16x_16, _16x_16),
					BULLET_ICE_SPEAR_90		=Main.spritesheet.getSpritesheet(48, 88, _16x_16, _16x_16),
					BULLET_ICE_SPEAR_180	=Main.spritesheet.getSpritesheet(0, 96, _16x_16, _16x_16),
					BULLET_ICE_SPEAR_0		=Main.spritesheet.getSpritesheet(16, 96, _16x_16, _16x_16),
					BULLET_ICE_CINTO 		=Main.spritesheet.getSpritesheet(48, 104, _16x_16, _16x_16),
					BULLET_ICE_CUBE 		=Main.spritesheet.getSpritesheet(48, 120, _16x_16, _16x_16),
					PENGUIN_EN 				=Main.spritesheet.getSpritesheet(32, 88, _8x8, _8x8),
					PENGUIN_EN_REV 			=Main.spritesheet.getSpritesheet(32, 96, _8x8, _8x8),
					BULLET_PENGUIN_0		=Main.spritesheet.getSpritesheet(40, 88, _8x8, _8x8),
					BULLET_PENGUIN_180		=Main.spritesheet.getSpritesheet(40, 96, _8x8, _8x8);
						/*********/////////////////**********/
	
	
	
							/*********DAMAGAGED GRASS BOSS SPRITES**********/	
	public static BufferedImage ICE_DAMAGED_ATT_1 = Main.hurt_spritesheet.getSpritesheet(0, 0, _16x_16, _16x_16),
								ICE_DAMAGED_ATT_2 = Main.hurt_spritesheet.getSpritesheet(16, 0, _16x_16, _16x_16),
								ICE_DAMAGED_WALK_1 = Main.hurt_spritesheet.getSpritesheet(32, 0, _16x_16, _16x_16),
								ICE_DAMAGED_WALK_2 = Main.hurt_spritesheet.getSpritesheet(48, 0, _16x_16, _16x_16);
	
	public static BufferedImage PENGUIN_HURT = Main.hurt_spritesheet.getSpritesheet(64, 0, _8x8, _8x8);

			

								/*********/////////////////**********/
	
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
								/*********FIRE BOSS SPRITES**********/
	
	public static BufferedImage FLIP_FIRE = Main.spritesheet.getSpritesheet(120, 208, _16x_16, _16x_16),
								FIRE_DAMAGED_1 = Main.hurt_spritesheet.getSpritesheet(0, 16, _16x_16, _16x_16),
								FIRE_DAMAGED_2 = Main.hurt_spritesheet.getSpritesheet(16, 16, _16x_16, _16x_16),
								BULLET_FIRE_STAR = Main.spritesheet.getSpritesheet(80, 72, _16x_16, _16x_16),
								BULLET_RED_ROCK = Main.spritesheet.getSpritesheet(136, 64, _8x8, _8x8),
								BULLET_BLUE_ROCK = Main.spritesheet.getSpritesheet(136, 56, _8x8, _8x8),
								RED_FIRE_PILAR =  Main.spritesheet.getSpritesheet(88, 224, _8x8, _16x_16),
								BLUE_FIRE_PILAR =  Main.spritesheet.getSpritesheet(96, 224, _8x8, _16x_16),
								BULLET_FIRE_BLAST = Main.spritesheet.getSpritesheet(64, 72, _16x_16, _16x_16),
								BULLET_BLUE_FIRE = Main.spritesheet.getSpritesheet(120, 56, _16x_16, _16x_16);
								
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage PORTAL_GRASS = Main.spritesheet.getSpritesheet(64, 248, _16x_16, 24),
								PORTAL_FIRE = Main.spritesheet.getSpritesheet(80, 248, _16x_16, 24),
								PORTAL_ICE = Main.spritesheet.getSpritesheet(96, 240, 24, _16x_16),
								PORTAL_ICE_2 = Main.spritesheet.getSpritesheet(96, 256, 24, _16x_16),
								PORTAL_GOLD = Main.spritesheet.getSpritesheet(120, 248, _16x_16, 24);
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
	public static BufferedImage FIRE_EN   	=Main.spritesheet.getSpritesheet(88, 208, _16x_16, _16x_16);
	public static BufferedImage PIKACHU_EN 	=Main.spritesheet.getSpritesheet(40, 0, _16x_16, _16x_16);
	public static BufferedImage BULLET_PL 	=Main.spritesheet.getSpritesheet(72, 0, _8x8, _8x8);
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
						/*********ORBITAIS SPRITE**********/
	
								// grass	
	public static BufferedImage GRASS_ORB   =Main.spritesheet.getSpritesheet(80, 0, _8x8, _8x8),
					BULLET_GRASS_ORB 		=Main.spritesheet.getSpritesheet(80, 8, _8x8, _8x8);
	
								//ice
	
	public static BufferedImage ICE_ORB   =Main.spritesheet.getSpritesheet(96, 0, _8x8, _8x8),
			BULLET_ICE_ORB 		=Main.spritesheet.getSpritesheet(96, 8, _8x8, _8x8);
						/*********/////////////////**********/
	
	
						/*********CAPIVARA**********/	

	public static BufferedImage CAPIVARA_ZEN = Main.spritesheet.getSpritesheet(144, 72, _16x_16, _16x_16),
								CAPIVARA_TALK = Main.spritesheet.getSpritesheet(160, 72, _16x_16, _16x_16),
								CAPIVARA_ZEN_DAMAGED = Main.hurt_spritesheet.getSpritesheet(32, 16, _16x_16, _16x_16),
								CAPIVARA_TALK_DAMAGED = Main.hurt_spritesheet.getSpritesheet(48, 16, _16x_16, _16x_16);

					/*********/////////////////**********/
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
	
	protected int width, height;
	protected double x, y;
	protected int maskx, masky, mwidth, mheight;
	protected BufferedImage sprite;
	public double life, maxLife;
	public boolean isDamaged = false;
	
	public static boolean geralDebug = false;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
		this.maskx = 0;
		this.masky = 0;
		this.mwidth = width;
		this.mheight = height;
	}
	
	public void setMask(int maskx, int masky, int mwidth, int mheight) {
		this.maskx = maskx;
		this.masky = masky;
		this.mwidth = mwidth;
		this.mheight = mheight;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	public int getX() {
		return (int)this.x;
	}

	public int getY() {
		return (int)this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public void setX(double x) {
		this.x = x;
	}


	public void setY(double y) {
		this.y = y;
	}


	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		
		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
	}
	 
	//Calcula a menor distancia entre 2 pontos :)
	public double calculateDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	
	
	public static boolean isColliding(Entity e1, Entity e2) {
		
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx, e2.getY() + e2.masky, e2.mwidth, e2.mheight);
		
		return e1Mask.intersects(e2Mask);
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}
	
}
