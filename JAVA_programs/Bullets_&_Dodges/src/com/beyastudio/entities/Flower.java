package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;

public class Flower extends Entity{
	
	private int direction;
	private BufferedImage sprites;
	private BufferedImage[] nsprites;
	
	private int frames = 0,
			maxFrames = 10,
			index = 0,
			maxIndex = 5;
	
	public Flower(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		sprites = Entity.FLOWER;
		
		Main.player.healling = 1.4;
		
		nsprites = new BufferedImage[6];
		
		for(int i = 0; i < 6; i++) {
			nsprites[i] = Main.spritesheet.getSpritesheet(144 + (i * 8), 32, 8, 8);
		}
		
	}
	
	@Override
	public void tick() {
		
		if(Main.player.haveFlower) {
			direction = Main.player.getDir();
			x = Main.player.getX();
			y = Main.player.getY() + 1;
			
			
			
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
				Sound.powerUp.play();
				Main.ui.flower = true;
				Main.player.haveFlower = true;
			}
			
		}
		
		
		
	}
	
	@Override
	public void render(Graphics g) {
		
		
		if(Main.player.haveFlower) {
			 
			if(this.direction == 3) {
				g.drawImage(sprites, this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
			
		}else {
			g.drawImage(nsprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			
		}
		
	}
	
}