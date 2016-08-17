package io.edgarcode.sort.innersort;

/**
 * 选择排序
 */
public class ChooseSort extends Sort {
    @Override
    public void exec() {
        /**
         * 第一趟从[0,COUNT]找到最小的一个,以及最小数据的index,和第0位的交换
         * 之后i++
         * 从[i,COUNT]找到最小的数据并记录index,和第i位交换
         *
         */
        for (int i = 0; i < COUNT; i++) {
            int min = data[i];
            int minIndex = i;
            for (int j = i; j < COUNT; j++) {
                if(data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }
            if (min < data[i]) {
                int tmp = data[i];
                data[i] = min;
                data[minIndex] = tmp;
            }
        }
    }
}
