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
import com.beyastudio.boss_A.Sakura;
import com.beyastudio.boss_A.Spooky;
import com.beyastudio.entities.Enemy;
import com.beyastudio.entities.Entity;
import com.beyastudio.entities.Orb_destroy;
import com.beyastudio.entities.Player;
import com.beyastudio.entities.PlayerBullet;
import com.beyastudio.entities.Puppy;
import com.beyastudio.entities.Tombstone;
import com.beyastudio.entities.teleporters.Teleport_back;
import com.beyastudio.entities.teleporters.Teleporter;
import com.beyastudio.wolrd.AnimatedTile;
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
	public static final int width = 120*3/* original = 4*/;
	public static final int height = 140 * 2/*ORIGINAL = 2*/;
	public static final int escala = 4,
							muxW = width * escala,
							muxH = height * escala;
	
	public static boolean orbgrass = true, orbice = true, orbfire = true;
	public static boolean crown = true, flower = true, beeCreab = true;
	
	public static String gameState = "normal";
	private boolean showMessageGameover  = true, restartGame = false;
	private int framesgameover = 0;
	
	public static String atualWorld = "/world.png";
	
	private BufferedImage image;
	public static List<WallTile> walls;
	public static List<WallTile> portals;
	public static List<ShootTile> shootWalls;
	public static List<ShootTileSlow> shootWallsSlow;
	public static List<IceShootTile> iceShootWalls;
	public static List<Entity> entities;
	public static List<PlayerBullet> playerBullets;
	public static List<Entity> tombs;
	public static List<Bullet> BossBullets;
	public static List<Orb_destroy> bee;
	public static List<AnimatedTile> animatedTiles;
	public static List<Sakura> sakura_trees;
	public static Spritesheet spritesheet, 
	hurt_spritesheet, control, art, logo, 
	teleports, boss_placeholders, boss_samurai,
	trees, tiles_samurai;
	
	public static boolean isBossG = false, isBossF = false, isBossI = false, isBossS = false;
	
	public static Finn boss_1;
	public static FireP boss_2;
	public static IceKing boss_3;
	public static Spooky boss_A;
	public static World world;
	public static Player player;
	public static Puppy puppy;
	public static Enemy enemy;
	public static UI ui;
	public static Random ran;
	public static Tombstone cursed_tomb;
	public static Portal portal_grass_1,portal_grass_2 , portal_ice_1,portal_ice_2, portal_fire_1, portal_fire_2, portal_gold_1, portal_gold_2;
	public static Teleport_back tbGrass, tbFire, tbIce;
	
	public static Menu menu;
	
	public int count_control = 0;
	
	public static int gameoverTextAlpha = 1,
					  gameoverTextAlphaBG = 10;
	
	public Main() {
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addMouseListener(this);
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
		tombs = new ArrayList<Entity>();
		bee = new ArrayList<Orb_destroy>();
		animatedTiles = new ArrayList<AnimatedTile>();
		iceShootWalls = new ArrayList<IceShootTile>();
		shootWallsSlow = new ArrayList<ShootTileSlow>();
		sakura_trees = new ArrayList<Sakura>();
		spritesheet = new Spritesheet("/spritesheet.png");
		control = new Spritesheet("/control_screen.png");
		art = new Spritesheet("/menu.png");
		boss_placeholders = new Spritesheet("/bossPlaceHolder.png");
		hurt_spritesheet = new Spritesheet("/hurt_spritesheet.png");
		logo = new Spritesheet("/logo.png");
		teleports = new Spritesheet("/portals.png");
		boss_samurai = new Spritesheet("/samurai.png");
		tiles_samurai = new Spritesheet("/tiles_samurai.png");
		trees = new Spritesheet("/trees.png");
		player = new Player(0, 0, 8, 8, spritesheet.getSpritesheet(0, 0, 8, 8));
		ui = new UI();
		entities.add(player);
		world = new World(atualWorld);
		this.setFocusable(true);
		this.requestFocus();
		
		//Init boss_1 Object
		
		menu = new Menu();
		
		//LOOP DA MAIN MUSIC
		//Sound.mainMusic.loop();
//
//		portal_gold_1 = new Portal(680, 480, Entity.PORTAL_GOLD);
//		portals.add(portal_gold_1);
//		
//		portal_gold_2 = new Portal(824 - 8, 480, Entity.PORTAL_GOLD);
//		portals.add(portal_gold_2);
		
		
		//TESTE*********************************************
		isBossS = true;
		boss_A = new Spooky(472, 472, 16, 16, Entity.SPOOKY_EN);
		
		
		//In the world 2
		if(Main.atualWorld == "/world2.png") {
			teleporters();
			
			puppy = new Puppy(67  *8, 63 * 8, 16, 16, Entity.PUPPY_TALK_0);
			entities.add(puppy);
			
			boss_1 = new Finn(228 , 140, 16, 16, Entity.FINN_EN);
			boss_2 = new FireP(144, 680, 16, 16, Entity.FIRE_EN);
			boss_3 = new IceKing(826, 752, 16, 16, Entity.ICE_EN);
			isBossG = true;
			isBossF = true;
			isBossI = true;
			
			
			//Tombs = player na frente
			//Portal = player atrásS
			portais();
		}
		
	}
	
	public void initFrame() {
		JFrame frame = new JFrame("Bullest & Dodges");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPreferredSize(new Dimension(muxW, muxH));
		
		frame.setVisible(true);
		
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
				Sound.diedPlayer.play();
				player.life = 0;
				cursed_tomb = new Tombstone(player.getX() - 4, player.getY() - 8, 16, 16, Entity.CURSED_TOMB_STONE);
				Main.entities.remove(player);
				gameState = "game_over";
			}
		
			//tick boss IF it EXIST
			
			if(isBossG) {
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
			
			if(isBossS) {
				boss_A.tick();
			}else {
				boss_A = null;
			}
		
			for(int i = 0; i < shootWalls.size(); i++) {
				ShootTile e = shootWalls.get(i);
				e.tick();
			}
			

			
			for(int i = 0; i < tombs.size(); i++) {
				Entity b = tombs.get(i);
				b.tick();
			}
			
				
			for(int i = 0; i < sakura_trees.size(); i++) {
				Entity b = sakura_trees.get(i);
				b.tick();
			}
				
			
			
			for(int i = 0; i < animatedTiles.size(); i++) {
				AnimatedTile b = animatedTiles.get(i);
				b.tick();
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
			
			for(int i = 0; i < bee.size(); i++) {
				Entity e = bee.get(i);
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
				Sound.menuSelect.play();
				gameState = "normal";
				World.restartGame("world2.png");
				gameoverTextAlpha = 0;
				gameoverTextAlphaBG = 0;
			}
			
			break;
		
		case "menu":
			
			menu.tick();
			break;
			
			
			
		case "control":
			this.count_control++;
			if(count_control >= 130) {
				gameState = "normal";
			}
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
		
		
		
		for(int i = 0; i < animatedTiles.size(); i++) {
			AnimatedTile b = animatedTiles.get(i);
			b.render(g);
		}
		world.render(g);
		//render boss IF it EXIST
		
		
		for(int i = 0; i < sakura_trees.size(); i++) {
			Entity b = sakura_trees.get(i);
			b.render(g);
		}	
		
		
		ui.render(g);
		
		for(int i = 0; i < tombs.size(); i++) {
			Entity b = tombs.get(i);
			b.render(g);
		}
		
		for(int i = 0; i < bee.size(); i++) {
			Entity e = bee.get(i);
			e.render(g);
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
		
		
		
		if(isBossF) {
			boss_2.render(g);
			for(int i = 0; i < shootWalls.size(); i++) {
				ShootTile e = shootWalls.get(i);
				e.render(g);
				}
		}
		
		if(isBossG) {
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
		
		
		if(isBossS) {
			boss_A.render(g);
		}
		
		for(int i = 0; i < portals.size(); i++) {
			WallTile e = portals.get(i);
			e.render(g);
		}
		
	
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
		}
		
		g.dispose();
		g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, muxW, muxH, null);
		
		if(gameState == "control") {
			g.drawImage(control.getSpritesheet(0, 0, 673, 673), 0, 0, null);
		}else if(gameState == "menu") {
			g.drawImage(art.getSpritesheet(0, 0, 650, 650), 0, 0, null);
			menu.render(g);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.setColor(Color.black);
			g.drawString("Beya's Studio", 20 + 20, 530);
			g.drawImage(logo.getSpritesheet(0, 0, 100, 100), 20, 530, null);
		}
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
				player.dmg = 50;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.restartGame = true;
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			if(gameState == "menu") {
				menu.enter = !menu.enter;
			}
			if(gameState == "control") {
				this.count_control = 130;
			}
		}
		
	}
	
	public static void portais() {
		portal_grass_1 = new Portal(457, 504, Entity.PORTAL_GRASS);
		portals.add(portal_grass_1);
		
		portal_grass_2 = new Portal(418, 504, Entity.PORTAL_GRASS);
		portals.add(portal_grass_2);
		
		portal_ice_1 = new Portal(392, 513, Entity.PORTAL_ICE);
		portals.add(portal_ice_1);
		
		portal_ice_2 = new Portal(392, 552, Entity.PORTAL_ICE_2);
		portals.add(portal_ice_2);
	
		portal_fire_1 = new Portal(418, 552, Entity.PORTAL_FIRE);
		portals.add(portal_fire_1);
		
		portal_fire_2 = new Portal(457, 552, Entity.PORTAL_FIRE);
		portals.add(portal_fire_2);
	}
	
	public static void removePortais() {
		portals.removeAll(portals);
	}
	
	public static void teleporters() {
		
		int num_teleports = 0;
		
		if(Main.atualWorld == "/world2.png") {
			num_teleports = 6;
		}
	
		
		if(num_teleports < 6) {
			
			num_teleports = 1;
			
			for(int i=0; i<num_teleports; i++) {
				switch(i) {
				
					case 0:
						entities.add(
								new Teleporter
								(584, 568, 16, 16, Entity.GRASS_TELEPORT, 160, 152));
						break;
				}
			}
		}
		
		else if(num_teleports == 6) {
			//Teleportes pros bosses da área 1
			for(int i=0; i<num_teleports; i++) {
				switch(i) {
				
					case 0:
						entities.add(
								new Teleporter
								(437, 508, 16, 16, Entity.GRASS_TELEPORT, 224, 224));
						break;
					case 1:
						entities.add(
								new Teleporter
								(437, 557, 16, 16, Entity.FIRE_TELEPORT, 160, 736));
						break;  
					case 2:
						entities.add(
								new Teleporter
								(396, 533, 16, 16, Entity.ICE_TELEPORT, 832, 928));
						break;
						
					case 3:
						entities.add(
								tbGrass =
								new Teleport_back
								(256, 216, 16, 16, Entity.LOBBY_TELEPORT, Teleport_back.xBack, Teleport_back.yBack));
						break;
						
					case 4:
						entities.add(
								tbFire =
								new Teleport_back
								(192, 736 - 8, 16, 16, Entity.LOBBY_TELEPORT, Teleport_back.xBack, Teleport_back.yBack));
						break;
						
					case 5: 
						entities.add(
								tbIce =
								new Teleport_back
								(864, 928 - 8, 16, 16, Entity.LOBBY_TELEPORT, Teleport_back.xBack, Teleport_back.yBack));
						break;
				}
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
		if(player != null) {
			player.shoot = true;
			player.mx = e.getX() / 4 + 5;
			player.my = e.getY() / 4 + 10;
			player.autoShoot = false;
		}
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
		
		if(player != null) {
			player.shoot = true;
			player.mx = e.getX() / 4 + 5;
			player.my = e.getY() / 4 + 10;
		}
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
