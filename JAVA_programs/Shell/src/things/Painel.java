package things;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Painel extends JPanel{

	private static final long serialVersionUID = 1L;
	private BufferedImage bs;
	private Graphics2D g2;
	private boolean isRunning;
	private Ball b;
	private Thing t;
	
	
	public Painel() {
		bs = new BufferedImage(Shell.WIDTH, Shell.HEIGHT, BufferedImage.TYPE_INT_RGB);
		g2 = (Graphics2D) bs.getGraphics();
		isRunning = true;
		b = new Ball();
		t = new Thing();
		this.setFocusable(true);
		this.requestFocus();
		
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				b.keyPressed(e.getKeyCode());
				t.keyPressed(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				b.keyReleased(e.getKeyCode());
			}
			
		});
	}
	
	public void loop() {
		while(isRunning) {
			tick();
			render();
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void tick() {
		b.tick();
		t.tick(b);
	}
	
	public void render() {
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Shell.WIDTH, Shell.HEIGHT);
		b.render(g2);
		t.render(g2);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(bs, 0, 0, null);
	}
	
	
}
