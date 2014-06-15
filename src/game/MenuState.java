package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MenuState {
	
	
	public static Image background;
	public static Image title;
	public static Image start;
	public static Image options;
	public static Image quit;

	
	public MenuState(){
		try {background = ImageIO.read(new File("/Game/Resources/Backgrounds/menuBack.png"));} 
		catch (IOException e) {e.printStackTrace();}
		try {title = ImageIO.read(new File("/Game/Resources/Menu/title.png"));} 
		catch (IOException e) {e.printStackTrace();}
		try {start = ImageIO.read(new File("/Game/Resources/Menu/start.png"));} 
		catch (IOException e) {e.printStackTrace();}
		try {options = ImageIO.read(new File("/Game/Resources/Menu/options.png"));} 
		catch (IOException e) {e.printStackTrace();}
		try {quit = ImageIO.read(new File("/Game/Resources/Menu/quit.png"));} 
		catch (IOException e) {e.printStackTrace();}

	}
	
	public static void draw(Graphics g){
		g.drawImage(background,0, 0, Game.screenSize.width,Game.screenSize.height, null);
		g.drawImage(title,Game.screenSize.width/2- 150, 100, 300,75, null);
		g.drawImage(start,Game.screenSize.width/2- 150, 225, 300,75, null);
		g.drawImage(options,Game.screenSize.width/2- 150, 325, 300,75, null);
		g.drawImage(quit,Game.screenSize.width/2- 150, 425, 300,75, null);
	}

	public static void actions(ActionEvent e) {

	}
}
