package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.World;

public class Player extends Entity {

	public boolean left, right, up, down, moved;

	// STATUS
	public int tLife = 100;
	public double spd = 1.4;
	public int dmg = 5;
	public double healling = .7;
	public double atackSpeed = 2;
	//
	
	//ARTIFACTS
	public boolean haveCrown = false, haveFlower = false, haveBeeCrab = false;
	//
	
	private boolean alternativaSkin = true;
	
	private BufferedImage bullet_atual;
	
	private PlayerBullet b;

	public double life = tLife, maxLife = tLife;

	int range_bullet = 7, range_flower = 11;

	private int frames = 0, Xindex = 0, Yindex = 0, DYindex = 0, max_frames = 7, maxYindex = 2, DmaxYindex = 3,
			maxXindex = 1;

	private int right_dir = 0, left_dir = 1, up_dir = 2, down_dir = 3;

	public boolean debug = false;

	public double mx, my, nextShoot = 0;

	public double dx, dy;

	private int dir = right_dir;

	public boolean shoot = false;
	public boolean autoShoot = false;

	//orbs
	public boolean haveGrass = false, haveIce = false, haveFire = false;
	//
	private BufferedImage[] rightPlayer, leftPlayer, upPlayer, downPlayer, rightAtack, leftAtack, upAtack, downAtack;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		this.maskx = 2;
		this.masky = 2;
		this.mwidth = 5;
		this.mheight = 5;

		leftPlayer = new BufferedImage[2];
		rightPlayer = new BufferedImage[2];

		leftAtack = new BufferedImage[2];
		rightAtack = new BufferedImage[2];

		upPlayer = new BufferedImage[3];
		/**** Cover animation ****/
		downPlayer = new BufferedImage[4];
		/***********************/
		upAtack = new BufferedImage[2];
		downAtack = new BufferedImage[2];
		
		
		

