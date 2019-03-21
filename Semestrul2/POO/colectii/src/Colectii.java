import java.util.ArrayList;
import java.util.Iterator;

interface Tip1 {
    public String getTip();

    public String toString();
}

class Intreg1 implements Tip1 {
    private int atribut;

    public Intreg1(int a) {
        atribut = a;
    }

    public String getTip() {
        return "Tip: " + "Intreg";
    }

    public String toString() {
        return "" + atribut;
    }
}

class Sir1 implements Tip1 {
    private String atribut;

    public Sir1(String a) {
        atribut = a;
    }

    public String getTip() {
        return "Tip: " + "String";
    }

    public String toString() {
        return "" + atribut;
    }
}

class Colectie1 implements Tip1 {
    private ArrayList<Tip1> colectie = new ArrayList<Tip1>();

    public String getTip() {
        String temp = "";
        for (Tip1 i : colectie)
            temp = temp + i.getTip();
        return temp;
    }

    public String toString() {
        Iterator<Tip1> it = colectie.iterator();
        String temp = "(";
        while (it.hasNext()) {
            Tip1 c = it.next();
            temp = temp + c + ", ";
        }
        temp = temp + ")";
        return temp;
    }

    public void adauga(Tip1 t) {
        colectie.add(t);
    }
}