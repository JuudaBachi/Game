package levels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tilemap.Map5;
import entitys.EnemyOne;
import entitys.Exit;
import entitys.Player;



public class LevelFive {
	
	public static boolean one = true;
	public static Image img;
	public static Map5 map = new Map5();
	public static EnemyOne VE = new EnemyOne(1240,500,0,3);//bb
	public static EnemyOne VE2 = new EnemyOne(1120,300,0,3);//bb
	public static EnemyOne VE3 = new EnemyOne(960,700,0,3);//bb
	public static EnemyOne VE4 = new EnemyOne(520,600,0,3);//bb
	public static EnemyOne VE5 = new EnemyOne(760,400,0,3);//bb
	public static EnemyOne VE6 = new EnemyOne(660,700,0,3);//bb
	public static EnemyOne HE = new EnemyOne(100,760,3,0);
	public static EnemyOne HE2 = new EnemyOne(200,600,3,0);
	public static EnemyOne HE3 = new EnemyOne(300,480,3,0);
	public static EnemyOne HE4 = new EnemyOne(400,360,3,0);
	public static EnemyOne HE5 = new EnemyOne(500,240,3,0);
	public static EnemyOne HE6 = new EnemyOne(600,160,3,0);
	public static Exit exit = new Exit(100,100);
	public static Player player = new Player(100,780);
	
	public LevelFive(){
		try {
			img = ImageIO.read(new File("/Game/Resources/Backgrounds/watery.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public static void draw(Graphics g){
		exit.draw(g);
		VE.draw(g);
		VE2.draw(g);
		VE3.draw(g);
		VE4.draw(g);
		VE5.draw(g);
		VE6.draw(g);
		HE.draw(g);
		HE2.draw(g);
		HE3.draw(g);
		HE4.draw(g);
		HE5.draw(g);
		HE6.draw(g);
		player.draw(g);
		map.draw(g);

	}
	
	public static void oob(){
		if(player.x < -50 || player.x > 1440){
			player.dead = true;
		}
		if(player.y < -200 || player.y > 920){
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
        Rectangle d9 = new Rectangle(HE6.x,HE6.y,25,25);
        Rectangle d10 = new Rectangle(VE4.x,VE4.y,25,25);
        Rectangle d11 = new Rectangle(VE5.x,VE5.y,25,25);
        Rectangle d12 = new Rectangle(VE6.x,VE6.y,25,25);
		map.rec();
		int max = map.list.size();
        boolean overblock = false;
 
		for(int q = 0;q<max;q++){
            // something like this (doesnt work properly)
            if (!player.inAir && !player.jump && player.x + 26 >= map.list.get(q).x - 25 && player.x <= map.list.get(q).x + 65 && player.y == map.list.get(q).y - 40) {
                overblock = true;
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
        
        if(d9.intersects(p)){
        	player.dead = true;
        }
        if(d10.intersects(p)){
        	player.dead = true;
        }
        if(d11.intersects(p)){
        	player.dead = true;
        }
        if(d12.intersects(p)){
        	player.dead = true;
        }
        
        Rectangle e = new Rectangle(exit.x,exit.y,25,25);
        if(p.intersects(e)){
        	game.PaintComponent.levelFive = false;
        	game.PaintComponent.winner = true;
        }
        
	}
	public static void actions(ActionEvent e) {
		
		VE.actions(e);
		VE2.actions(e);
		VE3.actions(e);
		VE4.actions(e);
		VE5.actions(e);
		VE6.actions(e);
		HE.actions(e);
		HE2.actions(e);
		HE3.actions(e);
		HE4.actions(e);
		HE5.actions(e);
		HE6.actions(e);
		oob();
		Collision();
		player.actions(e);
	}

}