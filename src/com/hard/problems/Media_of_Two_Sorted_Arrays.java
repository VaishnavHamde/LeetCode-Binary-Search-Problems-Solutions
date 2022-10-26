// https://leetcode.com/problems/median-of-two-sorted-arrays/

/*
	Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

	The overall run time complexity should be O(log (m+n)).
	
	Example 1:
	
	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.
	Example 2:
	
	Input: nums1 = [1,2], nums2 = [3,4]
	Output: 2.50000
	Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	 
	Constraints:
	
	nums1.length == m
	nums2.length == n
	0 <= m <= 1000
	0 <= n <= 1000
	1 <= m + n <= 2000
	-106 <= nums1[i], nums2[i] <= 106
*/

package com.hard.problems;

public class Media_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[1];
        int[] brr = new int[1];
        
        if(nums1.length > nums2.length){
            brr = nums1;
            arr = nums2;
        }
        else{
            arr = nums1;
            brr = nums2;
        }
        
        int n = arr.length;
        int m = brr.length;
        
        int begin1 = 0 ; int end1 = n;
        while(begin1<=end1){
            int i1 = (begin1+end1)/2;
            int i2 = (n+m+1)/2 - i1;

            int min1 = (i1==n) ? Integer.MAX_VALUE : arr[i1];
            int max1 = (i1==0) ? Integer.MIN_VALUE : arr[i1-1];

            int min2 = (i2==m) ? Integer.MAX_VALUE : brr[i2];
            int max2 = (i2==0) ? Integer.MIN_VALUE : brr[i2-1];

            if((max1<=min2) && (max2<=min1) ){
                if((n+m)%2==0)
                    return ((double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2);
                else
                    return ((double) Math.max(max1, max2));
            }
            else if(max1>min2)
                end1 = i1-1;
            else
                begin1 = i1+1;
	    }
        
        return -1;
    }
}
