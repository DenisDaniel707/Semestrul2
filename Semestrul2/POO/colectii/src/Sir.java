public class Sir implements Tip {
	private String s;

	public Sir(String s) {
		this.s = s;
	}

	public String getTip() {
		return "Tip: " + "Sir";
	}

	public String toString() {
		return s + " ";
	}
}
