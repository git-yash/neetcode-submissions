class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int bestSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }
}

// i =    1 2 3 4 5 6 7
// c = 2 -1 4 2 4 5 4 8
// b = 2  2 4 4 4 5 5 8
