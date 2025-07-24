package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;

        char[] char1 = s.toCharArray();
        for (int i = 0; i<char1.length-1; i++) {
            if(map.get(char1[i]) < map.get(char1[i+1])) {
                result = result - map.get(char1[i]);
            } else {
                result = result + map.get(char1[i]);
            }
        }
        result += map.get(char1[char1.length-1]);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.romanToInt("MCMXCIV");
        System.out.println(result);
    }
}