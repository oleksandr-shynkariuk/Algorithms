package algorithms.recursion;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combi- nations of n-pairs of parentheses.
    EXAMPLE:
    input: 3 (e.g., 3 pairs of parentheses) output: ()()(), ()(()), (())(), ((()))
 */
public class PrintAllBrackets {
    public static void main(String[] args) {
        int size = 1;
        printPar(size, size, "");
    }

    static void printPar(int left, int right, String str){
        if(left == 0 && right == 0){
            System.out.println(str);
            return;
        }
        if(left > 0){ //add left brace when possible
            String newStr = str + '{';
            printPar(left - 1, right, newStr);
        }

        if(right > 0 && right > left){//add right brace when possible
            String newStr = str + '}';
            printPar(left, right - 1, newStr);
        }
    }
}
