package levels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tilemap.Map;
import entitys.EnemyOne;
import entitys.Exit;
import entitys.Player;
import game.Game;



public class LevelOne {
	
	public static boolean one = true;
	public static Image img;
	public static Map map = new Map();
	public static Exit exit = new Exit(100,100);
	public static EnemyOne E1 = new EnemyOne(100,720,3,0);
	public static EnemyOne E2 = new EnemyOne(1400,640,3,0);
	public static EnemyOne E3 = new EnemyOne(100,520,3,0);
	public static EnemyOne E4 = new EnemyOne(50,440,3,0);
	public static EnemyOne E5 = new EnemyOne(1440,360,3,0);
	public static Player player = new Player(120, 800);
	
	public LevelOne(){
	/*	try {
			img = ImageIO.read(new File("/Game/Resources/Backgrounds/watery.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}
		
	public static void draw(Graphics g){
		//g.drawImage(img,0, 0, 1440,Game.screenSize.height, null);
		g.drawImage(img,0, 0, 1440,920, null);
		exit.draw(g);
		E1.draw(g);
		E2.draw(g);
		E3.draw(g);
		E4.draw(g);
		E5.draw(g);
		player.draw(g);
		map.draw(g);

	}
	public static void oob(){
		if(player.x < -40 || player.x > Game.WIDTH){
			player.dead = true;
		}
		if(player.y < 0 || player.y > 920){
			player.dead = true;
		}
	}
	
	public static void Collision(){
		
		//Entity vs Tiles
		Rectangle p = new Rectangle((int)player.x ,(int)player.y ,player.width,player.height);
        Rectangle d = new Rectangle(E1.x,E1.y,25,25);
        Rectangle d2 = new Rectangle(E2.x,E2.y,25,25);
        Rectangle d3 = new Rectangle(E3.x,E3.y,25,25);
        Rectangle d4 = new Rectangle(E4.x,E4.y,25,25);
        Rectangle d5 = new Rectangle(E5.x,E5.y,25,25);
		map.rec();
		int max = map.list.size();
        boolean overblock = false;
 
		for(int q = 0;q<max;q++){
            // something like this (doesnt work properly)
            if (!player.inAir && !player.jump && player.x + 26 >= map.list.get(q).x - 25 && player.x <= map.list.get(q).x + 65 && player.y == map.list.get(q).y - 40) {
                overblock = true;
            }
            
            if(map.list.get(q).intersects(d4)){
            	E4.xx = -E4.xx;
            }
            
            if (map.list.get(q).intersects(p)) {
                if (player.y > map.list.get(q).y) {
                    player.y = map.list.get(q).y + 40;
                    player.yy = 0;
                    break;
                }
                if (player.y < map.list.get(q).y + 40) {
                    player.y = map.list.get(q).y - 26;
                    player.inAir = false;
                    player.yy = 0;
                    break;
                }
            }
        }
 
        if (!overblock) {
            //player.inAir = true; // commented because it prevents jumping right now
        }
 
        //Entity vs Entity
        Rectangle e = new Rectangle(exit.x,exit.y,25,25);
        if(p.intersects(e)){
        	game.PaintComponent.levelOne = false;
        	game.PaintComponent.levelTwo = true;
        }

        if(d.intersects(p)){
        	player.dead = true;
        }
        if(d2.intersects(p)){
        	player.dead = true;
        }
        if(d3.intersects(p)){
        	player.dead = true;
        }
        if(d4.intersects(p)){
        	player.dead = true;
        }
        if(d5.intersects(p)){
        	player.dead = true;
        }
        
	}
	public static void actions(ActionEvent e) {
		
		oob();
		Collision();
		player.actions(e);
		E1.actions(e);
		E2.actions(e);
		E3.actions(e);
		E4.actions(e);
		E5.actions(e);
	}

}
