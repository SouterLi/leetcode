package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution215 {
    private int quickSort(List<Integer> numList, int k) {
        int mid = numList.getFirst();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        midList.add(mid);
        List<Integer> rightList = new ArrayList<>();
        for(int i = 1; i< numList.size(); i++) {
            if(numList.get(i)> mid) {
                leftList.add(numList.get(i));
            } else if(numList.get(i) == mid) {
                midList.add(mid);
            }else {
                rightList.add(numList.get(i));
            }
        }
        if(leftList.size() >= k) {
            return quickSort(leftList,k);
        } else if(leftList.size() + midList.size() >= k) {
            return mid;
        }else {
            return quickSort(rightList,k - leftList.size() - midList.size());
        }
    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for(int num : nums) {
            numList.add(num);
        }
        return quickSort(numList, k);
    }

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 9;
        int result = solution215.findKthLargest(nums, k);
        System.out.println(result); // Output: 5
    }
}
