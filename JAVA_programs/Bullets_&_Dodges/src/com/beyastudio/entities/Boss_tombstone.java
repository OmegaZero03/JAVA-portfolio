package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.boss_1.Finn;
import com.beyastudio.boss_2.FireP;
import com.beyastudio.boss_3.IceKing;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Boss_tombstone extends Entity{
	
	private int tempo = 100;
	
	private boolean stop = false;
	
	private int frames = 0,
			maxFrames = 10,
			index = 0,
			maxIndex = 3;
	
	private int cframes = 0,
			cmaxFrames = 31,
			cindex = 0,
			cmaxIndex = 3;
	
	private boolean charging;
	private String type;
	private int count;
	private BufferedImage[] sprites;
	private BufferedImage[] cursedSprites;
	private int chance = Main.ran.nextInt(100);
	
	public Boss_tombstone(int x, int y, int width, int height, BufferedImage sprite, String type) {
		super(x, y, width, height, null);
		
		this.type = type;
		
		sprites = new BufferedImage[4];
		cursedSprites = new BufferedImage[4];
		
		switch(this.type) {
		
		case"grass":
			
			System.out.println( "se tirou = "+ chance);
			
			if(Main.player.life >= 70 || chance >= 60) {
				Soul sg = new Soul(this.getX(), this.getY() - 10, 16, 16, null, "grass");
				Main.entities.add(sg);
			}
			
			sprites[0] = Entity.TOMB_GRASS_0;
			sprites[1] = Entity.TOMB_GRASS_1;
			sprites[2] = Entity.TOMB_GRASS_2;
			sprites[3] = Entity.TOMB_GRASS_3;
			
			cursedSprites[0] = Entity.CURSED_TOMB_GRASS_0;
			cursedSprites[1] = Entity.CURSED_TOMB_GRASS_1;
			cursedSprites[2] = Entity.CURSED_TOMB_GRASS_2;
			cursedSprites[3] = Entity.CURSED_TOMB_GRASS_3;
			break;
			
			
		case "ice":
			if(Main.player.life >= 70 || chance >= 60) {
				Soul sg = new Soul(this.getX() + 40, this.getY(), 16, 16, null, "ice");
				Main.entities.add(sg);
			}
			
			sprites[0] = Entity.TOMB_ICE_0;
			sprites[1] = Entity.TOMB_ICE_1;
			sprites[2] = Entity.TOMB_ICE_2;
			sprites[3] = Entity.TOMB_ICE_3;
			
			cursedSprites[0] = Entity.CURSED_TOMB_ICE_0;
			cursedSprites[1] = Entity.CURSED_TOMB_ICE_1;
			cursedSprites[2] = Entity.CURSED_TOMB_ICE_2;
			cursedSprites[3] = Entity.CURSED_TOMB_ICE_3;
			break;
			
			
		case "fire":
			if(Main.player.life >= 70 || chance >= 60) {
				Soul sg = new Soul(this.getX(), this.getY() - 10, 16, 16, null, "fire");
				Main.entities.add(sg);
			}
			
			sprites[0] = Entity.TOMB_FIRE_0;
			sprites[1] = Entity.TOMB_FIRE_1;
			sprites[2] = Entity.TOMB_FIRE_2;
			sprites[3] = Entity.TOMB_FIRE_3;
			
			cursedSprites[0] = Entity.CURSED_TOMB_FIRE_0;
			cursedSprites[1] = Entity.CURSED_TOMB_FIRE_1;
			cursedSprites[2] = Entity.CURSED_TOMB_FIRE_2;
			cursedSprites[3] = Entity.CURSED_TOMB_FIRE_3;
			break;
		}
		
	}
	
	
	
	@Override 
	public void tick() {
		
		
		if(this.calculateDistance(this.getX() + 8, this.getY() + 8, Main.player.getX(), Main.player.getY()) < 17) {
			
			charging = true;
			count++;
			System.out.println(count);
			
			
		}else {
			cindex = 0;
			charging = false;
			count = 0;
		}
		
		
		
		
		if(charging) {
			cframes++;
			if(cframes == cmaxFrames) {
				cframes = 0;
				cindex++;
				if(cindex > cmaxIndex) {
						cindex = 0;
				}
				
			}
		}else {
		frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
						index = 0;
				}
				
			}
		}
		
		if(charging) {
			if(count > tempo) {
				
				switch(type) {
				
				case "grass":
					stop = true;
					Main.isBoss = true;
					Main.boss_1 = new Finn(228 , 140, 16, 16, Entity.FINN_EN);
					break;
					
				case "ice":
					stop = true;
					Main.isBossI = true;
					Main.boss_3 = new IceKing(826, 752, 16, 16, Entity.ICE_EN);
					break;
					
					
				case "fire":
					stop = true;
					Main.isBossF = true;
					Main.boss_2 = new FireP(144, 680, 16, 16, Entity.FIRE_EN);
					break;
				}

				
				
				Main.tombs.remove(this);
			}
		}

		
	}
	
	@Override
	public void render(Graphics g) {
		
		if(charging) {
			g.drawImage(cursedSprites[cindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		else {
			g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		
		if(stop == false) {
			if(charging){
			// Mostrar contador pro player
				g.setColor(new Color(0xff060608));
				g.setFont(new Font("Lucida", Font.PLAIN, 9));
				g.drawString("" + count + "/100", ((int)x - Camera.x) - 6, ((int)y - Camera.y));
			}
		}
	}
		

}
