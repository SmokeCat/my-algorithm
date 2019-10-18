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
class Solution53Test {
	private static Solution53 s53;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s53 = new Solution53();
	}

	@ParameterizedTest
	@CsvSource({
//		"'[-2,1,-3,4,-1,2,1,-5,4]', 6",
		"'[-2,-3,-1]', -1"
	})
	void test(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] nums,
			int expect
			) {
		assertEquals(expect, s53.maxSubArray(nums), "solution53 failed: " + expect + " doesn't euqal " + s53.maxSubArray(nums));
	}

}
