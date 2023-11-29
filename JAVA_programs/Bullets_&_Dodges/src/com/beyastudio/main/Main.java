package com.beyastudio.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.beaystudio.sprite.Spritesheet;
import com.beaystudio.sprite.UI;
import com.beyastudio.boss_1.Bullet;
import com.beyastudio.boss_1.Finn;
import com.beyastudio.boss_2.FireP;
import com.beyastudio.boss_3.IceKing;
import com.beyastudio.entities.Enemy;
import com.beyastudio.entities.Entity;
import com.beyastudio.entities.Player;
import com.beyastudio.entities.PlayerBullet;
import com.beyastudio.wolrd.ShootTile;
import com.beyastudio.wolrd.ShootTileSlow;
import com.beyastudio.wolrd.WallTile;
import com.beyastudio.wolrd.World;

public class Main extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	
	private static final long serialVersionUID = 1L;
	private Thread th;
	private boolean isRunning = true;
	public static final int width = 240;
	public static final int height = 200;
	public static final int escala = 4,
							muxW = width * escala,
							muxH = height * escala;
	
	private BufferedImage image;
	public static List<WallTile> walls;
	public static List<ShootTile> shootWalls;
	public static List<ShootTileSlow> shootWallsSlow;
	public static List<Entity> entities;
	public static List<PlayerBullet> playerBullets;
	public static List<Bullet> BossBullets;
	public static Spritesheet spritesheet;
	
	public static boolean isBoss = false, isBossF = false, isBossI = false;
	
	public static Finn boss_1;
	public static FireP boss_2;
	public static IceKing boss_3;
	public static World world;
	public static Player player;
	public static Enemy enemy;
	public static UI ui;
	public static Random ran;
	
	public Main() {
		
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addMouseListener(this);
		setPreferredSize(new Dimension(muxW, muxH));
		initFrame();
		
		// Init Objects
		ran = new Random();
		ui = new UI();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		entities = new ArrayList<Entity>();
		walls = new ArrayList<WallTile>();
		playerBullets = new ArrayList<PlayerBullet>();
		BossBullets = new ArrayList<Bullet>();
		shootWalls = new ArrayList<ShootTile>();
		shootWallsSlow = new ArrayList<ShootTileSlow>();
		spritesheet = new Spritesheet("/spritesheet.png");
		player = new Player(0, 0, 8, 8, spritesheet.getSpritesheet(0, 0, 8, 8));
		entities.add(player);
		world = new World("/world2.png");
		this.setFocusable(true);
		this.requestFocus();
		
		//Init boss_1 Object
		
		
		//In the world 2
		if(World.WIDTH == 60 && World.HEIGHT == 60) {
			boss_1 = new Finn(220, 140, 16, 16, Entity.FINN_EN);
			boss_2 = new FireP(80, 368, 16, 16, Entity.FIRE_EN);
			boss_3 = new IceKing(364, 344, 16, 16, Entity.ICE_EN);
			isBoss = true;
			isBossF = true;
			isBossI = true;
		}
		
		
		
	}
	
	public void initFrame() {
		JFrame frame = new JFrame("Bullest & Dodges");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public synchronized void start() {
		th = new Thread(this);
		this.isRunning = true;
		th.start();
		
	}
	
	public synchronized void stop() {
		this.isRunning = false;
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//STARTS HERE!//
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
	/**************/
	
	//Logica do jogo
	public void tick() {
		
		
		if(player.life <= 0) {
			World.restartGame("world2.png");
		}
		
		//tick boss IF it EXIST
		if(isBoss) {
			boss_1.tick();
			}
		else boss_1 = null;
		
		if(isBossF) {
			boss_2.tick();
		}else {
			boss_2 = null;
		}
		
		if(isBossI) {
			boss_3.tick();
		}else {
			boss_3 = null;
		}
		

		for(int i = 0; i < shootWalls.size(); i++) {
			ShootTile e = shootWalls.get(i);
			e.tick();
		}

		for(int i = 0; i < shootWallsSlow.size(); i++) {
			ShootTileSlow e = shootWallsSlow.get(i);
			e.tick();
		}
		
		//lógica por tras de cada entidade
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		
		for(int i = 0; i < playerBullets.size(); i++) {
			Entity b = playerBullets.get(i);
			b.tick();
		}
		
		for(int i = 0; i < BossBullets.size(); i++) {
			Entity fb = BossBullets.get(i);
			fb.tick();
		}
		
	}
	
	//Renderizar o jogo
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(4);
			return;
		}
		
		Graphics g = image.getGraphics();
		g.setColor(new Color(19, 19, 19));
		g.fillRect(0, 0, width, height);
		
		/**Quanto mais em cima mais embaixo renderiza**/
		
		
		world.render(g);
		//render boss IF it EXIST
		if(isBoss) {
			boss_1.render(g);
			for(int i = 0; i < shootWalls.size(); i++) {
				ShootTile e = shootWalls.get(i);
				e.render(g);
				}
			for(int i = 0; i < shootWallsSlow.size(); i++) {
				ShootTileSlow e = shootWallsSlow.get(i);
				e.render(g);
			}
		}
		
		if(isBossF) {
			boss_2.render(g);
		}
		if(isBossI) {
			boss_3.render(g);
		}
		
		for(int i = 0; i < playerBullets.size(); i++) {
			Entity b = playerBullets.get(i);
			b.render(g);
			
		}
		
		// renderizando cada entidade
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		
		for(int i = 0; i < BossBullets.size(); i++) {
			Entity fb = BossBullets.get(i);
			fb.render(g);
		}
		
		ui.render(g);
	
		/**Quanto mais embaixo mais em cima renderiza**/
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, muxW, muxH, null);
		bs.show();
	}
	 
	@Override
	public void run() {
		
		long lastTime = System.nanoTime();
		double numTicks = 60.0;
		double ns = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
			
		}
		stop();
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 /*move player pra direita*/
		if(e.getKeyCode() == KeyEvent.VK_D || 
			e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = true;
		
		 /*move player pra esquerda*/
		else if(e.getKeyCode() == KeyEvent.VK_A ||
				e.getKeyCode() == KeyEvent.VK_LEFT) player.left = true; 
		
		 /*move player pra cima*/
		if(e.getKeyCode() == KeyEvent.VK_W ||
			e.getKeyCode() == KeyEvent.VK_UP) player.up = true;
		
		/*move player pra baixo*/
		if(e.getKeyCode() == KeyEvent.VK_S ||
			e.getKeyCode() == KeyEvent.VK_DOWN) player.down = true;
		
		if(e.getKeyCode() == KeyEvent.VK_E) {
			player.autoShoot = !player.autoShoot;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			Entity.geralDebug = !Entity.geralDebug;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			player.debug = !player.debug;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*parando de  mover player pra direita*/
		if(e.getKeyCode() == KeyEvent.VK_D || 
			e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = false;
		
		 /*parando de mover player pra esquerda*/
		else if(e.getKeyCode() == KeyEvent.VK_A ||
				e.getKeyCode() == KeyEvent.VK_LEFT) player.left = false; 
		
		 /*parando de mover player pra cima*/
		if(e.getKeyCode() == KeyEvent.VK_W ||
			e.getKeyCode() == KeyEvent.VK_UP) player.up = false;
		
		/*parando de mover player pra baixo*/
		else if(e.getKeyCode() == KeyEvent.VK_S ||
			e.getKeyCode() == KeyEvent.VK_DOWN) player.down = false;
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		player.shoot = true;
		player.mx = e.getX() / 4;
		player.my = e.getY() / 4;
		player.autoShoot = false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(player != null) {
			if(!player.autoShoot) {
				player.shoot = false;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		player.shoot = true;
		player.mx = e.getX() / 4;
		player.my = e.getY() / 4;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(player != null) {
			if(player.autoShoot) {
				player.mx = e.getX() / 4;
				player.my = e.getY() / 4;
			}
		}
		
	}
	
}
