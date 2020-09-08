package Oppgave2;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class BelteBand {

    public static LinkedList<Burger> burgerListe = new LinkedList<>();
    public static final int LIMIT = 5;
    public static int rand = ThreadLocalRandom.current().nextInt(2000,6000);


        public void addBurger(Kokk kokk, Burger burger) {
            synchronized (this) {

                if (burgerListe.size() >= LIMIT) {
                    System.out.printf("### "+Thread.currentThread().getName() + " er klar med hamburger, men belteband er full. Venter!" +" ###\n");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    notify();
                    System.out.printf("### "+Thread.currentThread().getName()+ " legger pa burger" + burger + " => "+ burgerListe+ " ###\n");
                    burgerListe.add(burger);

                }
            }
        }

        public void removeBurger(Servitor servitor) {

            synchronized (this) {
                if (burgerListe.size() == 0) {
                    System.out.printf("### "+Thread.currentThread().getName() + " vil ta en hamburger, men beltebandet er tom. Venter!" +" ###\n");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    notify();
                    Burger burger = burgerListe.remove();
                    System.out.printf("### "+ Thread.currentThread().getName()+" tar av burgere" +burger + " <= " + burgerListe+ " ###\n");

                }
            }
        }
}
    

