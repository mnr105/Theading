package Practice.Extr2;

/**
 * Created by lluca on 14-Nov-16.
 */
class MyThread1 extends Thread {
    Shared s;

    public MyThread1(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++)
            if (i % 2 == 0)
                try {
                    s.printOdd(i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }
}
