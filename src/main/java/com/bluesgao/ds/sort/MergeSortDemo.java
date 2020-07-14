package com.bluesgao.ds.sort;

import java.util.Arrays;

//归并排序
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        System.out.println("归并排序开始:" + Arrays.toString(arr));
        System.out.println("归并排序开始:" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end > start) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid, end);

        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = new int[end - start + 1];

    }


}
