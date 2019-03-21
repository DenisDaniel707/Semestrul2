public class Intreg implements Tip {
	private int a;

	public Intreg(int a) {
		this.a = a;
	}

	public String getTip() {
		return "Tip: " + "Intreg";
	}

	public String toString() {
		return a + " ";
	}
}
