package me.joey.Waves;

import org.lwjgl.opengl.Display;

public class Game {
	
	private static int x;
	private static int y;
	
	public static void start() {
		Renderer.setupDisplay();
		
		while(!Display.isCloseRequested()) {
			Renderer.prepareNextFrame();
		}
		
		Renderer.cleanup();
		
	}

}
