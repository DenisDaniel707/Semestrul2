
class Pereche {
    private int n;
    private Pereche p;

    public Pereche(int a, Pereche b) {
        n = a;
        p = b;
    }

    public void set(int a, Pereche b) {
        n = a;
        p = b;
    }

    public int getN() {
        return n;
    }

    public Pereche getP() {
        return p;
    }
}

public class maine {
    public static Pereche apelare(Pereche e, Pereche f) {
        f.set(17, e.getP());
        f = e;
        f.set(33, new Pereche(37, null));
        return new Pereche(19, new Pereche(29, null));
    }

    public static void main(String[] args) {
        Pereche x = new Pereche(43, new Pereche(83, null));
        Pereche y = new Pereche(97, new Pereche(100, null));
        Pereche z = x;
        x = apelare(x, y);
        System.out.println(z.getN());
        System.out.println(y.getP().getN());
    }
}