package com.bluesgao.ds.array;

/**
 * int数组
 */
public class Array {
    //保存数据容器
    private int elementData[];
    //数组容量
    private int capacity;
    //数组元素个数
    private int size;

    //构造函数，定义数组大小
    public Array(int n) {
        elementData = new int[n];
        capacity = n;
        size = 0;
    }

    /**
     * 根据索引查找数组元素的数据并返回
     * @param index
     * @return
     */
    public int find(int index) {
        //位置判断
        if (index < 0 || index >= size) {
            System.out.println("查找元素，索引[" + index + "]超出数组范围[0-" + (size - 1) + "]");
            return -1;
        } else {
            System.out.println("查找元素，索引[" + index + "]对应的元素是[" + elementData[index] + "]");
            return elementData[index];
        }
    }

    /**
     * 在指定位置，插入元素
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        //容量判断
        if (size == capacity) {
            System.out.println("插入元素，数组空间已满,在位置[" + index + "]插入元素[" + value + "]失败");
            return false;
        }

        //位置判断
        if (index < 0 || index > size) {
            System.out.println("插入元素，索引[" + index + "]超出数组范围[0-" + (size - 1) + "]");
            return false;
        }

        //插入操作
        //1,挪出位置：将index后面的元素往后挪动一个位置(从尾部开始挪动)
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        //2,插入元素
        elementData[index] = value;
        //3,更新统计数据
        size++;
        return true;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public boolean delete(int index) {
        //位置判断
        if (index < 0 || index >= size) {
            System.out.println("删除元素，索引[" + index + "]超出数组范围[0-" + (size - 1) + "]");
            return false;
        }

        //删除操作：从index开始将后面的元素向前挪动一个位置
        for (int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }
        //更新统计数据
        size--;
        return true;

    }

    /**
     * 打印数组元素
     */
    public void print() {
        System.out.print("打印数组元素：");
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.insert(0, 10);
        arr.insert(1, 11);
        arr.insert(2, 22);
        arr.insert(3, 13);
        arr.insert(4, 14);
        arr.insert(5, 15);

        arr.delete(5);

        arr.find(5);
        arr.find(4);

        arr.print();
    }
}
