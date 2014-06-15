package entitys;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;


public class Cannon   {
	
	public int x = Game.screenSize.width / 2;
	public int y = Game.screenSize.height / 2;
	public int width = 25;
	public int height = 25;
	public int xx = 3;
	public int yy = 0;
	public int bx = 0;
	public int by = 0;
	
	
	public Cannon(int x, int y){	
		this.x =x;
		this.y = y;
		

	}
	
	
	public void draw(Graphics g){
		
		g.setColor(Color.RED);
		g.fillOval(x, y, 25, 25);	
	}
	
	public void findTarget(){
		if(Player.x < x){
			bx = -2;
		}
		else{ bx = 2;}
		if (Player.y < y){
			by = -2;
		}
		else {by = 2;}
	}
	
	public void actions(ActionEvent e){
		findTarget();
		x += bx;
		y += by;
	}
	

}