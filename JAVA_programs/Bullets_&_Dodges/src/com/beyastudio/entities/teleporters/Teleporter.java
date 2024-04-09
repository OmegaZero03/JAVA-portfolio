package com.beyastudio.entities.teleporters;

import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;


public class Teleporter extends Entity{
	
	private int yTeleportLocation, xTeleportLocation;
	

	public Teleporter(int x, int y, int width, int height, BufferedImage sprite, int xTeleport, int yTeleport) {
		super(x, y, width, height, sprite);
		
		this.xTeleportLocation = xTeleport;
		this.yTeleportLocation = yTeleport;
		
	}
	
	@Override
	public void tick() {
		isCollinding();
		
	}
	
	public void isCollinding() {
		if (isColliding(this, Main.player)) {
			Main.player.setX(xTeleportLocation);
			Main.player.setY(yTeleportLocation);
		}
	}

}
