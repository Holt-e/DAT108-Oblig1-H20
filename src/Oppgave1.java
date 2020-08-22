import javax.swing.JOptionPane;
public class Oppgave1 {
public static volatile boolean running = true;

    public static class RunnableThread implements Runnable {
        @Override
        public void run() {

            while(running) {
                String input = JOptionPane.showInputDialog("Skriv inn din melding, quit for å slutte");
                System.out.println(input);
            }
        }

    }

    public void stopThread(){
      boolean running = false;
    }
}