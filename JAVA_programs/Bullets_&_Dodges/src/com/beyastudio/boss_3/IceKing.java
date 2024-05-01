package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Boss_tombstone;
import com.beyastudio.entities.Entity;
import com.beyastudio.entities.Ice_orbital;
import com.beyastudio.entities.teleporters.Teleport_back;
import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.IceShootTile;
import com.beyastudio.wolrd.Tile;

public class IceKing extends Entity{
	
	private String estado = "parado";
	
	private double spd = 0;
	
	private double attackSpeed = 8,
				nextShoot = 0,
				angle, anglep, anglepp,
				dx, dy;
	
	private boolean canCreat, att = false;
	private boolean walking, attacking = true;

	public boolean isDamaged = false;
	
	private int frames = 0,
			maxFrames = 8,
			index = 0,
			maxIndex = 1;
	
	public int damageFrames = 5, currentFrames = 0;
	
	private int count = 0, aux = 30;
	
	private Penguin[] penguins;
	
	private BufferedImage[] sprites, spritesWalk;

	public IceKing(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		this.life = 550;
		this.maxLife = 550;
		
		penguins = new Penguin[6];
		
		sprites = new BufferedImage[2];
		sprites[0] = Main.spritesheet.getSpritesheet(0, 192, 16, 16);
		sprites[1] = Main.spritesheet.getSpritesheet(16, 192, 16, 16);
		
		spritesWalk = new BufferedImage[2];
		spritesWalk[0] = Main.spritesheet.getSpritesheet(32, 192, 16, 16);
		spritesWalk[1] = Main.spritesheet.getSpritesheet(48, 192, 16, 16);
		
	}
	
