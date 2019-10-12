/**
 * 
 */
package com.smoke.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
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
		input = ((String) input).replace(" ", "");
		if (!checkSource((String)input)){
			throw new ArgumentConversionException("Input: \"" + input + "\"" + " cannot convert to " + targetClass.getName() + ": ");
		}
		
		return Arrays.stream(((String)input).replace("[[", "").replace("]]", "").split("],\\["))
				.map(row -> Arrays.stream(row.split(","))
					.map(Integer::parseInt).collect(Collectors.toList())
					).collect(Collectors.toList());
	}

	/**
	 *	检查输入的字符串是否能够转化为二维数组
	 * 
	 * @param source
	 * @return
	 */
	private boolean checkSource(String source){
		return source.matches("^\\[(\\[([1-9]\\d*,)*[1-9]\\d*\\],)*\\[([1-9]\\d*,)*[1-9]\\d*\\]\\]$") ;
	}
}
