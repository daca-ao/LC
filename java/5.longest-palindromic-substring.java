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
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right+1);
    }

    int expand(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
// @lc code=end

