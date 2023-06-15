/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start

import java.util.Collections;
import java.util.LinkedList;

class Solution {

    public String decodeString(String s) {

        LinkedList<String> stack = new LinkedList<>();
        int ptr = 0;
        while (ptr < s.length()) {
            char c = s.charAt(ptr);
            if (Character.isDigit(c)) {
                StringBuilder digit = new StringBuilder();
                while (Character.isDigit(s.charAt(ptr))) {
                    digit.append(s.charAt(ptr++));
                }
                stack.addLast(digit.toString());
            } else if (Character.isLetter(c) || c == '[') {
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                LinkedList<String> temp = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    temp.addLast(stack.removeLast());
                }
                Collections.reverse(temp);
                stack.removeLast();  // 左括号出栈
                int time = Integer.parseInt(stack.removeLast());
                String repeat = getString(temp);
                StringBuilder builder = new StringBuilder();
                while (time-- > 0) {
                    builder.append(repeat);
                }
                stack.addLast(builder.toString());
                ++ptr;
            }
        }
        
        return getString(stack);
    }

    public String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}

// @lc code=end
