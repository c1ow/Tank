package com.swing.mian;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import sun.print.resources.serviceui;

/**
 * 
 * @author 11273
 * 展示主界面
 */
public class TankWindow extends Frame{
	//图标初始坐标
	private  int x=50;
	private  int y=50;
	
	private	int zdw=20;
	private	int zdh=10;
	
	private int zdx;
	private int zdy;
	
	public static void main(String[] args) {
		new TankWindow().launchFrame();
	}
	
	@Override
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(color.RED);
		g.fillRect(x-10, y-11, 50, 50);
		g.setColor(color);
		
		g.setColor(color.black);
		g.fillRect(x+5, y+12, 50, 5);
		g.setColor(color);
		
		g.setColor(color.black);
		g.fillOval(x, y, 30, 30);
		g.setColor(color);
		
		g.setColor(color.black);
		g.fillOval(zdx, zdy, zdw, zdh);
		g.setColor(color);
		
		if (zdy>0 && zdx<600) {
			zdx+=5;
		}else{
			zdx=0;
			zdy=0;
		}
		
	}
	
	public void launchFrame() {
		this.setTitle("坦克移动");
		this.setLocation(600, 400);
		this.setSize(600, 400);
		this.setBackground(Color.white);
		//为关闭窗口添加响应
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		//设置是否允许改变窗口的大小
		this.setResizable(false);
		this.setVisible(true);
		new Thread(new TankMove()).start();;
		this.addKeyListener(new KeyController());
	}
	
	//图标移动
	private class TankMove implements Runnable{
		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				}catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
			
		}
	}
	
	public class KeyController extends KeyAdapter{
	
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
				y+=5;
				break;
			default:
				System.err.println("按钮误触");
				zdy=y;
				zdx=x;
				break;
			}
		}
	}
		

	
}
