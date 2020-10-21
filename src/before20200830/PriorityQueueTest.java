package before20200830;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author twt
 * @description
 * @date 2020/08/23
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        PriorityQueue<Integer> q = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }

        while (q.size() > 0) {
            System.out.println(q.poll());
        }


    }
}
