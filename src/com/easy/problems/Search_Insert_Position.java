// https://leetcode.com/problems/search-insert-position/

/*
	Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, 
	return the index where it would be if it were inserted in order.

	You must write an algorithm with O(log n) runtime complexity.
	
	Example 1:
	
	Input: nums = [1,3,5,6], target = 5
	Output: 2
	Example 2:
	
	Input: nums = [1,3,5,6], target = 2
	Output: 1
	Example 3:
	
	Input: nums = [1,3,5,6], target = 7
	Output: 4
	
	Constraints:
	
	1 <= nums.length <= 104
	-104 <= nums[i] <= 104
	nums contains distinct values sorted in ascending order.
	-104 <= target <= 104
*/

package com.easy.problems;

public class Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] == target){
                return mid;
            }
        }
        if(target > nums[nums.length-1])
            return nums.length;
        if(target < nums[0])
            return 0;
        
        for(int i =0; i < nums.length; i++){
            if(nums[i] < target && nums[i+1] > target){
                return i+1;
            }
        }
        return 123;
    }
}
