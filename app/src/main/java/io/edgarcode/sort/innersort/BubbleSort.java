package io.edgarcode.sort.innersort;

import android.util.Log;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort extends Sort {
    @Override
    public void exec() {
        Log.i("BubbleSort", "sort before " + Arrays.toString(data));
        /**
         * 第一趟排序从[0,count-1],两两比较,结果是最大的数值会换到最后一位
         * 第二趟排序从[0,count-2],两两比较,结果是次大的数值会换到倒数第二位
         * 依次循环,最后全部排序完成
         */
        for(int i=COUNT-1; i>=0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j+1]) {
                    int tmp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tmp;
                }
            }
        }
        Log.i("BubbleSort", "sort after " + Arrays.toString(data));
    }
}
