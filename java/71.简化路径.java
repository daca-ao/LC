/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                stack.pollLast();
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            result.append("/");
        } else {
            while (!stack.isEmpty()) {
                result.append("/").append(stack.pollFirst());
            }
        }
        return result.toString();
    }
}
// @lc code=end

