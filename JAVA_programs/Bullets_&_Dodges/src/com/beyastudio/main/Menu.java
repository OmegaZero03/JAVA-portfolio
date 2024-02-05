package com.beyastudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {

	public String[] options = {"New Adventure", "SURRENDER"};
	
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
				Main.gameState = "control";
				//
			}else if(options[currentOption] == options[1]) {
				System.exit(1);
			}
			
		}
		
	}
	
	public void render(Graphics g) {
		
		g.setFont(new Font("Noto Color Emoji", Font.BOLD, 36));
		g.setColor(Color.ORANGE);
		
		if(options[currentOption] == options[0]) {
			g.drawString("▶", 190, 524 + 15);
			g.drawString("◀", 404, 524 + 15);
			
		}else if(options[currentOption] == options[1]) {
			g.drawString("▶", 155, 602 + 15);
			g.drawString("◀", 440, 602 + 15);
		}
		
	}
}
