package algorithms.dynamic_programming;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class Knapsack {
    public static void main(String[] args) {
        int W = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        //Optimal subset is {1, 2} i.e. 0 is not included!
        System.out.println(knapSack(W, weights, values));
    }


    static int knapSack(int W, int[] weight, int[] values){
        int len = weight.length;
        int[][] K = new int[len + 1][W+1];

        for(int i = 0; i <= len; ++i){
            for(int w = 0; w <= W; ++w){
                if(i == 0 || w == 0){
                    K[i][w] = 0;
                } else if(weight[i - 1] <= w){
                    K[i][w] = Math.max(K[i - 1][w], values[i - 1] + K[i - 1][w - weight[i-1]]);
                } else{
                    //ith element is not included
                    K[i][w] = K[i-1][w];
                }
            }
        }

        return K[len][W];
    }
}
