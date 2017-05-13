package cas.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBigRational {

	@Test
	public void testAdd() {
		// 1/2 + 1/3 = 5/6
		assertEquals(BigRational.build(5, 6), BigRational.build(1, 2).add(BigRational.build(1, 3)));
		
		// 1/2 + 1/2 = 1
		assertEquals(BigRational.build(1, 1), BigRational.build(1, 2).add(BigRational.build(1, 2)));
	}

}
