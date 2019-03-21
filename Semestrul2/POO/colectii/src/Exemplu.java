abstract class A {
    protected int aField;

    public A() {
        aField = 3;
    }

    public int x() {
        return aField;
    }
}

class B extends A {
    protected int aField;

    public int x() {
        return 2;
    }
}

class Exemplu {
    public static void main(String[] args) {

        A a = new B();
        System.out.println(a.x());
    }
}