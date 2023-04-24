/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }

        // 定位回文子串的起点
        int left = 0;
        // 定位回文子串的终点
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文串长度为基数：中心点为一个元素
            int len1 = expand(s, i, i);
            // 回文串长度为偶数：中心点为两个元素
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > right - left) {  // 更新最长回文子串的长度
                // 更新起点
                left = i - (len - 1) / 2;
                // 更新终点
                right = i + len / 2;
            }
        }
        return s.substring(left, right+1);
    }

    // 从中间向两边扩展获取回文串
    int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// @lc code=end

