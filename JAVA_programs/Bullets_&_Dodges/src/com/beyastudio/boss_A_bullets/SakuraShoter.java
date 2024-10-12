package com.beyastudio.boss_A_bullets;

import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class SakuraShoter extends Entity{

	public SakuraShoter(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		Main.entities.add(this);
	}
	
	@Override
	public void tick() {
		
		
		
	}
	
	public void shoot() {
		
	}

}
