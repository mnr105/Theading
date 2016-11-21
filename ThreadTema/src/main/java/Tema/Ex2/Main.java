package Tema.Ex2;

import java.io.IOException;


/**
 * Created by lluca on 17-Nov-16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String numeFis = "C:\\Users\\lluca\\IdeaProjects\\ThreadTema\\src\\main\\java\\Tema\\Ex2\\Input.txt";
        String numeFisOut = "C:\\Users\\lluca\\IdeaProjects\\ThreadTema\\src\\main\\java\\Tema\\Ex2\\Output.txt";
        ReadFrom rf = new ReadFrom();

        rf.functiaGenerala(numeFis);
        rf.numefis = numeFisOut;
        rf.nrThread = 4;
        rf.cursor2 = 0;
        // System.out.println("cursor inainte: " + rf.cursor2);
        for (int i = 0; i <= rf.nrThread - 1; i++) {
            Thread t = new Thread(rf);
            t.start();
        }
        // System.out.println("cursor dupa: " + rf.cursor2);
    }
}
