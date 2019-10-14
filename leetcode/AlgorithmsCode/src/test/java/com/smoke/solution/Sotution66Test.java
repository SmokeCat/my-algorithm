/**
 * 
 */
package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.smoke.util.converter.ToIntArrayArgumentConverter;

/**
 * @author Smoke
 *
 */
class Sotution66Test {
	private static Sotution66 s66;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s66 = new Sotution66();
	}

	@ParameterizedTest
	@CsvSource({
		"'[1,2,3]', '[1,2,4]'",
		"'[1,2,3,4]', '[1,2,3,5]'",
		"'[1,2,3,9]', '[1,2,4,0]'",
		"'[1,9,9,9]', '[2,0,0,0]'",
		"'[9,9,9,9]', '[1,0,0,0,0]'",
	})
	void test(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] digits,
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] expected 
			) {
		assertArrayEquals(expected, s66.plusOne(digits), "solution39 failed");
	}

}
