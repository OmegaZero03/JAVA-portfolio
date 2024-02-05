package com.beaystudio.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.beyastudio.main.Main;
import com.beyastudio.wolrd.Camera;

public class UI {

	public boolean dmg, attspd, spd, hp,orbG, orbI, orbF, crown, flower, beeCrab;
	private int countDmg, countSpd, countAttspd, countHp, countorbG, countorbI, countorbF, countCrown, countFlower,countbeeCrab;
	private int timepop = 50;
	private int x, y;
	
	public UI() {
		x = (Main.width / 2) - Camera.x - 20;
		y = 150;
		dmg = attspd = spd = hp = crown = orbG = orbI = orbF= flower= beeCrab =false;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x - 7, y, 50, 7);
		g.setColor(new Color(255, 0 ,255));
		g.fillRect(x - 7, y, (int)((Main.player.life/Main.player.maxLife)*50) , 7);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 8));
		g.drawString("HP", x - 5, y + 7);
		
		g.setFont(new Font("arial",Font.PLAIN, 8));
		String s = String.valueOf((int)Main.player.life);
		String ss = String.valueOf((int)Main.player.maxLife);
		g.drawString(s + "/" + ss, x + 12 , y + 7);
		
		//SansSerif
		g.setColor(new Color(0xffee3fbb));
		g.setFont(new Font("SansSerif",Font.BOLD, 8));
		if(Main.player.haveCrown) {
			g.drawString("dmg ▶ " + Main.player.dmg * 2, x - 55, y + 7);
		}else {
			g.drawString("dmg ▶ " + Main.player.dmg, x - 55, y + 7);
		}
		
		g.setColor(new Color(0xff6b3d38));
		String ssss = String.format("%.1f",Main.player.spd);
		g.drawString("Spd ▶ " + ssss, x - 55, y-141);
		g.setColor(new Color(0xffdae0ea));
		String sss = String.format("%.1f",Main.player.atackSpeed);
		g.drawString("attSpd ▶ " + sss, x +52 - 3, y+7);
		g.setColor(new Color(0xffaa00ff));
		String sssss = String.format("%.1f", Main.player.healling);
		g.drawString("LifeSteal ▶ " + sssss, x +52 - 7, y-141);
		
		if(dmg) {
			countDmg++;
			if(countDmg <= timepop) {
				g.setFont(new Font("arial",Font.BOLD, 11));
				g.setColor(new Color(0xffee3fbb));
				g.drawString("DMG UP", x - 45, y - 24);
			}else {
				dmg = false;
				countDmg = 0;
			}
		}else {
			countDmg = 0;
		}
		
		if(spd) {
			countSpd++;
			if(countSpd <= timepop) {
				g.setFont(new Font("arial",Font.BOLD, 11));
				g.setColor(new Color(0xff6b3d38));
				g.drawString("SPD UP", x - 35, y - 105);
			}else {
				spd = false;
				countSpd = 0;
			}
		}else {
			countSpd = 0;
		}
		
		if(attspd) {
			countAttspd++;
			if(countAttspd <= timepop) {
				g.setFont(new Font("arial",Font.BOLD, 11));
				g.setColor(new Color(0xffdae0ea));
				g.drawString("ATT SPD UP", x +35, y- 20);
			}else {
				attspd = false;
				countAttspd = 0;
			}
		}else {
			countAttspd = 0;
		}
		
		if(hp) {
			countHp++;
			if(countHp <= timepop) {
				g.setFont(new Font("arial",Font.BOLD, 11));
				g.setColor(new Color(255, 0 ,255));
				g.drawString("HP UP", x, y - 10);
			}else {
				hp = false;
				countHp = 0;
			}
		}else {
			countHp = 0;
		}
		
		if(crown) {
			countCrown++;
			if(countCrown <= timepop + 30) {
				g.setFont(new Font("arial",Font.BOLD, 12));
				g.setColor(new Color(0xff143464));
				g.drawString("2X DMG", x, y - 100);
			}else {
				crown = false;
				countCrown = 0;
			}
		}else {
			countCrown = 0;
		}
		
		if(flower) {
			countFlower++;
			if(countFlower <= timepop + 30) {
				g.setFont(new Font("arial",Font.BOLD, 12));
				g.setColor(new Color(0xffffd541));
				g.drawString("Better shots!", x -10, y - 100);
			}else {
				flower = false;
				countFlower = 0;
			}
		}else {
			countFlower = 0;
		}
		
		if(beeCrab) {
			countbeeCrab++;
			if(countbeeCrab <= timepop + 30) {
				g.setFont(new Font("arial",Font.BOLD, 12));
				g.setColor(new Color(0xff316de5));
				g.drawString("Orbs that block bullets", x -40, y - 100);
			}else {
				beeCrab = false;
				countbeeCrab = 0;
			}
		}else {
			countbeeCrab = 0;
		}
		
		
		
		if(orbG) {
			countorbG++;
			if(countorbG <= timepop + timepop + 40) {
				g.setFont(new Font("arial",Font.PLAIN, 12));
				g.setColor(new Color(0xff24523b));
				g.drawString("GRASS ORBITAL", x - 23, y - 120);
				g.setFont(new Font("arial",Font.PLAIN, 9));
				g.drawString("Great against Ice", x - 15, y - 105);
				g.drawString("Weak against Fire", x - 15, y - 90);
			}else {
				orbG = false;
				countorbG = 0;
			}
		}else {
			countorbG = 0;
		}
		
		if(orbI) {
			countorbI++;
			if(countorbI <= timepop + timepop + 40) {
				g.setFont(new Font("arial",Font.PLAIN, 12));
				g.setColor(new Color(0xff143464));
				g.drawString("ICE ORBITAL", x - 23, y - 120);
				g.setFont(new Font("arial",Font.PLAIN, 9));
				g.drawString("Great against Fire", x - 23, y - 105);
				g.drawString("Weak against Grass", x - 26, y - 90);
			}else {
				orbI = false;
				countorbI = 0;
			}
		}else {
			countorbI = 0;
		}
		
		if(orbF) {
			countorbF++;
			if(countorbF <= timepop + timepop + 40) {
				g.setFont(new Font("arial",Font.PLAIN, 12));
				g.setColor(new Color(0xfff9a31b));
				g.drawString("FIRE ORBITAL", x - 23, y - 120);
				g.setFont(new Font("arial",Font.PLAIN, 9));
				g.drawString("Great against Grass", x - 22, y - 105);
				g.drawString("Weak against Ice", x - 19, y - 90);
			}else {
				orbF = false;
				countorbF = 0;
			}
		}else {
			countorbF = 0;
		}
		
	}
}
