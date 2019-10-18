/**
 * 
 */
package com.smoke.util;

import java.util.List;

/**
 * @author Smoke
 *
 */
public class ListsUtil {
	
	/**
	 *	判断两个List<T>内元素是否相等，顺序无关
	 * 
	 * @param <T>
	 * @param source
	 * @param expect
	 * @return
	 */
	public static <T> boolean listEqual(List<T> source, List<T> expect){
		return source.size() == expect.size() && source.containsAll(expect) && expect.containsAll(source);
	}
	
	/**
	 *	判断两个List<T>内元素是否按顺序相等
	 * 
	 * @param <T>
	 * @param source
	 * @param expect
	 * @return
	 */
	public static <T> boolean listEqualOrdered(List<T> source, List<T> expect){
		if(source.size() != expect.size()) return false;
		for(int i = 0; i < source.size(); i++){
			if(!source.get(i).equals(expect.get(i))) return false;
		}
		return true;
	}
}
