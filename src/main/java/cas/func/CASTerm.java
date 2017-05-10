package cas.func;

import java.math.BigDecimal;

public class CASTerm implements ICASFunc {
	public CASTerm(BigDecimal coefficient, Component[] parts) {
		this.coefficient = coefficient;
		this.parts = parts;
	}

	public BigDecimal coefficient;
	public Component[] parts;
	
	public boolean isConstant() {
		return parts == null;
	}
	
	public class Component {
		public CASTerm base;
		public BigDecimal exponent;
	}
}
