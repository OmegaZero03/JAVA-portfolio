package com.beyastudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {

	public String[] options = {"New Adventure", "Load Adventure", "SURRENDER"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up, down, enter;
	
	public void tick() {
		
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0) currentOption = maxOption;
		}
		if(down) {
			down = false;
			this.currentOption++;
			if(this.currentOption > maxOption) currentOption = 0;
			
		}
		
		if(enter) {
			enter = false;
			if(options[currentOption] == options[0]) {
				Main.gameState = "normal";
			}else if(options[currentOption] == options[1]) {
				//
			}else if(options[currentOption] == options[2]) {
				System.exit(1);
			}
			
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(180,32,42));
		g.fillRect(0, 0, Main.muxW, Main.muxH);
		
		g.setFont(new Font("arial", Font.ITALIC, 18));
		g.setColor(Color.ORANGE);
		g.drawString("Bullets & Dodges", Main.WIDTH / 2 + 8, Main.HEIGHT + 25);
		
		g.setFont(new Font("arial", Font.BOLD, 14));
		g.setColor(new Color(255,170,255));
		
		for(int i = 0; i < this.maxOption; i++) {
			g.drawString(options[i], Main.WIDTH / 2 + 30, Main.HEIGHT + (80 + (i * 20)));
		}
		g.setFont(new Font("arial", Font.BOLD, 12));
		g.setColor(new Color(170,0,255));
		g.drawString(options[2],  Main.WIDTH / 2 + 50, Main.HEIGHT + 120);
		
		g.setColor(Color.ORANGE);
		if(options[currentOption] == options[0]) {
			g.drawString(">", Main.WIDTH / 2 + 23, Main.HEIGHT + 80);
			g.drawString("<", Main.WIDTH / 2 + 139, Main.HEIGHT + 80);
			
		}else if(options[currentOption] == options[1]) {
			g.drawString(">", Main.WIDTH / 2 + 23, Main.HEIGHT + 100);
			g.drawString("<", Main.WIDTH / 2 + 143, Main.HEIGHT + 100);
			
		}else if(options[currentOption] == options[2]) {
			g.drawString(">", Main.WIDTH / 2 + 42, Main.HEIGHT + 120);
			g.drawString("<", Main.WIDTH / 2 + 122, Main.HEIGHT + 120);
		}
		
	}
}
