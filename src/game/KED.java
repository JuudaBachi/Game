package game;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import entitys.Player;

public class KED implements KeyEventDispatcher {
	
	
	public KED(){
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		int code = e.getKeyCode();
		if(e.getID() == KeyEvent.KEY_PRESSED){
			if(code == KeyEvent.VK_RIGHT){
				Player.Right();
			}
			if(code == KeyEvent.VK_LEFT){
				Player.Left();
			}	
			if(code == KeyEvent.VK_UP){
				Player.Jump();
			}
			if(code == KeyEvent.VK_DOWN){
				if(Player.inAir){
					Player.inAir = false;
					Player.yy=6;
				}
			}
		}
		if(e.getID() == KeyEvent.KEY_RELEASED){
			if(code == KeyEvent.VK_RIGHT){
				Player.Stop();
				Player.facingRight = true;
			}
			if(code == KeyEvent.VK_LEFT){
			Player.Stop();
			Player.facingRight = false;
			}	
			if(code == KeyEvent.VK_UP){
			Player.inAir = true;
			}	
			if(code == KeyEvent.VK_DOWN){
			
					Player.inAir = true;
				
			}
			
		}
		return false;
	}

}
