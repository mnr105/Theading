package Tema.Ex1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lluca on 15-Nov-16.
 */
public class Operatii implements Runnable {

    private int[] vector;
    List vectLista = new ArrayList();
    List rezA = new ArrayList();
    private Thread t;

    public Operatii(List vectLista, List rezA) {
        this.vectLista = vectLista;
        this.rezA = rezA;
    }

    public List NumPrimTh(List deCalculat) {
        List rezA = new ArrayList();
        for (Object i : deCalculat) {
            int a = Integer.parseInt(i.toString());
            if (isPrime(a)) {
                rezA.add(a);
            }
        }
        return rezA;
    }

    public boolean isPrime(int n) {
        //check if n is a multiple of 2

        if (n % 2 == 0) {
            if ((n >= 0) && (n < 3))
                return true;
            else
                return false;
        }
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public void run() {
        List rezA = new ArrayList();
        rezA = NumPrimTh(this.vectLista);
        System.out.println(System.currentTimeMillis());
        for (Object i : rezA) {
            System.out.println(i.toString());
        }
        System.out.println();

    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            System.out.println("a pornit threadul: " + t.getName());
            t.start();
        }
    }
}