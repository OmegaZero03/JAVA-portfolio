package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Tombstone extends Entity{

	private int frames = 0,
			maxFrames = 15,
			index = 0,
			maxIndex = 3;

	private BufferedImage[] sprites;
	
	public Tombstone(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		sprites = new BufferedImage[4];
		
		for(int i = 0; i < sprites.length; i++) {
			sprites[i] = Main.spritesheet.getSpritesheet(16 + (i * 16), 144, 16, 16);
		}
		
	}
	
	@Override
	public void tick() {
		
		frames++;
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index > maxIndex) {
				index = 0;
			}
		
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
	
}
