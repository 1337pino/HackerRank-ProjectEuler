/** Project Euler #2: Even Fibonacci numbers
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler002/problem
 */

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int numberOfTestcases = in.nextInt();

            for(int i = 0; i < numberOfTestcases; i++){
                long n = in.nextLong();

                long sum = 0;
                for (long iteration = 2, previous = 1; iteration <= n; ) {
                    // If this iteration is even, add to the sum
                    if (iteration % 2 == 0) {
                        sum+= iteration;
                    }

                    // Move to the next iteration of the Fibonacci sequence
                    long temp = previous;
                    previous = iteration;
                    iteration += temp;
                }
                
                System.out.println(sum);
            }
        } finally {
            in.close();
        }
    }
}
