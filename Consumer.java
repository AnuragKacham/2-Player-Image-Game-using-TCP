/**
 * @author anurag kacham
 * @author vigneshwar jayakumar
 *
 */

public class Consumer extends Thread {
	
	ProdCons match;
	
	Consumer(ProdCons match) {
		
		this.match = match;
		
	}
	
	public void run() {
		
		try {
			
			match.consume();
			
		}
		
		catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}	
}