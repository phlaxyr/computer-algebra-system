package cas.func;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.annotation.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

/**
 * A CASTerm is like a mathematical term; consisting of a coefficient, and one or more components. Each component 
 * consists of a base and an exponent; for example, in the following term: 
 * 
 *     6 * x^5 * y^3 * z^y
 * 
 * The coefficient is 6, and the three components are (x, 5), (y, 3), and (z, y). A term can also be used to show 
 * division; by using an ICASFunc as the base, and -1 as the exponent, fractions can be represented: 
 * 
 *     (x + 1) / (y + 1)   ->   TERM(1, [{SUM(x, 1), 1}, {SUM(y, 1), -1}])
 * 
 * @author eukaryote
 *
 */
@EqualsAndHashCode
public class CASTerm implements ICASFunc {
	@Getter
	private BigDecimal coefficient;
	
	@Nullable
	private Component[] parts;
	
	public CASTerm(@NonNull BigDecimal coefficient, Component[] parts) {
		this.coefficient = coefficient;
		this.parts = parts;
	}
	
	public boolean isConstant() {
		return parts == null;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("TERM(")
				.append(coefficient)
				.append(", ")
				.append(Arrays.toString(parts))
				.append(")")
				.toString();
	}
	
	@Data
	public static class Component {
		@NonNull
		private ICASFunc base;
		@NonNull
		private ICASFunc exponent;

		@Override
		public String toString() {
			return base.toString() + "^" + exponent;
		}
	}
}
