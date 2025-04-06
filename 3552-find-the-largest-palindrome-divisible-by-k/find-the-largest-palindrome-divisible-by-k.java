import java.math.BigInteger;

class Solution {
    public String largestPalindrome(int n, int k) {
        final StringBuilder ans = new StringBuilder(n);
        if(k == 1 || k == 3 || k == 9) {
            for(int i = 0; i < n; ++i) {
                ans.append('9');
            }
        } else if(k == 2) {
            if(n == 1) return "8";
            ans.append('8');
            for(int i = 0; i < n - 2; ++i) {
                ans.append('9');
            }
            ans.append('8');
        } else if(k == 4) {
            if(n < 4) return "8".repeat(n);
            ans.append("88");
            for(int i = 4; i < n; ++i) {
                ans.append('9');
            }
            ans.append("88");
        } else if(k == 5) {
            if(n == 1) return "5";
            ans.append('5');
            for(int i = 2; i < n; ++i) {
                ans.append('9');
            }
            ans.append('5');
        } else if (k == 8) {
            if(n < 7) return "8".repeat(n);
            ans.append("888");
            for(int i = 6; i < n; ++i) {
                ans.append('9');
            }
            ans.append("888");
        } else if (k == 6) {// ending => 2, 6, 8
            if(n < 3) return "6".repeat(n);
            if(n == 3) return "888";
            if(n == 4) return "8778";
            ans.append('8');
            if((n & 1) == 0) {
                for(int i = 0; i < (n-4)/2; ++i) {
                    ans.append('9');
                }
                int sum = 16 + 9*(n - 4);
                int num = 9;
                while((num*2 + sum) % 3 != 0) {
                    --num;
                }
                ans.append(num).append(num);
                for(int i = 0; i < (n-4)/2; ++i) {
                    ans.append('9');
                }
            } else {
                for(int i = 0; i < (n-3)/2; ++i) {
                    ans.append('9');
                }
                int sum = 16 + 9*(n - 3);
                int num = 9;
                while((num + sum) % 3 != 0) {
                    --num;
                }
                ans.append(num);
                for(int i = 0; i < (n-3)/2; ++i) {
                    ans.append('9');
                }
            }
            ans.append('8');
        } else if (k == 7) {// 7, 4, 1, 8, 5, 2, 9, 6, 3
            if(n < 3) return "7".repeat(n);
            if((n & 1) == 1) {
                final StringBuilder s1 = new StringBuilder((n - 2)/2);
                for(int i = 0; i < n/2; ++i) {
                    s1.append('9');
                }
                for(int j = 9; j > -1; --j) {
                    final String currNum = s1.toString().concat(j + "").concat(s1.toString());
                    final BigInteger b1 = new BigInteger(currNum);
                    if(b1.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0) {
                        return currNum;
                    }
                }
            } else {
                final StringBuilder s1 = new StringBuilder((n - 2)/2);
                for(int i = 0; i < (n - 2)/2; ++i) {
                    s1.append('9');
                }
                for(int j = 99; j > -1; j -= 11) {
                    final String currNum = s1.toString().concat(j + "").concat(s1.toString());
                    System.out.println(currNum);
                    final BigInteger b1 = new BigInteger(currNum);
                    if(b1.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0) {
                        return currNum;
                    }
                }
            }
        }
        return ans.toString();
    }
}