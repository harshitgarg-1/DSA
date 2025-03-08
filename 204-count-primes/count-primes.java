class Solution {
    public int countPrimes(int n) {
        int primes[] = new int[n + 1];
        int countPrime = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if (primes[i] == 0) {
                for (int j = i * i; j <= n; j = j + i) 
                {
                    primes[j] = 1;
                }
            }
        }

        for (int i = 2; i < n; i++) 
        {
            if (primes[i] == 0)
                countPrime++;
        }

        return countPrime;
    }
}