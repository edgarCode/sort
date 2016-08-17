package io.edgarcode.sort.innersort;

/**
 * 快速排序
 * 算法原理:
 *    通过一趟扫描,将要排序的数据分割成独立的两部分,其中一部分的所有数据都比另一部分的所有数据要小,然后再按此
 *    方法对这两部分数据分别进行快速排序,整个排序过程通过递归进行,以此达到整个数据变成有序序列.
 */
public class QuickSort extends Sort {
    @Override
    public void exec() {
        quick_sort(data, 0, COUNT-1);
    }


    private void quick_sort(int[] unsorted, int low, int high) {
        if (low >= high) return;
        int basicData = unsorted[low];  //选第一个元素为基准
        int left = low, right = high;
        while(left < right) {
            while(left<right && unsorted[right]>basicData) {
                right--;
            }
            unsorted[left] = unsorted[right];

            while (left<right && unsorted[left]<=basicData) {
                left ++;
            }
            unsorted[right] = unsorted[left];
        }
        //最后left==right,此时将基准数值赋值给unsorted[left或right]
        unsorted[left] = basicData;

        //分别使用快速排序来对左右两个未排序数组进行排序
        quick_sort(unsorted, low, left-1);
        quick_sort(unsorted, left+1, high);
    }
}
