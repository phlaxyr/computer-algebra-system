package cas.func;

import java.math.BigDecimal;

import javax.annotation.Nonnull;

public class CASNumber extends CASTerm {

	public CASNumber(@Nonnull BigDecimal value) {
		super(value, null);
	}

	
	@Override
	public String toString() {
		return "NUM(" + getCoefficient().toString() + ")";
	}
}
