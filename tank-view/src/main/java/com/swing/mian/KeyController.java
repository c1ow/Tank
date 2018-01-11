package com.swing.mian;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import sun.net.www.content.audio.x_aiff;

/**
 * 
 * @author 11273
 * 按键控制
 */
public class KeyController extends KeyAdapter{
	
	private  int x;
	private  int y;
	
	public  void getXY(int x,int y) {
		System.err.println("=============");
		this.x=x;
		this.y=y;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			x-=5;
			break;
		case KeyEvent.VK_RIGHT:
			x+=5;
			break;
		case KeyEvent.VK_UP:
			y-=5;
			break;
		case KeyEvent.VK_DOWN:
			x+=5;
			break;
		default:
			System.err.println("按钮误触");
			break;
		}
	}

}
