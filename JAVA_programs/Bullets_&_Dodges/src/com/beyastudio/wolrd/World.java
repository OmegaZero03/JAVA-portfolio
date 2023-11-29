package com.beyastudio.wolrd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.beaystudio.sprite.Spritesheet;
import com.beyastudio.boss_1.Bullet;
import com.beyastudio.boss_1.Finn;
import com.beyastudio.boss_2.FireP;
import com.beyastudio.boss_3.IceKing;
import com.beyastudio.entities.Enemy;
import com.beyastudio.entities.Entity;
import com.beyastudio.entities.Heal;
import com.beyastudio.entities.Player;
import com.beyastudio.entities.PlayerBullet;
import com.beyastudio.entities.Snorlax;
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
							// GRASS Floor / chao de grama
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_FLOOR);
							break;
							
							//DARK GREY / Cinza escuro
						case 0xff545455:
							// FIRE Floor / chao de chão
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_FIRE_FLOOR);
							break;
							
							//BROWN COLOR / MARROM
						case 0xffbb7547:
							//WOOD TILE/ CHÃO DE MADEIRA
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_WOOD_FLOOR);
							break;
							
							//GREY COLOR / cor cinza
						case 0xffb3b9d1:
							//Ice FLOOR / Chão de gelo
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_ICE_FLOOR);
							break;
							
							// ORANGE COLOR / cor de laranja
						case 0xfffa6a0a:
							// Fire wall/ parede de fogo
							WallTile fireWall = new WallTile(xx * 8, yy * 8, Tile.TILE_FIRE_WALL);
							tiles[xx + (yy * WIDTH)] = fireWall;
							Main.walls.add(fireWall);
							break;
							
							//White Color / Cor Branca
						case 0xffffffff:
							// leaf Wall / Parede de folhas
							WallTile wall = new WallTile(xx * 8, yy * 8, Tile.TILE_WALL);
							tiles[xx + (yy * WIDTH)] = wall;
							Main.walls.add(wall);
							
							break;
							
							//BLUE COLOR / COR AZUL
						case 0xff24bede:
							//ICE WALL / parede de gelo
							WallTile iceWall = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_WALL);
							tiles[xx + (yy * WIDTH)] = iceWall;
							Main.walls.add(iceWall);
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
					
							//Green Color / Cor Verde
						case 0xff26be46:
							Heal heal = new Heal(xx * 8, yy * 8, 8, 8, Entity.HEAL_EN);
							Main.entities.add(heal);
							break;
							
						case 0xff00f2ff:
							//Finn f = new Finn(xx * 8, yy*8, 16, 16, Entity.FINN_EN);
							//Main.entities.add(f);
							//System.out.println(" X = " + f.getX() + "Y = " + f.getY());
							break;
							
							//Yellow Color/ cor amarela
						case 0xfff2ff00:
							Main.entities.add(new Snorlax(xx*8 - 8, yy*8, 16, 16, Entity.PIKACHU_EN));
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
		
		return ! ((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile)  ||
				  (tiles[x2 + (y2*World.WIDTH)] instanceof WallTile)  ||
				  (tiles[x3 + (y3*World.WIDTH)] instanceof WallTile)  ||
				  (tiles[x4 + (y4*World.WIDTH)] instanceof WallTile));
	}
	
	public static void restartGame(String lvl) {
		
		Main.spritesheet = new Spritesheet("/spritesheet.png");
		Main.entities.clear();
		Main.walls.clear();
		Main.playerBullets.clear();
		Main.BossBullets.clear();
		Main.shootWalls.clear();
		Main.shootWallsSlow.clear();
		Main.entities = new ArrayList<Entity>();
		Main.walls = new ArrayList<WallTile>();
		Main.playerBullets = new ArrayList<PlayerBullet>();
		Main.BossBullets = new ArrayList<Bullet>();
		Main.shootWalls = new ArrayList<ShootTile>();
		Main.shootWallsSlow = new ArrayList<ShootTileSlow>();
		Main.player = new Player(0, 0, 8, 8, Main.spritesheet.getSpritesheet(0, 0, 8, 8));
		Main.entities.add(Main.player);
		Main.boss_1 = new Finn(220, 140, 16, 16, Entity.FINN_EN);
		Main.boss_2 = new FireP(80, 368, 16, 16, Entity.FIRE_EN);
		Main.boss_3 = new IceKing(364, 344, 16, 16, Entity.ICE_EN);
		Main.isBoss = true;
		Main.isBossF = true;
		Main.isBossI = true;
		Main.world = new World("/"+lvl);
		return;
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
