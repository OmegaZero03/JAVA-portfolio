package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.World;

public class Enemy extends Entity{

	private double spd;
	private int raioTrigger = 20;
	private double maxLife = 40;
	
	public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		spd = 0.8;
		this.life = 40;
	}

	
	@Override
	public void tick(){
		
		if(this.life < 0) {
			Main.entities.remove(this);
		}
		
		
		
		if(!(Main.player.getX() + raioTrigger >= (int)this.x && !(Main.player.getY() - raioTrigger >= (int)this.y ))) return;
		
		if((int)this.x < Main.player.getX() && World.isFree((int)(x+spd), this.getY())) {
			this.x += spd;
			
		}else if((int)this.x > Main.player.getX() && World.isFree((int)(x-spd), this.getY())) {
			this.x -= spd;
		}
		
		if((int)this.y < Main.player.getY() && World.isFree(this.getX(), (int)(y+spd))) {
			this.y += spd;
			
		}else if((int)this.y > Main.player.getY() && World.isFree(this.getX(), (int)(y-spd))) {
			this.y -= spd;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.red);
		g.fillRect((int)x - Camera.x, (int)y - 4 - Camera.y, 10, 2);
		g.setColor(Color.ORANGE);
		g.fillRect((int)x - Camera.x, (int)y - 4 - Camera.y, (int)((life/maxLife)*10) , 2);
		
	}
	
}
