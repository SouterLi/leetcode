package leetcode.simple;


//动态规划
public class Solution70 {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n; // 如果台阶数小于等于2，直接返回n
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs2(int n) {
        if(n <= 2) {
            return n; // 如果台阶数小于等于2，直接返回n
        }
        int p = 1;
        int q = 2;
        int r = 0;
        for(int i = 3; i <= n; i++) {
            r = p + q; // 当前台阶的方法数等于前两级台阶方法数之和
            p = q; // 更新p为q
            q = r; // 更新q为r
        }
        return r;
    }



    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        int n = 3; // 假设有5级台阶
        int result = solution70.climbStairs(n);
        System.out.println("爬" + n + "级台阶的方法总数是: " + result);
    }
}
