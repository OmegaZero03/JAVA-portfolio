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
import com.beyastudio.entities.NextLvl;
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
							tiles[xx + (yy * WIDTH)] = new BlackTile(xx * 8, yy * 8, Tile.TILE_BLACK);
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
							
							//White flower wood floor
						case 0xff71413b:
							//WHITE FLOWER WOOD TILE/ CHÃO DE MADEIRA COM A FLOR BRANCA
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_WOOD_FLOOR_WHITEF);
							break;
							
							
							
							//Yellow flower wood floor
						case 0xffdba463:
							//YELLOW FLOWER WOOD TILE/ CHÃO DE MADEIRA COM A FLOR BRANCA
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_WOOD_FLOOR_YELLOWF);
							break;
							
							
							
							//GRASS wood floor
						case 0xffe87547:
							//GRASS WOOD TILE/ CHÃO DE MADEIRA COM AS GRAMINHA
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_WOOD_FLOOR_GRASS);
							break;
							
							//GRASS wood floor 2
						case 0xfffa6a0a:
							//GRASS WOOD TILE 2/ CHÃO DE MADEIRA COM AS GRAMINHA 2
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_WOOD_FLOOR_GRASS_2);
							break;
							
						
							//GREY COLOR / cor cinza
						case 0xffb3b9d1:
							//Ice FLOOR / Chão de gelo
							tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 8, yy * 8, Tile.TILE_ICE_FLOOR);
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
							
							
							//Yellow Color/ cor amarela
						case 0xfff2ff00:
							Main.entities.add(new Snorlax(xx*8 - 8, yy*8, 16, 16, Entity.PIKACHU_EN));
							break;
							
							
						case 0xffff0086:
							Main.entities.add(new NextLvl(xx*8, yy*8, 8, 8, Entity.NEXT_LVL));
							break;
							
						//GrassWalls
						
						//Grass wall 1
						case 0xff50c878:
							WallTile grass1 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_1);
							tiles[xx + (yy * WIDTH)] = grass1;
							Main.walls.add(grass1);
							break;
							
						//Grass wall 2
						case 0xff5f8575:
							WallTile grass2 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_2);
							tiles[xx + (yy * WIDTH)] = grass2;
							Main.walls.add(grass2);
							break;
						
						//Grass wall 3
						case 0xff4f7942:
							WallTile grass3 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_3);
							tiles[xx + (yy * WIDTH)] = grass3;
							Main.walls.add(grass3);
							break;
							
						//Grass wall 4
						case 0xff228b22:
							WallTile grass4 = new WallTile(xx * 8, (yy * 8), Tile.TILE_GRASS_4);
							tiles[xx + (yy * WIDTH)] = grass4;
							Main.walls.add(grass4);
							break;
							
						//Grass wall 5
						case 0xff7cfc00:
							WallTile grass5 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_5);
							tiles[xx + (yy * WIDTH)] = grass5;
							Main.walls.add(grass5);
							break;
							
						//Grass wall 6
						case 0xff008000:
							WallTile grass6 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_6);
							tiles[xx + (yy * WIDTH)] = grass6;
							Main.walls.add(grass6);
							break;
							
						//Grass wall 7
						case 0xff355e3b:
							WallTile grass7 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_7);
							tiles[xx + (yy * WIDTH)] = grass7;
							Main.walls.add(grass7);
							break;
						
						//Grass wall 8
						case 0xff00a36c:
							WallTile grass8 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_8);
							tiles[xx + (yy * WIDTH)] = grass8;
							Main.walls.add(grass8);
							break;
							
							
						//Grass wall border 1
						case 0xff9acd32 :
							WallTile grassB1 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_BORDER_1);
							tiles[xx + (yy * WIDTH)] = grassB1;
							Main.walls.add(grassB1);
							break;
								
						//Grass wall border 3
						case 0xff6b8e23 :
							WallTile grassB2 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_BORDER_2);
							tiles[xx + (yy * WIDTH)] = grassB2;
							Main.walls.add(grassB2);
							break;
							
						//Grass wall border 3
						case 0xff556b2f :
							WallTile grassB3 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_BORDER_3);
							tiles[xx + (yy * WIDTH)] = grassB3;
							Main.walls.add(grassB3);
							break;
							
						//Grass wall border 4
						case 0xff808000 :
							WallTile grassB4 = new WallTile(xx * 8, yy * 8, Tile.TILE_GRASS_BORDER_4);
							tiles[xx + (yy * WIDTH)] = grassB4;
							Main.walls.add(grassB4);
							break;
							
							
							
						//iceWalls
							
						//Ice wall 1
						case 0xff6a5acd:
							WallTile ice1 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_1);
							tiles[xx + (yy * WIDTH)] = ice1;
							Main.walls.add(ice1);
							break;
								
						//Ice wall 2
						case 0xff836fff:
							WallTile ice2 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_2);
							tiles[xx + (yy * WIDTH)] = ice2;
							Main.walls.add(ice2);
							break;
							
						//Ice wall 3
						case 0xff6959cd:
							WallTile ice3 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_3);
							tiles[xx + (yy * WIDTH)] = ice3;
							Main.walls.add(ice3);
							break;
								
						//Ice wall 4
						case 0xff483d8b:
							WallTile ice4 = new WallTile(xx * 8, (yy * 8), Tile.TILE_ICE_4);
							tiles[xx + (yy * WIDTH)] = ice4;
							Main.walls.add(ice4);
							break;
								
						//Ice wall 5
						case 0xff191970:
							WallTile ice5 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_5);
							tiles[xx + (yy * WIDTH)] = ice5;
							Main.walls.add(ice5);
							break;
								
						//Ice wall 6
						case 0xff000080:
							WallTile ice6 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_6);
							tiles[xx + (yy * WIDTH)] = ice6;
							Main.walls.add(ice6);
							break;
								
						//Ice wall 7
						case 0xff1e90ff:
							WallTile ice7 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_7);
							tiles[xx + (yy * WIDTH)] = ice7;
							Main.walls.add(ice7);
							break;
							
						//Ice wall 8
						case 0xff00bfff:
							WallTile ice8 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_8);
							tiles[xx + (yy * WIDTH)] = ice8;
							Main.walls.add(ice8);
							break;
								
								
						//Ice wall border 1
						case 0xffadd8e6 :
							WallTile iceB1 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_BORDER_1);
							tiles[xx + (yy * WIDTH)] = iceB1;
							Main.walls.add(iceB1);
							break;
									
						//Ice wall border 3
						case 0xff4682b4 :
							WallTile iceB2 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_BORDER_2);
							tiles[xx + (yy * WIDTH)] = iceB2;
							Main.walls.add(iceB2);
							break;
								
						//Ice wall border 3
						case 0xffb0c4de :
							WallTile iceB3 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_BORDER_3);
							tiles[xx + (yy * WIDTH)] = iceB3;
							Main.walls.add(iceB3);
							break;
								
						//Ice wall border 4
						case 0xff0000ff :
							WallTile iceB4 = new WallTile(xx * 8, yy * 8, Tile.TILE_ICE_BORDER_4);
							tiles[xx + (yy * WIDTH)] = iceB4;
							Main.walls.add(iceB4);
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
		Main.boss_1 = new Finn(228, 140, 16, 16, Entity.FINN_EN);
		Main.boss_2 = new FireP(80, 368, 16, 16, Entity.FIRE_EN);
		Main.boss_3 = new IceKing(832, 824, 16, 16, Entity.ICE_EN);
		Main.isBoss = true;
		Main.isBossF = true;
		Main.isBossI = true;
		Main.world = new World("/"+lvl);
		return;
	}
	
	public static void nextLvl(String lvl) {
		
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
