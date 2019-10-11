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

class Solution39Test {
	static Solution39 s39;
	private static int[] candidates = {2,3,6,7};
	private static int target = 7;
//	private static int[] candidates = {2,3,5};
//	private static int target = 8;
	private static List<List<Integer>> res;

	@BeforeAll
	static void setUpBeforeClass() throws Exception { 
		s39 = new Solution39();
		res = new ArrayList<List<Integer>>();
		
		res.add(new ArrayList<Integer>(Arrays.asList(7)));
		res.add(new ArrayList<Integer>(Arrays.asList(2,2,3)));
//		res.add(new ArrayList<Integer>(Arrays.asList(2,2,2,2)));
//		res.add(new ArrayList<Integer>(Arrays.asList(2,3,3)));
//		res.add(new ArrayList<Integer>(Arrays.asList(3,5)));
	}

	@ParameterizedTest
	@CsvSource({
		"'[2,3,6,7]', 7, '[[7], [2, 2, 3]]'"
	})
//	@Test
	void test(
//			@ConvertWith() int[]candidates,
//			int target,
//			@ConvertWith(String2int.class) int[][] res
			) {
		List<List<Integer>> currRes = s39.combinationSum(candidates, target);
		assertTrue(currRes.containsAll(res) && res.containsAll(currRes), "solution39 failed");
	}

}
