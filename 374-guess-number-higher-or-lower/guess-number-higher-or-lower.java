/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i=0, j=n, mid=0;
        while(i<=j){
            mid = i+(j-i)/2;
            int x = guess(mid);
            if(x==0) return mid;
            if(x==-1) j = mid-1;
            if(x==1) i = mid+1;
        }
        return -1;
    }
}