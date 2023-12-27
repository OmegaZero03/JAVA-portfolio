package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Snorlax extends Entity{

	private int frames = 0,
			maxFrames = 8,
			index = 0,
			maxIndex = 1;
	
	
	public boolean showMessage;
	
	private BufferedImage[] sprites;
	
	private int true_life = 99999;
	
	
	public int damageFrames = 5, currentFrames = 0;
	
	public Snorlax(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		this.life = true_life;
		this.maxLife = true_life;
		
		sprites = new BufferedImage[2];
		sprites[0] = Entity.CAPIVARA_ZEN;
		sprites[1] = Entity.CAPIVARA_TALK;
		
		
		//Grass_orbital o = new Grass_orbital(this.getX() - 8, this.getY(), 8, 8, Entity.GRASS_ORB);
		//Main.entities.add(o);
		
		//Ice_orbital o2 = new Ice_orbital(this.getX() + 24, this.getY(), 8, 8, Entity.ICE_ORB);
		//Main.entities.add(o2);
	}

	@Override
	public void tick() {
		if(this.life < 0) {
			Main.entities.remove(this);
		}
		
		
		if(isDamaged) {
			this.currentFrames++;
			if(this.currentFrames == this.damageFrames) {
				this.currentFrames = 0;
				isDamaged = false;
				
			}
			
		}
		
		if(this.calculateDistance(this.getX() + 8, this.getY() + 8, Main.player.getX(), Main.player.getY()) < 60) {
			
			showMessage = true;
			
		}else {
			showMessage = false;
			index = 0;
		}
		
		if(showMessage) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
		if(!isDamaged) {
			
			sprites[0] = Entity.CAPIVARA_ZEN;
			sprites[1] = Entity.CAPIVARA_TALK;
			
			g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}else {
			
			sprites[0] = Entity.CAPIVARA_ZEN_DAMAGED;
			sprites[1] = Entity.CAPIVARA_TALK_DAMAGED;
			
			g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		
		//if(life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, 20, 2);
			g.setColor(new Color(0xff804b24));
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
		//}
		
	}//g.setColor(new Color(0xffbb7547));
	
}
