// https://leetcode.com/problems/koko-eating-bananas/

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/

package com.medium.problems;
import java.util.*;

public class Koko_Eating_Bananas {
	public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = Integer.MAX_VALUE;
        boolean bool = false;
        
        if(piles.length == h)
            return high;
        
        while(low <= high){
            int mid = (low+high)/2;
            long temp = hrs(piles, mid);
            if(temp == h){
            	bool = true;
                res = Math.min(res, mid);
                high = mid - 1;
            }
            else if(temp > h)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        if(!bool)
        	return low;
        
        return res;
    }
    
    public long hrs(int[] piles,double mid){
        long res = 0;
        
        for(int i = 0; i < piles.length; i++)
            res += Math.ceil(piles[i]/mid);
        
        return res;
    }
}
