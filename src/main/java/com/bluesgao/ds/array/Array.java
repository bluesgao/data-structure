package com.bluesgao.ds.array;

/**
 * 数组
 * 1，数组是一种线性表数据结构，用一段连续的内存空间，存储一些相同类型的数据。
 * 2，根据下标随机访问的时间复杂度是O(1)。
 * 3，指定位置插入和删除时间复杂度是O(n)。
 * 4，数组具有空间局部性优势，对cpu cache友好，可以利用cpu cache line，访问效率高。
 * 5，数组的缺点是容量固定。
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
     *
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
     * 普通插入版，时间复杂度O(n)
     *
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
     * 在指定位置，插入元素
     * 快速插入版，时间复杂度O(1)
     * 原理：如果数组中存储的数据并没有任何规律，数组只是被当作一个存储数据的集合。
     * 在这种情况下，如果要将某个数据插入到第 k 个位置，为了避免大规模的数据搬移，
     * 我们还有一个简单的办法就是，直接将第 k 位的数据搬移到数组元素的最后，把新的元素直接放入第 k 个位置。
     *
     * @param index
     * @param value
     * @return
     */
    public boolean fastInsert(int index, int value) {
        //容量判断
        if (size == capacity) {
            System.out.println("快速插入元素，数组空间已满,在位置[" + index + "]插入元素[" + value + "]失败");
            return false;
        }

        //位置判断
        if (index < 0 || index > size) {
            System.out.println("快速插入元素，索引[" + index + "]超出数组范围[0-" + (size - 1) + "]");
            return false;
        }

        //插入操作
        if (index == 0 || index == size) {
            elementData[index] = value;
        } else {
            int temp = elementData[index];
            elementData[index] = value;
            elementData[size] = temp;
        }
        index++;
        return true;
    }

    /**
     * 删除指定位置的元素
     *
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
        for (int i = 0; i <= size; i++) {
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
        //arr.insert(4, 14);
        //arr.insert(5, 15);
        arr.fastInsert(3,23);

        arr.delete(5);

        arr.find(5);
        arr.find(4);


        arr.print();
    }
}
