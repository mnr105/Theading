package Practice.Extr2;

/**
 * Created by lluca on 14-Nov-16.
 */
class Shared {
    String[] names;

    boolean conditionVar = false;

    public Shared(String[] names2) {
        this.names = names2;
    }

    synchronized void printOdd(int v) throws InterruptedException {
        while (conditionVar) {
            System.out.println("waiting in printOdd " + v);
            wait();
        }
        conditionVar = true;
        System.out.println(names[v]);
        System.out.println("notifing from printOdd " + v);
        notify();
    }

    synchronized void printEven(int v) throws InterruptedException {
        while (!conditionVar) {
            System.out.println("waiting in printEven " + v);
            wait();
        }
        conditionVar = false;
        System.out.println(names[v]);
        System.out.println("notifing from printEven " + v);
        notify();
    }
}
