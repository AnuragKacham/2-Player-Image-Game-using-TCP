/**
 * @author anurag kacham
 * @author vigneshwar jayakumar
 *
 */

 public class Test {

	public static void main(String args[]) {
		
		ProdCons matchBoxStorage = new ProdCons(500);
		
		new Producer(matchBoxStorage).start();
		new Consumer(matchBoxStorage).start();
	}
}
