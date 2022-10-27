// https://leetcode.com/problems/single-element-in-a-sorted-array/

/*
	You are given a sorted array consisting of only integers where every element appears exactly twice, 
	except for one element which appears exactly once.

	Return the single element that appears only once.
	
	Your solution must run in O(log n) time and O(1) space.
	
	Example 1:
	
	Input: nums = [1,1,2,3,3,4,4,8,8]
	Output: 2
	Example 2:
	
	Input: nums = [3,3,7,7,10,11,11]
	Output: 10
	
	Constraints:
	
	1 <= nums.length <= 105
	0 <= nums[i] <= 105
*/

package com.medium.problems;

public class Single_Element_in_a_Sorted_Array {
	public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        if(nums.length == 1)
            return nums[0];
        
        if(nums[0] != nums[1])
            return nums[0];
        
        if(nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length-1];
        
        while(low <= high){
            int mid = (low + high)/2;
            int temp = nums[mid];
    
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]){
                return nums[mid];
            }
            
            if(temp == nums[mid - 1]){
                if((mid - 1)%2 == 0){
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
            else{
                if(mid%2 == 0){
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
            
        }
        
        return -1;
    }
}
