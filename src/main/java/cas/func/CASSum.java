package cas.func;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

/**
 * A CASSum is a sum of multiple terms. This can be used to represent a polynomial, for instance. Subtraction is 
 * represented as negative coefficients in terms. 
 * 
 * @author eukaryote
 *
 */
@EqualsAndHashCode
@AllArgsConstructor
public class CASSum implements ICASFunc {
	@Getter
	@NonNull
	private CASTerm[] terms;
	
	@Override
	public String toString() {
		return "SUM" + Arrays.toString(terms);
	}
}
