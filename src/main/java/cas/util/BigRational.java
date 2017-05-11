package cas.util;

import java.math.BigInteger;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class BigRational implements Comparable<BigRational> {
	@Getter
	private BigInteger numerator;

	@Getter
	private BigInteger denominator;

	// Force static factory methods //

	public static BigRational build(long value) {
		return build(BigInteger.valueOf(value), BigInteger.ONE);
	}

	/**
	 * Static factory method for BigRational. Returns either cached BigRational
	 * or newly constructed one.
	 */
	public static BigRational build(BigInteger numerator, BigInteger denominator) {
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
}
