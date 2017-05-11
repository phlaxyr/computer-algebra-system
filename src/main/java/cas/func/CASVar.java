package cas.func;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
public class CASVar implements ICASFunc {
	@Getter
	private String varname;

	public CASVar(@NonNull String varname) {
		this.varname = varname;
	}

	@Override
	public String toString() {
		return "VAR(" + varname + ")";
	}
}
