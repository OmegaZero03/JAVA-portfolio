package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Heal extends Entity{

	public Heal(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	@Override
	public void tick() {
		for(int i = 0; i < Main.entities.size(); i++){
			Entity atual = Main.entities.get(i);
			if(atual instanceof Player){
				if(Entity.isColliding(this, atual)) {
					Main.player.life += 10;
					System.out.println("X = " + this.getX() + " " + "Y = " + this.getY());
					Main.entities.remove(this);
					System.out.println(Main.player.life);
				}
			}
		}

	}
}
