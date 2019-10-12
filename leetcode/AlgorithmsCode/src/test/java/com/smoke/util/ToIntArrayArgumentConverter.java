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
			throw new ArgumentConversionException("Input: \"" + input + "\"" + " cannot convert to " + targetClass.getName() + ": ");
		}
		
		List<Integer> list = Arrays.stream(((String)input).replace("[", "").replace("]", "").split(","))
				.map(Integer::parseInt).collect(Collectors.toList());
		
		int[] arr = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			arr[i] = list.get(i);
		}
			
		return arr;
	}
	
	/**
	 *	检查输入的字符串是否能够转化为数组
	 * 
	 * @param source
	 * @return
	 */
	private boolean checkSource(String source){
		return source.matches("^\\[([1-9]\\d*,)*[1-9]\\d*\\]$") ;
	}
}
