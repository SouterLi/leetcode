package leetcode.simple;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int j = 0;
        int result = -1;
        for(int i = 0; i< haystacks.length; i++) {
            if(haystacks[i] == needles[j]) {
                j++;
                if(j == needles.length) {
                    result = i - j + 1;
                    break;
                }
            } else{
                i = i-j;
                j = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int result = solution28.strStr("sadbutsad","sad");
        System.out.println(result);
    }
}
