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

import com.smoke.util.ListsUtil;
import com.smoke.util.converter.To2DIntegerArrayListArgumentConverter;

/**
 * @author Smoke
 *
 */
class Solution188Test {
	private static Solution188 s188;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s188 = new Solution188();
	}

	/**
	 * Test method for {@link com.smoke.solution.Solution188#generate(int)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"0, '[]'",
		"1, '[[1]]'",
		"5, '[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]'"
	})
	void testGenerate(
			int numRows,
			@ConvertWith(To2DIntegerArrayListArgumentConverter.class) List<List<Integer>> expect
			) {
		assertTrue(ListsUtil.listEqualOrdered(s188.generate(numRows), expect), "solution188 failed: " + s188.generate(numRows).toString() + " doesn't queal " + expect.toString());
	}

}
