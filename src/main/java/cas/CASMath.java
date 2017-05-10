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
	
	public static BigDecimal decimalFrom(double from) {
		return new BigDecimal(from, CASMath.getDecimalContext());
	}
}
