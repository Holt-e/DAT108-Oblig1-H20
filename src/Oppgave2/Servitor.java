package Oppgave2;
import Oppgave2.BelteBand;
import static Oppgave2.BelteBand.rand;

public class Servitor extends Thread{

    private final BelteBand beltebånd;
    private int nummer;

    public Servitor(BelteBand beltebånd,int nummer) {
        this.nummer = nummer;
        this.beltebånd = beltebånd;
    }
        public void run(){
            while(true) {
                try{
                    sleep(rand);
                }catch(InterruptedException e){}
                beltebånd.removeBurger(this);
                nummer--;
            }
        }

    @Override
    public String toString() {
        return "Servitor " + nummer;
    }

}
