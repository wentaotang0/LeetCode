package algorithms.sort;

import java.util.Arrays;

/**
 * @Description 快速排序练习
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/28
 */
public class QuickSort {


    public static void quickSort(int arr[], int n) {
        quickSortInternally(arr, 0, n - 1);
    }


    private static void quickSortInternally(int arr[], int p, int r) {
        if (p >= r) return;
        //获取分区点
        int partation = partation(arr, p, r);
        quickSortInternally(arr, p, partation - 1);
        quickSortInternally(arr, partation + 1, r);
    }

    private static int partation(int arr[], int p, int r) {

        int privot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < privot) {
                //避免原地交换
                if (i == j) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;

    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        QuickSort.quickSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }


}
