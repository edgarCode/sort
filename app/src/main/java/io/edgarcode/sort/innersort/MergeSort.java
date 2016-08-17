package io.edgarcode.sort.innersort;

/**
 * 归并排序
 * 算法原理:(假设序列共有n个元素)
 *    1.将序列每相邻的两个元素进行归并操作,形成floor(n/2)个序列,每个序列包含2个元素然后进行排序
 *    2.将上述序列再次进行归并,形成floor(n/4)个序列,每个序列包含4个元素
 *    3.重复步骤2,直到所有的元素都是有序的
 */
public class MergeSort extends Sort {
    @Override
    public void exec() {
        int[] sorted = new int[COUNT];
        merge_sort(data, sorted, 0, COUNT-1);
    }

    private void merge_sort(int[] unsorted, int[] sorted, int start, int end) {
        if (start >= end)
            return;
        int len = end - start;
        int middle = (len >> 1) + start; //计算中间位置,由于递归,最后会将序列切分成一个序列只有1个元素的N个序列
        int start1 = start, end1 = middle;
        int start2 = middle+1, end2 = end;
        //分左右两批进行归并排序
        merge_sort(unsorted, sorted, start1, end1);
        merge_sort(unsorted, sorted, start2, end2);

        //以下是归并排序
        int i=start;
        //拿left序列的start1元素和right序列的start2元素比较,较小的放在sorted数组的i位置
        //一次比较之后,如果left序列的start1元素被拿走则start1指针右移,如果right序列的start2元素被拿走,则start2指针右移
        //直至left或right其中一个序列被移空
        while(start1<=end1 && start2<=end2) {
            sorted[i++] = unsorted[start1] < unsorted[start2] ? unsorted[start1++] : unsorted[start2++];
        }
        //如果left序列还有数据,则将left序列剩余的元素放到sorted数组中
        while (start1<=end1) {
            sorted[i++] = unsorted[start1++];
        }
        //如果right序列还有数据,则将right序列剩余的元素放到sorted数组中
        while (start2<=end2) {
            sorted[i++] = unsorted[start2++];
        }

        //将已排序的元素赋值给unsorted数组
        for (int j = start; j <= end; j++) {
            unsorted[j] = sorted[j];
        }
    }
}
