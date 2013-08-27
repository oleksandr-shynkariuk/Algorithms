package algorithms.strings;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class AllPermutations {
    public static void main(String[] args) {
       getPermutations("abcdefghijklm");
    }

    static void getPermutations(String str){
        String prefix = "";
        permute(prefix, str);
    }

    static void permute(String prefix, String str){
        int len = str.length();
        if(len == 0) System.out.print(prefix + ", ");
        for(int i = 0; i < len; ++i){
            permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
        }
    }
}
