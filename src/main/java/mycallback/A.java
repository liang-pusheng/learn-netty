package mycallback;

public class A {

    private B b;

    public A(B b) {
        this.b = b;
    }

    public void a1() {
        b.bMethod(this);
    }

    public void aMethod() {
        System.out.println("a");
    }
}
