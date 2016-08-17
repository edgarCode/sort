package io.edgarcode.sort.innersort;

/**
 * 直接插入排序
 * 算法原理:
 *     将数据分为两部分,有序部分和无序部分,一开始有序部分包含第1个元素,依次将无序的元素插入到有序部分,知道所有元素有序.
 *     插入时,拿无序部分第一个元素(A)从有序的最后一个元素开始对比,直至找到比A小的B,将A放在B之后,完成插入
 */
public class InsertSort extends Sort {
    @Override
    public void exec() {
        for (int i = 1; i < COUNT; i++) {
            int tmp = data[i];
            int j = i-1;
            while (j>=0 && tmp<data[j]) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = tmp;
        }
    }
}
