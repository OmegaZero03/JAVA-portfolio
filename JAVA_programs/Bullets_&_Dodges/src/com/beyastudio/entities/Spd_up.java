package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;

public class Spd_up extends Entity{

	public Spd_up(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	@Override
	public void tick() {
		for(int i = 0; i < Main.entities.size(); i++){
			Entity atual = Main.entities.get(i);
			if(atual instanceof Player){
				if(Entity.isColliding(this, atual)) {
					//Sound.powerUp.play();
					Main.ui.spd = true;
					Main.player.spd += .07;
					Main.entities.remove(this);
				}
			}
		}

	}
	
}
