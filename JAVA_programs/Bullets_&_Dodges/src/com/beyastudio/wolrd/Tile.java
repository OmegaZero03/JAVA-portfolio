package com.beyastudio.wolrd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class Tile {

	public static BufferedImage TILE_FLOOR = Main.spritesheet.getSpritesheet(32, 16, 8, 8);
	public static BufferedImage TILE_WALL = Main.spritesheet.getSpritesheet(16, 88, 8, 8);
	public static BufferedImage TILE_SHOOT = Main.spritesheet.getSpritesheet(40, 16, 8, 8);
	
	public static BufferedImage TILE_ICE_FLOOR = Main.spritesheet.getSpritesheet(16, 72, 8, 8);
	public static BufferedImage TILE_ICE_WALL = Main.spritesheet.getSpritesheet(24, 72, 8, 8);
	
	public static BufferedImage TILE_FIRE_FLOOR = Main.spritesheet.getSpritesheet(16, 80, 8, 8);
	public static BufferedImage TILE_FIRE_WALL = Main.spritesheet.getSpritesheet(24, 80, 8, 8);
	
	public static BufferedImage TILE_WOOD_FLOOR = Main.spritesheet.getSpritesheet(24, 88, 8, 8),
								TILE_WOOD_FLOOR_WHITEF = Main.spritesheet.getSpritesheet(64, 88, 8, 8),
								TILE_WOOD_FLOOR_YELLOWF = Main.spritesheet.getSpritesheet(64, 96, 8, 8),
								TILE_WOOD_FLOOR_GRASS = Main.spritesheet.getSpritesheet(72, 96, 8, 8);
	
	public static BufferedImage TILE_INV = Main.spritesheet.getSpritesheet(104, 104, 8, 8);
	
	public static BufferedImage TILE_BLACK = Main.spritesheet.getSpritesheet(88, 96, 8, 8);
	
	public static BufferedImage TILE_GRASS_1 = Main.spritesheet.getSpritesheet(80, 88, 8, 8),
								TILE_GRASS_2 = Main.spritesheet.getSpritesheet(88, 88, 8, 8),
								TILE_GRASS_3 = Main.spritesheet.getSpritesheet(96, 88, 8, 8),
								TILE_GRASS_4 = Main.spritesheet.getSpritesheet(80, 96, 8, 8),
								TILE_GRASS_5 = Main.spritesheet.getSpritesheet(96, 96, 8, 8),
								TILE_GRASS_6 = Main.spritesheet.getSpritesheet(80, 104, 8, 8),
								TILE_GRASS_7 = Main.spritesheet.getSpritesheet(88, 104, 8, 8),
								TILE_GRASS_8 = Main.spritesheet.getSpritesheet(96, 104, 8, 8);
	
	
	
	private BufferedImage sprite;
	protected int x;
	protected int y;
	private int maskx, masky, mwidth, mheight;
	protected int width = 8, height = 8;
	
	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
		this.maskx = 4;
		this.masky = 4;
		this.mwidth = 1;
		this.mheight = 1;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static boolean isColliding(Entity t1, Tile t2) {
		
		Rectangle e1Mask = new Rectangle(t1.getX(), t1.getY(), t1.getWidth(), t1.getHeight());
		Rectangle e2Mask = new Rectangle(t2.getX() + t2.maskx, t2.getY() + t2.masky, t2.mwidth, t2.mheight);
		
		return e1Mask.intersects(e2Mask);
	}
	
	
	public void render(Graphics g) {;
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}
}
