package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import levels.LevelFive;
import levels.LevelFour;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;


@SuppressWarnings("serial")
public class PaintComponent extends JPanel implements ActionListener, MouseListener {
	
	public int pointX;
	public int pointY;
	public int x;
	public int y;
	public Timer t = new Timer(5,this);
	public static boolean mainMenu =  true;
	public static boolean levelOne = false;
	public static boolean levelTwo = false;
	public static boolean levelThree = false;
	public static boolean levelFour = false;
	public static boolean levelFive = false;
	public static boolean winner = false;
	public KED ked = new KED();
	public static Image img,img2,img3,img4,img5,img6;
	

	public PaintComponent(){
			try {
		img = ImageIO.read(new File("/Game/Resources/Backgrounds/levelTwo.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
			try {
		img2 = ImageIO.read(new File("/Game/Resources/Backgrounds/watery.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
			try {
		img3 = ImageIO.read(new File("/Game/Resources/Backgrounds/levelThree.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
			try {
		img4 = ImageIO.read(new File("/Game/Resources/Backgrounds/LevelFour.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
			try {
		img5 = ImageIO.read(new File("/Game/Resources/Backgrounds/LevelFive.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
			try {
		img6 = ImageIO.read(new File("/Game/Resources/Backgrounds/winner.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
		t.start();	
		addMouseListener(this);
		setFocusable(true);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(ked);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(mainMenu){
			MenuState.draw(g);
		}
		if(levelOne){
			g.drawImage(img2,0, 0, 1440,920, null);
			LevelOne.draw(g);
		}
		if(levelTwo){
			g.drawImage(img,0, 0, 1440,920, null);
			LevelTwo.draw(g);
		}
		if(levelThree){
			g.drawImage(img3,0, 0, 1440,920, null);
			LevelThree.draw(g);
		}
		if(levelFour){
			g.drawImage(img4,0, 0, 1440,920, null);
			LevelFour.draw(g);
		}
		if(levelFive){
			g.drawImage(img5,0, 0, 1440,920, null);
			LevelFive.draw(g);
		}
		if(winner){
			g.drawImage(img6,0, 0, 1440,920, null);
		}

		
	}
		

	public void mousePressed(MouseEvent e){
		if(mainMenu == true){
		Point point = e.getPoint();
		pointX = (int) point.getX();
		pointY = (int) point.getY();
		if(pointX >1440/2- 150 && pointX < 1440/2+ 150 && pointY > 225 && pointY < 225 + 75){
			mainMenu = false; 
			levelOne = true;
		}
		if(pointX >1440/2- 150 && pointX < 1440/2+ 150 && pointY > 425 && pointY < 425 + 75){
			System.exit(0);
		}
		}
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(mainMenu){
			MenuState.actions(e);
		}
		if(levelOne){
			LevelOne.actions(e);
		}
		if(levelTwo){
			LevelTwo.actions(e);
		}
		if(levelThree){
			LevelThree.actions(e);
		}
		if(levelFour){
			LevelFour.actions(e);
		}
		if(levelFive){
			LevelFive.actions(e);
		}
			
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0){}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	

}
