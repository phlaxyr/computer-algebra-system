package cas;

import java.math.BigDecimal;

import org.junit.Test;

import cas.func.CASNumber;
import cas.func.CASTerm;

public class TestCAS {
	@Test
	public void test() {
		System.out.println(new CASTerm(CASMath.decimalFrom(123), new CASTerm.Component[] {
				new CASTerm.Component(new CASNumber(CASMath.decimalFrom(321)), CASMath.decimalFrom(3))
		}));
	}
}
