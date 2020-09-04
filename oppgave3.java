import java.util.LinkedList;
import java.util.concurrent.*;



public class oppgave3 {
	
	public static LinkedList<Integer> burgerListe = new LinkedList<>();
    public static Object lock = new Object();
    public static final int limit = 5;
    public static int antallburgere = 0;
    public static int fjernburger;
	
	public static void main(String[] args) throws Ecxeption {
		
		BlockingQueue queue = new ArrayBlockingQueue(1024);
		
		Kokk kokk = new kokk(queue);
		Servitor servitor = new servitor(queue);
		
		new thread().start();
		new thread().start();
		
		Thread.sleep(3000);
	}
	
	public class Kokk implements Runnable {
		
		protected BlockingQueue queue = null;
		
		public Kokk(BlockingQueue queue) {
			this.queue = queue;
		}
		
		public void run() {
			try {
				queue.put("1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public class Servitor implements Runnable {

		protected BlockingQueue queue = null;
		
		public Servitor(BlockingQueue queue) {
			this.queue = queue;
		}
		
		public void run() {
			try {
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
