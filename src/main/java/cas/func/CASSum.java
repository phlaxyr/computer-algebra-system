package cas.func;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class CASSum implements ICASFunc {
	@Getter
	private CASTerm[] terms;
	
	@Override
	public String toString() {
		return "SUM" + Arrays.toString(terms);
	}
}
