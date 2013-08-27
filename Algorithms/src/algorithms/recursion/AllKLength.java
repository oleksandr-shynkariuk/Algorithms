package algorithms.recursion;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 * Given a set of characters and a positive integer k, print all possible recursion of length k that can be formed from the given set.

Examples:

Input:
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb


Input:
set[] = {'a', 'b', 'c', 'd'}, k = 1
Output:
a
b
c
d
For a given set of size n, there will be n^k possible recursion of length k.
The idea is to start from an empty output string (we call it prefix in following code).
One by one add all characters to prefix. For every character added, print all possible recursion with current prefix by recursively calling for k equals to k-1.
 */
public class AllKLength {

    public static void main(String[] args) {
        char[] set1 = {'a', 'b', 'c', 'd', 'e', 'f'};
        int k = 2;
        printAllKLength(set1, k);
    }

    static void printAllKLength(char[] set, int k){
        int n = set.length;
        printAllKLengthRec(set, n, k, "");
    }

    static void printAllKLengthRec(char[] set, int n, int k, String prefix){
        if(k == 0) { //base case, found a solution
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i < n; ++i){
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, n, k - 1, newPrefix);
        }
    }
}
