package leetcode.intermediate;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result1 = nums[0] + nums[1] + nums[2];
        int result2 = Math.abs(result1 - target);

        for (int i = 0; i< nums.length-2; i++) {
            int y = i+1;
            int z = nums.length-1;
            while(y<z) {
                int result = nums[i] + nums[y] + nums[z];
                if(result < target) {
                    if(result2 > target - result) {
                        result2 = target - result;
                        result1 = result;
                    }
                    y++;
                } else if(result > target) {
                    if(result2 > result - target) {
                        result2 = result-target;
                        result1 = result;
                    }
                    z--;
                } else {
                    return result;
                }
            }
        }
        return result1;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
        int result = solution16.threeSumClosest(nums, -14);
        System.out.println(result);
    }
}
