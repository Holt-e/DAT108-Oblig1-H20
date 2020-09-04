import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.LinkedList;
import java.util.Random;


//TODO: Fikse teller, slik at den teller +1 og ikke *2
//TODO: Fikse slik at servit�ren tar med seg burger
//TODO: Fikse kokk2, kokk3 og serivt�r 2


public class oppgave3 {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(4);
	public static LinkedList<Integer> burgerListe = new LinkedList<>();
	public static int rand = ThreadLocalRandom.current().nextInt(2000,6000);
	public static int antallburgere = 0;
	public static int fjernburger;
		
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					kokk1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					servitor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
		private static void kokk1() throws InterruptedException {
			
			while(true) {
				Thread.sleep(rand);
				int laget = ++antallburgere;
				queue.put(laget);
				
				burgerListe.add(antallburgere++);
				System.out.println("Kokk1 legger p� hamburger " + laget + " >> " + burgerListe);
			}
		}
		
		
		private static void servitor() throws InterruptedException {
			
			while(true) {
				Thread.sleep(rand);
					
					int servere = ;
					queue.take();
					
					fjernburger = burgerListe.remove(antallburgere--);
					System.out.println("Servitor1 tar av hamburger " + servere + " >> " + burgerListe);
				}
			}
		}
