public class Main {

    public static void main(String[] args){

        // Kjøring av oppgave 1

        // Thread thread1 = new Thread( new Oppgave1.Oppgave1Thread(),"thread1" );
        // thread1.start();

        //Kjøring av oppgave 2, denne lager en Thread for hver kokk og hver servitør

        Thread threadkokk1 = new Thread (new Oppgave2.Oppgave2Kokk1(),"kokk1");
        threadkokk1.start();

        Thread threadkokk2 = new Thread (new Oppgave2.Oppgave2Kokk2(),"kokk2");
        threadkokk2.start();

        Thread threadkokk3 = new Thread (new Oppgave2.Oppgave2Kokk3(),"kokk3");
        threadkokk3.start();

        Thread threadservitor1 = new Thread (new Oppgave2.Oppgave2Servitor1(),"servitør1");
        threadservitor1.start();

        Thread threadservitor2 = new Thread (new Oppgave2.Oppgave2Servitor2(),"servitør2");
        threadservitor2.start();


    }
}
