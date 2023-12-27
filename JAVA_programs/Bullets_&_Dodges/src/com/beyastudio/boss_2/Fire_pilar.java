package com.beyastudio.boss_2;

import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.ShootTile;

public class Fire_pilar extends ShootTile{
	
	
	private String red_blue;

	public Fire_pilar(int x, int y, BufferedImage sprite, int angle, String red_blue) {
		super(x, y, null, angle);
		
		this.angle = Math.toRadians(angle);
		
		this.attackSpeed = 15;
		
		this.nextShoot = 0;
		
		this.red_blue = red_blue;
		
		if(red_blue == "red") {
			this.sprite = Entity.RED_FIRE_PILAR;
		}
		else if(red_blue == "blue") {
			this.sprite = Entity.BLUE_FIRE_PILAR;
		}
		
	}
	
	
	
	@Override
	
	public void tick(){
		
		if(System.currentTimeMillis()< nextShoot) return;
		
		nextShoot = System.currentTimeMillis() + (attackSpeed * 100);

		
		if(red_blue == "red") {
			if(angle == Math.toRadians(180)) {
				for(int i = 0; i < 5; i++) {
					double j = Math.toRadians(angle - (i * 15));
					
					dx = Math.cos(j);
					dy = Math.sin(j);
					
					Bullet_red_rock br1 = new Bullet_red_rock(this.getX() + 4, this.getY(), 8, 8, Entity.BULLET_RED_ROCK, dx, dy);
					Main.BossBullets.add(br1);
				}
			}
			else if(angle == Math.toRadians(179)) {
					for(int i = 0; i < 5; i++) {
						double j = angle - Math.toRadians(i * 15);
						
						dx = Math.cos(j);
						dy = Math.sin(j);
						
						Bullet_red_rock br = new Bullet_red_rock(this.getX() + 4, this.getY(), 8, 8, Entity.BULLET_RED_ROCK, dx, dy);
						Main.BossBullets.add(br);
					}
				}
				
		}else if (red_blue == "blue") {
			if(angle == Math.toRadians(270)) {
				for(int i = 0; i < 5; i++) {
					double j = Math.toRadians(angle + (i * 15));
					
					dx = Math.cos(j);
					dy = Math.sin(j);
					
					Bullet_blue_rock br = new Bullet_blue_rock(this.getX() + 4, this.getY(), 8, 8, Entity.BULLET_BLUE_ROCK, dx, dy);
					Main.BossBullets.add(br);
				}
			}
			else if(angle == Math.toRadians(180)) {
					for(int i = 0; i < 5; i++) {
						double j = angle + Math.toRadians(i * 15);
						
						dx = Math.cos(j);
						dy = Math.sin(j);
						
						Bullet_blue_rock br = new Bullet_blue_rock(this.getX() + 4, this.getY(), 8, 8, Entity.BULLET_BLUE_ROCK, dx, dy);
						Main.BossBullets.add(br);
					}
				}
				
				
			}
			
			
		}
		
		

}
