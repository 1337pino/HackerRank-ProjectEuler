/** Project Euler #5: Smallest multiple
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
 */

import java.util.*;

public class Solution5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int numberOfTestcases = in.nextInt();
            for(int i = 0; i < numberOfTestcases; i++){
                int integerN = in.nextInt();
                            
                System.out.println(calculateLeastCommonMultiple(integerN));
            }
        } finally {
            in.close();
        }
    }
    
    /**
     * Calculates the Least Common Multiple (LCM) of all the integers from 1 to a given number
     * 
     * @param num Upper limit (inclusively) of the range of integers, starting from 1, that the LCM 
     * is calculated from
     * @return an integer value of the LCM
     */
    public static int calculateLeastCommonMultiple (int num) {
        HashMap<Integer, Integer> largestPrimeFactors = new HashMap<Integer, Integer>();
        
        /* For each integer from num to 1, identify and count each prime factor.  Then update 
           largestPrimeFactors only with the largest quantities for each unique prime factor 
           found */
        for (int i = num; i > 1; i--) {
            HashMap<Integer, Integer> numPrimeFactors = new HashMap<Integer, Integer>();
            findPrimeFactors(i, numPrimeFactors);

            for (Iterator<Map.Entry<Integer, Integer>> primeFactors 
                    = numPrimeFactors.entrySet().iterator(); primeFactors.hasNext(); ) {
                Map.Entry<Integer, Integer> primeFactor = primeFactors.next();
                
                if (!largestPrimeFactors.containsKey(primeFactor.getKey())) {
                    largestPrimeFactors.put(primeFactor.getKey(), primeFactor.getValue());
                } else if (largestPrimeFactors.get(primeFactor.getKey()) < primeFactor.getValue()) {
                    largestPrimeFactors.replace(primeFactor.getKey(), primeFactor.getValue());
                }
            }
        }
        
        /* Calculate the LCM as the product of the prime factors (raised to the power of their 
           largest counts) */
        int primeFactorProduct = 1;
        for (Iterator<Map.Entry<Integer, Integer>> primeFactors 
                = largestPrimeFactors.entrySet().iterator(); primeFactors.hasNext(); ) {
            Map.Entry<Integer, Integer> primeFactor = primeFactors.next();
            primeFactorProduct *= Math.pow(primeFactor.getKey(), primeFactor.getValue());
        }
        return primeFactorProduct;
    }

    /**
     * Finds all of the prime factors for a given number and updates their count in a provided 
     * HashMap
     * 
     * @param num Number to find the prime factors of
     * @param primeFactors HashMap to store the counts of all prime factors
     */
    public static void findPrimeFactors(int num, HashMap<Integer, Integer> primeFactors) {
        int walker = (int) Math.sqrt(num);
        
        while (walker > 1) {
            if (num % walker == 0) {
                // Break down Factor #1
                findPrimeFactors(walker, primeFactors);
                
                // Break down Factor #2
                findPrimeFactors((num / walker), primeFactors);
                
                break;
            }
            
            walker--;
        }
        
        if (walker == 1) {
            primeFactors.merge(num, 1, Integer::sum);
        }
    }
}