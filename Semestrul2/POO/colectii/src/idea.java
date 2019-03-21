class A {
    public void fun(String sir, int a) {
        System.out.println("A");
    }
}

class B extends A {
    public void fun(String sir, int a) {
        System.out.println("B");
    }
}

class idea {
    public static void main(String[] args) {
        A y = new B();
        y.fun(" ", 1);
    }
}