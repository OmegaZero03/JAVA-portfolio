package com.beaystudio.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class UI {

	private int x, y;
	
	public UI() {
		x = (Main.width / 2) - Camera.x - 20;
		y = 150;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 50, 7);
		g.setColor(new Color(255, 0 ,255));
		g.fillRect(x, y, (int)((Main.player.life/Main.player.maxLife)*50) , 7);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 8));
		g.drawString("HP", x, y + 7);
		
		g.setFont(new Font("arial",Font.PLAIN, 8));
		String s = String.valueOf((int)Main.player.life);
		g.drawString(s + "/" + "100", x + 20, y + 7);
		
		

	}
}
