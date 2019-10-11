/**
 * 
 */
package com.smoke.util;



import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 * @author Smoke
 *
 */
public class ToArrayListArgumentConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object input, Class<?> targetClass) throws ArgumentConversionException {
		if (!String.class.equals(targetClass)){
			throw new ArgumentConversionException("Cannot convert to " + targetClass.getName() + ": " + input);
		}

		return null;
	}
	
	/**
	 *	调试用
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		int arg[][] = {{7}, {2,2,3}};
//		
//		for(int[] arg1 : arg){
//			for(int i : arg1){
//				System.out.println(arg1.toString());
//			}
//		}
		
		System.out.println(int[].class.getName());

		
	}

}
