package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;

public class BeeCrab extends Entity{
	
	//private int direction;
	private BufferedImage sprites;
	private BufferedImage[] nsprites;
	
	private int frames = 0,
			maxFrames = 10,
			index = 0,
			maxIndex = 5;
	
	public BeeCrab(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		sprites = Entity.FLOWER;
		
		
		nsprites = new BufferedImage[6];
		
		for(int i = 0; i < 6; i++) {
			nsprites[i] = Main.spritesheet.getSpritesheet(144 + (i * 8), 40, 8, 8);
		}
		
	}
	
	@Override
	public void tick() {
		
		if(Main.player.haveBeeCrab) {
			
			Orb_destroy bee = new Orb_destroy(Main.player.getX(), Main.player.getY(), 8, 8, Entity.BEE, "bee");
			Main.bee.add(bee);
			
			Orb_destroy crab = new Orb_destroy(Main.player.getX(), Main.player.getY(), 8, 8, Entity.BEE, "crab");
			Main.bee.add(crab);
			
			Main.entities.remove(this);
			
		}else {
			
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			
			}
			
			if(Entity.isColliding(this, Main.player)) {
				//Sound.powerUp.play();
				Main.ui.beeCrab = true;
				Main.player.haveBeeCrab = true;
			}
			
		}
		
		
		
	}
	
	@Override
	public void render(Graphics g) {
		
		
		if(Main.player.haveBeeCrab) {
			 
			g.drawImage(sprites, this.getX() - Camera.x, this.getY() - Camera.y, null);

			
		}else {
			g.drawImage(nsprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			
		}
		
	}
	
}