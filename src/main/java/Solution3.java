/** Project Euler #3: Largest prime factor
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003/problem
 */

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int numberOfTestcases = in.nextInt();
            for(int i = 0; i < numberOfTestcases; i++){
                long n = in.nextLong();
                
                System.out.println(findBiggestPrimeFactor(n));
            }
        } finally {
            in.close();
        }
    }
    
    /**
     * Finds the largest prime factor for a number
     * 
     * @param num number to be factorized
     * @return largest prime factor
     */
    public static long findBiggestPrimeFactor(long num) {
        List<Long> primeFactors = new ArrayList<Long>();
        
        findPrimeFactors(num, primeFactors);
        
        Collections.sort(primeFactors);
        
        return primeFactors.get(primeFactors.size() - 1);
    }
    
    /**
     * Identifies each of the prime factors and updates a list with them.  Not guaranteed to 
     * contain add every prime factor but will add every unique prime factor at least once.
     * 
     * @param num number to be factorized
     * @param primeFactors list of identified prime factors
     */
    public static void findPrimeFactors(long num, List<Long> primeFactors) {
        long walker = (long) Math.sqrt(num);
        
        while (walker > 1) {
            if (num % walker == 0) {
                findPrimeFactors(walker, primeFactors);
                
                if (num / walker != walker) {
                    findPrimeFactors((num / walker), primeFactors);
                }
                
                break;
            }
            
            walker--;
        }
        
        if (walker == 1) {
            primeFactors.add(num);
        }
    }
}
