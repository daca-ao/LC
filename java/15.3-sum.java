import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums); // 对数组排序，为多指针解法打基础

        for (int k = 0; k < nums.length - 2; k++) {  // 第一个指针（锚）
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                // 跳过相同的值
                continue;
            }
            int i = k + 1;  // 第二个指针
            int j = nums.length - 1;  // 第三个指针
            while (i < j) {
                // 求 n 个数之和，n 指针是最常见且时间复杂度较为友好的方法
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // 和小于 0：指针右移取更大的值
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    // 和大于 0：指针左移取更小的值
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    // 满足条件
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }
}
// @lc code=end

