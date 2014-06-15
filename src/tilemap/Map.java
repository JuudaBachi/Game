package tilemap;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Map {
	
	
	public static final int CLEAR = 0;
	public static final int BLOCKED = 1;
	public static final int WIDTH = Game.screenSize.width / 40;
	public static final int HEIGHT = (Game.screenSize.height+ 20 ) / 40;
	public static final int TILE_SIZE = 40;
	public Color color = new Color(232, 190, 91);
	public static int[][] data = new int[WIDTH][HEIGHT];
	public ArrayList<Rectangle> list = new ArrayList<Rectangle>();
	public boolean u = true;
	
	public Map(){
		
		for(int y = 0; y<HEIGHT; y++){
			//data[-1][y] = BLOCKED;
			//data[WIDTH][y] = BLOCKED;
			
		}
		for(int x = 0; x <WIDTH; x++){
			data[x][HEIGHT-4] = BLOCKED;

			if (x < WIDTH - 3) {
				data[x][HEIGHT - 8] = BLOCKED;
			}
		}
			
	}
		
	
	
	public void rec(){
		if(u){
			for(int x = 0; x < WIDTH; x++){
				for(int y = 0; y<HEIGHT; y++){
		if(data[x][y] == BLOCKED){

		Rectangle r = new Rectangle(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
		list.add(r);
			}
		}
			}
		u = false;
		}
	}
	
	public void draw(Graphics g){
		
		for(int x = 0; x < WIDTH; x++){
			for(int y = 0; y<HEIGHT; y++){

				
				if(data[x][y] == BLOCKED){
					g.setColor(color);
					g.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
					g.setColor(Color.BLACK);
					g.drawRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
					}
				}
				
		
				
			}
		}
		

	public boolean blocked(float x, float y){
		return data[(int)x][(int)y] == BLOCKED;
	}

}
