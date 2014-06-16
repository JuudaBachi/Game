package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import levels.LevelOne;


public class Game {
	
	public static JFrame gameFrame = new JFrame();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static PaintComponent PaintComponent = new PaintComponent();
	static LevelOne LevelOne = new LevelOne();
	static MenuState Menu = new MenuState();
	public static int WIDTH = 1440;
	public static int HEIGHT = 920;
	
	public static void main(String[] args) {
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		//gameFrame.setSize(screenSize.width,screenSize.height);
		gameFrame.setSize(WIDTH,HEIGHT);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setTitle("Blox");
		gameFrame.setVisible(true);		
		gameFrame.add(PaintComponent);

	}	 			
}
