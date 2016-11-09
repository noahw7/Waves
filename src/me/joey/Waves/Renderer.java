package me.joey.Waves;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Renderer {
	
	public static void setupDisplay() {
    	try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
	        Display.setTitle("Waves");
	        Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
    	
        glEnable(GL_TEXTURE_2D);
    	
        glMatrixMode(GL_PROJECTION);
        glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
	}
	
	public static void renderBlock(int x, int y, int size, int r, int g, int b) {
        glColor3f(r, g, b);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glTexCoord2f(1, 0);
        glTexCoord2f(1, 1);
        glTexCoord2f(0, 1);
        glEnd();
	}
	
	public static void prepareNextFrame() {
		glClear(GL_COLOR_BUFFER_BIT);
		Display.sync(60);
	}
	
	public static void cleanup() {
		Display.destroy();
	}

}
