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
	
	private boolean canCreat = true;

	public IceKing(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.life = 550;
		this.maxLife = 550;
	}
	
	@Override 
	public void tick() {
		if (life <= 0) {
			Main.isBossI = false;
		}
		
		stateMachine();

		
	}
	
	
	public void stateMachine() {
		
		switch(estado){
			case "parado":
				spd = 1;
				if(life!=maxLife) {
					this.estado = "fase_1"; 
				}
				break;
				
			case "fase_1":
				 if(canCreat) {
					 System.out.println("entrei");
					 for(int i = 0; i < 3; i++) {
						 Penguin p = new Penguin(this.getX() - 8 * (3 * (i+1)), this.getY(), 8, 8, Entity.PENGUIN_EN_REV);
						 Main.entities.add(p);
					 }
					 
					 canCreat = false;
				 }
				
				break;	
		}
		
	}
	
	
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, 10, 2);
			g.setColor(Color.GREEN);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 10), 2);
		}

	}
	
}
