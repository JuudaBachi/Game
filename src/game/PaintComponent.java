package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import levels.LevelOne;


@SuppressWarnings("serial")
public class PaintComponent extends JPanel implements ActionListener, MouseListener {
	
	public int pointX;
	public int pointY;
	public int x;
	public int y;
	public Timer t = new Timer(5,this);
	public boolean mainMenu =  true;
	public boolean levelOne = false;
	public KED ked = new KED();
	

	public PaintComponent(){
		
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
			LevelOne.draw(g);
		}

		
	}
		

	public void mousePressed(MouseEvent e){
		if(mainMenu == true){
		Point point = e.getPoint();
		pointX = (int) point.getX();
		pointY = (int) point.getY();
		if(pointX >Game.screenSize.width/2- 150 && pointX < Game.screenSize.width/2+ 150 && pointY > 225 && pointY < 225 + 75){
			mainMenu = false; 
			levelOne = true;
		}
		if(pointX >Game.screenSize.width/2- 150 && pointX < Game.screenSize.width/2+ 150 && pointY > 425 && pointY < 425 + 75){
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
