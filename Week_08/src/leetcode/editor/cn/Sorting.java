package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author doongxujiao
 * @version V1.0
 * @package leetcode.editor.cn
 * @description TODO
 * @date 2021/1/22
 * @Copyright 2020 nuoyun All rights reserved.
 */
public class Sorting {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,15,26,4,19};
//        selectionSort(arr);
        insertionSort(arr);
//        bubbleSort(arr);

    }

    /**
     * @author dongxujiao
     * @description 选择排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @date 2021-01-22 11:10
     * @param  * @param arr
     * @return int[]
     */
    public static int[] selectionSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * @author dongxujiao
     * @description 插入排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @date 2021-01-22 11:15
     * @param  * @param arr
     * @return int[]
     */
    public static int[] insertionSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len ; i++) {
            int preIndex = i - 1;
            int cur = arr[i];
            while (preIndex >= 0 && arr[preIndex]>cur) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -- ;
            }
            arr[preIndex + 1] = cur;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }



    /**
     * @author dongxujiao
     * @description 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     *
     * @date 2021-01-22 11:20
     * @param  * @param arr
     * @return int[]
     */
    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i -1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
