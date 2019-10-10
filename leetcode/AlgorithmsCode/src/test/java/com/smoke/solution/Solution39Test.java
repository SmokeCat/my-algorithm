package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

	@Test
	void test() {
		List<List<Integer>> currRes = s39.combinationSum(candidates, target);
		assertTrue(currRes.containsAll(res) && res.containsAll(currRes), "solution39 failed");
	}

}
