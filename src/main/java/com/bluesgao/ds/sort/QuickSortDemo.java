package com.bluesgao.ds.sort;

import java.util.Arrays;

/*
 * 快速排序在每一轮挑选一个基准元素，并让其他比它大的元素移动到数列一边，比它小的元素移动到数列的另一边，从而把数列拆解成了两个部分。
 * 快速排序的平均时间复杂度是 O（nlogn），最坏情况下的时间复杂度是 O（n^2）
 * 选定了基准元素以后，我们要做的就是把其他元素当中小于基准元素的都移动到基准元素一边，大于基准元素的都移动到基准元素另一边
 * */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4, 123, 354, -12, 123, -123, 24, 1, 23, 656, 89, 45, 1, 1, 78, 0};
        System.out.println("快速排序开始:" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序结束:" + Arrays.toString(arr));
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    //分区
    //实现元素的移动，让数列中的元素依据自身大小，分别移动到基准元素的左右两边
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }

            //控制right指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }

    //交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
