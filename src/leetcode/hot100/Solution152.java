package leetcode.hot100;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] < 0 && max[i-1] < 0) {
                max[i] = max[i-1] * nums[i];
            } else if(nums[i] < 0 && max[i-1] > 0) {
                max[i] = nums[i];
            } else if(nums[i] > 0 && max[i-1] < 0) {
                max[i] = nums[i];
            } else {
                max[i] = max[i-1] * nums[i];
            }
        }

        int result = max[0];
        for(int i = 1; i < max.length; i++) {
            result = Math.max(result, max[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int[] nums = {2,-2,3,-2,4,-3,1};
        int result = solution152.maxProduct(nums);
        System.out.println(result); // Output: 6
    }
}
