// class Solution {
//     public int prefixStrings(int n) {
//         // code here
        
//     }
// }

class Solution {

    private static final int MOD = 1000000007;

    public int prefixStrings(int n) {

        // code here

        // Catalan number C_n = (1 / (n + 1)) * (2n choose n)

        // C_n = (2n)! / ((n + 1)! * n!)

        long num = factorial(2 * n);

        long den = (factorial(n + 1) * factorial(n)) % MOD;



        long ans = (num * modInverse(den, MOD)) % MOD;

        return (int) ans;

    }



    private static long factorial(int n) {

        long fact = 1;

        for (int i = 1; i <= n; i++) {

            fact = (fact * i) % MOD;

        }

        return fact;

    }



    private static long power(long base, long exp) {

        long res = 1;

        base %= MOD;

        while (exp > 0) {

            if ((exp & 1) == 1) res = (res * base) % MOD;

            base = (base * base) % MOD;

            exp >>= 1;

        }

        return res;

    }



    private static long modInverse(long n, int m) {

        return power(n, m - 2);

    }

}