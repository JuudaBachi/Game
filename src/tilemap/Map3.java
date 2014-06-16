package tilemap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Map3 {
	
	
	public static final int CLEAR = 0;
	public static final int BLOCKED = 1;
	public static final int WIDTH = 1440 / 40; //36
	public static final int HEIGHT = 920 / 40; //23
	public static final int TILE_SIZE = 40;
	public Color color = new Color(232, 190, 91);
	public static int[][] data = new int[WIDTH][HEIGHT];
	public ArrayList<Rectangle> list = new ArrayList<Rectangle>();
	public boolean u = true;
	
	public Map3(){
		
		for(int y = 0; y<HEIGHT; y++){
			//data[WIDTH - 29][y] = BLOCKED;
		}
		for(int x = 0; x <WIDTH; x++){
			if(x < WIDTH - 5){
				data[x][HEIGHT - 20] = BLOCKED;
			}
			data[x][HEIGHT - 3] = BLOCKED;
			if(x < WIDTH - 32){
				data[x][HEIGHT - 6] = BLOCKED;
			}
			if(x < WIDTH - 25 && x > 5){
				data[x][HEIGHT - 9] = BLOCKED;
			}
			if(x < WIDTH - 20 && x > 10){
				data[x][HEIGHT - 12] = BLOCKED;
			}
			if(x < WIDTH - 15 && x > 15){
				data[x][HEIGHT - 15] = BLOCKED;
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