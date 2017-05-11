package cas.func;

import javax.annotation.Nonnull;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class CASVar implements ICASFunc {
	@Getter
	private String varname;

	public CASVar(@Nonnull String varname) {
		this.varname = varname;
	}

	@Override
	public String toString() {
		return "VAR(" + varname + ")";
	}
}
