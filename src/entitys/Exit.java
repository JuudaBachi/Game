package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;


public class Exit   {
	
	public int x = 40 * 3;
	public int y = 40 * 6;
	public int width = 40;
	public int height = 40;	
	
	public Exit(int x, int y){	
		this.x = x;
		this.y = y;
	}
	public Exit(){	

	}
	
	
	public void draw(Graphics g){
		
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 25, 25);	
	
	}
	
	public void actions(ActionEvent e){
		
	}
	

}