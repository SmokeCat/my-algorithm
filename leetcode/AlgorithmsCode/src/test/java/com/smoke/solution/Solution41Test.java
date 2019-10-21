/**
 * 
 */
package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.smoke.util.converter.ToIntArrayArgumentConverter;

/**
 * @author Smoke
 *
 */
class Solution41Test {
	private static Solution41 s41;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s41 = new Solution41();
	}

	@ParameterizedTest
	@CsvSource({
		"'[]', 1",
		"'[1, 2, 0]', 3",
		"'[3, 4, -1, 1]', 2",
		"'[7, 8, 9, 10, 11]', 1",
		"'[1]', 2"
	})
	void testFirstMissingPositive(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] nums,
			int expect
			) {
		assertEquals(expect, s41.firstMissingPositive(nums), "solution41 failed: nums = " + Arrays.toString(nums));
	}

}
