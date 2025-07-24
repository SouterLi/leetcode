package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储后修课程
        List<List<Integer>> graph = new ArrayList<>();
        //存储每门课程的入度
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            graph.get(preCourse).add(course);

            inDegree[course]++;
        }

        //使用队列存储入度为0的课程
        List<Integer> queue = new ArrayList<>();
        //将所有入度为0的课程加入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        //记录已修课程的数量
        int count = 0;
        //进行拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            count++;
            //遍历所有后修课程
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                //如果入度为0，则加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //创建一个二维数组，存储每门课程所有的后续课程
        List<List<Integer>> postCourse = new ArrayList<>();
        //创建一个数组，存放所有课程的入度
        int[] preCount = new int[numCourses];

        // 初始化postCourse
        for(int i = 0; i < numCourses; i++) {
            postCourse.add(new ArrayList<>());
        }

        //建图
        for(int[] prerequisite: prerequisites) {
            postCourse.get(prerequisite[1]).add(prerequisite[0]);
            preCount[prerequisite[0]]++;
        }

        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < preCount.length; i++) {
            if(preCount[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int currentCourse = queue.removeFirst();
            count++;
            for(int pos: postCourse.get(currentCourse)) {
                preCount[pos]--;
                if(preCount[pos] == 0) {
                    queue.add(pos);
                }
            }
        }
        return count == numCourses;
    }
}
