package Oppgave1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Kjøring av oppgave 1

        Thread thread1 = new Thread(new Oppgave1.Oppgave1Thread(), "thread1");
        thread1.start();
    }
}