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
import com.beyastudio.entities.Bullet;
import com.beyastudio.entities.Enemy;
import com.beyastudio.entities.Entity;
import com.beyastudio.entities.Player;
import com.beyastudio.wolrd.WallTile;
import com.beyastudio.wolrd.World;

public class Main extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	
	private static final long serialVersionUID = 1L;
	private Thread th;
	private boolean isRunning = true;
	public static final int width = 120;
	public static final int height = 120;
	public static final int escala = 4, muxW = width * escala, muxH = height * escala;
	private BufferedImage image;
	public static List<WallTile> walls;
	public static List<Entity> entities;
	public static List<Bullet> bullets;
	public static Spritesheet spritesheet;
	
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
		bullets = new ArrayList<Bullet>();
		spritesheet = new Spritesheet("/spritesheet.png");
		player = new Player(0, 0, 8, 8, spritesheet.getSpritesheet(0, 0, 8, 8));
		entities.add(player);
		world = new World("/world2.png");
		this.setFocusable(true);
		this.requestFocus();
	}
	
	public void initFrame() {
		JFrame frame = new JFrame("Game #1 JAVA");
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
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	//Logica do jogo
	public void tick() {
		
		//lógica por tras de cada entidade
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			Entity b = bullets.get(i);
			b.tick();
		}
		
	}
	
	//Renderizar o jogo
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = image.getGraphics();
		g.setColor(new Color(19, 19, 19));
		g.fillRect(0, 0, width, height);
		
		
		world.render(g);
		ui.render(g);
		// renderizando cada entidade
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			Entity b = bullets.get(i);
			b.render(g);
			
		}
		
		ui.render(g);
		
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
			Player.autoShoot = !Player.autoShoot;
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(player != null) {
			if(!Player.autoShoot) {
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
			if(Player.autoShoot) {
				player.mx = e.getX() / 4;
				player.my = e.getY() / 4;
			}
		}
		
	}
	
}
