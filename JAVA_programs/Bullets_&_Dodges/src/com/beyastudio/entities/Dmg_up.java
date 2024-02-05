package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;

public class Dmg_up extends Entity{

	public Dmg_up(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	@Override
	public void tick() {
		for(int i = 0; i < Main.entities.size(); i++){
			Entity atual = Main.entities.get(i);
			if(atual instanceof Player){
				if(Entity.isColliding(this, atual)) {
					Main.ui.dmg = true;
					Main.player.dmg += 1;
					Main.entities.remove(this);
				}
			}
		}

	}

}
