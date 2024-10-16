package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;

public class Crown extends Entity{
	
	private int direction;
	private BufferedImage[] sprites;
	private BufferedImage[] nsprites;
	
	private int frames = 0,
			maxFrames = 10,
			index = 0,
			maxIndex = 5;
	
	public Crown(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		
		sprites = new BufferedImage[4];
		
		sprites[0] = Entity.CROWN_DIR;
		sprites[1] = Entity.CROWN_ESQ;
		sprites[2] = Entity.CROWN_BAI;
		sprites[3] = Entity.CROWN_CIM;
		
		
		nsprites = new BufferedImage[6];
		
		for(int i = 0; i < 6; i++) {
			nsprites[i] = Main.spritesheet.getSpritesheet(144 + (i * 8), 24, 8, 8);
		}
		
	}
	
	@Override
	public void tick() {
		
		if(Main.player.haveCrown) {
			direction = Main.player.getDir();
			x = Main.player.getX();
			y = Main.player.getY() - 2;
			
			
			
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
				Main.ui.crown = true;
				Main.player.haveCrown = true;
			}
			
		}
		
		
		
	}
	
	@Override
	public void render(Graphics g) {
		
		
		if(Main.player.haveCrown) {
			switch(direction) {
			
				case 0:
				//direita
				
				g.drawImage(sprites[0], this.getX() - Camera.x, this.getY() - Camera.y, null);
				break;
				
				case 1:
				g.drawImage(sprites[1], this.getX() - Camera.x, this.getY() - Camera.y, null);
				//esquerda
				
				break;
				
				case 2:
				g.drawImage(sprites[2], this.getX() - Camera.x, this.getY() - Camera.y, null);
				//cima
				
				break;
				
				case 3:
				g.drawImage(sprites[3], this.getX() - Camera.x, this.getY() - Camera.y, null);
				//baixo
				break;
				
			}
			
		}else {
			g.drawImage(nsprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			
		}
		
	}
	
}
