package com.beyastudio.wolrd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class Tile {

	
	public static int tile_size = 8;
	
	
	
										/*********////////////////**********/
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_FLOOR = Main.spritesheet.getSpritesheet(32, 16, tile_size, tile_size);
	public static BufferedImage TILE_WALL = Main.spritesheet.getSpritesheet(16, 88, tile_size, tile_size);
	public static BufferedImage TILE_SHOOT = Main.spritesheet.getSpritesheet(40, 16, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_ICE_FLOOR = Main.spritesheet.getSpritesheet(16, 72, tile_size, tile_size);
	public static BufferedImage TILE_ICE_WALL = Main.spritesheet.getSpritesheet(24, 72, 8, 8);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_FIRE_FLOOR = Main.spritesheet.getSpritesheet(16, 80, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_WOOD_FLOOR = Main.spritesheet.getSpritesheet(24, 88, tile_size, tile_size),
								TILE_WOOD_FLOOR_WHITEF = Main.spritesheet.getSpritesheet(72, 88, tile_size, tile_size),
								TILE_WOOD_FLOOR_YELLOWF = Main.spritesheet.getSpritesheet(64, 96, tile_size, tile_size),
								TILE_WOOD_FLOOR_GRASS = Main.spritesheet.getSpritesheet(72, 96, tile_size, tile_size),
								TILE_WOOD_FLOOR_GRASS_2 = Main.spritesheet.getSpritesheet(72, 104, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_INV = Main.spritesheet.getSpritesheet(136, 216, tile_size, tile_size);
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_BLACK = Main.spritesheet.getSpritesheet(88, 96, tile_size, tile_size);
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_GRASS_1 = Main.spritesheet.getSpritesheet(80, 88, tile_size, tile_size),
								TILE_GRASS_2 = Main.spritesheet.getSpritesheet(88, 88, tile_size, tile_size),
								TILE_GRASS_3 = Main.spritesheet.getSpritesheet(96, 88, tile_size, tile_size),
								TILE_GRASS_4 = Main.spritesheet.getSpritesheet(80, 96, tile_size, tile_size),
								TILE_GRASS_5 = Main.spritesheet.getSpritesheet(96, 96, tile_size, tile_size),
								TILE_GRASS_6 = Main.spritesheet.getSpritesheet(80, 104, tile_size, tile_size),
								TILE_GRASS_7 = Main.spritesheet.getSpritesheet(88, 104, tile_size, tile_size),
								TILE_GRASS_8 = Main.spritesheet.getSpritesheet(96, 104, tile_size, tile_size),
								TILE_GRASS_BORDER_1 = Main.spritesheet.getSpritesheet(64, 112, tile_size, tile_size),
								TILE_GRASS_BORDER_2 = Main.spritesheet.getSpritesheet(72, 112, tile_size, tile_size),
								TILE_GRASS_BORDER_3 = Main.spritesheet.getSpritesheet(64, 120, tile_size, tile_size),
								TILE_GRASS_BORDER_4 = Main.spritesheet.getSpritesheet(72, 120, tile_size, tile_size);
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	public static BufferedImage TILE_CARPET_1 = Main.spritesheet.getSpritesheet(0, 112, tile_size, tile_size),
								TILE_CARPET_2 = Main.spritesheet.getSpritesheet(8, 112, tile_size, tile_size),
								TILE_CARPET_3 = Main.spritesheet.getSpritesheet(16, 112, tile_size, tile_size),
								TILE_CARPET_4 = Main.spritesheet.getSpritesheet(0, 120, tile_size, tile_size),
								TILE_CARPET_5 = Main.spritesheet.getSpritesheet(8, 120, tile_size, tile_size),
								TILE_CARPET_6 = Main.spritesheet.getSpritesheet(16, 120, tile_size, tile_size),
								TILE_CARPET_7 = Main.spritesheet.getSpritesheet(0, 128, tile_size, tile_size),
								TILE_CARPET_8 = Main.spritesheet.getSpritesheet(8, 128, tile_size, tile_size),
								TILE_CARPET_9 = Main.spritesheet.getSpritesheet(16, 128, tile_size, tile_size),
								TILE_CARPET_BORDER_1 = Main.spritesheet.getSpritesheet(0, 136, tile_size, tile_size),
								TILE_CARPET_BORDER_2 = Main.spritesheet.getSpritesheet(8, 136, tile_size, tile_size),
								TILE_CARPET_BORDER_3 = Main.spritesheet.getSpritesheet(0, 144, tile_size, tile_size),
								TILE_CARPET_BORDER_4 = Main.spritesheet.getSpritesheet(8, 144, tile_size, tile_size);
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_SAND_1 = Main.spritesheet.getSpritesheet(24, 112, tile_size, tile_size),
								TILE_SAND_2 = Main.spritesheet.getSpritesheet(32, 112, tile_size, tile_size),
								TILE_SAND_3 = Main.spritesheet.getSpritesheet(40, 112, tile_size, tile_size),
								TILE_SAND_4 = Main.spritesheet.getSpritesheet(24, 120, tile_size, tile_size),
								TILE_SAND_5 = Main.spritesheet.getSpritesheet(32, 120, tile_size, tile_size),
								TILE_SAND_6 = Main.spritesheet.getSpritesheet(40, 120, tile_size, tile_size),
								TILE_SAND_7 = Main.spritesheet.getSpritesheet(24, 128, tile_size, tile_size),
								TILE_SAND_8 = Main.spritesheet.getSpritesheet(32, 128, tile_size, tile_size),
								TILE_SAND_9 = Main.spritesheet.getSpritesheet(40, 128, tile_size, tile_size);
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_ICE_1 = Main.spritesheet.getSpritesheet(104, 88, tile_size, tile_size),
								TILE_ICE_2 = Main.spritesheet.getSpritesheet(112, 88, tile_size, tile_size),
								TILE_ICE_3 = Main.spritesheet.getSpritesheet(120, 88, tile_size, tile_size),
								TILE_ICE_4 = Main.spritesheet.getSpritesheet(104, 96, tile_size, tile_size),
								TILE_ICE_5 = Main.spritesheet.getSpritesheet(120, 96, tile_size, tile_size),
								TILE_ICE_6 = Main.spritesheet.getSpritesheet(104, 104, tile_size, tile_size),
								TILE_ICE_7 = Main.spritesheet.getSpritesheet(112, 104, tile_size, tile_size),
								TILE_ICE_8 = Main.spritesheet.getSpritesheet(120, 104, tile_size, tile_size),
								TILE_ICE_BORDER_1 = Main.spritesheet.getSpritesheet(128, 88, tile_size, tile_size),
								TILE_ICE_BORDER_2 = Main.spritesheet.getSpritesheet(136, 88, tile_size, tile_size),
								TILE_ICE_BORDER_3 = Main.spritesheet.getSpritesheet(128, 96, tile_size, tile_size),
								TILE_ICE_BORDER_4 = Main.spritesheet.getSpritesheet(136, 96, tile_size, tile_size);
	
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	
	public static BufferedImage TILE_FIRE_1 = Main.spritesheet.getSpritesheet(80, 136, tile_size, tile_size),
								TILE_FIRE_2 = Main.spritesheet.getSpritesheet(88, 136, tile_size, tile_size),
								TILE_FIRE_3 = Main.spritesheet.getSpritesheet(96, 136, tile_size, tile_size),
								TILE_FIRE_4 = Main.spritesheet.getSpritesheet(80, 144, tile_size, tile_size),
								TILE_FIRE_5 = Main.spritesheet.getSpritesheet(96, 144, tile_size, tile_size),
								TILE_FIRE_6 = Main.spritesheet.getSpritesheet(80, 152, tile_size, tile_size),
								TILE_FIRE_7 = Main.spritesheet.getSpritesheet(88, 152, tile_size, tile_size),
								TILE_FIRE_8 = Main.spritesheet.getSpritesheet(96, 152, tile_size, tile_size),
								TILE_FIRE_BORDER_1 = Main.spritesheet.getSpritesheet(128, 120, tile_size, tile_size),
								TILE_FIRE_BORDER_2 = Main.spritesheet.getSpritesheet(136, 120, tile_size, tile_size),
								TILE_FIRE_BORDER_3 = Main.spritesheet.getSpritesheet(128, 128, tile_size, tile_size),
								TILE_FIRE_BORDER_4 = Main.spritesheet.getSpritesheet(136, 128, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	
	public static BufferedImage TILE_LAVA_1 = Main.spritesheet.getSpritesheet(0, 72, tile_size, tile_size),
								TILE_LAVA_2 = Main.spritesheet.getSpritesheet(8, 72, tile_size, tile_size),
								TILE_LAVA_3 = Main.spritesheet.getSpritesheet(0, 80, tile_size, tile_size),
								TILE_LAVA_4 = Main.spritesheet.getSpritesheet(8, 80, tile_size, tile_size),
								TILE_LAVA_5 = Main.spritesheet.getSpritesheet(16, 80, tile_size, tile_size),
								TILE_LAVA_6 = Main.spritesheet.getSpritesheet(0, 88, tile_size, tile_size),
								TILE_LAVA_7 = Main.spritesheet.getSpritesheet(8, 88, tile_size, tile_size);
		
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	
	public static BufferedImage TILE_GOLD_1 = Main.spritesheet.getSpritesheet(144, 88, tile_size, tile_size),
								TILE_GOLD_2 = Main.spritesheet.getSpritesheet(152, 88, tile_size, tile_size),
								TILE_GOLD_3 = Main.spritesheet.getSpritesheet(160, 88, tile_size, tile_size),
								TILE_GOLD_4 = Main.spritesheet.getSpritesheet(144, 96, tile_size, tile_size),
								TILE_GOLD_5 = Main.spritesheet.getSpritesheet(160, 96, tile_size, tile_size),
								TILE_GOLD_6 = Main.spritesheet.getSpritesheet(144, 104, tile_size, tile_size),
								TILE_GOLD_7 = Main.spritesheet.getSpritesheet(152, 104, tile_size, tile_size),
								TILE_GOLD_8 = Main.spritesheet.getSpritesheet(160, 104, tile_size, tile_size),
								TILE_GOLD_BORDER_1 = Main.spritesheet.getSpritesheet(168, 88, tile_size, tile_size),
								TILE_GOLD_BORDER_2 = Main.spritesheet.getSpritesheet(176, 88, tile_size, tile_size),
								TILE_GOLD_BORDER_3 = Main.spritesheet.getSpritesheet(168, 96, tile_size, tile_size),
								TILE_GOLD_BORDER_4 = Main.spritesheet.getSpritesheet(176, 96, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	
	
	public static BufferedImage TILE_STONE_1 = Main.spritesheet.getSpritesheet(144, 112, tile_size, tile_size),
								TILE_STONE_2 = Main.spritesheet.getSpritesheet(152, 112, tile_size, tile_size),
								TILE_STONE_3 = Main.spritesheet.getSpritesheet(144, 120, tile_size, tile_size),
								TILE_STONE_4 = Main.spritesheet.getSpritesheet(152, 120, tile_size, tile_size),
								TILE_STONE_5 = Main.spritesheet.getSpritesheet(144, 128, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_UNDER_TREE_0 = Main.tiles_samurai.getSpritesheet(32, 16, tile_size, tile_size),
								TILE_UNDER_TREE_1 = Main.tiles_samurai.getSpritesheet(40, 16, tile_size, tile_size),
								TILE_UNDER_TREE_2 = Main.tiles_samurai.getSpritesheet(48, 16, tile_size, tile_size),
								TILE_UNDER_TREE_3 = Main.tiles_samurai.getSpritesheet(32, 24, tile_size, tile_size),
								TILE_UNDER_TREE_4 = Main.tiles_samurai.getSpritesheet(40, 24, tile_size, tile_size),
								TILE_UNDER_TREE_5 = Main.tiles_samurai.getSpritesheet(48, 24, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_PINK_0 = Main.tiles_samurai.getSpritesheet(128, 8, tile_size, tile_size),
			TILE_PINK_1 = Main.tiles_samurai.getSpritesheet(136, 8, tile_size, tile_size),
			TILE_PINK_2 = Main.tiles_samurai.getSpritesheet(144, 8, tile_size, tile_size),
			TILE_PINK_3 = Main.tiles_samurai.getSpritesheet(128, 16, tile_size, tile_size),
			TILE_PINK_4 = Main.tiles_samurai.getSpritesheet(136, 16, tile_size, tile_size),
			TILE_PINK_5 = Main.tiles_samurai.getSpritesheet(144, 16, tile_size, tile_size),
			TILE_PINK_6 = Main.tiles_samurai.getSpritesheet(128, 24, tile_size, tile_size),
			TILE_PINK_7 = Main.tiles_samurai.getSpritesheet(136, 24, tile_size, tile_size),
			TILE_PINK_8 = Main.tiles_samurai.getSpritesheet(144, 24, tile_size, tile_size);
	
				/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public static BufferedImage TILE_WATER = Main.tiles_samurai.getSpritesheet(128, 0, tile_size, tile_size),
			TILE_WGROUND_0 = Main.tiles_samurai.getSpritesheet(136, 0, tile_size, tile_size),
			TILE_WGROUND_1 = Main.tiles_samurai.getSpritesheet(144, 0, tile_size, tile_size),
			TILE_WGROUND_2 = Main.tiles_samurai.getSpritesheet(144, 8, tile_size, tile_size),
			TILE_WGROUND_3 = Main.tiles_samurai.getSpritesheet(152, 8, tile_size, tile_size),
			TILE_WGROUND_4 = Main.tiles_samurai.getSpritesheet(152, 16, tile_size, tile_size),
			TILE_WGROUND_5 = Main.tiles_samurai.getSpritesheet(152, 24, tile_size, tile_size),
			TILE_WGROUND_6 = Main.tiles_samurai.getSpritesheet(144, 32, tile_size, tile_size),
			TILE_WGROUND_7 = Main.tiles_samurai.getSpritesheet(136, 32, tile_size, tile_size),
			TILE_WGROUND_8 = Main.tiles_samurai.getSpritesheet(128, 32, tile_size, tile_size),
			TILE_WGROUND_9 = Main.tiles_samurai.getSpritesheet(120, 24, tile_size, tile_size),
			TILE_WGROUND_10 = Main.tiles_samurai.getSpritesheet(120, 16, tile_size, tile_size),
			TILE_WGROUND_11 = Main.tiles_samurai.getSpritesheet(120, 8, tile_size, tile_size),
			//**********ANIMATED PARTS******************
			TILE_ANI_WATER = Main.tiles_samurai.getSpritesheet(128, 8, tile_size, tile_size),
			TILE_ANI_WGROUND_0 = Main.tiles_samurai.getSpritesheet(128, 8, tile_size, tile_size),
			TILE_ANI_WGROUND_1 = Main.tiles_samurai.getSpritesheet(136, 8, tile_size, tile_size),
			TILE_ANI_WGROUND_2 = Main.tiles_samurai.getSpritesheet(144, 8, tile_size, tile_size),
			TILE_ANI_WGROUND_3 = Main.tiles_samurai.getSpritesheet(128, 16, tile_size, tile_size),
			TILE_ANI_WGROUND_4 = Main.tiles_samurai.getSpritesheet(136, 16, tile_size, tile_size),
			TILE_ANI_WGROUND_5 = Main.tiles_samurai.getSpritesheet(144, 16, tile_size, tile_size),
			TILE_ANI_WGROUND_6 = Main.tiles_samurai.getSpritesheet(128, 24, tile_size, tile_size),
			TILE_ANI_WGROUND_7 = Main.tiles_samurai.getSpritesheet(136, 24, tile_size, tile_size),
			TILE_ANI_WGROUND_8 = Main.tiles_samurai.getSpritesheet(144, 24, tile_size, tile_size),
			TILE_ANI_WGROUND_9 = Main.tiles_samurai.getSpritesheet(144, 24, tile_size, tile_size),
			TILE_ANI_WGROUND_10 = Main.tiles_samurai.getSpritesheet(144, 24, tile_size, tile_size),
			TILE_ANI_WGROUND_11 = Main.tiles_samurai.getSpritesheet(144, 24, tile_size, tile_size);
			
	
	
	
	
	protected BufferedImage sprite;
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
	
	
	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}
}
