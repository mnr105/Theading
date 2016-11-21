package Tema.Ex2;

import java.io.*;
import java.util.*;

/**
 * Created by lluca on 17-Nov-16.
 */
public class ReadFrom implements Runnable {

    Thread t;
    String numefis;
    int nrThread;
    int cursor2;
    String[] splitatu;
    HashSet setu = new HashSet();

    public ReadFrom() throws IOException {
    }

    // citesc fisierul si fac lista cu toate cuvintele care apar in functie cu start si end
    public HashSet functiaGenerala(String input) throws IOException {
        // fisier in care scriu datele
       /* File name2 = new File(output);
        FileWriter out = new FileWriter(name2, true);*/

        //Fisier din care citesc datele
        File name = new File(input);
        FileReader in = new FileReader(name);

        // colectia in care adaug cuvintele citite din fisier
        // HashSet lista = new HashSet();

        // citesc si separ in fct de regex
        StringBuilder sb = new StringBuilder();
        int data = in.read();
        while (data != -1) {
            char dataChar = (char) data;
            sb.append(dataChar);
            data = in.read();
        }
        in.close();

        // parcurg string-ul rezultat pentru completarea HashSet-ului
        String regex = "([^a-zA-Z]+)'*\\1*";
        splitatu = sb.toString().split(regex);
        for (int i = 0; i < splitatu.length; i++) {
            setu.add(splitatu[i]);
        }

        // parcurg HashSet-ul pentru a obtine procentajul cuvintelor
      /*  for (Object i : lista) {
            int wordCount = 0;
            for (int j = 0; j < split.length; j++) {
                if (i.toString().equals(split[j]))
                    wordCount += 1;
            }

            double num = ((double) 100 / split.length) * ((double) wordCount);


            //trec in fisier
            out.append(i.toString() + " apare de aproximativ: " + String.format("%2f", num) + "% de ori\n");

            //scriu in fisier
            out.flush();
        }*/
        return setu;
    }

    // citesc din fisier si bag intr-un stringBuiler
    public String citFis(String input) throws IOException {
        File name = new File(input);
        FileReader in = new FileReader(name);
        StringBuilder sb = new StringBuilder();
        int data = in.read();
        while (data != -1) {
            char dataChar = (char) data;
            sb.append(dataChar);
            data = in.read();
        }
        in.close();
        return sb.toString();
    }


    // iar stringBuilder-ul si il regex-uiesc
    public String[] regexuirea(String citit) {
        String regex = "([^a-zA-Z]+)'*\\1*";
        String[] split = citit.split(regex);
        return split;
    }

    // fac HashSet-ul
    public HashSet dinVectStrInSet(String[] splitatu) {
        HashSet set = new HashSet();
        for (int i = 0; i < splitatu.length; i++) {
            set.add(splitatu[i]);
        }
        return set;
    }

    // ii fac procentul
    public void trecInFis(HashSet set, String[] split, String fisier, int start, int end) throws IOException {
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        cursor2 = cursor2 + 1;
        File name2 = new File(fisier);
        FileWriter out = new FileWriter(name2, true);
        Object[] ceva = set.toArray();
        for (int l = start; l <= end; l++) {
            int wordCount = 0;
            for (int j = 0; j < split.length; j++) {
                if (ceva[l].toString().equals(split[j]))
                    wordCount += 1;
            }
            double num = ((double) 100 / split.length) * ((double) wordCount);

            //trec in fisier
            out.append(ceva[l].toString() + " apare de aproximativ: " + String.format("%2f", num) + "% de ori\n");

            //scriu in fisier
            out.flush();
        }
    }

    public void run() {
        try {
            //System.out.println("cursor din run: " + cursor2);
            trecInFis(setu, splitatu, numefis, ((cursor2 * 100) / nrThread), ((cursor2 + 1) * 100) / nrThread);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        if (t == null) {
            t = new Thread(this);
            //System.out.println("a fost null si a pornit thread-ul: " + t.getName());
            t.start();
        } else {
            System.out.println("Exista Thread: " + t.getName());
            // System.out.println("cursor din start " + cursor2);
            t.start();
        }
    }
}
