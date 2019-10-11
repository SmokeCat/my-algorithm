/**
 * 
 */
package com.smoke.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 *	用于Junit5 @ConvertWith 的类型转换器
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
		if (!String.class.equals(targetClass)){
			throw new ArgumentConversionException("Cannot convert to " + targetClass.getName() + ": " + input);
		}
		
		return Arrays.stream(((String)input).split("],\\["))
			      .map(row -> row.replace("[[", "").replace("]]", ""))
			      .map(row -> Arrays.stream(row.split(","))
			        .map(Integer::parseInt).collect(Collectors.toList())
			      ).collect(Collectors.toList());
	}
//	
//	/**
//	 *	调试用
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args) {
////		int arg[][] = {{7}, {2,2,3}};
////		
////		for(int[] arg1 : arg){
////			for(int i : arg1){
////				System.out.println(arg1.toString());
////			}
////		}
//		
//		String s = "[[7],[2,2,3]]";
//
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		
//		res.add(new ArrayList<Integer>(Arrays.asList(7)));
//		res.add(new ArrayList<Integer>(Arrays.asList(2,2,3)));
//		
//		System.out.println(Arrays.stream(s.split("],\\["))
//			      .map(row -> row.replace("[[", "").replace("]]", ""))
//			      .map(row -> Arrays.stream(row.split(","))
//			        .map(Integer::parseInt).collect(Collectors.toList())
//			      ).collect(Collectors.toList()));
//	}

}
