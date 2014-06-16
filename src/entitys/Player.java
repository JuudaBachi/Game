package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;


public class Player   {
	
	public float x = 40;
	public float y = 800;
	public  int width = 26;
	public  int height = 26;
	public  float xx = 0;
	public  float yy = 0;
	public  boolean inAir = true;
	public  boolean dead = false;
	public  float grav = 1;
	public  float tVol = 2;
	public  float speed;
	public  boolean jump = false;
	public int spawnx, spawny;
	public boolean once = true;
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		if(once){
		spawnx = (int) this.x;
		spawny = (int) this.y;
		once = false;
		}

	}	
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.fillRect((int)x, (int)y, width, height);	
	
	}	
	public void actions(ActionEvent e){
		
		isDead();
		if(inAir == true){
		fall();
		}
		x += xx;
		y += yy;
		
	}
	
	public void fall(){
		yy = yy + grav;
		if(yy>tVol){
			yy = tVol;
		}
		y += yy;
	
		
	}
	
	public void isDead(){
		if (dead == true){
			dead = false;
			respawn();
		}
	}
	public void respawn(){
		x = spawnx ;
		y = spawny ;
	}
	public void Right(){xx = 2;}
	public void Left(){xx = -2;}
	public void Jump() {	
		if(inAir == false){
		yy = yy - grav * 15;
		y += yy;
		inAir = true;
		}
	
	}
	public void Stop(){xx = 0;}
	}

