package levels;

import entitys.Player;
import game.Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tilemap.Map;



public class LevelOne {
	
	public static boolean one = true;
	public static Image img;
	public static Map map = new Map();
	
	public LevelOne(){
		try {
			img = ImageIO.read(new File("/Game/Resources/Backgrounds/watery.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public static void draw(Graphics g){
		g.drawImage(img,0, 0, Game.screenSize.width,Game.screenSize.height, null);
		Player.draw(g);
		map.draw(g);

	}
	
	
	public static void Collision(){
		
		//Entity vs Tiles
		Rectangle p = new Rectangle((int)Player.x ,(int)Player.y ,Player.width,Player.height);
		map.rec();
		int max = map.list.size();
		for(int q = 0;q<max;q++){
				if(map.list.get(q).intersects(p) && Player.y  > map.list.get(q).y * 40 ){
					Player.y += Player.yy + 6;
					Player.yy = 0;
					
				}
				if(map.list.get(q).intersects(p) && Player.y  < map.list.get(q).y * 40){
					Player.y += -Player.yy + - 2;
					Player.inAir = false;
					Player.yy = 0;
				}
				if(map.list.get(q).intersects(p) && Player.x > map.list.get(q).x * 40 ){
					Player.x += Player.xx + 2;
				}
				if(map.list.get(q).intersects(p) && Player.x < map.list.get(q).x * 40 ){
					Player.x += -Player.xx + - 2;
	
				}
			
		}
		//Entity vs Entity
		


	}
	public static void actions(ActionEvent e) {
		
		Collision();
		Player.actions(e);
	}

}
