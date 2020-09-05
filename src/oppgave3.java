import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.LinkedList;


public class oppgave3 {
	
	public static void main(String args[]) {
	    BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>(5);
	     
		 Thread kokk1 = new Thread(new Kokk(sharedQueue,1), "Kokk 1");
		 Thread kokk2 = new Thread(new Kokk(sharedQueue,1), "Kokk 2");
		 Thread kokk3 = new Thread(new Kokk(sharedQueue,1), "Kokk 3");
		 Thread servitor1 = new Thread(new Servitor(sharedQueue,1), "Servitør 1");
		 Thread servitor2 = new Thread(new Servitor(sharedQueue,1), "Setvitør 2");
		
		 kokk1.start();
		 kokk2.start();
		 kokk3.start();
		 servitor1.start();
		 servitor2.start();
		    }
	}

	class Kokk implements Runnable {

	    private final BlockingQueue<Integer> sharedQueue;
	    public static LinkedList<Integer> burgerListe = new LinkedList<>();
	    public static int rand = ThreadLocalRandom.current().nextInt(2000,3000);

	    public Kokk(BlockingQueue<Integer> sharedQueue,int threadNo) {
	        this.sharedQueue = sharedQueue;
	    }

	    @Override
	    public void run() {
	        for(int i=1; i<= 10; i++){
	            try {
	            	Thread.sleep(rand);
	                int number = i;
	                sharedQueue.put(number);
	                System.out.println(Thread.currentThread().getName() + " legger på hamburger " + number + " >> " + sharedQueue);    
	            } catch (Exception err) {
	                err.printStackTrace();
	            }
	        }
	    }
	}

	class Servitor implements Runnable{

	    private final BlockingQueue<Integer> sharedQueue;
	    public static LinkedList<Integer> burgerListe = new LinkedList<>();
	    public static int rand = ThreadLocalRandom.current().nextInt(2000,6000);
	    
	    public Servitor(BlockingQueue<Integer> sharedQueue,int threadNo) {
	        this.sharedQueue = sharedQueue;
	    }

	    @Override
	    public void run() {
	        while(true){
	            try {
	            	Thread.sleep(rand);
	                int num = sharedQueue.take();
	                System.out.println(Thread.currentThread().getName() + " tar av hamburger "+ num + " >> " + sharedQueue);
	            } catch (Exception err) {
	               err.printStackTrace();
	            }
	        }
	    }   
	}