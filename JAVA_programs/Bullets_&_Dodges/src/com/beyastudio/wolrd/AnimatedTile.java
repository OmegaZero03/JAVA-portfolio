package com.beyastudio.wolrd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.sql.Time;

import com.beyastudio.main.Main;

public class AnimatedTile extends FloorTile{
	
	private int frames = 0,
			maxFrames = 38,
			frameIndex = 0,
			maxIndex = 1;
	
	private BufferedImage[] aguaAnimationSprites;

	public AnimatedTile(int x, int y, BufferedImage sprite, BufferedImage animationImage1, BufferedImage animationImage2) {
		super(x, y, sprite);
		
		
		Main.animatedTiles.add(this);
		
		this.aguaAnimationSprites = new BufferedImage[2];
		aguaAnimationSprites[0] = animationImage1;
		aguaAnimationSprites[1] = animationImage2;
		

		
		
		
	}
	
	public void tick() {
		
		frames++;
		if(frames == maxFrames) {
			frames = 0;
			frameIndex++;
			if(frameIndex > maxIndex) {
				frameIndex = 0;
			}
		}
		
	}
	
	
	@Override
	public void render(Graphics g) {
		
		for(int i=0; i < 2; i++) {
			g.drawImage(aguaAnimationSprites[frameIndex], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}

	}
	
}
