package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;
import com.beyastudio.wolrd.Camera;

public class Snorlax extends Entity{

	private int frames = 0,
			maxFrames = 8,
			index = 0,
			maxIndex = 1;
	

	//Quantidade de frases
	public int n_frases = 16;
	/********************/
		
	public int n = (n_frases) + 1;
	public String[] frases = new String[n];
	
	
	public boolean showMessage;
	
	private BufferedImage[] sprites;
	
	private int true_life = 99999;
	
	public int curIndexMsg = 0;

	public int fraseIndex = 0;
	
	public int time = 0, maxTime = 6, timeWaitChange = 0, maxTimeWait = 7;
	
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
		
		dialogue();
	}

	@Override
	public void tick() {
		if(this.life < 0) {
			Sound.bossDied.play();
			Main.entities.remove(this);
		}
		
		if(isDamaged) {
			this.currentFrames++;
			if(this.currentFrames == this.damageFrames) {
				this.currentFrames = 0;
				isDamaged = false;
				
			}
			
		}
		
		if(this.fraseIndex == n_frases && index == 0)	return;
		
		if(this.calculateDistance(this.getX() + 8, this.getY() + 8, Main.player.getX(), Main.player.getY()) < 40) {
			
			showMessage = true;
			
		}else {
			index = 0;
			showMessage = false;
			curIndexMsg = 0;
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
			
			time++;
			if(this.time >= this.maxTime) {
				time = 0;
			
				if(curIndexMsg < frases[fraseIndex].length()) {
					curIndexMsg++;
				}else {
					if(fraseIndex < frases.length - 1) {
						
						timeWaitChange++;
						
						if(timeWaitChange >= maxTimeWait) {
						timeWaitChange = 0;
						
						fraseIndex++;
						curIndexMsg = 0;
						
						}
						
					}
					
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
		
		
		if(showMessage) {
			g.setColor(new Color(0xff261911));
			g.setFont(new Font("Lucida", Font.PLAIN, 10));
			g.drawString(frases[fraseIndex].substring(0, curIndexMsg), ((int)x - Camera.x) - 40, ((int)y - Camera.y) - 16);
		}
		
		//if(life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, 20, 2);
			g.setColor(new Color(0xff804b24));
			g.fillRect((int) x - Camera.x - 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 20), 2);
		//}
		
	}//g.setColor(new Color(0xffbb7547));
	
	public void dialogue() {
		for(int i = 0; i < frases.length; i++) {
			String txt = null;

			switch(i) {
			
			/*Invisible caracter -> (ㅤ)*/
			/*   IDEAL SIZE    */
			//"123456789112345"
			//  15 characters.
			
			case 0:
				txt = "ㅤㅤㅤHIT ME!";
				break;
			case 1:
				txt = "Sorry, suup Beauty";
				break;
			case 2:
				txt = "Gimme that good old...";
				break;
			case 3:
				txt = "ㅤㅤㅤㅤHIT!!!";
				break;
			case 4:
				txt = "I... Love being hurt.";
				break;
			case 5:
				txt = "Wait... that sword...";
				break;
			case 6:
				txt = "OㅤㅤㅤMㅤㅤㅤG";
				break;
			case 7:
				txt = "Now it's WIN WIN";
				break;
			case 8:
				txt = "If you HIT me";
				break;
			case 9:
				txt = "ㅤYou heal yourself";
				break;
			case 10:
				txt = "And i would LOVE IT";
				break;
			case 11:
				txt = "ㅤDon't worry";
				break;
			case 12:
				txt = "My skin is very HEAVY";
				break;
			case 13:
				txt = "It's IMPOSSIBLE";
				break;
			case 14:
				txt = "ㅤㅤTo kill me.";
				break;
			case 15:
				txt = "fefefefefefe...";
				break;
			case 16:
				txt = "ㅤHIT PLEASE!";
				break;
			
			}
			
			
			frases[i] = txt;
			
		}
	}
	
}
