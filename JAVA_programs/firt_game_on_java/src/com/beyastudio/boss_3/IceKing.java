package com.beyastudio.boss_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.entities.Entity;
import com.beyastudio.wolrd.Camera;

public class IceKing extends Entity{

	public IceKing(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.life = 200;
		this.maxLife = 200;
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		if (life != maxLife) {
			g.setColor(Color.red);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, 10, 2);
			g.setColor(Color.ORANGE);
			g.fillRect((int) x - Camera.x + 3, (int) y - 4 - Camera.y, (int) ((life / maxLife) * 10), 2);
		}

	}
	
}
