package com.beyastudio.boss_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.ShootTile;
import com.beyastudio.wolrd.ShootTileSlow;
import com.beyastudio.wolrd.Tile;

public class Finn extends Entity {

	public int rangeWalk = 8 * 2;
	
	public double spd = 1;
	private double attackSpeed = 7;

	private boolean canCreat;

	private String estado = "parado";

	private boolean canChooseY, canChooseX, canShoot;
	
	private double anglep, anglepp;
	
	private int timer = 0;

	public int angleRotationAdd = 0;
	
	private int range,
				negaRange,
				maxLife = 600,
				angleAddOne = 1,
				locationY,
				locationX;

	private double dx, dy, nextShoot, angle;

	public Finn(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		this.range = x + rangeWalk;
		this.negaRange = x - rangeWalk;
		this.life = maxLife;

		this.anglep = Math.toRadians(90);
		
		
		this.anglepp = Math.toRadians(30);

		this.canCreat = true;
		
	}

	@Override
	public void tick() {

		if (this.life <= 0) {
			Main.isBoss = false;
			Main.shootWalls.removeAll(Main.shootWalls);
			Main.shootWallsSlow.removeAll(Main.shootWallsSlow);
		}

		stateMachine();
		
	}

	public void stateMachine() {

		switch (estado) {

		case "parado":
			spd = 0;

			if (life != maxLife) {
				
				estado = "atacando_tentacle";
			}
			break;

		case "atacando_tentacle":

			if (canCreat) {
				
				for(int i = 0; i < 5; i++) {
					ShootTile t = new ShootTile(206 + (i*7), 210, Tile.TILE_INV, 90);
					Main.shootWalls.add(t);
				}
				
				
				/*-----------360_down-----------*/
				
				for(int i = 0; i < 4; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 232 - (i*8), Tile.TILE_WALL, 360);
					Main.shootWalls.add(tile_0);

				}

				/*-----------180_down-----------*/
				for(int i = 0; i < 4; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 232 - (i*8), Tile.TILE_WALL, 180);
					Main.shootWalls.add(tile_180);

				}
				
				/*-----------90_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 208 + (i*8), Tile.TILE_WALL, 270);
					Main.shootWalls.add(tile_90);
				}
				
				/*-----------270_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(290 + (i*8), 232 - (i*8), Tile.TILE_WALL, 270);
					Main.shootWalls.add(tile_180);

				}
				
				/********************************/
				//             UP
				/********************************/
				
				
				/*-----------360_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 54 + (i*8), Tile.TILE_WALL, 360);
					Main.shootWalls.add(tile_0);

				}

				/*-----------180_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 54 + (i*8), Tile.TILE_WALL, 180);
					Main.shootWalls.add(tile_180);

				}
				
				/*-----------90_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 80 - (i*8), Tile.TILE_WALL, 90);
					Main.shootWalls.add(tile_90);
				}
				
				/*-----------270_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(312 - (i*8), 80 - (i*8), Tile.TILE_WALL, 90);
					Main.shootWalls.add(tile_180);

				}


				
				canCreat = false;
			}
			

			attackSpeed = .9;
			/******* Attackspeed system ********/
			if (System.currentTimeMillis() < nextShoot) {
				return;
			}

			nextShoot = System.currentTimeMillis() + (attackSpeed * 100);

			/* Attack start */
			angleAddOne += 2;

			angle = Math.toRadians(90 + angleAddOne);

			dx = Math.cos(anglep + angleAddOne + .01);
			dy = Math.sin(anglep + angleAddOne + .01);

			Bullet b = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
			Main.finnBullets.add(b);
			
			dx = Math.cos(angle);
			dy = Math.sin(angle);

			Bullet b1 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
			Main.finnBullets.add(b1);

			dx = Math.cos(angle + anglep);
			dy = Math.sin(angle + anglep);

			Bullet b2 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
			Main.finnBullets.add(b2);

			dx = Math.cos(angle + (anglep * 2));
			dy = Math.sin(angle + (anglep * 2));

			Bullet b3 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
			Main.finnBullets.add(b3);

			dx = Math.cos(angle + (anglep * 3));
			dy = Math.sin(angle + (anglep * 3));

			Bullet b4 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
			Main.finnBullets.add(b4);
			
			if(life <= (maxLife * .7)) {
				Main.shootWalls.removeAll(Main.shootWalls);
				canCreat = true;
				canChooseY = true;
				estado = "fase_2";
			}
			break;
			
		case "fase_2":
			
			if(canCreat) {
				for(int i = 0; i < 5; i++) {
					ShootTile t = new ShootTile(206 + (i*7), 210, Tile.TILE_INV, 90);
					Main.shootWalls.add(t);
				}
			}
			canCreat = false;
			
			spd = 1;

			
			if(canChooseY) {
				locationY = Main.ran.nextInt(1, 3);
			}
			if(canChooseX) {
				locationX = Main.ran.nextInt(1, 3);
			}
			
			
			if(locationY == 1) {
				if(y > 64) {
					y -= spd;
					canChooseY = false;
				}
				canChooseX = true;
			}else if(locationY == 2) {
				if(y < 208) {
					y += spd;
					canChooseY = false;
				}
				canChooseX = true;
			}
			
			if(locationX == 1) {
				double xx = x;
				if(x > 168) {
					x -= spd;
				}
				canChooseX = false;
			}
			else if(locationX == 2) {
				double xx = x;
				if(x < 280) {
					x += spd;
				}
				canChooseX = false;
				
			}
			
			attackSpeed = 10;
			/******* Attackspeed system ********/
			if (System.currentTimeMillis() < nextShoot) {
				return;
			}

			nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
			
			
			
			canShoot = true;
			
			if(canShoot) {

				
				
				angle = Math.atan2(Main.player.getY()- y, Main.player.getX() - x);
					
				this.dx = Math.cos(angle - Math.toRadians(28));
				this.dy = Math.sin(angle - Math.toRadians(28));
					
				Bullet bola = new Bullet(this.getX(), this.getY(), 8, 8, Entity.BULLET_FINN_1, dx, dy);
				bola.damage = 5;
				bola.spd = 1;
				Main.finnBullets.add(bola);
				
				this.dx = Math.cos(angle);
				this.dy = Math.sin(angle);
					
				Bullet bola1 = new Bullet(this.getX(), this.getY(), 8, 8, Entity.BULLET_FINN_1, dx, dy);
				bola1.damage = 5;
				bola1.spd = 1;
				Main.finnBullets.add(bola1);
				
				
				this.dx = Math.cos(angle + Math.toRadians(28));
				this.dy = Math.sin(angle + Math.toRadians(28));
					
				Bullet bola2 = new Bullet(this.getX(), this.getY(), 8, 8, Entity.BULLET_FINN_1, dx, dy);
				bola2.damage = 5;
				bola2.spd = 1;
				Main.finnBullets.add(bola2);

				
				
				this.anglep = 0;
				
				int qtdBullet = 6;
				int agleHelper = 140;
				
				switch(locationY) {
				
				case 1:
					switch(locationX) {
					
					case 1:
						for(int i = 0; i < qtdBullet; i++) {
							angle = Main.ran.nextDouble(170, 360);
							anglep = Math.toRadians(angle + agleHelper);
							this.dx = Math.cos(anglep);
							this.dy = Math.sin(anglep);
							
							Bullet_slash bSlash = new Bullet_slash(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_SLASH, dx, dy);
							Main.finnBullets.add(bSlash);
							System.out.println(angle);
						}
						break;
						
					case 2:
						for(int i = 0; i < qtdBullet; i++) {
							angle = Main.ran.nextDouble(180, 370);
							anglep = Math.toRadians(angle - agleHelper);
							this.dx = Math.cos(anglep);
							this.dy = Math.sin(anglep);
							
							Bullet_slash bSlash = new Bullet_slash(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_SLASH, dx, dy);
							Main.finnBullets.add(bSlash);
							System.out.println(angle);
						}
						break;
						
					}//SWITCH X
					
					break;
				
					
				case 2:
					switch(locationX) {
					
					case 1:
						for(int i = 0; i < qtdBullet; i++) {
							angle = Main.ran.nextDouble(0, 181);
							anglep = Math.toRadians(angle - agleHelper);
							this.dx = Math.cos(anglep);
							this.dy = Math.sin(anglep);
							
							Bullet_slash bSlash = new Bullet_slash(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_SLASH, dx, dy);
							Main.finnBullets.add(bSlash);
							System.out.println(angle - agleHelper);
						}
						break;
						
					case 2:
						for(int i = 0; i < qtdBullet; i++) {
							angle = Main.ran.nextDouble(0, 181);
							anglep = Math.toRadians(angle + agleHelper);
							this.dx = Math.cos(anglep);
							this.dy = Math.sin(anglep);
							
							Bullet_slash bSlash = new Bullet_slash(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_SLASH, dx, dy);
							Main.finnBullets.add(bSlash);
							System.out.println(angle);
						}
						break;
						
					}//SWITCH X
					
					break;
				}
			
			}
			
			

			
			
			
			
			if(life <= maxLife * .5) {
				estado = "fase_3";
				Main.shootWalls.removeAll(Main.shootWalls);
				canCreat = true;
			}
			
			break;

		case "fase_3":
			//x = 220, y = 140

			if(canCreat) {
				for(int i = 0; i < 5; i++) {
					ShootTile t = new ShootTile(206 + (i*7), 210, Tile.TILE_INV, 90);
					Main.shootWalls.add(t);
				}
				
				/*-----------360_down-----------*/
				
				for(int i = 0; i < 4; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 232 - (i*8), Tile.TILE_WALL, 360);
					Main.shootWalls.add(tile_0);

				}

				/*-----------180_down-----------*/
				for(int i = 0; i < 4; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 232 - (i*8), Tile.TILE_WALL, 180);
					Main.shootWalls.add(tile_180);

				}
				
