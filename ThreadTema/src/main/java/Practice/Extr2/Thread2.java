package Practice.Extr2;

/**
 * Created by lluca on 14-Nov-16.
 */
public class Thread2 {

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F"};

        Shared s = new Shared(names);

        MyThread1 t1 = new MyThread1(s);
        MyThread2 t2 = new MyThread2(s);

        t1.start();
        t2.start();
    }
}
