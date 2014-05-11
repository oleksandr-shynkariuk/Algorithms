package algorithms.dynamic_programming;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class Fibonacci {

    //iterative solution
    public int iterativeFibonacci(int n) throws Exception {
        if(n < 0){
            throw new Exception("Input n must be greater than or equal to 0");
        }
        if(n == 0){
            return 0;
        }
        if(n < 3){
            return 1;
        }

        int a = 1;
        int b = 1;
        int result = 0;
        for(int i = 3; i < n; ++i){
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.iterativeFibonacci(20));
    }
}
