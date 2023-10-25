package things;

import javax.swing.JFrame;

public class Shell {

	public final static int HEIGHT = 500;
	public final static int WIDTH = 500;
	private Painel p;
	
	public Shell(){
		this.initFrame();
	}
	
	public void initFrame() {
		JFrame window = new JFrame();
		p = new Painel();
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.add(p);
		p.loop();
	}
	
	public static void main(String[] args) {
		new Shell();


	}
	
	
}
