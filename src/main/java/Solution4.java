/** Project Euler #4: Largest palindrome product
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem
 */

import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int t = in.nextInt();
            for(int i = 0; i < t; i++){
                int integerN = in.nextInt();
                
                for (int j = integerN - 1; j >= 100001; j--) {
                    if (verifyPalindrome(j)) {
                        for (int k = 100; k < 1000; k++) {
                            if (j % k == 0) {
                                int multiplicand = j / k;
                                
                                if ((multiplicand >= 100) && (multiplicand < 1000)) {
                                    System.out.println(j);
                                    
                                    // Kill both loops
                                    k = 1000;
                                    j = 101100;
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            in.close();
        }
    }
    
    /**
     * Verify in a given number is a palindrome
     * 
     * @param num number to verify
     * @return True if the number is a palindrome digit-wise
     */
    public static boolean verifyPalindrome(int num) {
        String numString = String.valueOf(num);
        
        int walkerA = 0, walkerB = numString.length() - 1;
        
        while (walkerA < walkerB) {
            if (numString.charAt(walkerA) != numString.charAt(walkerB)) {
                return false;
            }
            
            walkerA++;
            walkerB--;
        }
        return true;
    }
}
