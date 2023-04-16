/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder("");
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        while (n1 >= 0 || n2 >= 0) {
            int x = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            result.append(sum % 10);
            n1--;
            n2--;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
// @lc code=end

