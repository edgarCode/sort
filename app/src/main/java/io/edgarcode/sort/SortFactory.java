package io.edgarcode.sort;

import io.edgarcode.sort.innersort.BinaryTreeSort;
import io.edgarcode.sort.innersort.BubbleSort;
import io.edgarcode.sort.innersort.ChooseSort;
import io.edgarcode.sort.innersort.CountingSort;
import io.edgarcode.sort.innersort.HeapSort;
import io.edgarcode.sort.innersort.InsertSort;
import io.edgarcode.sort.innersort.MergeSort;
import io.edgarcode.sort.innersort.QuickSort;
import io.edgarcode.sort.innersort.RadixSort;
import io.edgarcode.sort.innersort.ShellSort;
import io.edgarcode.sort.innersort.Sort;

/**
 * Created by zhangjifeng on 16/8/15.
 */
public class SortFactory {
    private static SortFactory sInstance = new SortFactory();
    public static SortFactory getInstance() {
        return sInstance;
    }

    public Sort createSort(String type) {
        if (type.equals("bubble")) {
            return new BubbleSort();
        } else if (type.equals("choose")) {
            return new ChooseSort();
        } else if (type.equals("insert")) {
            return new InsertSort();
        } else if (type.equals("quick")) {
            return new QuickSort();
        } else if (type.equals("merge")) {
            return new MergeSort();
        } else if (type.equals("heap")) {
            return new HeapSort();
        } else if (type.equals("shell")) {
            return new ShellSort();
        } else if (type.equals("radix")) {
            return new RadixSort();
        } else if (type.equals("binarytree")) {
            return new BinaryTreeSort();
        } else if (type.equals("counting")) {
            return new CountingSort();
        }
        return null;
    }
}
