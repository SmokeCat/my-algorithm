/**
 * 
 */
package com.smoke.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Smoke
 *
 */
public class Solution188 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>(numRows);
        
        List<Integer> preRow = null;
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i+1);
            for(int j = 0; j < i + 1; j ++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(preRow.get(j-1) + preRow.get(j));
                }
            }
            pascalsTriangle.add(row);
            preRow = row;
        }
        
        return pascalsTriangle;
    }
}
