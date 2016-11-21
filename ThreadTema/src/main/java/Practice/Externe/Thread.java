package Practice.Externe;

/**
 * Created by lluca on 14-Nov-16.
 */
class MyThread extends Thread {
    String name;

    public MyThread(String n) {
        this.name = n;
    }

    @Override
    public void run() {
        synchronized (Thread1.names) {
            for (int it = 0; it < Thread1.names.length; it++) {

                if (name.equals("t1")) {
                    if (it == 1)
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    Thread1.names[it] = Thread1.names[it].concat("1");
                }

                if (name.equals("t2")) {
                    System.out.println("t2: " + Thread1.names[it]);
                }
            }
        }
    }
}

