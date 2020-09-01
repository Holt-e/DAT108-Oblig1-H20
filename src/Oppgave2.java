import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Oppgave2{

    public static LinkedList<Integer> burgerListe = new LinkedList<>();
    public static Object lock = new Object();
    public static final int LIMIT = 5;
    public static int antallburgere = 0;
    public static int fjernburger;
    public static int rand = ThreadLocalRandom.current().nextInt(2000,6000);

    public static class Oppgave2Kokk1 implements Runnable {
        @Override
        public void run() {
            while (antallburgere != LIMIT) {
                try {
                Thread.sleep(rand);
                burgerListe.add(antallburgere++);
                    System.out.println("Kokk1 la til burger" + antallburgere);
            } catch (InterruptedException e){}



            }
        }
    }

    public static class Oppgave2Kokk2 implements Runnable {
        @Override
        public void run() {
            while (antallburgere != LIMIT) {
                try {
                    Thread.sleep(rand);
                } catch (InterruptedException e){}

                burgerListe.add(antallburgere++);
                System.out.println("Kokk2 la til burger" + antallburgere);

            }
        }
    }
    public static class Oppgave2Kokk3 implements Runnable {
        @Override
        public void run() {
            while (antallburgere != LIMIT) {
                try {
                    Thread.sleep(rand);
                } catch (InterruptedException e){}

                burgerListe.add(antallburgere++);
                System.out.println("Kokk3 la til burger" +antallburgere);

            }
        }
    }

    public static class Oppgave2Servitor1 implements Runnable {
        @Override
        public void run(){

        while (!burgerListe.isEmpty()) {
            fjernburger = burgerListe.remove(antallburgere--);
            System.out.println("Servitør1 tar av hamburger " + burgerListe);
                    }
                }
            }

    public static class Oppgave2Servitor2 implements Runnable {
        @Override
         public void run(){

            while (!burgerListe.isEmpty()) {
                fjernburger = burgerListe.remove(antallburgere--);
                System.out.println("Servitør2 tar av hamburger " + burgerListe);
                }
             }
        }

}
    

