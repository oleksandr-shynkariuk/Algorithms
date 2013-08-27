package algorithms.arrays;

import java.util.Random;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 *
 * Durstenfeld shuffle algorithm:
 *
To shuffle an array a of n elements (indices 0..n-1):
    for i from n − 1 downto 1 do
        j ← random integer with 0 ≤ j ≤ i
        exchange a[j] and a[i]
 */
public class DurstenfeldShuffle {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 11, 12, 13, 14, 15};
        printArray(array);

        array = shuffle(array);
        printArray(array);
    }

    static void printArray(int[] arr){
        System.out.print("{");
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.print("}\n");
    }

    static int[] shuffle(int[] arr){
        Random rand = new Random();
        for(int i = arr.length - 1; i > 0; --i){
            //int j = rand.nextInt(arr.length); -- incorrect implementation!
            int j = rand.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
}
