package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Bullet;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.Tile;

public class Orb_destroy extends Entity{
	
	private String beeCrab;
	private BufferedImage[] sprites;
	private int count = 0;
	private double dx, dy;
	public int spd = 0;
	public int move = 30;
	

	public Orb_destroy(int x, int y, int width, int height, BufferedImage sprite, String beeCrab) {
		super(x, y, width, height, sprite);
		this.beeCrab = beeCrab;
		
		sprites = new BufferedImage[2];
		
		sprites[0] = Entity.BEE;
		sprites[1] = Entity.CRAB;
		
		
		this.maskx = 2;
		this.masky = 2;
		this.mwidth = 4;
		this.mheight = 4;
	}
	
	@Override
	public void tick(){
		
		
		if(Main.player.haveBeeCrab == false) {
			Main.bee.removeAll(Main.bee);
		}
		
		
		switch(beeCrab) {
		case "bee":
			x = Main.player.getX();
			y = Main.player.getY() + Math.sin(count * .05) * 16;
			count++;
			break;
			
			
		case "crab":
			x = Main.player.getX() + Math.cos(count * .05) * 16;
			y = Main.player.getY();
			count++;
			break;
		}
		
		
		collidingBullet();
	}
	
	
	public void collidingBullet() {
		for (int i = 0; i < Main.BossBullets.size(); i++) {
			Bullet atual = Main.BossBullets.get(i);

			if (Entity.isColliding(this, atual)) {
				Main.BossBullets.remove(atual);
				return;
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		switch(beeCrab) {
		
		case "bee":
			g.drawImage(sprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
			break;
			
			
		case "crab":
			g.drawImage(sprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
			break;
		
		
		}
	}

}
