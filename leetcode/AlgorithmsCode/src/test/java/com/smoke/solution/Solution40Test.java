/**
 * 
 */
package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.smoke.util.converter.To2DIntegerArrayListArgumentConverter;
import com.smoke.util.converter.ToIntArrayArgumentConverter;

/**
 * @author Smoke
 *
 */
class Solution40Test {
	private static Solution40 s40;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s40 = new Solution40();
	}

	@ParameterizedTest
	@CsvSource({
		"'[10,1,2,7,6,1,5]', 8, '[[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]'",
		"'[3,1,3,5,1,1]', 8, '[[1,1,1,5],[1,1,3,3],[3,5]]'",
		"'[1]', 0, '[]'",
		"'[ ]', 1, '[]'"
	})
	void test(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[] candidates,
			int target,
			@ConvertWith(To2DIntegerArrayListArgumentConverter.class) List<List<Integer>> res
			) {
		List<List<Integer>> currRes = s40.combinationSum(candidates, target);
		assertTrue(currRes.containsAll(res) && res.containsAll(currRes));
	}

}