				/*-----------90_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 208 + (i*8), Tile.TILE_WALL, 270);
					Main.shootWalls.add(tile_90);
				}
				
				/*-----------270_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(290 + (i*8), 232 - (i*8), Tile.TILE_WALL, 270);
					Main.shootWalls.add(tile_180);

				}
				
				/********************************/
				//             UP
				/********************************/
				
				
				/*-----------360_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 54 + (i*8), Tile.TILE_WALL, 360);
					Main.shootWalls.add(tile_0);

				}

				/*-----------180_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 54 + (i*8), Tile.TILE_WALL, 180);
					Main.shootWalls.add(tile_180);

				}
				
				/*-----------90_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 80 - (i*8), Tile.TILE_WALL, 90);
					Main.shootWalls.add(tile_90);
				}
				
				/*-----------270_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(312 - (i*8), 80 - (i*8), Tile.TILE_WALL, 90);
					Main.shootWalls.add(tile_180);

				}
			}
			
			canCreat = false;
			spd += 1;
			angle = Math.toRadians(90 + spd);
			double radius = 80;

			
			
			dy = Math.sin(angle);
			dx = Math.cos(angle);
			
			x = 220 + (radius*dx);
			y = 140 + (radius*dy);
			
			
			
			attackSpeed = .8;
			/******* Attackspeed system ********/

			
			if (System.currentTimeMillis() < nextShoot) {
				return;
			}
			
			nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
			
			if(x > 290 && x < 300) {

				Bullet_sword_w sword = new Bullet_sword_w(this.getX(), this.getY(), 16, 16, Entity.BULLET_FINN_SWORD_180, -1, 0);
				Main.finnBullets.add(sword);
			}
			
			if(x > 140 && x < 150 ) {

				Bullet_sword_w sword2 = new Bullet_sword_w(this.getX(), this.getY(), 16, 16, Entity.BULLET_FINN_SWORD_0, 1, 0);
				Main.finnBullets.add(sword2);
			}
			
			if (x > 185 && x < 270) {
				Bullet_sword_h sword3 = new Bullet_sword_h(this.getX(), this.getY(), 16, 16, Entity.BULLET_FINN_SWORD_270, 0, 1);
				Main.finnBullets.add(sword3);
				System.out.println("xx");
			}
			
			
			if(x > 185 && x < 270) {
				Bullet_sword_h sword4 = new Bullet_sword_h(this.getX(), this.getY(), 16, 16, Entity.BULLET_FINN_SWORD_90, 0, -1);
				Main.finnBullets.add(sword4);
			}
			
			
			if(life < (maxLife * .2)) {
				estado = "fase_final";
				Main.shootWalls.removeAll(Main.shootWalls);
				canCreat = true;
			}
			
			break;
			
		case "fase_final":
			
			
			spd = 0;
			
			if(x > 224)
			{
				spd = 1;
				x -= spd;
			}
			if(x < 224) {
				spd = 1;
				x += spd;
			}
			if(y > 64) {
				
				spd = 1;
				y -= spd;
			}
			if(y < 64) {
				
				spd = 1;
				y += spd;
			}
		
			if (canCreat) {
				
				for(int i = 0; i < 5; i++) {
					ShootTile t = new ShootTile(206 + (i*7), 210, Tile.TILE_INV, 90);
					Main.shootWalls.add(t);
					}
					
				/*-----------90_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 208 + (i*8), Tile.TILE_WALL, 270);
					Main.shootWalls.add(tile_90);
					}
					
				/*-----------270_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(290 + (i*8), 232 - (i*8), Tile.TILE_WALL, 270);
					Main.shootWalls.add(tile_180);
					}

				/*-----------360_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 54 + (i*8), Tile.TILE_WALL, 360);
					Main.shootWalls.add(tile_0);
					}
				
				/*-----------180_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 54 + (i*8), Tile.TILE_WALL, 180);
					Main.shootWalls.add(tile_180);

				}
				
				for(int i = 0; i < 17; i++) {
					ShootTileSlow t = new ShootTileSlow(160 + (i*8), 60, Tile.TILE_INV);
					Main.shootWallsSlow.add(t);
				}
				
				canCreat = false;
			}
			
			
			
			break;
		}


		
		
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		if (life != 600) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, 10, 2);
			g.setColor(Color.ORANGE);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 10), 2);
		}

	}

}
