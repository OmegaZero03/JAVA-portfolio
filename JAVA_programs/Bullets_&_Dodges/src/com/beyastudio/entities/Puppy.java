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
	public int n_frases = 43;
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
			
			
			/*   IDEIAL SIZE    */
			//"123456789112345"
			//  15 characters.
			
			case 0:
				txt = "    SUP duuude!";
				break;
			case 1:
				txt = "ya are new here, right?";
				break;
			case 2:
				txt = "there are 4 paths";
				break;
			case 3:
				txt = "taking down ya will see";
				break;
			case 4:
				txt = "A COLD MONSTER";
				break;
			case 5:
				txt = "all the MONSTROSITIES";
				break;
			case 6:
				txt = "he makes........";
				break;
			case 7:
				txt = "ya can't even IMAGINE";
				break;
			case 8:
				txt = "just follow the treasures";
				break;
			case 9:
				txt = "He left everything...";
				break;
			case 10:
				txt = "on that place...";
				break;
			case 11:
				txt = " Oh........";
				break;
			case 12: 
				txt = " got it...";
				break;
				
			case 13:
				txt = "the girl am i right?";
				break;
			case 14:
				txt = "she's on the left...";
				break;
				
			case 15:
				txt = "but I wouldn't bother her ";
				break;
				
			case 16:
				txt = "this early on...";
				break;
				
			case 17:
				txt = "not with out and ORB";
				break;
				
			case 18:
				txt = "following the MONSTER";
				break;
				
			case 19:
				txt = "leads to a split.";
				break;
			case 20:
				txt = "get down again...";
				break;
			case 21:
				txt = "and face the MONSTER";
				break;
			case 22:
				txt = "  Get left...";
				break;
			case 23:
				txt = "and face the.........";
				break;
			case 24:
				txt = "what was that thing again?";
				break;
			case 25:
				txt = "IDK, but whatever....";
				break;
			case 26:
				txt = "There are three of them!";
				break;
			case 27:
				txt = "Gonna stop my monolo...";
				break;
			case 28:
				txt = "    Wait.....";
				break;
			case 29:
				txt = "  that sword......";
				break;
			case 30:
				txt = "where did you found it?";
				break;
			case 31:
				txt = "i guess is apropriate...";
				break;
			case 32:
				txt = "with that magesty sword";
				break;
			case 33:
				txt = "you can be able to";
				break;
			case 34:
				txt = "Slam then all";
				break;
			case 35:
				txt = "and take their artifacts!";
				break;
			case 36:
				txt = "yourself can be";
				break;
			case 37:
				txt = " UNSTOPPABLE";
				break;
			case 38:
				txt = "or can you???...";
				break;
			case 39:
				txt = "xaxaxaxaxaxaxa....";
				break;
			case 40:
				txt = ".......................";
				break;
			case 41:
				txt = "ya don't speak that much";
				break;
			case 42:
				txt = "  ....don't ya?";
				break;
				
			case 43:
				txt = "xaxaxaxaxaxaxa....";
				break;
			}
			
			
			frases[i] = txt;
			
		}
	}

}


