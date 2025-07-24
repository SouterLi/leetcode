package leetcode.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< nums.length; i++) {
            list.add(nums[i]);
        }
        test(result, new ArrayList<>(), list, 0, nums.length);

        return result;
    }

    public void test(List<List<Integer>> result, List<Integer> aaa, List<Integer> restNums, int currentPositon, int n) {
        if(currentPositon == n) {
            result.add(aaa);
        }
        for(int i = 0; i<restNums.size(); i++) {
            aaa.add(restNums.get(i));
            List<Integer> bbb = new ArrayList<>(restNums);
            bbb.remove(i);
            test(result,aaa, bbb,currentPositon+1, n);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution47 su = new Solution47();
        List<List<Integer>> result = su.permuteUnique(nums);
        System.out.println(result);
    }
}
