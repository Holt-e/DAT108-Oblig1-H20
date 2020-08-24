public class Main {

    public static void main(String[] args){

        // Kjøring av oppgave 1
        Thread thread = new Thread( new Oppgave1.RunnableThread(),"thread1" );
        thread.start();

    }
}
