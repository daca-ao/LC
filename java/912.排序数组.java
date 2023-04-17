/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {

    Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        // 使用快排
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] a, int begin, int end) {
        if (begin > end) {
            return;
        }

        int left = begin;
        int right = end;
        // 随机确定支点的位置
        int pivotInt = RANDOM.nextInt(end - begin + 1) + begin;
        int pivot = a[pivotInt];
        //选定基准值后，将基准值的位置和最开头的位置交换，这样在右边留出连续空间，便于交换
        swap(a, pivotInt, begin);

        while (left != right) {
            // 从右到左找到比支点小的元素 r
            while (a[right] >= pivot && left < right) {
                right--;
            }
            // 从左到右找到比支点大的元素 l
            while (a[left] <= pivot && left < right) {
                left++;
            }

            // l 的索引比 r 小（l 在 r 的左边）
            if (left < right) {
                swap(a, left, right);
            }
        }

        // 支点往中间移
        a[begin] = a[left];
        a[left] = pivot;

        quickSort(a, begin, left - 1);  // 左边快排
        quickSort(a, left + 1, end);  // 右边快排
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// @lc code=end