		if(this.alternativaSkin == false) {
			
			this.bullet_atual = Entity.BULLET_PL;

			
			for (int i = 0; i < 2; i++) {
				rightPlayer[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 0, 8, 8);
				leftPlayer[i] = Main.spritesheet.getSpritesheet(16 + (i * 8), 0, 8, 8);

				upAtack[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 56, 8, 8);
				downAtack[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 64, 8, 8);

				rightAtack[i] = Main.spritesheet.getSpritesheet(0, 24 + (i * 8), 16, 8);
				leftAtack[i] = Main.spritesheet.getSpritesheet(0, 40 + (i * 8), 16, 8);
			}

			for (int i = 0; i < 3; i++) {
				upPlayer[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 8, 8, 8);
			}
			for (int i = 0; i < 4; i++) {
				downPlayer[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 16, 8, 8);
			}
			
		}else {
			
			this.bullet_atual = Entity.BULLET_PL_A;

			for (int i = 0; i < 2; i++) {
				rightPlayer[i] = Main.spritesheet.getSpritesheet(248 + (i * 8), 0, 8, 8);
				leftPlayer[i] = Main.spritesheet.getSpritesheet((248+16) + (i * 8), 0, 8, 8);

				upAtack[i] = Main.spritesheet.getSpritesheet(248 + (i * 8), 56, 8, 8);
				downAtack[i] = Main.spritesheet.getSpritesheet(248 + (i * 8), 64, 8, 8);

				rightAtack[i] = Main.spritesheet.getSpritesheet(248, 24 + (i * 8), 16, 8);
				leftAtack[i] = Main.spritesheet.getSpritesheet(248, 40 + (i * 8), 16, 8);
			}

			for (int i = 0; i < 3; i++) {
				upPlayer[i] = Main.spritesheet.getSpritesheet(248 + (i * 8), 8, 8, 8);
			}
			for (int i = 0; i < 4; i++) {
				downPlayer[i] = Main.spritesheet.getSpritesheet(248 + (i * 8), 16, 8, 8);
			}
			
		}
		
		
	}

	@Override
	public void tick() {

		maxLife = tLife;
		
		this.moving();

		if (moved || shoot || autoShoot) {
			frames++;
			if (frames == max_frames) {
				frames = 0;
				Yindex++;
				DYindex++;
				Xindex++;
				if (Xindex > maxXindex) {
					Xindex = 0;
				}
				if (Yindex > maxYindex) {
					Yindex = 0;
				}
				if (DYindex > DmaxYindex) {
					DYindex = 0;
				}
			}

		}

		this.shotting();
		
	}
	
	/************************GRÁFICO********************************/


	@Override
	public void render(Graphics g) {

		if (shoot || autoShoot) {

			if (dir == right_dir) {
				g.drawImage(rightAtack[Xindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(leftAtack[Xindex], this.getX() - Camera.x - 8, this.getY() - Camera.y, null);
			}
			if (dir == up_dir) {
				g.drawImage(upAtack[Xindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == down_dir) {
				g.drawImage(downAtack[Xindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}

		} else {

			if (dir == right_dir) {
				g.drawImage(rightPlayer[Xindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(leftPlayer[Xindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}

			if (dir == up_dir) {
				g.drawImage(upPlayer[Yindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == down_dir) {
				g.drawImage(downPlayer[DYindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
		}

		if (debug) {
			life = maxLife;
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
	}
	
	/************************SISTEMA DE MOVIMENTO********************************/
	
	private void moving() {
		
		moved = false;
		
		
		if((right || left) && (up || down)) {
			spd = (1.4 * 0.70) + 0.013;
		}else {
			spd = 1.4;
		}
		
		if (right && World.isFree((int) (x + spd), this.getY())) {
			moved = true;
			dir = right_dir;
			x += spd;
		}
		else if (left && World.isFree((int) (x - spd), this.getY())) {
			moved = true;
			dir = left_dir;
			x -= spd;
		}

		if (up && World.isFree(this.getX(), (int) (y - spd))) {
			moved = true;
			dir = down_dir;
			y -= spd;

		}
		else if (down && World.isFree(this.getX(), (int) (y + spd))) {
			moved = true;
			dir = up_dir;
			y += spd;
		}
	}
	
	private double normalize() {
		
		double length = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
		
		return 0;

	}
	
	/************************ SISTEMA DE TIRO********************************/
	
	
	
	public void shotting() {
		Camera.x = Camera.clamp(this.getX() - (Main.width / 2), 0, World.WIDTH * 8 - Main.width);
		Camera.y = Camera.clamp(this.getY() - (Main.height / 2), 0, World.HEIGHT * 8 - Main.height);

		if (System.currentTimeMillis() < nextShoot) {
			return;
		}

		nextShoot = System.currentTimeMillis() + (atackSpeed * 100);

		double angle = Math.atan2(my - (this.getY() - Camera.y + 5), mx - (this.getX() - Camera.x + 5));

		dx = Math.cos(angle);
		dy = Math.sin(angle);

		if (shoot || autoShoot) {
			Sound.shootPlayer.play();

			if (dir == right_dir) {
				
				if(haveFlower) {
					b = new PlayerBullet(this.getX() + 7, this.getY() - 3, 8, 8, Entity.BULLET_FLOWER_PL, dx, dy,
							this.range_flower);
					b.maskx = 1;
					b.masky = 1;
					b.mwidth = 6;
					b.mheight = 6;
				}else {
					b = new PlayerBullet(this.getX() + 7, this.getY() - 3, 8, 8, bullet_atual, dx, dy,
							this.range_bullet);
				}
				
				
				
				if(haveCrown) {
					b.damage = dmg * 2;
				}else {
					b.damage = dmg;
				}
				b.heal = healling;
				Main.playerBullets.add(b);

			} else if (dir == left_dir) {
				
				if(haveFlower) {
					b = new PlayerBullet(this.getX() - 7, this.getY() - 3, 8, 8, Entity.BULLET_FLOWER_PL, dx, dy,
							this.range_flower);
					b.maskx = 1;
					b.masky = 1;
					b.mwidth = 6;
					b.mheight = 6;
				}else {
					
					b = new PlayerBullet(this.getX() - 7, this.getY() - 3, 8, 8, bullet_atual, dx, dy,
							this.range_bullet);
				}
				
				
				if(haveCrown) {
					b.damage = dmg * 2;
				}else {
					b.damage = dmg;
				}
				b.heal = healling;
				Main.playerBullets.add(b);
			}

			if (dir == down_dir) {
				if(haveFlower) {
					b = new PlayerBullet(this.getX(), this.getY() - 4, 8, 8, Entity.BULLET_FLOWER_PL, dx, dy,
							this.range_flower);
					b.maskx = 1;
					b.masky = 1;
					b.mwidth = 6;
					b.mheight = 6;
				}else {
					
					b = new PlayerBullet(this.getX(), this.getY() - 4, 8, 8, bullet_atual, dx, dy,
							this.range_bullet);
				}
				
				if(haveCrown) {
					b.damage = dmg * 2;
				}else {
					b.damage = dmg;
				}
				b.heal = healling;
				Main.playerBullets.add(b);
				
			} else if (dir == up_dir) {
				if(haveFlower) {

					b = new PlayerBullet(this.getX() + 2, this.getY() + 4, 8, 8, Entity.BULLET_FLOWER_PL, dx, dy,
							this.range_flower);
					b.maskx = 1;
					b.masky = 1;
					b.mwidth = 6;
					b.mheight = 6;
					
				}else {
					
					b = new PlayerBullet(this.getX() + 2, this.getY() + 4, 8, 8, bullet_atual, dx, dy,
							this.range_bullet);
					
				}
				
				
				if(haveCrown) {
					b.damage = dmg * 2;
				}else {
					b.damage = dmg;
				}
				
				b.heal = healling;
				Main.playerBullets.add(b);
			}

		}

	}
	

	public double getAtackSpeed() {
		return atackSpeed;
	}

	public void setAtackSpeed(double atackSpeed) {
		this.atackSpeed = atackSpeed;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
}
