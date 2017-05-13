package cas.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
public class BigRational implements Comparable<BigRational> {
	@Getter
	@NonNull
	private BigInteger numerator;

	@Getter
	@NonNull
	private BigInteger denominator;

	// Force static factory methods //

	public static BigRational build(long value) {
		return build(BigInteger.valueOf(value), BigInteger.ONE);
	}

	public static BigRational build(long numerator, long denominator) {
		return build(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
	}

	/**
	 * Static factory method for BigRational. Returns either cached BigRational
	 * or newly constructed one.
	 */
	public static BigRational build(@NonNull BigInteger numerator, @NonNull BigInteger denominator) {
		return new BigRational(numerator, denominator);
	}

	/**
	 * Create a BigRational from a string (e.g `-123/456`)
	 */
	public static BigRational build(String s) {
		String[] parts = s.split("/", 3);

		if (parts.length == 2)
			return build(new BigInteger(parts[0]), new BigInteger(parts[1]));
		else if (parts.length == 1)
			return build(new BigInteger(parts[0]), BigInteger.ONE);
		else
			throw new IllegalArgumentException("For input string: \"" + s + "\"");
	}

	private BigRational(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;

		// ensure denominator != 0
		if (denominator.equals(BigInteger.ZERO)) {
			throw new ArithmeticException("Denominator cannot be zero!");
		}

		// make lowest terms
		reduce();

		// ensure denominator is always positive
		if (denominator.compareTo(BigInteger.ZERO) < 0) {
			denominator = denominator.negate();
			numerator = numerator.negate();
		}
	}

	private void reduce() {
		BigInteger g = numerator.gcd(denominator);
		
		// if both are negative
		if(numerator.signum() == -1 && denominator.signum() == -1)
			g = g.negate();
		
		numerator = numerator.divide(g);
		denominator = denominator.divide(g);
	}

	@Override
	public String toString() {
		return new StringBuilder().append(numerator).append('/').append(denominator).toString();
	}

	@Override
	public int compareTo(BigRational o) {
		// cross multiply
		return this.numerator.multiply(o.denominator).compareTo(this.denominator.multiply(o.numerator));
	}

	public boolean isZero() {
		return numerator.signum() == 0;
	}

	public boolean isPositive() {
		return numerator.signum() > 0;
	}

	public boolean isNegative() {
		return numerator.signum() < 0;
	}

	public BigRational negate() {
		return build(numerator.negate(), denominator);
	}

	public BigRational abs() {
		return isNegative() ? negate() : this;
	}

	public BigRational reciprocal() {
		return build(denominator, numerator);
	}

	public BigRational add(BigRational o) {
		return build(this.numerator.multiply(o.denominator).add(this.denominator.multiply(o.numerator)),
				this.denominator.multiply(o.denominator));
	}

	public BigRational subtract(BigRational o) {
		return add(o.negate());
	}

	public BigRational multiply(BigRational o) {
		return build(o.numerator.multiply(this.numerator), o.denominator.multiply(this.denominator));
	}

	public BigRational divide(BigRational o) {
		return build(o.denominator.multiply(this.numerator), o.numerator.multiply(this.denominator));
	}

	public double doubleValue() {
		return new BigDecimal(numerator).divide(new BigDecimal(denominator), 32, RoundingMode.HALF_EVEN).doubleValue();
	}
}
