package cas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CASMath {
	private CASMath() { throw new AssertionError(); }
	
	private static final MathContext DECIMAL_CONTEXT = new MathContext(100, RoundingMode.HALF_EVEN);
	
	public static MathContext getDecimalContext() {
		return DECIMAL_CONTEXT;
	}
}
