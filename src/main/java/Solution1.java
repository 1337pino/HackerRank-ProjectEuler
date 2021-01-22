
/** Project Euler #1: Multiples of 3 and 5
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
 */

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        try {
            int numberOfTestcases = in.nextInt();
            
            for(int i = 0; i < numberOfTestcases; i++){
                int integerN = in.nextInt();
                long sum = 0;
                
                sum += calculateArithmeticSum(3, integerN);
                sum += calculateArithmeticSum(5, integerN);
                sum -= calculateArithmeticSum(15, integerN);
                
                System.out.println(sum);
            }
        } finally {
            in.close();
        }
    }
    
    /**
     * Calculates the sum of an arithmetic series between 0 and a max value (exclusively)
     * 
     * @param multiple the increment between terms in the series
     * @param max the maximum limit for the series (exclusively)
     * @return arithmetic summation of the described series
     */
    public static long calculateArithmeticSum(int multiple, int max) {
        long n = (max - 1) / multiple;
        
        return (n * (2 * multiple + ((n - 1) * multiple))) / 2;
    }
}