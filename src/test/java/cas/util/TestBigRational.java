package cas.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBigRational {

	@Test
	public void testAdd() {
		// 1/2 + 1/3 = 5/6
		assertEquals(BigRational.build("5/6"), BigRational.build("1/2").add(BigRational.build("1/3")));

		// 1/2 + 1/2 = 1
		assertEquals(BigRational.build("1/1"), BigRational.build("1/2").add(BigRational.build("1/2")));

		BigRational b = BigRational.build("1/9");
		BigRational retn = BigRational.build(0);
		for (int i = 0; i < 9000; i++) {
			retn = retn.add(b);
		}
		assertEquals(BigRational.build("1000/1"), retn);
	}

	@Test
	public void testSubtract() {
		// 5/6 - 1/3 = 1/2
		assertEquals(BigRational.build(17, 24), BigRational.build(5, 6).subtract(BigRational.build(1, 8)));

		// 1 - 1/2 = 1/2
		assertEquals(BigRational.build(1, 2), BigRational.build(1, 1).subtract(BigRational.build(1, 2)));

	}

	@Test
	public void testMultiply() {
		// 1/2 * 1/3 = 1/6
		assertEquals(BigRational.build(93569, 420384), BigRational.build("-7/906").multiply(BigRational.build("-26734/928")));

		// 2/3 * 1/4 = 1/6
		assertEquals(BigRational.build(19, -4), BigRational.build("57/-3").multiply(BigRational.build("1/4")));

	}

	@Test
	public void testDivide() {
		assertEquals(BigRational.build("1/1"), BigRational.build("-1/1").divide(BigRational.build("-1/1")));
		
		assertEquals(BigRational.build("368956154146104041338487302204230/6842970045940769278989794312076920539427909963"), BigRational.build("12365452351254123654/-8706747200397588249059740289357").divide(BigRational.build("785938753984759/-29837659283745")));
	}
}
