package com.beyastudio.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;
import com.beyastudio.wolrd.World;

public class Player extends Entity{

	public boolean left, right, up, down, moved;
	public double spd = 1.4;
	
	public double life, maxLife = 100;

	
	private int atackSpeed = 2;

	
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
	
	
	
	public double mx, my, nextShoot = 0;
	
	public double dx, dy;
	
	private int dir = right_dir;
	
	public boolean shoot = false;
	public static boolean autoShoot = false;
	
	
	private BufferedImage[] rightPlayer, leftPlayer, upPlayer, downPlayer;
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		leftPlayer = new BufferedImage[2];
		rightPlayer = new BufferedImage[2];
		upPlayer = new BufferedImage[3];
		downPlayer = new BufferedImage[3];
		
		life = 100;
		
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
		
		
		this.collidingEnemy();
		this.death();
		
		Camera.x = Camera.clamp(this.getX() - (Main.width / 2),0 , World.WIDTH * 8 - Main.width );
		Camera.y = Camera.clamp(this.getY() - (Main.height / 2),0 , World.HEIGHT* 8 - Main.height );
		

		
		if(System.currentTimeMillis()< nextShoot) {
			return;
		}
		
		nextShoot = System.currentTimeMillis() + (atackSpeed * 100);
		
		
		
		double angle = Math.atan2(my - (this.getY() - Camera.y + 5) , mx - (this.getX() - Camera.x + 5));
		
		dx = Math.cos(angle);
		dy = Math.sin(angle);
		
		if(shoot || autoShoot) {
			
			if(dir == right_dir){
				
				Bullet b = new Bullet(this.getX()+ 3, this.getY() - 4, 8, 8, Entity.BULLET_PL, dx, dy);
				Main.bullets.add(b);
				
			}else if(dir == left_dir) {
				Bullet b = new Bullet(this.getX() - 3, this.getY() - 4, 8, 8, Entity.BULLET_PL, dx, dy);
				Main.bullets.add(b);
			}
			
			if(dir == down_dir) {
				Bullet b = new Bullet(this.getX() - 3, this.getY() - 4, 8, 8, Entity.BULLET_PL, dx, dy);
				Main.bullets.add(b);
			}else if(dir == up_dir) {
				Bullet b = new Bullet(this.getX() + 3, this.getY() - 4, 8, 8, Entity.BULLET_PL, dx, dy);
				Main.bullets.add(b);
			}
			
		}
		
	
		
	}
	
	
	public void death() {
		if(this.life > 0) {
			return;
		}
		System.exit(1);
	}
	
	public void collidingEnemy() {
		for(int i = 0; i < Main.entities.size(); i++) {
			Entity atual = Main.entities.get(i);
			
			if(atual instanceof Enemy){
				if(Entity.isColliding(this, atual)){
					
					if(Main.ran.nextInt(100) >= 30) {
						System.out.println("Falhou");
						return;
					}
					life--;
					System.out.println(life);
				}
			}
		}
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