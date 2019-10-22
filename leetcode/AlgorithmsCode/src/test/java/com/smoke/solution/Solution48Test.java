package com.smoke.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Solution48Test {
	private static Solution48 s48;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		s48 = new Solution48();
	}

	@ParameterizedTest
	@CsvSource({
		"'[[1,2,3],[4,5,6],[7,8,9]]'", "'[[7,4,1],[8,5,2],[9,6,3]]'"
	})
	void testRotate(
			) {
		
		fail("Not yet implemented");
	}

}
