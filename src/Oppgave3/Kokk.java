package Oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;


class Kokk extends Thread {

    public static int rand = ThreadLocalRandom.current().nextInt(2000, 6000);
    public static int burger = 1;
    private final BlockingQueue<Integer> burgerListe;
    public int LIMIT = 5;
    public Kokk(BlockingQueue<Integer> sharedQueue) {
        this.burgerListe = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
            }

            while (burgerListe.size() >= LIMIT) {
                System.out.println("### " + Thread.currentThread().getName() + " er klar med burger, men belteband er full. Venter!" + " ###");
                try {
                    Thread.sleep(rand);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                burgerListe.put(burger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("### " + Thread.currentThread().getName() + " legger pa " + "burger (" + burger + ")" + " => " + burgerListe.toString() + " ###");
            burger++;
        }
    }
}
