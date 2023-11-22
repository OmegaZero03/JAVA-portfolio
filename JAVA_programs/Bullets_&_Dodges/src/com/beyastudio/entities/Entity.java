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
	
	public static BufferedImage HEAL_EN  	=Main.spritesheet.getSpritesheet(24, 8, _8x8, _8x8);
	public static BufferedImage ENEMY_EN  	=Main.spritesheet.getSpritesheet(32, 8, _8x8, _8x8);
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
						/*********GRASS BOSS SPRITES**********/
	public static BufferedImage FINN_EN  	=Main.spritesheet.getSpritesheet(16, 24, _16x_16, _16x_16),
					BULLET_FINN_1 		 	=Main.spritesheet.getSpritesheet(48, 40, _16x_16, _16x_16),
					BULLET_FINN_SWORD_0  	=Main.spritesheet.getSpritesheet(48, 56, _16x_16, _16x_16),
					BULLET_FINN_SWORD_180   =Main.spritesheet.getSpritesheet(64, 56, _16x_16, _16x_16),
					BULLET_FINN_SWORD_90  	=Main.spritesheet.getSpritesheet(96, 56, _16x_16, _16x_16),
					BULLET_FINN_SWORD_270   =Main.spritesheet.getSpritesheet(80, 56, _16x_16, _16x_16),
					BULLET_FINN_SLASH  	 	=Main.spritesheet.getSpritesheet(32, 56, _16x_16, _16x_16),
					GRASS_EN   				=Main.spritesheet.getSpritesheet(48, 24, _16x_16, _16x_16);
						/*********/////////////////**********/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
						/*********ICE BOSS SPRITES**********/
	public static BufferedImage ICE_EN     	=Main.spritesheet.getSpritesheet(16, 40, _16x_16, _16x_16),
					BULLET_ICE_FLAKE 		=Main.spritesheet.getSpritesheet(32, 72, _16x_16, _16x_16),
					BULLET_ICE_SPEAR_270	=Main.spritesheet.getSpritesheet(48, 72, _16x_16, _16x_16),
					BULLET_ICE_SPEAR_90		=Main.spritesheet.getSpritesheet(48, 88, _16x_16, _16x_16),
					PENGUIN_EN 				=Main.spritesheet.getSpritesheet(32, 88, _8x8, _8x8),
					PENGUIN_EN_REV 			=Main.spritesheet.getSpritesheet(32, 96, _8x8, _8x8),
					BULLET_PENGUIN_0		=Main.spritesheet.getSpritesheet(40, 88, _8x8, _8x8),
					BULLET_PENGUIN_180		=Main.spritesheet.getSpritesheet(40, 96, _8x8, _8x8);
						/*********/////////////////**********/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
	public static BufferedImage FIRE_EN   	=Main.spritesheet.getSpritesheet(32, 40, _16x_16, _16x_16);
	public static BufferedImage PIKACHU_EN 	=Main.spritesheet.getSpritesheet(40, 0, _16x_16, _16x_16);
	public static BufferedImage BULLET_PL 	=Main.spritesheet.getSpritesheet(72, 0, _8x8, _8x8);	
	
	
	
	protected int width, height;
	protected double x, y;
	protected int maskx, masky, mwidth, mheight;
	private BufferedImage sprite;
	public double life, maxLife;
	
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
	 
	
	public static boolean isColliding(Entity e1, Entity e2) {
		
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx, e2.getY() + e2.masky, e2.mwidth, e2.mheight);
		
		return e1Mask.intersects(e2Mask);
	}
	
}
