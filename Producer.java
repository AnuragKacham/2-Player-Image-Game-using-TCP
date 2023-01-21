/**
 * @author anurag kacham
 * @author vigneshwar jayakumar
 *
 */

public class Producer extends Thread {
	
	ProdCons match;

	Producer(ProdCons match) {
		
		this.match = match;
	
	}

	public void run() {
		
		try {
			
			 match.produce("match");
			 
		}
		
		catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}
}