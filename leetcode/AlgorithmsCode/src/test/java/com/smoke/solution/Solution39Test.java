package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.smoke.util.ListsUtil;
import com.smoke.util.converter.To2DIntegerArrayListArgumentConverter;
import com.smoke.util.converter.ToIntArrayArgumentConverter;

class Solution39Test {
	private static Solution39 s39;

	@BeforeAll
	static void setUpBeforeClass() throws Exception { 
		s39 = new Solution39();
	}

	@ParameterizedTest
	@CsvSource({
		"'[2, 3, 6, 7]', 7, '[[7],[2, 2, 3]]'",
		"'[2, 3, 5]', 8, '[[2, 2, 2, 2],[2, 3, 3],[3, 5]]'",
		"'[1]', 0, '[]'",
		"'[ ]', 1, '[]'"
	})
//	@Test
	void test(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[]candidates,
			int target,
			@ConvertWith(To2DIntegerArrayListArgumentConverter.class) List<List<Integer>> res
			) {
		List<List<Integer>> currRes = s39.combinationSum(candidates, target);
		assertTrue(ListsUtil.listEqual(currRes, res), "solution39 failed： " + currRes.toString() + " doesn't equal " + res.toString());
	}

}
