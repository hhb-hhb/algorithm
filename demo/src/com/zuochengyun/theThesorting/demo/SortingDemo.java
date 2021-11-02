package com.zuochengyun.theThesorting.demo;

public class SortingDemo {


    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 7, 6, 0, 1, 4};
//        int[] arrSort = selectSort(arr);
//        for (int i = 0; i < arrSort.length; i++) {
//            System.out.println(arrSort[i]);
//        }
//       int[] insertSort = insertSort(arr);
        int[] buullSort = bullueSort(arr);
        for (int i = 0; i < buullSort.length; i++) {
            System.out.println(buullSort[i]);
        }
    }
    //选择排序

    /**
     * 首先找到数组中最小的元素，然后和1位置上的元素进行交换，如果1位置上的
     * 元素是最小的，那么1位置上的元素和自己交换,以此类推。
     */
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    //插入排序

    /**
     * 将一个元素插入到其他已经有序的元素中，那么这个元素的后面的元素都需要向后移动一位。
     * 从第二个元素开始，找到他左边的元素依次进行比较，如果左边的元素比他大，依次向后比较，
     * 直到找到左边元素比他小或者相等的为止。然后插入到该元素的右边。以此类推。
     */
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //从第二个元素开始进行插入
        for (int i = 1; i < arr.length; i++) {
            //记录i位置上的元素
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > arr[i]) {
                k--;
            }
            //移动k+1+1位置到i上的元素后移一位
            for (int j = i; j > k + 1; j--) {
                arr[j] = arr[j - 1];
            }
            //把i位置上的元素插入到k+1位置上（插入到该位置的右边）
            arr[k + 1] = temp;
        }
        return arr;
    }


    //冒泡排序

    /**
     * 第一轮从第一个元素开始，第一个元素和第二个元素开始比较，
     * 如果第一个元素比第二个元素大，则交换他们的位置（大的元素向后面移动）
     * 再比较第二个元素和第三个元素，如果第二个元素比第三个元素大，那么二者交换位置。
     * 以此类推。
     * 第二轮从第二个元素开始，以此类推。
     */
    public static int[] bullueSort(int[] arr) {
        //外层的for循环只是记录要循环的次数。
        for (int i = 0; i < arr.length; i++) {
            //内层循环也是循环的次数，在该次数内进行比较交换
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    //交换位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    //冒泡排序优化
    // 如果第一次排序没有元素发生移动，也就是这个数组原本就是有序的。那么不需要后续进排序了
    /*public static int[] bullueSorted2(int[] arr) {

    }*/
}
