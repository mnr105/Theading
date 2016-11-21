package Practice.Externe;

/**
 * Created by lluca on 14-Nov-16.
 */
public class Thread1 {
    static String[] names = {"A", "B", "C", "D", "E"};

    public static void main(String arg[]) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");

        t1.start();
        t2.start();
    }

}
