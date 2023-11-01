package com.beaystudio.sprite;

import java.awt.Color;
import java.awt.Graphics;

import com.beyastudio.main.Main;

public class UI {

	private int x, y;
	
	public UI() {
		x = 5;
		y = 5;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 50, 7);
		g.setColor(Color.green);
		g.fillRect(x, y, (int)((Main.player.life/Main.player.maxLife)*50) , 7);

	}
}
