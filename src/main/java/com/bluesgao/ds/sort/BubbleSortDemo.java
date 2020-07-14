package com.bluesgao.ds.sort;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        System.out.println("冒泡排序开始:" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序结束:" + Arrays.toString(arr));
    }

    //冒泡排序
    //每一趟遍历，将一个最大的数移到序列末尾
    //时间复杂度：最好O(n),最坏O(n*n),平均O(n*n)
    //空间复杂度：O(1)，属于原地排序，不需要开辟额外空间
    private static void bubbleSort(int[] arr) {
        //注意边界
        if (arr != null && arr.length >= 2) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
}
