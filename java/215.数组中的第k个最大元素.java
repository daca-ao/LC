/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    Random RANDOM = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] a, int begin, int end, int k) {
        int index = partition(a, begin, end);
        if (index == k) {
            return a[index];
        } else {
            return index < k ? quickSelect(a, index + 1, end, k) : quickSelect(a, begin, index - 1, k);
        }
    }

    // 使用快排
    private int partition(int[] a, int begin, int end) {

        // 随机确定支点的位置
        int pivotInt = RANDOM.nextInt(end - begin + 1) + begin;
        int pivot = a[pivotInt];
        //选定基准值后，将基准值的位置和最开头的位置交换，这样在右边留出连续空间，便于交换
        swap(a, pivotInt, begin);

        int left = begin;
        int right = end;
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

        return left;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// @lc code=end

