package cas.func;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

/**
 * A CASVar holds a variable name and should be equal to and have the same hashCode as any other CASVar with the same 
 * stored name. A CASVar should be immutable. 
 *  
 * @author eukaryote
 *
 */
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
