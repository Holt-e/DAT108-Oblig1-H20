package Oppgave2;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class BelteBand {

    public static final int LIMIT = 5;
    public static LinkedList<Burger> burgerListe = new LinkedList<>();
    public static int rand = ThreadLocalRandom.current().nextInt(2000, 6000);


    public void addBurger(Kokk kokk, Burger burger) {
        synchronized (this) {

            if (burgerListe.size() >= LIMIT) {
                System.out.println("### " + Thread.currentThread().getName() + " er klar med burger, men belteband er full. Venter!" + " ###");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                notify();
                System.out.println("### " + Thread.currentThread().getName() + " legger pa burger " + burger + " => " + burgerListe + " ###");
                burgerListe.add(burger);

            }
        }
    }

    public void removeBurger(Servitor servitor) {

        synchronized (this) {
            if (burgerListe.size() == 0) {
                System.out.println("### " + Thread.currentThread().getName() + " vil ta en burger, men beltebandet er tom. Venter!" + " ###");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                notify();
                Burger burger = burgerListe.remove();
                System.out.println("### " + Thread.currentThread().getName() + " tar av burger " + burger + " <= " + burgerListe + " ###");

            }
        }
    }
}
    

