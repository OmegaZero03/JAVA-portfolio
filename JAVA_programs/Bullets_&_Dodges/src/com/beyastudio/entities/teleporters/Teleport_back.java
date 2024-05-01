package com.beyastudio.entities.teleporters;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Teleport_back extends Teleporter{
	
	public static int xBack = 488;
	public static int yBack = 496;

	public Teleport_back(int x, int y, int width, int height, BufferedImage sprite, int xTeleport, int yTeleport) {
		super(x, y, width, height, sprite, xTeleport, yTeleport);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick() {
		
		isCollinding();
	}

}
