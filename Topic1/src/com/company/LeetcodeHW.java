package com.company;

import java.util.Arrays;

public class LeetcodeHW {

    // # 1
    // Example: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
    public static String restoreString(String s, int[] indices) {
        char [] res = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }

    // # 2
    // Example: x = 121 or -121 or 10 673 -- 376
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int initValue = x;
        int reverseValue = 0;

        while (x> 0) {
            reverseValue = reverseValue * 10;
            reverseValue = reverseValue + x % 10;
            x /= 10;
        }

        if (initValue == reverseValue) return true;
        return false;
    }

    // # 3
    // num = 14 --> 14/7 -- 7 --> 7-1 -> 6 %2 == 3 -1 --> 2/2 == 0
    public static int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num = num /2;
            }
            else {
                num = num -1;
            }
            steps++;
        }
        return steps;
    }

    // #4
    // Example: word1 = ["ab", "c"], word2 = ["a", "bc"]
    // Example: word1 = ["a", "cb"], word2 = ["ab", "c"]
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1Full = "";
        String word2Full = "";
        for (int i = 0; i < word1.length; i++) {
            word1Full+=word1[i];
        }
        for (int j = 0; j < word2.length; j++) {
            word2Full+=word2[j];
        }
        return word1Full.equals(word2Full);
    }


    // #5
    /*
    Example:
    arr = [1,4,2,5,3]
    [1] = 1
    [4] = 4
    [2] = 2
    [5] = 5
    [3] = 3
    [1,4,2] = 7
    [4,2,5] = 11
    [2,5,3] = 10
    [1,4,2,5,3] = 15
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int subArrLen = 1;
        int arrLen = arr.length;
        while (subArrLen <= arrLen) {
            for (int i = 0; i < arrLen - (subArrLen - 1); i++) {
                for (int j = i; j < i + subArrLen; j++) {
                    sum += arr[j];
                }
            }
            subArrLen = subArrLen + 2;
        }
        return sum;
    }

    // #6

    // n = 4 ---> [1, -1, 2, -2] --0
    // n = 5  --> [0, 1, -1, 2, -2]
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int counter = 0;
        if (n % 2 == 1) {
            result[0] = 0;
            counter++;
        }
        for(int i = 1; i <= n / 2; ++i) {
            result[counter++] = i;
            result[counter++] = -i;
        }
        return result;
    }


    public static void main(String[] args) {
	// write your code here

        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};

        System.out.println(restoreString(s, indices));
        System.out.println(isPalindrome(121));
        System.out.println(numberOfSteps(14));

        String [] word1 = {"ab", "c"};
        String [] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));


        int [] numbers = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(numbers));

        int [] results = sumZero(5);
        System.out.println(Arrays.toString(results));

    }
}
