import java.util.*;

public class Colectie implements Tip {
	private ArrayList<Tip> colectie = new ArrayList<Tip>();

	public String getTip() {
		String temp = "";
		for (Tip i : colectie) {
			temp = temp + i.getTip();
		}
		return temp;
	}

	public String toString() {
		Iterator<Tip> it = colectie.iterator();
		String temp = "(";
		while (it.hasNext()) {
			Tip c = it.next();
			temp = temp + c.toString() + ",";
		}
		temp = temp + ")";
		return temp;
	}

	public void adauga(Tip t) {
		colectie.add(t);
	}

	public boolean equals(Object o) {
		if (o instanceof Colectie)
			return ((Colectie) o).colectie.equals(colectie);
		else
			return false;
	}
}
