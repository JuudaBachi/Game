package entitys;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import levels.LevelOne;
import tilemap.Map;


public class Player   {
	
	public static float x = 40;
	public static float y = 900;
	public static float size = 0.3f;
	public static int width = 26;
	public static int height = 26;
	public static float xx = 0;
	public static float yy = 0;
	public static boolean inAir = true;
	public static boolean dead = false;
	public static boolean facingRight = true;
	public static float grav = 1;
	public static float tVol = 2;
	public static float speed;
	public static boolean jump = false;
	
	public Player(){	

	}	
	public static void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.fillRect((int)x, (int)y, width, height);	
	
	}	
	public static void actions(ActionEvent e){
		
		if(inAir == true){
		fall();
		}
		x += xx;
		y += yy;
		
	}
	
	public static void fall(){
		yy = yy + grav;
		if(yy>tVol){
			yy = tVol;
		}
		Player.y += yy;
	
		
	}
	
	public static void isDead(){
		if (dead == true){
			respawn();
			inAir = true;
		}
	}
	public static void respawn(){
		x = 10;
		y = 10;
	}
	public static void Right(){xx = 2;}
	public static void Left(){xx = -2;}
	public static void Jump() {
		
		if(inAir == false){
		inAir = true;
		yy = yy - grav * 15;
		y += yy;
		}
	
	}
	public static void Stop(){xx = 0;}
	
	

		
	}

