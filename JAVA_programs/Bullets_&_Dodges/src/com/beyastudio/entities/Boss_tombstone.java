package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Finn;
import com.beyastudio.boss_2.FireP;
import com.beyastudio.boss_3.IceKing;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Boss_tombstone extends Entity{
	
	private int tempo = 100;
	
	private boolean charging;
	private String type;
	private int count;
	
	public Boss_tombstone(int x, int y, int width, int height, BufferedImage sprite, String type) {
		super(x, y, width, height, sprite);
		this.type = type;
	}
	
	
	
	@Override 
	public void tick() {
		
		if(this.calculateDistance(this.getX() + 8, this.getY() + 8, Main.player.getX(), Main.player.getY()) < 10) {
			
			charging = true;
			count++;
			System.out.println(count);
		}else {
			charging = false;
			count = 0;
		}
		
		if(charging) {
			if(count > tempo) {
				
				switch(type) {
				
				case "grass":
					Main.isBoss = true;
					Main.boss_1 = new Finn(228 , 140, 16, 16, Entity.FINN_EN);
					break;
					
				case "ice":
					Main.isBossI = true;
					Main.boss_3 = new IceKing(826, 752, 16, 16, Entity.ICE_EN);
					break;
					
					
				case "fire":
					Main.isBossF = true;
					Main.boss_2 = new FireP(144, 680, 16, 16, Entity.FIRE_EN);
					break;
				}

				
				
				Main.tombs.remove(this);
			}
		}
		
	}
	
	//@Override
	//public void render(Graphics g) {
		
//		if(!isDamaged) {
//			if(capa) {
//				sprites[0] = Main.spritesheet.getSpritesheet(0, 160, 16, 16);
//				sprites[1] = Main.spritesheet.getSpritesheet(24, 160, 24, 16);
//			}
//			else {
//				sprites[0] = Main.spritesheet.getSpritesheet(0, 176, 16, 16);
//				sprites[1] = Main.spritesheet.getSpritesheet(24, 176, 24, 16);
//			}
//			
//			if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
//			if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x - 8, this.getY() - Camera.y, null);
//		}else {
//			if(capa) {
//				sprites[0] = Entity.FINN_DAMAGED_CAP;
//				sprites[1] = Entity.FINN_DAMAGED_CAP_ATT;
//			}
//			else{
//				sprites[0] = Entity.FINN_DAMAGED_NOT_CAP;
//				sprites[1] = Entity.FINN_DAMAGED_NOT_CAP_ATT;
//			}
//			
//			if(index == 0) g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
//			if(index == 1) g.drawImage(sprites[index], this.getX() - Camera.x - 8, this.getY() - Camera.y, null);
//		}
//		
//		
//		if (life != maxLife) {
//			g.setColor(Color.red);
//			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, 20, 2);
//			g.setColor(Color.ORANGE);
//			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
//		}
//
//	}
		
	//}

}
