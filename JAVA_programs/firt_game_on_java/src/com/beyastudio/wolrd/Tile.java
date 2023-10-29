package com.beyastudio.wolrd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Tile {

	public static BufferedImage TILE_FLOOR = Main.spritesheet.getSpritesheet(24, 16, 8, 8);
	public static BufferedImage TILE_WALL = Main.spritesheet.getSpritesheet(32, 16, 8, 8);
	
	private BufferedImage sprite;
	private int x, y;
	
	
	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}
}
