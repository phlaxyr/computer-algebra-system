package cas.func;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.annotation.Nonnull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class CASTerm implements ICASFunc {
	@Getter
	private BigDecimal coefficient;
	private Component[] parts;
	
	public CASTerm(@Nonnull BigDecimal coefficient, @Nonnull Component[] parts) {
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
	@AllArgsConstructor
	public static class Component {
		private CASTerm base;
		private BigDecimal exponent;
		
		@Override
		public String toString() {
			return base.toString() + "^" + exponent;
		}
	}
}