	public void tick() {
		if (life <= 0) {
			Sound.bossDied.play();
			Boss_tombstone tb = new Boss_tombstone(this.getX() - 4, this.getY() - 20, 16, 16, Entity.TOMB_NEUTRAL, "ice");
			Main.tombs.add(tb);
			
			Main.entities.add(
					Main.tbIce =
					new Teleport_back
					(864, 928 - 8, 16, 16, Entity.LOBBY_TELEPORT, Teleport_back.xBack, Teleport_back.yBack));
			
			if(Main.orbice) {
				Ice_orbital o = new Ice_orbital(this.getX(), this.getY(), 8, 8, Entity.ICE_ORB);
				Main.entities.add(o);
				Main.orbice = false;
			}

			Main.iceShootWalls.removeAll(Main.iceShootWalls);
			Main.isBossI = false;
		}
		
		stateMachine();
		
		if(att) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			
			}
		}
		
		if(isDamaged) {
			this.currentFrames++;
			if(this.currentFrames == this.damageFrames) {
				this.currentFrames = 0;
				isDamaged = false;
				
			}
			
		}
		

		
		
	}
	
	
	public void stateMachine() {
		
		switch(estado){
			case "parado":
				
				if(life!=maxLife) {
					this.estado = "fase_1"; 
					// thats the normal one, DONT touch:  
					this.setAttackSpeed(1.5);
					canCreat = true;
					att = true;
					//System.out.println(this.calculateDistance(this.getX(), this.getY(), Main.player.getX(), Main.player.getY()));
					Main.entities.remove(Main.tbIce);
				}
				break;
				
				
			case "fase_1":
				
				
				if(canCreat) {
	
					for(int i = 0; i < 5; i++) {
						
					}
	
					
					
					penguins[0] = new Penguin(776, 864, 8, 8, Entity.PENGUIN_EN);
					Main.entities.add(penguins[0]);
					
					penguins[1] = new Penguin(776, 776, 8, 8, Entity.PENGUIN_EN);
					Main.entities.add(penguins[1]);
					
					penguins[2] = new Penguin(880, 776, 8, 8, Entity.PENGUIN_EN);
					Main.entities.add(penguins[2]);
					
					penguins[3] = new Penguin(880, 864, 8, 8, Entity.PENGUIN_EN);
					Main.entities.add(penguins[3]);
					
					penguins[4] = new Penguin(760, 816, 8, 8, Entity.PENGUIN_EN);
					Main.entities.add(penguins[4]);
					
					penguins[5] = new Penguin(896, 816, 8, 8, Entity.PENGUIN_EN);
					Main.entities.add(penguins[5]);
					canCreat = false;
					
				}
				
				int count_aux = 35;
				
				count++;
				
				if (count < count_aux * 2) return;
				int playerY = Main.player.getY() - 5;
				int playerX = Main.player.getX() - 3;
				double dis = this.calculateDistance(this.getX(), this.getY(), Main.player.getX(), Main.player.getY());
				

				
				if(count > count_aux * 3) {
					
	
					
					if(dis > 0) {
						
						walking = true;
						attacking = false;
						
						spd = 1.5;

						anglep = Math.atan2(playerY- y, playerX - x);

						dx = Math.cos(anglep);
						dy = Math.sin(anglep);
					
						x += dx * spd;
						y += dy * spd;
						
						if(count > count_aux * 6) {
							spd = 0;
							count = 0;
							
							walking = false;
							attacking = true;
						}
					}
					

				}
				

				 
				//anglep = Main
				angle = Math.toRadians(90);
				
				if (System.currentTimeMillis() < nextShoot) return;
					
				nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
		
				for(int i = 0; i < 4; i++) {
					
					dx = Math.cos(angle + (i * angle));
					dy = Math.sin(angle + (i * angle));
					if(i == 0) {
						Bullet_spear bs = new Bullet_spear(this.getX() + 4, this.getY(), 16, 16, Entity.BULLET_ICE_SPEAR_90, dx, dy);
						Main.BossBullets.add(bs);
					}else if(i == 1) {
						Bullet_spear bs = new Bullet_spear(this.getX(), this.getY() + 4, 16, 16, Entity.BULLET_ICE_SPEAR_180, dx, dy);
						bs.setMask(2, 6, 11, 5);
						Main.BossBullets.add(bs);
					}else if(i == 2) {
						Bullet_spear bs = new Bullet_spear(this.getX() - 4, this.getY(), 16, 16, Entity.BULLET_ICE_SPEAR_270, dx, dy);
						Main.BossBullets.add(bs);
					}else {
						Bullet_spear bs = new Bullet_spear(this.getX(), this.getY() - 4, 16, 16, Entity.BULLET_ICE_SPEAR_0, dx, dy);
						bs.setMask(2, 6, 11, 5);
						Main.BossBullets.add(bs);
					}
					
				}//for

				
				if(this.life <= maxLife * 0.7) {
					
					for(int i = 0; i < penguins.length; i++) {
						Main.entities.remove(penguins[i]);
					}
					canCreat = true;
					this.setAttackSpeed(.7);
					count = 0;
					estado = "fase_2";
					maxFrames = 5;
					frames = 0;
				}
				
				
				break;	
				
				
				
			case "fase_2":

				spd = 0;
				
				//X = 824 Y = 816
				
				if(x > 824) {
					spd = 1;
					x -= spd;
				}
				if(x < 824) {
					spd = 1;
					x += spd;
				}
				if(y > 816) {
					spd = 1;
					y -= spd;
				}
				if(y < 816) {
					spd = 1;
					y += spd;
				}
				
				//X = 825
				//Y = 816
				
				
				
//				if(canCreat) {
//
//					
//					
//				canCreat = false;
//				}
				
				
				if(getX() == 824 && (getY() == 816)) {

				walking = false;
				attacking = true;
				
				
				if(count < aux) {
					
					if (System.currentTimeMillis() < nextShoot) return;
					
					nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
					
				anglep += 7;

				angle = Math.toRadians(330 +  anglep);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_flake bf = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
				Main.BossBullets.add(bf);
				
				angle = Math.toRadians(90 +  anglep);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_flake bf2 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
				Main.BossBullets.add(bf2);
				
				angle = Math.toRadians(210 +  anglep);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_flake bf3 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
				Main.BossBullets.add(bf3);
				
				if (count == 30) {
					anglepp = anglep*-1;
				}
				
				}
				
				if (count > aux){
					
					
					if (System.currentTimeMillis() < nextShoot) return;
					
					nextShoot = System.currentTimeMillis() + (attackSpeed * 100);
					
					anglepp -= 7;

					angle = Math.toRadians(330 +  anglepp);
					
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					
					Bullet_flake bf = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
					Main.BossBullets.add(bf);
					
					angle = Math.toRadians(90 +  anglepp);
					
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					
					Bullet_flake bf2 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
					Main.BossBullets.add(bf2);
					
					angle = Math.toRadians(210 +  anglepp);
					
					dx = Math.cos(angle);
					dy = Math.sin(angle);
					
					Bullet_flake bf3 = new Bullet_flake(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_FLAKE, dx, dy);
					Main.BossBullets.add(bf3);
					
					if(count > aux * 2) {
						count = 0;
						anglep = anglepp*-1;
					}
					
				
				}
				System.out.println(count);
				count++;
				}
				
				if(this.life <= maxLife * 0.5) {
					estado = "fase_3";
					canCreat = true;
					this.setAttackSpeed(4);
					spd = 4;
					maxFrames = 29;
				}
						
				break;
				
			case "fase_3":
				
				if(canCreat) {
					
					
					penguins[0] = new Penguin(776, 864, 8, 8, Entity.PENGUIN_EN);
					penguins[0].setAttackSpeed(6);
					Main.entities.add(penguins[0]);
					
					penguins[1]= new Penguin(776, 776, 8, 8, Entity.PENGUIN_EN);
					penguins[1].setAttackSpeed(6);
					Main.entities.add(penguins[1]);
					
					penguins[2] = new Penguin(880, 776, 8, 8, Entity.PENGUIN_EN);
					penguins[2].setAttackSpeed(6);
					Main.entities.add(penguins[2]);
					
					penguins[3] = new Penguin(880, 864, 8, 8, Entity.PENGUIN_EN);
					penguins[3].setAttackSpeed(6);
					Main.entities.add(penguins[3]);
					canCreat = false;
					
				}
				
				int temp_esperando = 12;
				
				
				angle = Math.atan2(Main.player.getY()- y, Main.player.getX() - x);
				
				if (System.currentTimeMillis() < nextShoot) return;
				nextShoot = System.currentTimeMillis() + (temp_esperando * 100);
				
				dx = Math.cos(angle);
				dy = Math.sin(angle);
				
				Bullet_cinto c = new Bullet_cinto(this.getX(), this.getY(), 16, 16, Entity.BULLET_ICE_CINTO, dx, dy);
				Main.BossBullets.add(c);
				
				
				if(this.life <= maxLife * 0.25) {
					
					for(int i = 0; i < penguins.length; i++) {
						Main.entities.remove(penguins[i]);
					}
					
					canCreat = true;
					this.setAttackSpeed(20);
					
					spd = 1;
					maxFrames = 5;
					frames = 0;
					estado = "fase_4";
				}
				break;
				
				
			case "fase_4":
				
				//X = 829 Y = 936
				
				walking = true;
				attacking = false;
				
				spd = 0;
				
				if(x > 829) {
					spd = 1;
					x -= spd;
				}
				if(x < 829) {
					spd = 1;
					x += spd;
				}
				if(y > 936) {
					spd = 1;
					y -= spd;
				}
				if(y < 936) {
					spd = 1;
					y += spd;
				}
				
				if(this.getX() == 829 && this.getY() == 936) { 
					
					walking = false;
					attacking = true;
				
					if(canCreat) {
						
						for(int i = 0; i < 8; i++) {
							
							IceShootTile t = new IceShootTile(752 + (i * 20), 944 - 8, Tile.TILE_INV, 270);
							t.setAttackSpeed(2);
							Main.iceShootWalls.add(t);

							IceShootTile t2 = new IceShootTile(912, 920 - (i * 20), Tile.TILE_INV, 180);
							Main.iceShootWalls.add(t2);
							
						}
						canCreat = false;
					}
				}
				
				break;
				
		}
		
	}
	
	
	
	
	
	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	

	@Override
	public void render(Graphics g) {
		super.render(g);
		
		if(!isDamaged) {
			if(attacking) {
				
				sprites[0] = Main.spritesheet.getSpritesheet(0, 192, 16, 16);
				sprites[1] = Main.spritesheet.getSpritesheet(16, 192, 16, 16);
				
				if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			if(walking) {
				
				spritesWalk[0] = Main.spritesheet.getSpritesheet(32, 192, 16, 16);
				spritesWalk[1] = Main.spritesheet.getSpritesheet(48, 192, 16, 16);
				
				if(index == 0) g.drawImage(spritesWalk[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(spritesWalk[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
		}else {
		
			if(attacking) {
				
				sprites[0] = Entity.ICE_DAMAGED_ATT_1;
				sprites[1] = Entity.ICE_DAMAGED_ATT_2;
				
				if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			if(walking) {
				
				spritesWalk[0] = Entity.ICE_DAMAGED_WALK_1;
				spritesWalk[1] = Entity.ICE_DAMAGED_WALK_2;
				
				if(index == 0) g.drawImage(spritesWalk[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if(index == 1) g.drawImage(spritesWalk[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			
		
		}
		
		
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, 20, 2);
			g.setColor(Color.GREEN);
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
		}

	}
	
}
