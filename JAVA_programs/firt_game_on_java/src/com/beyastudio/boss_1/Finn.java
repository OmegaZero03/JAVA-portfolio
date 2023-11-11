package com.beyastudio.boss_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.ShootTile;
import com.beyastudio.wolrd.Tile;

public class Finn extends Entity {

	public int rangeWalk = 8 * 2;

	public double spd = 1;
	private double attackSpeed = 7;

	private boolean canCreat;

	private String estado = "parado";

	private double anglep, anglepp;

	private int range, negaRange, maxLife = 600, angleAddOne = 1;

	private double dx, dy, nextShoot, angle;

	public Finn(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		this.range = x + rangeWalk;
		this.negaRange = x - rangeWalk;
		this.life = 600;

		this.anglep = Math.toRadians(90);
		this.anglepp = Math.toRadians(50);

		this.canCreat = true;
	}

	@Override
	public void tick() {

		if (this.life < 0) {
			Main.isBoss = false;
			Main.shootWalls.removeAll(Main.shootWalls);
		}

		stateMachine();
		// x += spd;

		/*
		 * wa if(x >= range) { spd = spd * (-1); } else if(x <= negaRange) { spd = spd *
		 * (-1); }
		 */

		/* Sistema de mirar no player */
		// double angle = Math.atan2(Main.player.getY() - this.getY()
		// ,Main.player.getX() - this.getX());
		/***************************/

		// double angle = Math.toRadians(90 + i);
		// i += 10;

		/****************************/

//		dx = Math.cos(angle + anglep);
//		dy = Math.sin(angle + anglep);
//		
//		Bullet b1 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
//		Main.finnBullets.add(b1);
//		/****************************/
//		
//		dx = Math.cos(angle + anglepp);
//		dy = Math.sin(angle + anglepp);
//		
//		Bullet b2 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
//		Main.finnBullets.add(b2);
//		/****************************/
//		
//		dx = Math.cos(angle - anglep);
//		dy = Math.sin(angle -  anglep);
//		
//		Bullet b3 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
//		Main.finnBullets.add(b3);
//		/****************************/
//		dx = Math.cos(angle - anglepp);
//		dy = Math.sin(angle - anglepp);
//		
//		Bullet b4 = new Bullet(this.getX() - 5, this.getY() - 4, 16, 16, Entity.BULLET_FINN_1, dx, dy);
//		Main.finnBullets.add(b4);
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
				/*-----------360_down-----------*/
				
				for(int i = 0; i < 4; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 232 - (i*8), Tile.TILE_SHOOT, 360);
					Main.shootWalls.add(tile_0);

				}

				/*-----------180_down-----------*/
				for(int i = 0; i < 4; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 232 - (i*8), Tile.TILE_SHOOT, 180);
					Main.shootWalls.add(tile_180);

				}
				
				/*-----------90_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 208 + (i*8), Tile.TILE_SHOOT, 270);
					Main.shootWalls.add(tile_90);
				}
				
				/*-----------270_down-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(290 + (i*8), 232 - (i*8), Tile.TILE_SHOOT, 270);
					Main.shootWalls.add(tile_180);

				}
				
				/********************************/
				//             UP
				/********************************/
				
				
				/*-----------360_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_0 = new ShootTile(160 - (i*8), 54 + (i*8), Tile.TILE_SHOOT, 360);
					Main.shootWalls.add(tile_0);

				}

				/*-----------180_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(288 + (i*8), 54 + (i*8), Tile.TILE_SHOOT, 180);
					Main.shootWalls.add(tile_180);

				}
				
				/*-----------90_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_90 = new ShootTile(136 + (i*8), 80 - (i*8), Tile.TILE_SHOOT, 90);
					Main.shootWalls.add(tile_90);
				}
				
				/*-----------270_up-----------*/
				for(int i = 0; i < 3; i++) {
					ShootTile tile_180 = new ShootTile(312 - (i*8), 80 - (i*8), Tile.TILE_SHOOT, 90);
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
