package com.beyastudio.wolrd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.beyastudio.entities.*;
import com.beyastudio.main.Main;

public class World {

	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	
	public World(String path) {
		try {
			
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			
			/*----------- Big O = n² -----------*/
			/*Tiles machine / Máquina de tiles*/
			for(int xx = 0; xx < map.getWidth(); xx++) {
				for(int yy = 0; yy < map.getHeight(); yy++) {
					 
					int pixelAtual = pixels[xx + (yy * map.getWidth())];
					tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_FLOOR);
					
					
					switch(pixelAtual) {
					
							//Black Color / Cor Preta
						case 0xff000000:
							// Floor / chao
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_FLOOR);
							break;
							
							//White Color / Cor Branca
						case 0xffffffff:
							// Wall / Parede
							tiles[xx + (yy * WIDTH)] = new WallTile(xx * 8, yy * 8, Tile.TILE_WALL);
							break;
							
							//Blue Color / Cor Azul
						case 0xff225af6:
							// Player / Jogador
							Main.player.setX(xx*8);
							Main.player.setY(yy*8);
							break;
							
							//Red Color / Cor Vermelha
						case 0xffbe2633:
							//Enemy / Inimigo
							Main.entities.add(new Enemy(xx * 8, yy * 8, 8, 8, Entity.ENEMY_EN));
							break;
					
						case 0xff26be46:
							Heal heal = new Heal(xx * 8, yy * 8, 8, 8, Entity.HEAL_EN);
							Main.entities.add(heal);
							break;
							
						case 0xff00f2ff:
							Main.entities.add(new Finn(xx * 8, yy*8, 16, 16, Entity.FINN_EN));
							break;
							
						case 0xfff2ff00:
							Main.entities.add(new Pikachu(xx*8, yy*8, 16, 16, Entity.PIKACHU_EN));
							break;
					}
					
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}//try \ catch
	}
	
	public static boolean isFree(int xnext, int ynext) {
		
		int size = 8;
		int x1 = xnext / size;
		int y1 = ynext / size;
		
		int x2 = (xnext + size - 1)/ size;
		int y2 = ynext / size;
		
		int x3 = xnext / size;
		int y3 = (ynext + size - 1) / size;
		
		int x4 = (xnext + size - 1) / size;
		int y4 = (ynext + size - 1) / size;
		
		return ! ((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile) ||
				  (tiles[x2 + (y2*World.WIDTH)] instanceof WallTile)  ||
				  (tiles[x3 + (y3*World.WIDTH)] instanceof WallTile)  ||
				  (tiles[x4 + (y4*World.WIDTH)] instanceof WallTile));
	}
	
	
	public void render(Graphics g) {
		int xstart = Camera.x / 8;
		int ystart = Camera.y / 8;
		
		int xfinal = xstart + (Main.width / 8);
		int yfinal = ystart + (Main.height / 8);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(g);
			}
		}
	}
	
}
