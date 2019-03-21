import java.util.Date;
import java.util.Random;

class Minge1 {
    private int x, y;
    private CoordinateGenerator1 o = new CoordinateGenerator1();

    public Minge1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void suteaza() throws Out1, Corner1, Gol1 {
        x = o.generateX();
        y = o.generateY();

        if (y == 0 || y == 50)
            throw new Out1();
        else if (x == 0 || x == 100)
            if (y >= 20 && y <= 30)
                throw new Gol1();
            else
                throw new Corner1();
    }
}

class Out1 extends Exception {

}

class Corner1 extends Exception {

}

class Gol1 extends Exception {

}

class Joc1 {
    private String e1, e2;
    private int g1, g2, o = 0, c = 0;

    public Joc1(String e1, String e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1 + " " + g1 + "-" + g2 + " " + e2 + "  Total out-uri:" + o + "  Total cornere:" + c;
    }

    public void simuleaza() {
        Minge1 m = new Minge1(50, 25);
        int a;
        for (int i = 0; i < 1000; i++) {
            try {
                m.suteaza();
            } catch (Gol1 e) {
                a = m.getX();
                if (a == 0)
                    g1++;
                else
                    g2++;
                m = new Minge1(50, 25);
            } catch (Corner1 e) {
                c++;
                a = m.getX();
                if (a == 0) {
                    if (m.getY() == 0) {
                        m = new Minge1(0, 0);
                    } else
                        m = new Minge1(0, 50);
                } else if (m.getY() == 0)
                    m = new Minge1(100, 0);
                else
                    m = new Minge1(100, 50);
            } catch (Out1 e) {
                o++;
                m = new Minge1(m.getX(), m.getY());
            }
        }
    }
}

class Fotbal {
    public static void main(String[] args) {
        Joc1 j = new Joc1("Steaua", "Dinamo");
        j.simuleaza();
        System.out.println(j);
    }
}

class CoordinateGenerator1 {
    private Random randomGenerator;

    public CoordinateGenerator1() {
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
    }

    public int generateX() {
        int x = randomGenerator.nextInt(101);
        if (x < 5) {
            x = 0;
        } else if (x > 95) {
            x = 100;
        } else {
            x = randomGenerator.nextInt(99) + 1;
        }
        return x;
    }

    public int generateY() {
        int y = randomGenerator.nextInt(101);
        if (y < 5) {
            y = 0;
        } else if (y > 95) {
            y = 50;
        } else {
            y = randomGenerator.nextInt(49) + 1;
        }
        return y;
    }
}