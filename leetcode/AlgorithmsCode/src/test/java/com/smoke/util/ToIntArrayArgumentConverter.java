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
 * @author Smoke
 *
 */
public class ToIntArrayArgumentConverter extends SimpleArgumentConverter {

	@Override
	public Object convert(Object input, Class<?> targetClass) throws ArgumentConversionException {
		if (!String.class.equals(targetClass)){
			throw new ArgumentConversionException("Cannot convert to " + targetClass.getName() + ": " + input);
		}
		
		List<Integer> list = Arrays.stream(((String)input).split(","))
				.map(row -> row.replace("[", "").replace("]", ""))
				.map(Integer::parseInt).collect(Collectors.toList());
		
		int[] arr = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			arr[i] = list.get(i);
		}
			
		return arr;
	}
	
	/**
	 *	调试用
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		String candidates = "2,3,6,7";
//		
//		List<Integer> list = Arrays.stream(candidates.split(","))
//				.map(row -> row.replace("[", "").replace("]", ""))
//				.map(Integer::parseInt).collect(Collectors.toList());
//		
//		int[] arr = new int[list.size()];
//		
//		for(int i = 0; i < list.size(); i++){
//			arr[i] = list.get(i);
//		}
//		
//		
//		System.out.println(list.getClass().getName());
//
//		System.out.println(arr.getClass().getName());
//		
//	}

}
