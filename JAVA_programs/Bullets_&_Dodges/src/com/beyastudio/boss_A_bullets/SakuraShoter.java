package com.beyastudio.boss_A_bullets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.beyastudio.entities.Entity;
import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class SakuraShoter extends Entity{
	
	private int MAX_BULLETS = 10;
	private long miliSeconds = 1100;
	private List<Bullet_sakura> bullets;
	
	
	
	public SakuraShoter(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		Main.entities.add(this);
		this.bullets = new ArrayList<Bullet_sakura>();
	}

	
	@Override
	public void tick() {


		shoot();
		
		//System.out.println(bullets.size()); // n consegue saber quando elas somem

		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		
		if(geralDebug) {
			g.setColor(Color.GREEN);
			g.fillRect((this.getX() + maskx) - Camera.x, (this.getY() + masky) - Camera.y, mwidth, mheight);
		}
	}
	
    private boolean swap = true;
	private long lastShotTime = 0; // Armazena o tempo do último tiro
    public void shoot() {
        long currentTime = System.currentTimeMillis(); // Tempo atual em milissegundos

        
        if (bullets.size() < MAX_BULLETS) {
	        if (currentTime - lastShotTime >= miliSeconds) {
	        	
	        	if(swap) {
	        		bullets.add(new Bullet_sakura(this.getX(), this.getY(), 16, 16, Entity.BULLET_PINK_PETAL, x-4, y-12, bullets));
	        	}
	        	else {
	        		bullets.add(new Bullet_sakura(this.getX(), this.getY(), 16, 16, Entity.BULLET_PINK_LEAF, x-4, y-12, bullets));
	        	}
	        	swap = !swap;
	            lastShotTime = currentTime;
	
	        }
        }
    }
	

}
