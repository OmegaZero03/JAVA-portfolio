package com.beyastudio.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class Puppy extends Entity{

	public boolean showMessage = true;
	
	public int curIndexMsg = 0;

	public int fraseIndex = 0;
	
	public int time = 0, maxTime = 6, timeWaitChange = 0, maxTimeWait = 7;
	
	private int frames = 0,
			maxFrames = 8,
			index = 0,
			maxIndex = 3;

	//Quantidade de frases
	public int n_frases = 45;
	/********************/
		
	public int n = (n_frases) + 1;
	public String[] frases = new String[n];
	
	private BufferedImage[] sprites;
	
	public Puppy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		dialogue();
		
		sprites = new BufferedImage[4];
		sprites[0] = Entity.PUPPY_TALK_0;
		sprites[1] = Entity.PUPPY_TALK_1;
		sprites[2] = Entity.PUPPY_TALK_2;
		sprites[3] = Entity.PUPPY_TALK_3;
	}

	
	@Override
	public void tick() {
		
		
		if(this.calculateDistance(this.getX() + 8, this.getY() + 8, Main.player.getX(), Main.player.getY()) < 30) {
			
			showMessage = true;
			
		}else {
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
		
		g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		
		if(showMessage) {
			g.setColor(Color.white);
			g.setFont(new Font("Lucida", Font.PLAIN, 10));
			g.drawString(frases[fraseIndex].substring(0, curIndexMsg), ((int)x - Camera.x) - 40, ((int)y - Camera.y) - 16);
		}
		if(geralDebug) {
			g.setColor(Color.RED);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
	
	}
	
	
	
	public void dialogue() {
		for(int i = 0; i < frases.length; i++) {
			String txt = null;

			switch(i) {
			
			/*Invisible caracter -> (ㅤ)*/
			/*   IDEAL SIZE    */
			//"123456789112345"
			//  15 characters.
			
			case 0:
				txt = "Hi, stay close to me.";
				break;
			case 1:
				txt = "Nice to meet ya!";
				break;
			case 2:
				txt = "That place only has";
				break;
			case 3:
				txt = "ㅤStrong enemys";
				break;
			case 4:
				txt = "So never stay still";
				break;
			case 5:
				txt = "ㅤKeep on moving";
				break;
			case 6:
				txt = "Take left, from here";
				break;
			case 7:
				txt = "Lays the strongest one";
				break;
			case 8:
				txt = "The Grass monster";
				break;
			case 9:
				txt = "ㅤGetting down";
				break;
			case 10:
				txt = "Leads to a split.";
				break;
			case 11:
				txt = "Left from there, lays";
				break;
			case 12: 
				txt = "The Fire monster";
				break;
			case 13:
				txt = "Taking down again";
				break;
			case 14:
				txt = "Ya will face the easiest";
				break;
			case 15:
				txt = "The Ice monster";
				break;
			case 16:
				txt = "Here are some tips";
				break;
			case 17:
				txt = "Every boss has 4 fases";
				break;
			case 18:
				txt = "I would start from the Ice";
				break;
			case 19:
				txt = "ㅤㅤif i was ya";
				break;
			case 20:
				txt = "Just don't stop moving";
				break;
			case 21:
				txt = "stay out of his carpet";
				break;
			case 22:
				txt = "And ya should defeat him";
				break;
			case 23:
				txt = "ㅤSuper easy";
				break;
			case 24:
				txt = "Fire one is kinda hard";
				break;
			case 25:
				txt = "But there is a lot of";
				break;
			case 26:
				txt = "ㅤㅤSave spots";
				break;
			case 27:
				txt = "Where ya don't even";
				break;
			case 28:
				txt = "ㅤNeed to move";
				break;
			case 29:
				txt = "Found this spots";
				break;
			case 30:
				txt = "And claim the fire orb";
				break;
			case 31:
				txt = "The Grass one is tough!";
				break;
			case 32:
				txt = "I recommed leave for last";
				break;
			case 33:
				txt = "Each boss drops 1 ORB";
				break;
			case 34:
				txt = "The ORB is guaranteed";
				break;
			case 35:
				txt = "But they can also drop";
				break;
			case 36:
				txt = "ㅤTheir SOULS";
				break;
			case 37:
				txt = "ㅤIf your lucky";
				break;
			case 38:
				txt = "or if you defeat then with";
				break;
			case 39:
				txt = "big chunks of your life";
				break;
			case 40:
				txt = "Souls drops Power ups";
				break;
			case 41:
				txt = "And strong ARTIFACTS";
				break;
			case 42:
				txt = "Try getting all of them";
				break;
			case 43:
				txt = "One more thing";
				break;
			case 44:
				txt = "Don't let him controls ya!";
				break;
			case 45:
				txt = "xaxaxaxaxa...";
				break;
			}
			
			
			frases[i] = txt;
			
		}
	}

}


