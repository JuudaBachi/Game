package levels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tilemap.Map2;
import entitys.EnemyOne;
import entitys.Exit;
import entitys.Player;
import game.Game;



public class LevelTwo {
	
	public static boolean one = true;
	public static Image img;
	public static Map2 map = new Map2();
	public static EnemyOne VE = new EnemyOne(160,300,0,3);//bb
	public static EnemyOne VE2 = new EnemyOne(280,400,0,3);//bb
	public static EnemyOne VE3 = new EnemyOne(360,500,0,3);//bb
	public static EnemyOne HE = new EnemyOne(900,160,3,0);
	public static EnemyOne HE2 = new EnemyOne(1400,240,3,0);
	public static EnemyOne HE3 = new EnemyOne(500,120,3,0);//bb
	public static EnemyOne HE4 = new EnemyOne(600,440,3,0);//bb12
	public static EnemyOne HE5 = new EnemyOne(100,600,3,0);//8
	public static Exit exit = new Exit(100,100);
	public static Player player = new Player(40, 780);
	
	public LevelTwo(){
		try {
			img = ImageIO.read(new File("/Game/Resources/Backgrounds/levelTwo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public static void draw(Graphics g){
		//g.drawImage(img,0, 0, 1440,Game.screenSize.height, null);
		g.drawImage(img,0, 0, 1440,920, null);
		exit.draw(g);
		VE.draw(g);
		VE2.draw(g);
		VE3.draw(g);
		HE.draw(g);
		HE2.draw(g);
		HE3.draw(g);
		HE4.draw(g);
		HE5.draw(g);
		player.draw(g);
		map.draw(g);

	}
	public static void oob(){
		if(player.x < -40 || player.x > Game.WIDTH){
			player.dead = true;
		}
		if(player.y < -100 || player.y > 920){
			player.dead = true;
		}
	}
	
	
	public static void Collision(){
		
		//Entity vs Tiles
		Rectangle p = new Rectangle((int)player.x ,(int)player.y ,player.width,player.height);
        Rectangle d = new Rectangle(VE.x,VE.y,25,25);
        Rectangle d2 = new Rectangle(VE2.x,VE2.y,25,25);
        Rectangle d3 = new Rectangle(VE3.x,VE3.y,25,25);
        Rectangle d4 = new Rectangle(HE.x,HE.y,25,25);
        Rectangle d5 = new Rectangle(HE2.x,HE2.y,25,25);
        Rectangle d6 = new Rectangle(HE3.x,HE3.y,25,25);
        Rectangle d7 = new Rectangle(HE4.x,HE4.y,25,25);
        Rectangle d8 = new Rectangle(HE5.x,HE5.y,25,25);
		map.rec();
		int max = map.list.size();
        boolean overblock = false;
 
		for(int q = 0;q<max;q++){
            // something like this (doesnt work properly)
            if (!player.inAir && !player.jump && player.x + 26 >= map.list.get(q).x - 25 && player.x <= map.list.get(q).x + 65 && player.y == map.list.get(q).y - 40) {
                overblock = true;
            }
            if(map.list.get(q).intersects(d)){
            	VE.yy = - VE.yy;
            }
            if(map.list.get(q).intersects(d2)){
            	VE2.yy = - VE2.yy;
            }
            if(map.list.get(q).intersects(d3)){
            	VE3.yy = - VE3.yy;
            }
            if(map.list.get(q).intersects(d4)){
            	HE.xx = - HE.xx;
            }
            if(map.list.get(q).intersects(d5)){
            	HE2.xx = - HE2.xx;
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
        if(d6.intersects(p)){
        	player.dead = true;
        }
        if(d7.intersects(p)){
        	player.dead = true;
        }
        if(d8.intersects(p)){
        	player.dead = true;
        }
        Rectangle e = new Rectangle(exit.x,exit.y,25,25);
        if(p.intersects(e)){
        	game.PaintComponent.levelTwo = false;
        	game.PaintComponent.levelThree = true;
        	
        }
        
	}
	public static void actions(ActionEvent e) {
		VE.actions(e);
		VE2.actions(e);
		VE3.actions(e);
		HE.actions(e);
		HE2.actions(e);
		HE3.actions(e);
		HE4.actions(e);
		HE5.actions(e);
		oob();
		Collision();
		player.actions(e);
	}

}