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
class Solution88Test {
	private static Solution88 s88;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s88 = new Solution88();
	}

	/**
	 * Test method for {@link com.smoke.solution.Solution88#merge(int[], int, int[], int)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"'[1,2,3]', 3, '[]', 0, '[1,2,3]'",
		"'[0,0,0]', 0, '[1,2,3]', 3, '[1,2,3]'",
		"'[]', 0, '[]', 0, '[]'",
		"'[1,2,3,0,0,0]', 3, '[2,5,6]', 3, '[1,2,2,3,5,6]'",
		"'[2,5,6,0,0,0]', 3, '[1,2,3]', 3, '[1,2,2,3,5,6]'"
	})
	void testMerge(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] nums1,
			int m,
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] nums2,
			int n,
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] except
			) {
		s88.merge(nums1, m, nums2, n);
		assertArrayEquals(nums1, except, "solution88 faild: " + Arrays.toString(nums1) + " doesn't equal " + Arrays.toString(except));
	}

}
