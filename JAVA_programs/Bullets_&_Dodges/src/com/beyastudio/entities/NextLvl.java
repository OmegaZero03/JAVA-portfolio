package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.World;

public class NextLvl extends Entity{

	private String mundo;;
	
	
	
	public NextLvl(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		this.mundo = "world.png";
	}
	
	public NextLvl(int x, int y, int width, int height, BufferedImage sprite, String mundo) {
		super(x, y, width, height, sprite);
		this.mundo = mundo;
		
	}

	
	@Override
	public void tick() {
		
		if(Entity.isColliding(this, Main.player)) {
			Main.atualWorld = "/" + mundo;
			Main.removePortais();
			World.nextLvl(mundo);
		}
		
	}
	
}
