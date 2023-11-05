package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Entity {

	public static BufferedImage HEAL_EN = Main.spritesheet.getSpritesheet(24, 8, 8, 8);
	public static BufferedImage ENEMY_EN = Main.spritesheet.getSpritesheet(32, 8, 8, 8);
	public static BufferedImage FINN_EN = Main.spritesheet.getSpritesheet(16, 24, 16, 16);
	public static BufferedImage PIKACHU_EN = Main.spritesheet.getSpritesheet(40, 0, 16, 16);
	public static BufferedImage BULLET_PL = Main.spritesheet.getSpritesheet(72, 0, 8, 8);
	
	protected int width, height;
	protected double x, y;
	protected int maskx, masky, mwidth, mheight;
	private BufferedImage sprite;
	public double life;
	
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
	}
	 
	
	public static boolean isColliding(Entity e1, Entity e2) {
		
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx, e2.getY() + e2.masky, e2.mwidth, e2.mheight);
		
		return e1Mask.intersects(e2Mask);
	}
	
}
