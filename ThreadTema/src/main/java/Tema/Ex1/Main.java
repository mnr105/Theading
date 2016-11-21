package Tema.Ex1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lluca on 15-Nov-16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        int[] listaNumereRandom = {2, 3, 65, 3, 2, 5, 7, 8, 4, 3, 243, 676, 5, 331, 35, 2, 7, 9, 7};

        List tradus = new ArrayList();
        List tradus2 = new ArrayList();
        for (int i = 0; i < listaNumereRandom.length; i++) {
            tradus.add(listaNumereRandom[i]);
        }
        Operatii op = new Operatii(tradus.subList(0, tradus.size() / 2), tradus2);
        Operatii op2 = new Operatii(tradus.subList(tradus.size() / 2, tradus.size() - 1), tradus2);
        Operatii op0 = new Operatii(tradus, tradus2);

        op0.start();

      /*  Thread t1 = new Thread(op);
        t1.start();
        t1.join();
        Thread t2 = new Thread(op2);
        t2.start();
        t2.join();*/

    }
}
//output initial: 2 3 3 2 5 7 3 5 331 2 7 7