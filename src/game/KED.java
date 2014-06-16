package game;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import levels.LevelFive;
import levels.LevelFour;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;

public class KED implements KeyEventDispatcher {
	
	public KED(){
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		int code = e.getKeyCode();
		if(e.getID() == KeyEvent.KEY_PRESSED){
			if(code == KeyEvent.VK_RIGHT){
				LevelOne.player.Right();
				LevelTwo.player.Right();
				LevelThree.player.Right();
				LevelFour.player.Right();
				LevelFive.player.Right();
			}
			if(code == KeyEvent.VK_LEFT){
				LevelOne.player.Left();
				LevelTwo.player.Left();
				LevelThree.player.Left();
				LevelFour.player.Left();
				LevelFive.player.Left();
			}	
			if(code == KeyEvent.VK_UP){
				LevelOne.player.Jump();
				LevelTwo.player.Jump();
				LevelThree.player.Jump();
				LevelFour.player.Jump();
				LevelFive.player.Jump();
			}
			if(code == KeyEvent.VK_DOWN){
				if(LevelOne.player.inAir){
					LevelOne.player.inAir = false;
					LevelOne.player.yy=6;
				}
				if(LevelTwo.player.inAir){
					LevelTwo.player.inAir = false;
					LevelTwo.player.yy = 6;
				}
				if(LevelThree.player.inAir){
					LevelThree.player.inAir = false;
					LevelThree.player.yy = 6;
				}
				if(LevelFour.player.inAir){
					LevelFour.player.inAir = false;
					LevelFour.player.yy = 6;
				}
				if(LevelFive.player.inAir){
					LevelFive.player.inAir = false;
					LevelFive.player.yy = 6;
				}
			}
		}
		if(e.getID() == KeyEvent.KEY_RELEASED){
			if(code == KeyEvent.VK_RIGHT){
				LevelOne.player.Stop();
				LevelTwo.player.Stop();
				LevelThree.player.Stop();
				LevelFour.player.Stop();
				LevelFive.player.Stop();
			}
			if(code == KeyEvent.VK_LEFT){
				LevelOne.player.Stop();
				LevelTwo.player.Stop();
				LevelThree.player.Stop();
				LevelFour.player.Stop();
				LevelFive.player.Stop();
			}	
			if(code == KeyEvent.VK_UP){
				LevelOne.player.inAir = true;
				LevelTwo.player.inAir = true;
				LevelThree.player.inAir = true;
				LevelFour.player.inAir = true;
				LevelFive.player.inAir = true;
			}	
			if(code == KeyEvent.VK_DOWN){
				LevelOne.player.inAir = true;
				LevelTwo.player.inAir = true;
				LevelThree.player.inAir = true;
				LevelFour.player.inAir = true;
				LevelFive.player.inAir = true;
			}
			
		}
		return false;
	}

}
