/**
 * 
 */
package com.smoke.solution;

/**
 * @author Smoke
 *
 */
public class Sotution66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] += carry;
            carry = 0;
            if(digits[i] < 10){
                return digits;
            }else{
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
        }
        

        // 当加 1-9时，通用
        // if(carry>0 && carry < 10){
        //     int[] newDigits = new int[digits.length + 1];
        //     newDigits[0] = carry;
        //     for(int i = 0; i<digits.length; i++){
        //         newDigits[i + 1] = digits[i];
        //     }
        //     return newDigits;
        // }

        // 全9的数字 加1时，最高位为1，剩余全0
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
