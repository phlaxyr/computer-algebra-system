package cas.func;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.annotation.Nonnull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
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
	public static class Component {
		@NonNull
		private CASTerm base;
		@NonNull
		private BigDecimal exponent;

		@Override
		public String toString() {
			return base.toString() + "^" + exponent;
		}
	}
}
