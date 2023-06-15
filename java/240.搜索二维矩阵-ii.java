/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    private int search(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = row[mid];
            if (num == target) {
                return mid;
            }
            if (target > num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

