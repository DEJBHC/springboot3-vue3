package com.example.springboot;

import java.util.Scanner;

public class IDCardValidator {
    public static void main(String[] args) {
        for (int i = 0; i <10;i++) {
            String id17 = new Scanner(System.in).nextLine();  // 示例17位身份证号
            System.out.println("The 18th digit of the ID card: " + calculateCheckDigit(id17));
        }
    }

    /**
     * 计算并返回18位身份证号码的校验码
     * @param id17 前17位身份证号码
     * @return 校验码
     */
    public static char calculateCheckDigit(String id17) {
        if (id17 == null || id17.length() != 17) {
            throw new IllegalArgumentException("Invalid input, must be 17 digits.");
        }
        
        int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String checkCodes = "10X98765432";
        
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += Character.getNumericValue(id17.charAt(i)) * weights[i];
        }
        
        int mod = sum % 11;
        return checkCodes.charAt(mod);
    }
}