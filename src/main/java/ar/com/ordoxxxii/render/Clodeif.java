package ar.com.ordoxxxii.render;

import processing.core.PApplet;

public class Clodeif extends PApplet {
	int w, h, ux, uy;
	float q;

	public static void main(String[] args) {
		PApplet.main("ar.com.ordoxxxii.render.Clodeif");
	}

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		w = width / 2;
		h = height / 2;
	}

	public void draw() {
		int t = 30;
		float j = TWO_PI / 205;
		int once = 11;
		
		background(237);
		drawCirclesAndLines(t, j, ux, uy, once);
		drawCenterDot(t);
		
		if (mousePressed) {
			gridSelector();
		} else {
			step(j);
		}

	}

	private void drawCenterDot(int t) {
		ellipse(w, h, t - 7, t - 7);
	}

	private void drawCirclesAndLines(int t, float j, int ux, int uy, int once) {
		stroke(3, 193);
		strokeWeight(1);
		noFill();
		for (int i = 0; i < once; i++) {
			int u = 33;
			int c = t + u * i;
			ellipse(w, h, c, c);
			c *= 0.5;
			u *= 0.5;
			drawConectedLines(j, ux, uy, once, i, u, c);
		}
	}

	private void drawConectedLines(float j, int ux, int uy, int once, int i, int u, int c) {
		for (float g = 0; (g < TWO_PI) && i != (once - 1); g += TWO_PI / (i * ux + uy)) {
			float o = j * (i + 1) * q;
			float l = g + o;
			line(cos(l) * c + w, sin(l) * c + h, cos(l + o * 2) * (c + u) + w, sin(l + o * 2) * (c + u) + h);
		}
	}

	private void gridSelector() {
		ux = (int) (map(mouseX, 0, w * 2, 1, 11));
		uy = (int) (map(mouseY, 0, h * 2, 0, 11));
		strokeWeight(0.5f);
		for (int i = 0; i < height; i += height / 11) {
			line(0, i, width, i);
		}
		for (int e = 0; e < width; e += width / 11) {
			line(e, 0, e, height);
		}

		printConfig(ux, uy);
	}

	private void printConfig(int ux, int uy) {
		textSize(27);
		fill(0);
		text(ux + " x " + uy, 10, 40);
	}

	private void step(float j) {
		q = (q + j);
	}

}
