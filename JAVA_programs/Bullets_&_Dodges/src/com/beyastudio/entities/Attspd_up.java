package com.beyastudio.entities;

import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.main.Sound;

public class Attspd_up extends Entity{

	public Attspd_up(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	@Override
	public void tick() {
		for(int i = 0; i < Main.entities.size(); i++){
			Entity atual = Main.entities.get(i);
			if(atual instanceof Player){
				if(Entity.isColliding(this, atual)) {
					//Sound.powerUp.play();
					Main.ui.attspd = true;
					Main.player.atackSpeed -= 0.07;
					if(Main.player.atackSpeed < 1) {
						Main.player.atackSpeed = 1;
					}
					Main.entities.remove(this);
				}
			}
		}

	}

}
