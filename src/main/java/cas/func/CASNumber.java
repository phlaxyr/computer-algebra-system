package cas.func;

import java.math.BigDecimal;

import lombok.NonNull;

/**
 * A CASNumber is a special case of CASTerm where the exponents of all the components are zero. This is 
 * represented internally by setting the component array to null. A CASNumber is to be used in cases where a parameter 
 * could be an ICASFunc or a number; in cases where only a number is to be used, a BigDecimal or appropriate type 
 * should be used instead.
 * 
 * @author eukaryote
 *
 */
public class CASNumber extends CASTerm {

	public CASNumber(@NonNull BigDecimal value) {
		super(value, null);
	}

	
	@Override
	public String toString() {
		return "NUM(" + getCoefficient().toString() + ")";
	}
}
