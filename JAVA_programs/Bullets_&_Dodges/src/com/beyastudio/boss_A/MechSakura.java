package com.beyastudio.boss_A;

import java.awt.image.BufferedImage;


public class MechSakura extends Sakura{

	public MechSakura(int x, int y, int width, int height, BufferedImage sprite, BufferedImage spriteUp) {
		super(x, y, width, height, sprite, spriteUp);
		
		life = 200;
	
	}
	
	
	@Override
	public void tick() {
		
	}
}
