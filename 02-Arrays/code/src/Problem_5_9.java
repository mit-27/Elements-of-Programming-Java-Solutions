import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Problem_5_9 {

    // ENUMERATE ALL PRIMES TO n

    // Write a program that takes an integer argument and returns all the primes between 1
    //and that integer. For example, if the input is 18, you should return (2,3,5,7,11,13,17).

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getAllPrimes(n).toString());

    }

    private static List<Integer> getAllPrimes(int n)
    {
        List<Integer> primes = new ArrayList<>();

        // we remove all multiples of prime and tracked it via below Array
        // Here in below False = prime and true = not prime as bool array default values are false
        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <=n ; i++) {

            if(!isPrime[i])
            {
                // add it to prime
                primes.add(i);

                // Change i's multiples to nonPrime
                for(int j=i;j<=n;j=j+i)
                {
                    // converting into nonPrime
                    isPrime[j]=true;
                }
            }

        }



        return primes;
    }


}
