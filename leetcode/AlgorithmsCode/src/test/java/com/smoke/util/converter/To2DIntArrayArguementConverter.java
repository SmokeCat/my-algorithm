/**
 * 
 */
package com.smoke.util.converter;

import java.util.stream.Stream;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 * @author Smoke
 *
 */
public class To2DIntArrayArguementConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object input, Class<?> targetClass) throws ArgumentConversionException {
		input = ((String) input).replace(" ", "");
		if (!checkSource((String)input)){
			if(isEmptyArray((String)input)){
				return new int[0][];
			}
			throw new ArgumentConversionException("candidates: \"" + input + "\" cannot convert to " + targetClass.getName() + ": ");
		}

		return Stream.of(((String) input).replace("[[", "").replace("]]", "").split("],\\["))
				.map(row -> Stream.of(row.split(","))
					.mapToInt(Integer::parseInt).toArray()
					)
				.toArray(size -> new int[size][]);
	}

	/**
	 *	检查输入的字符串是否能够转化为二维数组
	 * 
	 * @param source
	 * @return
	 */
	private boolean checkSource(String source){
		return source.matches("^\\[(\\[((-?[1-9]\\d*|0),?)*\\],?)+\\]$") ;
	}	
	
	/**
	 *	检查输入的字符串是否是一个空数组
	 * 
	 * @param source
	 * @return
	 */
	private boolean isEmptyArray(String source){
		return source.matches("^\\[\\]$");
	}
}
