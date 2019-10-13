/**
 * 
 */
package com.smoke.util.converter;


import java.util.stream.Stream;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 *	用于Junit5 @ConvertWith 的类型转换器
 *	将类似"[1,2,3,4,5]"的字符串转换为int[]数组
 * 
 * @author Smoke
 *
 */
public class ToIntArrayArgumentConverter extends SimpleArgumentConverter {

	/**
	 * convert int[] string to int[]
	 */
	@Override
	public Object convert(Object input, Class<?> targetClass) throws ArgumentConversionException {
		input = ((String) input).replace(" ", "");
		if (!checkSource((String)input)){
			if(isEmptyArray((String)input)){
				return new int[0];
			}
			throw new ArgumentConversionException("candidates: \"" + input + "\" cannot convert to " + targetClass.getName() + ": ");
		}
			
		return Stream.of(((String)input).replace("[", "").replace("]", "").split(","))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
	
	/**
	 *	检查输入的字符串是否能够转化为数组
	 * 
	 * @param source
	 * @return
	 */
	private boolean checkSource(String source){
		return source.matches("^\\[([1-9]\\d*,?)+\\]$") ;
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
