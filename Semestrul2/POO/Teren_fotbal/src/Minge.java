public class Minge {
	private int x, y;
	private CoordinateGenerator o = new CoordinateGenerator();

	public Minge(int a, int b) {
		x = a;
		y = b;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void suteaza() throws Corner, Gol, Out {
		x = o.generateX();
		y = o.generateY();

		if (y == 0 || y == 50)
			throw new Out();
		else if (x == 0 || x == 100)
			if (y >= 20 && y <= 30)
				throw new Gol();
			else
				throw new Corner();
	}
}
