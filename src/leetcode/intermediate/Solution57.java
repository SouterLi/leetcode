package leetcode.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0; i< intervals.length; i++) {
            if(start != 0) {
                if(newInterval[1] < intervals[i][0]) {
                    int[] list = new int[2];
                    list[0] = start;
                    list[1] = newInterval[1];
                    result.add(list);
                    end = 1;
                    int[] list2 = new int[2];
                    list2[0] = intervals[i][0];
                    list2[0] = intervals[i][1];
                    result.add(list2);
                } else if(newInterval[1] > intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                    int[] list = new int[2];
                    list[0] = start;
                    list[1] = intervals[i][1];
                    result.add(list);
                    end = 1;                }
            } else {
                if(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1] || (intervals[i][0] < newInterval[0] && intervals[i][1] > newInterval[1])) {
                    int[] list = new int[2];
                    list[0] = intervals[i][0];
                    list[1] = intervals[i][1];
                    result.add(list);
                } else if(intervals[i][0] > newInterval[0]) {
                    start = newInterval[0];
                } else if(intervals[i][0] < newInterval[0] && intervals[i][1] < newInterval[1]) {
                    start = intervals[i][0];
                }
            }

            if(end != 0) {
                int[] list = new int[2];
                list[0] = intervals[i][0];
                list[1] = intervals[i][1];
                result.add(list);
            }
        }

        int[][] result2 = new int[result.size()][2];
        for(int i = 0; i< result.size(); i++) {
            result2[i] = result.get(i);
        }

        return result2;
    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{6,9}};
        int[] b = {2, 5};
        Solution57 solution57 = new Solution57();
        int[][] result = solution57.insert(a,b);
        System.out.println(result);
    }
}
