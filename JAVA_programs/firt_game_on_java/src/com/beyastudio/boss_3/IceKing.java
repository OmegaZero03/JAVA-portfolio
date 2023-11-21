package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class IceKing extends Entity{
	
	private String estado = "parado";
	
	private double spd = 0;

	public IceKing(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.life = 20;
		this.maxLife = 20;
	}
	
	@Override 
	public void tick() {
		if (life <= 0) {
			Main.isBossI = false;
		}
		

		
	}
	
	
	public void stateMachine() {
		
		switch(estado){
			case "parado":
				spd = 0;
				if(life!=maxLife) {
					this.estado = "fase_1"; 
				}
				break;
				
			case "fase_1":
				
				
				
				break;
				

				
		}
		
	}
	
	
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, 10, 2);
			g.setColor(Color.ORANGE);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 10), 2);
		}

	}
	
}
