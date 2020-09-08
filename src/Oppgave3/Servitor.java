package Oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

class Servitor extends Thread {

    public static int rand = ThreadLocalRandom.current().nextInt(2000, 6000);
    private final BlockingQueue<Integer> burgerListe;

    public Servitor(BlockingQueue<Integer> sharedQueue) {
        this.burgerListe = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            while (burgerListe.size() == 0) {
                System.out.println("### " + Thread.currentThread().getName() + " vil ta en hamburger, men belteband er tom. Venter!" + " ###");
                try {
                    Thread.sleep(rand);
                } catch (InterruptedException e) {
                }

            }

            try {
                int num = burgerListe.take();
                System.out.println(Thread.currentThread().getName() + " tar av hamburger " + num + " >> " + burgerListe + " ###");
                Thread.sleep(rand);
            } catch (InterruptedException e1) {
            }
        }
    }
}
