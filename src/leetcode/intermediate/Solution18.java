package leetcode.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for(int i = 0; i< nums.length-2;i++) {
            for (int j = nums.length-1; j> i+2; j--) {
                int m = i+1;
                int n = j-1;
                while(m<n) {
                    int sum = nums[i] + nums[m] + nums[n] + nums[j];
                    if(nums[i] + nums[m] > 0 && nums[n] + nums[j] > Integer.MAX_VALUE - nums[i] - nums[m]) {
                        n--;
                    } else if(nums[i] + nums[m] < 0 && nums[n] + nums[j] < Integer.MIN_VALUE - nums[i] - nums[m]) {
                        m++;
                    } else if(sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        list.add(nums[j]);
                        result.add(list);
                        m++;
                        n--;
                    } else if(sum < target) {
                        m++;
                    } else {
                        n--;
                    }

                }
            }
        }

        return result.stream().toList();
    }

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> result = solution.fourSum(nums, -294967296);
        System.out.println(result);

    }
}
