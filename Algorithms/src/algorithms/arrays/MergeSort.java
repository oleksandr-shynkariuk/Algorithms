package algorithms.arrays;

import java.util.Arrays;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {10, 9, 7, 10, 12, 5, 2, 3};
        ms.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int low, int high) {
        if(low < high){
            int middle = low + (high - low) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    private void merge(int[] arr, int low, int middle, int high) {
        int[] tmp = new int[arr.length];
        for(int i = low; i <= high; ++i){
            tmp[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while(i <= middle && j <= high){
            if(tmp[i] <= tmp[j]){
                arr[k] = tmp[i];
                ++i;
            } else {
                arr[k] = tmp[j];
                ++j;
            }
            ++k;
        }

        //copy rest
        while(i <= middle){
            arr[k] = tmp[i];
            ++i;
            ++k;
        }
        while(j <= high){
            arr[k] = tmp[j];
            ++j;
            ++k;
        }
    }
}
