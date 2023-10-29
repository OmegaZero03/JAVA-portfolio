package com.beyastudio.wolrd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {

	private Tile[] tiles;
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
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_FLOOR);
							break;
							
						default:
							// floor again / chao de novo
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_FLOOR);
							break;
					
					}
					
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}//try \ catch
	}
	
	
	public void render(Graphics g) {
		for(int xx = 0; xx < WIDTH; xx++) {
			for(int yy = 0; yy < HEIGHT; yy++) {
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(g);
			}
		}
	}
	
}
