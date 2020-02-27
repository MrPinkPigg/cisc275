package multLab;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {

	@Test
	public void testMult() {
		int product1 = Math.mult(2, 4);
		int product2 = Math.mult(8, 4);
		
		assertEquals(8, product1);
		assertEquals(32, product2);
	}

}
