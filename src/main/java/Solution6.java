/** Project Euler #6: Sum square difference
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler006/problem
 */

import java.util.*;

public class Solution6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        try {
            int numberOfTestcases = in.nextInt();
            for(int i = 0; i < numberOfTestcases; i++){
                int integerN = in.nextInt();
                
                System.out.println(calculateSquareOfTheSum(integerN) 
                        - calculateSumOfTheSquare(integerN));
            }
        } finally {
            in.close();
        }
    }
    
    /**
     * Calculates the square of the sum of numbers from 1 to the given number
     * 
     * @param num upper limit for the arithmetic sum
     * @return the square of the sum as a long
     */
    public static long calculateSquareOfTheSum(long num) {
        long sum = (num * (2 + (num - 1))) / 2;
        
        return (long) Math.pow(sum, 2);
    }
    
    /**
     * Calculates the sum of the nth perfect squares
     * 
     * @param num the nth number for the summation limit
     * @return the sum as a long
     */
    public static long calculateSumOfTheSquare(long num) {
        return ((num * (num + 1) * (2 * num + 1)) / 6);
    }
}
