package Oppgave2;

import static Oppgave2.BelteBand.rand;

public class Kokk extends Thread {

    private final BelteBand belteband;
    private int nummer;

    public Kokk(BelteBand belteband, int nummer) {
        this.nummer = nummer;
        this.belteband = belteband;
    }

    public void run() {
        while (true) {
            try {
                sleep(rand);
            } catch (InterruptedException e) {
            }
            belteband.addBurger(this, new Burger());
            nummer++;
        }
    }

}
