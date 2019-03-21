class A {
    int x = 0;
}

class B extends A {
    void exec() {
        System.out.println("A");
    }

    static void fa(A a) {
        ((B) a).exec();
    }

    public static void main(String[] args) {
        B.fa(new A());
        B.fa(new B());
    }
}