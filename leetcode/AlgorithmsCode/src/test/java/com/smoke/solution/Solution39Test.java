package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.smoke.util.To2DIntegerArrayListArgumentConverter;
import com.smoke.util.ToIntArrayArgumentConverter;

class Solution39Test {
	static Solution39 s39;

	@BeforeAll
	static void setUpBeforeClass() throws Exception { 
		s39 = new Solution39();
	}

	@ParameterizedTest
	@CsvSource({
		"'[2, 3, 6, 7]', 7, '[[7],[2, 2, 3]]'",
		"'[2, 3, 5]', 8, '[[2, 2, 2, 2],[2, 3, 3],[3, 5]]'"
	})
//	@Test
	void test(
			@ConvertWith(ToIntArrayArgumentConverter.class) int[]candidates,
			int target,
			@ConvertWith(To2DIntegerArrayListArgumentConverter.class) List<List<Integer>> res
			) {
		List<List<Integer>> currRes = s39.combinationSum(candidates, target);
		assertTrue(currRes.containsAll(res) && res.containsAll(currRes), "solution39 failed");
	}

}
