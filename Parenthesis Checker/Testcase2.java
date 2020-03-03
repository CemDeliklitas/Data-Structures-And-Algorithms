public class HareketliToplar {
	public static void main(String[] args) {
		// set the scale of the coordinate system
		StdDraw.setCanvasSize(700, 700);
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		StdDraw.setScale(-1.0, 1.0);
		StdDraw.enableDoubleBuffering();
		double rk = 0.900, rj = 0.250; // initial position
		double vk = 0.015, vj = 0.017; // initial velocity
		double rx = 0.480, ry = 0.860; // initial position
		double vx = 0.015, vy = 0.017; // initial velocity
		double radius = 0.10; // radius
		while (true) {// main animation loop
			// bounce off wall according to law of elastic collision
			if (Math.abs(rx + vx) > 1.0 - radius)
				vx = -vx;
			if (Math.abs(ry + vy) > 1.0 - radius)
				vy = -vy;
			if (Math.abs(rk + vk) > 1.0 - radius)
				vk = -vk;
			if (Math.abs(rj + vj) > 1.0 - radius)
				vj = -vj;
			if (Math.sqrt ((rx-rk)*(rx-rk) + (ry-rj)*(ry-rj)) < (radius*2)) {
				vx = -vx;
				vy = -vy;
				vk = -vk;
				vj = -vj;
				
			}

			rx = rx + vx; // update position
			ry = ry + vy;
			rk = rk + vk;
			rj = rj + vj;
			StdDraw.clear(StdDraw.WHITE); // clear the background
			StdDraw.setPenColor(StdDraw.BLACK); // draw ball on the screen
			StdDraw.filledCircle(rx, ry, radius);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(rk, rj, radius);
			StdDraw.show(); // copy offscreen buffer to onscreen
			StdDraw.pause(20); // pause for 20 ms
		}
	}
}