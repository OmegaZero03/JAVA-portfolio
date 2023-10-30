package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Entity {

	public static BufferedImage HEAL_EN = Main.spritesheet.getSpritesheet(24, 8, 8, 8);
	public static BufferedImage ENEMY_EN = Main.spritesheet.getSpritesheet(32, 8, 8, 8);
	public static BufferedImage FINN_EN = Main.spritesheet.getSpritesheet(16, 24, 16, 16);
	public static BufferedImage PIKACHU_EN = Main.spritesheet.getSpritesheet(40, 0, 16, 16);
	
	protected int width, height;
	protected double x, y;
	private BufferedImage sprite;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
	}
	 
	
	
}
