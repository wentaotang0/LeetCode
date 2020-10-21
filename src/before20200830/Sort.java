package before20200830;

import java.util.Arrays;

/**
 * @author twt
 * @description
 * @date 2020/03/15
 */
public class Sort {


    /**
     * 冒泡排序
     *
     * @param a
     */
    public void bubbleSort(int a[]) {

        int l = a.length;
        if (a == null || l == 0) return;
        for (int i = 0; i < l; i++) {
            boolean flag = false;
            for (int j = 0; j < l - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) return;//有一轮冒泡没有交换，说明数组已经有序
        }
    }


    /**
     * 插入排序
     *
     * @param a
     */
    public void insertionSort(int a[]) {
        int l = a.length;
        if (a == null || l == 0) return;

        for (int i = 1; i < l; i++) {

            int b = a[i];//每次从无须区取一个要比较的数。最开始第一个数为有序区间，身下的为无需区间
            int j = i - 1;
            for (; j >= 0; j--) {//从要比较的数上一个位置开始遍历
                if (a[j] > b) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[++j] = b;//因为插入的位置在比b小的数后面，此时索引的位置在比b小的数
        }
    }


    /**
     * 选择排序
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     *
     * @param a
     */
    public void selectionSort(int a[]) {
        int l = a.length;
        if (a == null || l == 0) return;
        for (int i = 0; i < l - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < l; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int arr[] = {3, 5, 4, 1, 2, 6};
        System.out.println(Arrays.toString(arr));
//        sort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        sort.insertionSort(arr);
//        System.out.println(Arrays.toString(arr));
        sort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
