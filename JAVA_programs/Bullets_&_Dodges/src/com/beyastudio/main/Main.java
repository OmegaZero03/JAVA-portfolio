package com.beyastudio.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
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
import com.beyastudio.entities.Puppy;
import com.beyastudio.entities.Tombstone;
import com.beyastudio.wolrd.IceShootTile;
import com.beyastudio.wolrd.Portal;
import com.beyastudio.wolrd.ShootTile;
import com.beyastudio.wolrd.ShootTileSlow;
import com.beyastudio.wolrd.WallTile;
import com.beyastudio.wolrd.World;

public class Main extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	
	private static final long serialVersionUID = 1L;
	private Thread th;
	private boolean isRunning = true;
	public static final int width = 160;
	public static final int height = 160;
	public static final int escala = 4,
							muxW = width * escala,
							muxH = height * escala;
	
	public static String gameState = "menu";
	private boolean showMessageGameover  = true, restartGame = false;
	private int framesgameover = 0;
	
	private BufferedImage image;
	public static List<WallTile> walls;
	public static List<WallTile> portals;
	public static List<ShootTile> shootWalls;
	public static List<ShootTileSlow> shootWallsSlow;
	public static List<IceShootTile> iceShootWalls;
	public static List<Entity> entities;
	public static List<PlayerBullet> playerBullets;
	public static List<Bullet> BossBullets;
	public static Spritesheet spritesheet, hurt_spritesheet;
	
	public static boolean isBoss = false, isBossF = false, isBossI = false;
	
	public static Finn boss_1;
	public static FireP boss_2;
	public static IceKing boss_3;
	public static World world;
	public static Player player;
	public static Puppy puppy;
	public static Enemy enemy;
	public static UI ui;
	public static Random ran;
	public static Tombstone cursed_tomb;
	public static Portal portal_grass_1,portal_grass_2 , portal_ice_1,portal_ice_2, portal_fire_1, portal_fire_2, portal_gold_1, portal_gold_2;
	
	public static Menu menu;
	
	public static int gameoverTextAlpha = 1,
					  gameoverTextAlphaBG = 10;
	
	public Main() {
		
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addMouseListener(this);
		setPreferredSize(new Dimension(muxW, muxH));
		initFrame();
		
		// Init Objects
		ran = new Random();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		entities = new ArrayList<Entity>();
		walls = new ArrayList<WallTile>();
		portals = new ArrayList<WallTile>();
		playerBullets = new ArrayList<PlayerBullet>();
		BossBullets = new ArrayList<Bullet>();
		shootWalls = new ArrayList<ShootTile>();
		iceShootWalls = new ArrayList<IceShootTile>();
		shootWallsSlow = new ArrayList<ShootTileSlow>();
		spritesheet = new Spritesheet("/spritesheet.png");
		hurt_spritesheet = new Spritesheet("/hurt_spritesheet.png");
		player = new Player(0, 0, 8, 8, spritesheet.getSpritesheet(0, 0, 8, 8));
		ui = new UI();
		entities.add(player);
		puppy = new Puppy(70  *8, 57 * 8, 16, 16, Entity.PUPPY_TALK_0);
		entities.add(puppy);
		world = new World("/world2.png");
		this.setFocusable(true);
		this.requestFocus();
		
		//Init boss_1 Object
		
		menu = new Menu();
		
		portal_grass_1 = new Portal(352, 480, Entity.PORTAL_GRASS);
		portals.add(portal_grass_1);
		
		portal_grass_2 = new Portal(248, 480, Entity.PORTAL_GRASS);
		portals.add(portal_grass_2);
		
		portal_ice_1 = new Portal(552, 568, Entity.PORTAL_ICE);
		portals.add(portal_ice_1);
		
		portal_ice_2 = new Portal(552, 600, Entity.PORTAL_ICE_2);
		portals.add(portal_ice_2);
		
		portal_fire_1 = new Portal(536, 768, Entity.PORTAL_FIRE);
		portals.add(portal_fire_1);
		
		portal_fire_2 = new Portal(424, 768, Entity.PORTAL_FIRE);
		portals.add(portal_fire_2);

		portal_gold_1 = new Portal(680, 480, Entity.PORTAL_GOLD);
		portals.add(portal_gold_1);
		
		portal_gold_2 = new Portal(824 - 8, 480, Entity.PORTAL_GOLD);
		portals.add(portal_gold_2);
		//portal_gold = new Portal(0, 0, Entity.PORTAL_GOLD);
		
		//In the world 2
		if(World.WIDTH == 120  && World.HEIGHT == 120) {
			boss_1 = new Finn(228 , 140, 16, 16, Entity.FINN_EN);
			boss_2 = new FireP(144, 680, 16, 16, Entity.FIRE_EN);
			boss_3 = new IceKing(826, 752, 16, 16, Entity.ICE_EN);
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
		
		
		
		Image icon = null;
		try {
			icon = ImageIO.read(getClass().getResource("/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image_cursor = toolkit.getImage(getClass().getResource("/cursor.png"));
		Cursor cursor = toolkit.createCustomCursor(image_cursor, new Point(0, 0), "img");
		
		frame.setCursor(cursor);
		frame.setIconImage(icon);
		
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
		
		
		switch(gameState) {
		
		case "normal":
			
			this.restartGame = false;
			if(player.life <= 0) {
				player.life = 0;
				cursed_tomb = new Tombstone(player.getX() - 4, player.getY() - 8, 16, 16, Entity.CURSED_TOMB_STONE);
				Main.entities.remove(player);
				gameState = "game_over";
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
			
			
			
			for(int i = 0; i < iceShootWalls.size(); i++) {
				IceShootTile e = iceShootWalls.get(i);
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
		
			break;
			
			
		case "game_over":
			
			this.framesgameover++;
			if(this.framesgameover == 20) {
				this.framesgameover = 0;
				if(this.showMessageGameover) {
					this.showMessageGameover = false;
				}else {
					showMessageGameover = true;
				}
			}
			
			cursed_tomb.tick();
			
			if(gameoverTextAlpha != 255) {
				gameoverTextAlpha++;
			}
			
			if(gameoverTextAlphaBG != 100) {
				gameoverTextAlphaBG++;
			}
			
			if(restartGame) {
				this.restartGame = false;
				gameState = "normal";
				World.restartGame("world2.png");
				gameoverTextAlpha = 0;
				gameoverTextAlphaBG = 0;
				
			}
			
			break;
		
		case "menu":
			
			menu.tick();
			break;
			
			
		
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
		
		if(isBossF) {
			boss_2.render(g);
			for(int i = 0; i < shootWalls.size(); i++) {
				ShootTile e = shootWalls.get(i);
				e.render(g);
				}
		}
		
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

		if(isBossI) {
			boss_3.render(g);
			
			for(int i = 0; i < iceShootWalls.size(); i++) {
				IceShootTile e = iceShootWalls.get(i);
				e.render(g);
			}
		}
		
		for(int i = 0; i < portals.size(); i++) {
			WallTile e = portals.get(i);
			e.render(g);
		}
		
		ui.render(g);
	
		/**Quanto mais embaixo mais em cima renderiza**/
		
		if(gameState == "game_over") {
			Graphics g2 = (Graphics2D) g;			
			g2.setColor(new Color(255,213,65, gameoverTextAlphaBG));
			g2.fillRect(0, 0, muxW, muxH);
			g.clearRect(muxH, escala, width, height);
			g.setFont(new Font("arial", Font.BOLD, 12));
			g.setColor(new Color(255,0,255, gameoverTextAlpha));
			g.drawString("You failed", 45, 70);
			g.setFont(new Font("creepster", Font.BOLD, 20));
			g.setColor(new Color(170,0, 0, gameoverTextAlpha));
			g.drawString("ME", 45 + 57, 70);
			g.setFont(new Font("arial", Font.BOLD, 9));
			g.setColor(new Color(0,0,0, gameoverTextAlpha));
			if(showMessageGameover) {
				g.drawString("> Press Space to try again <", 20, 110);
			}
			cursed_tomb.render(g);
		}else if(gameState == "menu") {
			menu.render(g);
		}
		
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
			e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
			
			if(gameState == "menu") {
				menu.up = !menu.up;
			}
		}
		
		/*move player pra baixo*/
		if(e.getKeyCode() == KeyEvent.VK_S ||
			e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
			if(gameState == "menu") {
				menu.down = !menu.down;
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E) {
			player.autoShoot = !player.autoShoot;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if(gameState == "normal") {
				Entity.geralDebug = !Entity.geralDebug;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(gameState == "normal") {
				player.debug = !player.debug;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.restartGame = true;
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			if(gameState == "menu") {
				menu.enter = !menu.enter;
			}
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
		player.mx = e.getX() / 4 + 5;
		player.my = e.getY() / 4 + 10;
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
		player.mx = e.getX() / 4 + 5;
		player.my = e.getY() / 4 + 10;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(player != null) {
			if(player.autoShoot) {
				player.mx = e.getX() / 4 + 5;
				player.my = e.getY() / 4 + 10;
			}
		}
		
	}
	
}
