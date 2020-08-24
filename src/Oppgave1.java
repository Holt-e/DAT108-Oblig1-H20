import javax.swing.JOptionPane;
public class Oppgave1 {

    private String btnString1 = "Ok";
    private String btnString2 = "Cancel";
    public static volatile boolean running = true;

    public static class RunnableThread implements Runnable {
        @Override
        public void run() {

            while(running) {
                try{
                    Thread.sleep(3000);
                } catch (InterruptedException e){}

                String stop = "quit";
                String input = JOptionPane.showInputDialog("Skriv inn din melding, quit for å slutte",stop);
                System.out.println(input);
            if(input.equals(stop)){
                stopThread();
                }
            }
        }

    }

    public static void stopThread(){
      boolean running = false;
    }
}