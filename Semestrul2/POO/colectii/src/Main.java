public class Main {
	public static void main(String[] argv) {
		Colectie c = new Colectie();
		Colectie c2 = new Colectie();
		Colectie c3 = new Colectie();
		Intreg i1 = new Intreg(1);
		Intreg i2 = new Intreg(2);
		Intreg i3 = new Intreg(3);
		Intreg i4 = new Intreg(4);
		Sir s1 = new Sir("Sir 1");
		Sir s2 = new Sir("Sir 2");
		Sir s3 = new Sir("Sir 3");
		Sir s4 = new Sir("Sir 4");
		c.adauga(i1);
		c.adauga(i2);
		c.adauga(i3);
		c.adauga(i4);
		c.adauga(s1);
		c.adauga(s2);
		c2.adauga(c);
		c2.adauga(s3);
		c3.adauga(c2);
		c3.adauga(s4);
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c.equals(c2));
	}
}
