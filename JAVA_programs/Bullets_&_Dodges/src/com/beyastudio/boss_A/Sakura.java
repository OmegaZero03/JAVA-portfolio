package com.beyastudio.boss_A;

import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;

public class Sakura extends Entity{
	
	private BufferedImage spriteUp;

	public Sakura(int x, int y, int width, int height, BufferedImage sprite, BufferedImage spriteUp) {
		super(x, y, width, height, sprite);
		
		this.spriteUp = spriteUp;
		Main.sakura_trees.add(this);
	}
	
	public Sakura(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		Main.entities.add(this);
	}
	
	@Override
	public void tick() {
		
	}
	
	
	protected void setUp(int xx, int yy) {
		Main.entities.add(new Sakura(xx, yy-21, 16, 32, spriteUp)); 
	}
	

	
	
}
