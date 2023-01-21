/**
 * @author anurag kacham
 * @author vigneshwar jayakumar
 *
 */

public class ProdCons {
	/**
	 * This class is used to simulate the producer consumer working.
	 */

	final int matchesCount = 90;
	final int maxMatchesConsumed = 50;
	final int matchBoxesCount = 9;
	int matchesProduced = 0;
	int matchBoxesProduced = 0;
	int currentMatches;
	int matchesTermination;


	// Default constructor for this class to assign the number of matches
	// so that when reached, the program would be terminated.
	public ProdCons(int numberOfMatchesToTerminateProgram) {
		this.matchesTermination = numberOfMatchesToTerminateProgram;
	}
	
	// synchronized block where only one 
	// producer thread can perform the execution
	synchronized void produce(String match) throws InterruptedException {
		
        while (true) {
            synchronized (this)
            {
            	
            	// condition to terminate the program
            	if (currentMatches == matchesTermination) {
            		notifyAll();
            		break;
            	}
            	
                while (matchesProduced == matchesCount && 
                		matchBoxesProduced == matchBoxesCount) wait();

                // current number of matches will be incremented if 
                // it doesn't equal max matches.
                if (matchesProduced < matchesCount) {
                	currentMatches++;
                	System.out.println("Producer matches - " + 
                	(++matchesProduced));
                }
                
                // current match box count will be incremented if it doesn't
                // equal max match boxes count.
                if (matchBoxesProduced < matchBoxesCount) {
                	System.out.println("Producer matchboxes - "
                            + (++matchBoxesProduced));
                }
                
                // the rest threads will be notified and
                // current thread will be put to sleep
                notify();

                Thread.sleep(100);
            }
        }
        System.out.println("Producer thread  has been terminated");
		
	}

	// synchronized block where only one consumer thread can perform execution.
	synchronized void consume() throws InterruptedException {
		
		while (true) {
			
            synchronized (this) {
            	
            	if (currentMatches == matchesTermination) {
            		notifyAll();
            		break;
            	}
            	
            	// consumer won't be able to produce any final product as
            	// no limited resources are met at that point, so will wait.
                while (matchesProduced < 50 || matchBoxesProduced == 0) wait();

                // one final product will be produced using below resources.
                matchesProduced -= 50;
                matchBoxesProduced -= 1;
                
                System.out.println("Consumer matches - fifty, "
                		+ "matchbox - one match box");
                
                notify();

                Thread.sleep(100);
            }
        }
		System.out.println("Cosumer thread has been termintaed.");

	}
}
