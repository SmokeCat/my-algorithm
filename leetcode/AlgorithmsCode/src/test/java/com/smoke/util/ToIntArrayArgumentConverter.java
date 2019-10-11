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

	@Override
	public Object convert(Object input, Class<?> targetClass) throws ArgumentConversionException {
//		if (!String.class.getName().equals(targetClass)){
//			throw new ArgumentConversionException("Cannot convert to " + targetClass.getName() + ": " + input);
//		}
		
		List<Integer> list = Arrays.stream(((String)input).split(","))
				.map(row -> row.replace("[", "").replace("]", ""))
				.map(Integer::parseInt).collect(Collectors.toList());
		
		int[] arr = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			arr[i] = list.get(i);
		}
			
		return arr;
	}
}
