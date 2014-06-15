package entitys;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;


public class EnemyOne   {
	
	public int x = 0;
	public int y = Game.screenSize.height - 60;
	public int width = 25;
	public int height = 25;
	public int xx = 3;
	public int yy = 0;
	public boolean inAir = true;
	
	
	public EnemyOne(int x, int y){	
		this.x = x;
		this.y = y;
	}
	public EnemyOne(){	

	}
	
	
	public void draw(Graphics g){
		
		g.setColor(Color.RED);
		g.fillRect(x, y, 25, 25);	
	
	}
	
	public void actions(ActionEvent e){
		
		walls();
		x += xx;
		y += yy;	
	}
	
	public void walls(){
		
		if(x < 0 || x > Game.screenSize.width-30){
			xx = -xx;
		}
	}

}