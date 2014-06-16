package game;

import java.awt.Graphics;
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
		try {quit = ImageIO.read(new File("/Game/Resources/Menu/quit.png"));} 
		catch (IOException e) {e.printStackTrace();}

	}
	
	public static void draw(Graphics g){
		g.drawImage(background,0, 0,1440,920, null);
		g.drawImage(title,1440/2- 150, 100, 300,75, null);
		g.drawImage(start,1440/2- 150, 225, 300,75, null);
		g.drawImage(quit,1440/2- 150, 325, 300,75, null);
	}

	public static void actions(ActionEvent e) {

	}
}
