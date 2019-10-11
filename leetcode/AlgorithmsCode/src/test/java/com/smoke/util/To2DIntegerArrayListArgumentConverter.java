/**
 * 
 */
package com.smoke.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 *	用于Junit5 @ConvertWith 的类型转换器
 *	将类似"[[1,2],[3,4,5,6]]"的字符串转换成List<List<Integer>>对象
 * 
 * @author Smoke
 *
 */
public class To2DIntegerArrayListArgumentConverter extends SimpleArgumentConverter {

	
	/**
	 * convert int[][] string to List<List<Integer>>
	 */
	@Override
	public List<List<Integer>> convert(Object input, Class<?> targetClass) throws ArgumentConversionException {
//		if (!String.class.equals(targetClass)){
//			throw new ArgumentConversionException("Cannot convert to " + targetClass.getName() + ": " + input);
//		}
		
		return Arrays.stream(((String)input).split("],\\["))
			      .map(row -> row.replace("[[", "").replace("]]", ""))
			      .map(row -> Arrays.stream(row.split(","))
			        .map(Integer::parseInt).collect(Collectors.toList())
			      ).collect(Collectors.toList());
	}
}
