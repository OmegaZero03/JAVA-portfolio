package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.World;

public class Player extends Entity{

	public boolean left, right, up, down, moved;
	public double spd = 1.4;
	
	private int frames = 0, 
				Xindex= 0, 
				Yindex = 0, 
				max_frames = 10, 
				maxYindex = 2, 
				maxXindex = 1;
	
	private int right_dir = 0, 
				left_dir = 1, 
				up_dir = 2, 
				down_dir = 3; 
	
	
	private int dir = right_dir;
	
	
	private BufferedImage[] rightPlayer, leftPlayer, upPlayer, downPlayer;
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		leftPlayer = new BufferedImage[2];
		rightPlayer = new BufferedImage[2];
		upPlayer = new BufferedImage[3];
		downPlayer = new BufferedImage[3];
		
		for(int i = 0; i < 2; i++){
			rightPlayer[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 0, 8, 8);
			leftPlayer[i] = Main.spritesheet.getSpritesheet(16 + (i * 8), 0, 8, 8);
		}
		
		for(int i = 0; i < 3; i++){
			upPlayer[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 8, 8, 8);
			downPlayer[i] = Main.spritesheet.getSpritesheet(0 + (i * 8), 16, 8, 8);
		}
		
	}
	
	@Override
	public void tick() {
		moved = false;
		if(right && World.isFree((int)(x+spd), this.getY())) {
			moved = true;
			dir = right_dir;
			x += spd;
		}else if (left && World.isFree((int)(x-spd), this.getY())) {
			moved = true;
			dir = left_dir;
			x -= spd;
		}
		
		if(up && World.isFree(this.getX(), (int)(y-spd))) {
			moved = true;
			dir = down_dir;
			y -= spd;
			
		}else if(down && World.isFree(this.getX(), (int)(y+spd))){
			moved = true;
			dir = up_dir;
			y += spd;
		}
		
		if(moved){
			frames++;
			if(frames == max_frames) {
				frames = 0;
				Yindex++;
				Xindex++;
				if(Xindex > maxXindex) {
					Xindex = 0;
				}
				if(Yindex > maxYindex) {
					Yindex = 0;
				}
			}
			
		}
		
		Camera.x = Camera.clamp(this.getX() - (Main.width / 2),0 , World.WIDTH * 8 - Main.width );
		Camera.y = Camera.clamp(this.getY() - (Main.height / 2),0 , World.HEIGHT* 8 - Main.height );
		
	}
	
	@Override
	public void render(Graphics g) {

		if(dir == right_dir){
			g.drawImage(rightPlayer[Xindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}else if(dir == left_dir) {
			g.drawImage(leftPlayer[Xindex], this.getX() - Camera.x, this.getY() - Camera.y ,null);
		}
		
		if(dir == up_dir) {
			g.drawImage(upPlayer[Yindex], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}else if(dir == down_dir) {
			g.drawImage(downPlayer[Yindex], this.getX() - Camera.x,this.getY() - Camera.y, null);
		}
		
	}
	
}
