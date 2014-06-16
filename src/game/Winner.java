package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Winner {
	
	
	public static Image background;


	
	public Winner(){
		try {background = ImageIO.read(new File("/Game/Resources/Backgrounds/winner.png"));} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static void draw(Graphics g){
		g.drawImage(background,0, 0,1440,920, null);
	}

	public static void actions(ActionEvent e) {

	}
}
