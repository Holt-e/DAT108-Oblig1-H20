package Oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> burgerListe = new LinkedBlockingQueue<Integer>(5);

        Thread kokk1 = new Kokk(burgerListe);
        kokk1.setName("Kokk 1");
        Thread kokk2 = new Kokk(burgerListe);
        kokk2.setName("Kokk 2");
        Thread kokk3 = new Kokk(burgerListe);
        kokk3.setName("Kokk 3");
        Thread servitor1 = new Servitor(burgerListe);
        servitor1.setName("Servitor 1");
        Thread servitor2 = new Servitor(burgerListe);
        servitor2.setName("Setvitor 2");

        kokk1.start();
        kokk2.start();
        kokk3.start();
        servitor1.start();
        servitor2.start();
    }
}