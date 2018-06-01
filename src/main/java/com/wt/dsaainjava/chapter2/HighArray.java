package com.wt.dsaainjava.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author WuTian
 * @date 2018-06-01 11:41
 * @description 章节2习题, 未考虑并发问题
 */
public class HighArray {
    //默认大小
    private final int defaultCapacity = 10;
    //数组容量
    private int capacity;
    //当前对象个数
    private int size;
    //对象容器
    private int[] item;

    private static final Logger log = LoggerFactory.getLogger(HighArray.class);

    public HighArray() {
        item = new int[defaultCapacity];
        capacity = defaultCapacity;
    }

    public HighArray(int capacity) {
        item = new int[capacity];
        this.capacity = capacity;
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 14:29
     * @param value
     * @return void
     * @throws
     * @description 插入
     */
    public void insert(int value) {
        ensureCapacity();
        item[size] = value;
        size++;
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 13:54
     * @param
     * @return void
     * @throws
     * @description 确保数组空间
     */
    private void ensureCapacity() {
        if (size == capacity) {
            capacity = (capacity + (capacity >> 1));
            item = Arrays.copyOf(item, capacity);
        }
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 17:27
     * @param
     * @return int
     * @throws
     * @description 返回当前数组里元素的数量
     */
    public int size() {
        return this.size;
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 14:38
     * @param index
     * @return boolean
     * @throws
     * @description 删除指定位置的对象
     */
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            log.error("Index out of Bounds.");
            return false;
        }
        item[index] = 0;
        //压缩，防止出现空槽
        compact(index);
        size--;
        return true;
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 14:39
     * @param value
     * @return int
     * @throws
     * @description 按值删除，如果值存在，则返回其下标，否则返回-1
     */
    public int delete(int value) {
        int index = find(value);
        if (index == -1) {
            return -1;
        }
        item[index] = 0;
        //压缩，防止出现空槽
        compact(index);
        size--;
        return index;
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 14:58
     * @param index
     * @return void
     * @throws
     * @description 压缩数组，防止出现空洞
     */
    private void compact(int index) {
        for (int i = index; i < (size - 1); i++) {
            item[i] = item[i + 1];
        }
        if (index != (size - 1)) {
            item[size - 1] = 0;
        }
    }


    /*
     * @author  WuTian
     * @date 2018/6/1 14:43
     * @param index
     * @return int
     * @throws
     * @description 获取指定下标的值
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            log.error("Index out of Bounds.");
            return -1;
        }
        return item[index];
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 14:58
     * @param value
     * @return int
     * @throws
     * @description 获取指定值的小标，不存在返回-1
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (item[i] == value) {
                return i;
            }
        }
        log.error("Can not find the specified value " + value);
        return -1;
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 15:48
     * @param
     * @return int
     * @throws
     * @description 返回最大值
     */
    public int max() {
        int maxIndex = findMaxIndex();
        return item[maxIndex];
    }

    /*
     * @author  WuTian
     * @date 2018/6/1 17:41
     * @param
     * @return int
     * @throws
     * @description 删除最大值
     */
    public int removeMax() {
        int maxIndex = findMaxIndex();
        deleteByIndex(maxIndex);
        return maxIndex;

    }

    /*
     * @author  WuTian
     * @date 2018/6/1 17:38
     * @param
     * @return int
     * @throws
     * @description 获得最大值的下标
     */
    private int findMaxIndex() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (item[i] > item[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    /*
     * @author  WuTian
     * @date 2018/6/1 14:41
     * @param
     * @return java.lang.String
     * @throws
     * @description 重写toString方法
     */
    @Override
    public String toString() {
        return Arrays.toString(item);
    }


    public static void main(String[] args) {
        //[3, 5, 70, 71, 74, 43, 12, 46, 15, 51, 20, 56, 57, 25, 60, 93, 30, 94, 95]
        HighArray ha = new HighArray(3);
        System.out.println("first insert.");
        ha.insert(3);
        ha.insert(5);
        ha.insert(70);
        ha.insert(71);
        ha.insert(74);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("delete value 71.");
        ha.delete(71);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("second insert.");
        ha.insert(43);
        ha.insert(12);
        ha.insert(46);
        ha.insert(15);
        ha.insert(51);
        ha.insert(20);
        ha.insert(56);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("delete value 74.");
        ha.delete(74);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("third insert.");
        ha.insert(57);
        ha.insert(25);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("delete value at index 6.");
        ha.deleteByIndex(6);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("4th insert.");
        ha.insert(60);
        ha.insert(93);
        ha.insert(30);
        ha.insert(94);
        ha.insert(95);
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
        System.out.println("Delete max value.");
        System.out.println("Max index at:" + ha.removeMax());
        System.out.println(ha.toString());
        System.out.println("Size:" + ha.size());
        System.out.println("Max Value:" + ha.max());
    }

}
