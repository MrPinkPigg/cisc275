package multLab;

public class Math {

	public static void main(String[] args) {}
	
	public static int mult(int multiplicand, int multiplior) {
		int product = 0;
		
		for(int i = 0; i < multiplior; i++){
			product += multiplicand;
		}
		
		return product;
	}

}
