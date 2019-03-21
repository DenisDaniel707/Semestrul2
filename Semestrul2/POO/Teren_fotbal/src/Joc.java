public class Joc {
	private String e1, e2;
	private int g1, g2, o = 0, c = 0;

	public Joc(String nume1, String nume2) {
		e1 = nume1;
		e2 = nume2;
	}

	public String toString() {
		return e1 + " " + g1 + "-" + g2 + " " + e2 + "  Total out-uri:" + o + "  Total cornere:" + c;
	}

	public void simuleaza() {
		Minge m = new Minge(50, 25);
		int a;

		for (int i = 0; i < 1000; i++) {
			try {
				m.suteaza();
			} catch (Gol e) {
				a = m.getX();
				if (a == 0)
					g2++;
				else
					g1++;
			} catch (Corner e) {
				c++;
			} catch (Out e) {
				o++;
			}
		}
	}
}
