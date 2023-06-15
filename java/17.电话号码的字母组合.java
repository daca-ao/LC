/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return dfs(map, digits, 0, new StringBuilder());
    }

    private List<String> dfs(Map<Character, String> map, String digits, int index, StringBuilder builder) {
        List<String> result = new ArrayList<>();
        if (index == digits.length()) {
            result.add(builder.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            for (char c : letters.toCharArray()) {
                builder.append(c);
                result.addAll(dfs(map, digits, index + 1, builder));
                builder.deleteCharAt(index);  // empty the string builder
            }
        }
        return result;
    }
}
// @lc code=end
