package com.beyastudio.main;

import java.applet.Applet;
import java.applet.AudioClip;

@SuppressWarnings("removal")
public class Sound {

	private AudioClip clip;
	
	public static final Sound musicBackground = new Sound("/music.wav"),
							hurtPlayer = new Sound("/hurt_player.wav"),
							shootPlayer = new Sound("/shoot_player.wav"),
							diedPlayer = new Sound("/PLAYER_DIED.wav"),
							bossDied = new Sound("/BOSS_DIED.wav"),
							bossHurt = new Sound("/boss_hurt.wav"),
							powerUp = new Sound("/powerUp.wav"),
							menuChange = new Sound("/menu_change.wav"),
							menuSelect = new Sound("/menu_select.wav"),
							mainMusic = new Sound("/music.wav");
							
	
	private Sound(String name) {
		
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		}catch(Throwable e) {}
	}
	
	
	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		}catch(Throwable e) {}
		
	}
	
	public void loop() {
		try {
			new Thread() {
				@SuppressWarnings("deprecation")
				public void run() {
					clip.loop();
				}
			}.start();
		}catch(Throwable e) {}
		
	}
	
}
