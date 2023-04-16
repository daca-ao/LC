/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            if ((result == Integer.MAX_VALUE && mod > 7) || (result == Integer.MIN_VALUE && mod < -8)) {
                return 0;
            }
            result = result * 10 + mod;
            x /= 10;
        }
        return result;
    }
}
// @lc code=end

