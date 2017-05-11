package cas;

import java.math.BigDecimal;

import org.junit.Test;

import cas.func.CASNumber;
import cas.func.CASSum;
import cas.func.CASTerm;
import cas.func.CASTerm.Component;
import cas.func.CASVar;

public class TestCAS {
	@Test
	public void test() {
		System.out.println(
				new CASTerm(CASMath.decimalFrom(1), new Component[] {
						new Component(new CASSum(new CASTerm[] {
								new CASTerm(CASMath.decimalFrom(-1), new Component[] {
										new Component(new CASVar("b"), CASMath.decimalFrom(1))
								}),
								new CASTerm(CASMath.decimalFrom(1), new Component[] {
										new Component(new CASSum(new CASTerm[] {
												new CASTerm(CASMath.decimalFrom(1), new Component[] {
														new Component(new CASVar("b"), CASMath.decimalFrom(2))
												}),
												new CASTerm(CASMath.decimalFrom(-4), new Component[] {
														new Component(new CASVar("a"), CASMath.decimalFrom(1)),
														new Component(new CASVar("c"), CASMath.decimalFrom(1))
												})
										}), CASMath.decimalFrom(-1))
								}),
						}), CASMath.decimalFrom(1)),
						
						new Component(new CASTerm(CASMath.decimalFrom(2), 
								new Component[] {new Component(new CASVar("a"), CASMath.decimalFrom(1))
						}), CASMath.decimalFrom(-1))
				}));
	}
}
