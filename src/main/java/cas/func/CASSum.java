package cas.func;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

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
