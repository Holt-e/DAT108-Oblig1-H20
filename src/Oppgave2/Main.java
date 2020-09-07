package Oppgave2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BelteBand belteBand = new BelteBand();
        // denne lager en Thread for hver kokk og hver servitør

        Kokk threadkokk1 = new Kokk(belteBand, 1); threadkokk1.setName("kokk1");

        Kokk threadkokk2 = new Kokk(belteBand, 2); threadkokk2.setName("kokk2");

        Kokk threadkokk3 = new Kokk(belteBand, 3); threadkokk3.setName("kokk3");

        Servitor threadservitor1 = new Servitor(belteBand,1); threadservitor1.setName("servitor1");

        Servitor threadservitor2 = new Servitor(belteBand, 2);threadservitor2.setName("servitor2");

        //denne Starter alle trådene
        threadkokk1.start();
        threadkokk2.start();
        threadkokk3.start();
        threadservitor1.start();
        threadservitor2.start();


    }
}
