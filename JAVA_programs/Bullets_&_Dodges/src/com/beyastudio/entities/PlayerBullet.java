package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.boss_3.Penguin;
import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.Tile;

public class PlayerBullet extends Entity {

	private double dx, dy;

	/****** STATUS **********/
	protected int spd = 2;
	public int damage = 3;
	protected int range;
	public double heal = .7;
	/**********************/

	private int range_mux;
	private double lifeTime_right, lifeTime_left, lifeTime_up, lifeTime_down;

	public PlayerBullet(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, int range) {
		super(x, y, width, height, sprite);
		this.maskx = 2;
		this.masky = 2;
		this.mwidth = 4;
		this.mheight = 4;
		
		this.range = range;
		this.range_mux = 8 * this.range;

		this.dx = dx;
		this.dy = dy;
		lifeTime_right = x + range_mux;
		lifeTime_left = x - range_mux;
		lifeTime_up = y + range_mux;
		lifeTime_down = y - range_mux;
	}

	@Override
	public void tick() {
		x += dx * spd;
		y += dy * spd;
		collidingEnemy();
		selfDestroy();
		collidingWall();
		collidingFinn();
		collidingIce();
		collidingFire();
		collidingSamurai();

		if ((x >= lifeTime_right) || (x <= lifeTime_left) || (y >= lifeTime_up) || (y <= lifeTime_down)) {
			Main.playerBullets.remove(this);
		}

	}


	public void selfDestroy() {
		if ((this.getX() >= (Main.width + Camera.x) - 8) || (this.getX() <= 0)
				|| (this.getY() >= (Main.height + Camera.y) - 8) || (this.getY() <= 0)) {
			Main.playerBullets.remove(this);
		}

	}

	public void collidingWall() {
		for (int i = 0; i < Main.walls.size(); i++) {
			Tile atual = Main.walls.get(i);

			if (Tile.isColliding(this, atual)) {
				Main.playerBullets.remove(this);
				return;
			}
		}
	}

	public void collidingFinn() {
		if (Main.boss_1 == null)
			return;

		if (Entity.isColliding(this, Main.boss_1)) {
			//Sound.bossHurt.play();
			Main.boss_1.life -= damage;
			Main.boss_1.isDamaged = true;
			Main.player.life += heal;
			if(Main.player.life > Main.player.maxLife) {
				Main.player.life = Main.player.maxLife;
			}
			System.out.println("vida = " + Main.boss_1.life);
			Main.playerBullets.remove(this);
		}
	}
	
	public void collidingSamurai() {
		if (Main.boss_A == null)
			return;

		if (Entity.isColliding(this, Main.boss_A)) {
			//Sound.bossHurt.play();
			Main.boss_A.life -= damage;
			Main.boss_A.isDamaged = true;
			Main.player.life += heal;
			if(Main.player.life > Main.player.maxLife) {
				Main.player.life = Main.player.maxLife;
			}
			System.out.println("vida = " + Main.boss_A.life);
			Main.playerBullets.remove(this);
		}
	}
	
	public void collidingFire() {
		if (Main.boss_2 == null)
			return;

		if (Entity.isColliding(this, Main.boss_2)) {
			//Sound.bossHurt.play();
			Main.boss_2.life -= damage;
			Main.boss_2.isDamaged = true;
			Main.player.life += heal;
			if(Main.player.life > Main.player.maxLife) {
				Main.player.life = Main.player.maxLife;
			}
			System.out.println("vida = " + Main.boss_2.life);
			Main.playerBullets.remove(this);
		}
	}
	public void collidingIce() {
		if (Main.boss_3 == null)
			return;

		if (Entity.isColliding(this, Main.boss_3)) {
			//Sound.bossHurt.play();
			Main.boss_3.life -= damage;
			Main.boss_3.isDamaged = true;
			Main.player.life += heal;
			if(Main.player.life > Main.player.maxLife) {
				Main.player.life = Main.player.maxLife;
			}
			System.out.println("vida = " + Main.boss_3.life);
			Main.playerBullets.remove(this);
		}
	}

	public void collidingEnemy() {
		for (int i = 0; i < Main.entities.size(); i++) {
			Entity atual = Main.entities.get(i);
			boolean isEnemy = atual instanceof Enemy;
			boolean isPenguin = atual instanceof Penguin;
			boolean isPikachu = atual instanceof Snorlax;
			boolean isSoul = atual instanceof Soul;

			if (isEnemy || isPenguin) {
				if (Entity.isColliding(this, atual)) {
					//Sound.bossHurt.play();
					atual.life -= damage;
					atual.isDamaged = true;
					Main.player.life += heal;
					if(Main.player.life > Main.player.maxLife) {
						Main.player.life = Main.player.maxLife;
					}
					System.out.println("vida = " + atual.life);
					Main.playerBullets.remove(this);
					return;
				}
			}
			if(isPikachu || isSoul) {
				if (Entity.isColliding(this, atual)) {
					//Sound.bossHurt.play();
					atual.life -= damage;
					atual.isDamaged = true;
					Main.player.life += heal + 3;
					if(Main.player.life > Main.player.maxLife) {
						Main.player.life = Main.player.maxLife;
					}
					System.out.println("vida = " + atual.life);
					Main.playerBullets.remove(this);
					return;
				}
				}
			}
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	

	
}
