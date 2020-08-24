import javax.swing.JOptionPane;
public class Oppgave1 {


    public static class RunnableThread implements Runnable {

        private static boolean stopping = false;

        public synchronized void requestStop(){
            this.stopping = true;
        }

        public synchronized boolean isStoppingRequesting(){
            return stopping;
        }

        @Override
        public void run() {

            while(!stopping) {
                try{
                    Thread.sleep(3000);
                } catch (InterruptedException e){}

                String stop = "quit";
                String input = JOptionPane.showInputDialog("Skriv inn din melding, quit for å slutte",stop);
                System.out.println(input);

                if (input==null)
                {
                        //Error generated here
                        System.out.println("Du har trykket på Cancel");

                    requestStop();
                }


            if(input.equals(stop)){
                requestStop();
                }
            }
        }

    }
}