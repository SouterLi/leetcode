package leetcode.hot100;

public class Solution298 {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp;

        for(int i = 2; i< nums.length; i++) {
            temp = Math.max(first+nums[i], second);
            first = second;
            second = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution298 solution298 = new Solution298();
        int[] nums = {2,7,9,3,1};
        int result = solution298.rob(nums);
        System.out.println(result); // Output: 12
    }
}
