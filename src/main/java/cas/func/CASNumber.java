package cas.func;

import java.math.BigDecimal;

import lombok.NonNull;

public class CASNumber extends CASTerm {

	public CASNumber(@NonNull BigDecimal value) {
		super(value, null);
	}

	
	@Override
	public String toString() {
		return "NUM(" + getCoefficient().toString() + ")";
	}
}
