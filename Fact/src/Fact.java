
public class Fact {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		System.out.println(fact(n));
		
	}
	private static int fact(int n){	
		if (n == 0)
			return 1;
		else
			return n*fact(n-1);
	}
}
