import java.util.ArrayList;

class Problema {

    protected double dificultate;

    public Problema() {
        dificultate = Math.random();
    }

}

abstract class Concurent {
    protected int nrRezolvate;
    protected int timp;
    protected double gradPregatire = Math.random();

    abstract void rezolvaProblema(Problema p);
}

class Incepator extends Concurent {

    void rezolvaProblema(Problema p) {
        if (gradPregatire > p.dificultate) {
            nrRezolvate++;
            if (p.dificultate > 0.5) {
                timp += (1 - gradPregatire) * 2000;
            } else {
                timp += (1 - gradPregatire) * 1000;
            }
        }
    }
}

class Experimentat extends Incepator {

    protected ArrayList<Concurs> concursuri = new ArrayList<Concurs>();

    public void rezolvaProblema(Problema p) {
        boolean ok = false;
        for (Concurs i : concursuri)
            if (i.verificaPb(p))
                ok = true;
        if (ok)
            timp = 0;
        else
            super.rezolvaProblema(p);
    }
}

abstract class Concurs {

    protected ArrayList<Concurent> concurenti = new ArrayList<Concurent>();
    protected ArrayList<Problema> probleme = new ArrayList<Problema>();
    protected int nrProbleme;

    public Concurs(int nrProbleme, ArrayList<Problema> probleme) {
        this.nrProbleme = nrProbleme;
        this.probleme = probleme;
    }

    public boolean verificaPb(Problema pb) {
        return probleme.contains(pb);
    }

    public Concurent getCastigator() {
        int aux = 0;
        Concurent temp = null;
        for (Concurent i : concurenti)
            if (i.nrRezolvate > aux) {
                aux = i.nrRezolvate;
                temp = i;
            } else if (i.nrRezolvate == aux) {
                if (i.timp < temp.timp)
                    temp = i;
            }
        return temp;
    }

    abstract public void start();
}

class Simplu extends Concurs {

    public Simplu(int nr, ArrayList<Problema> p) {
        super(nr, p);
    }

    public void start() {
        for (Concurent i : concurenti)
            for (Problema j : probleme)
                i.rezolvaProblema(j);
    }
}

class Regional extends Simplu {

    protected ArrayList<Concurs> subConcursuri = new ArrayList<Concurs>();

    public Regional(int nr, ArrayList<Problema> p, ArrayList<Concurs> sc) {
        super(nr, p);
        subConcursuri = sc;
    }

    public void start() {
        for (Concurs i : subConcursuri)
            i.start();
        super.start();
    }

    public void Castigatori() {
        ArrayList<Concurent> participanti = new ArrayList<Concurent>();
        for (Concurs i : subConcursuri) {
            participanti.add(i.getCastigator());
        }
    }
}